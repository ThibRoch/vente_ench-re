package fr.eni.eni_encheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.eni_encheres.bo.*;

public class EnchereDAO {

	private static Connection con;
	private static EnchereDAO instance = null;
	private static String sql="";

	private EnchereDAO() {
	}

	public static EnchereDAO getInstance() {
		if (instance == null) {
			instance = new EnchereDAO();
		}
		return instance;
	}

	private static Connection connectionBDD() throws ClassNotFoundException, SQLException {
		DataSource ds;
		InitialContext ctx;
		
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/pool_cnx");
			con = ds.getConnection();

		} catch (NamingException e) {
			e.printStackTrace();
		}
		return con;
	}

	public EnchereDAO(Connection con) {
		EnchereDAO.con = con;
	}

	public void addEnchere(Enchere enchere){
		sql = "INSERT INTO encheres (date_enchere, no_article, montant_enchere, no_utilisateur) VALUES (?, ?, ?, ?)";
		
		try  {
			con = connectionBDD();
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setDate(1, (Date) enchere.getDateEnchere());
			pstmt.setString(2, enchere.getNomArticle());
			pstmt.setInt(3, enchere.getMontantEnchere());
			pstmt.setInt(4, enchere.getUser().getNoUtilisateur());
			pstmt.executeUpdate();

			pstmt.close();
			con.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Enchere> getEncheres(){
		sql = "SELECT * FROM encheres";
		List<Enchere> encheres = new ArrayList<>();
		
		try {
			con = connectionBDD();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Enchere enchere = new Enchere();
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setNomArticle(rs.getString("no_article"));
				enchere.setMontantEnchere(rs.getInt("montant_enchere"));
				UtilisateurDAO.findByPseudo(rs.getString("user"));
				encheres.add(enchere);
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return encheres;
	}
}
