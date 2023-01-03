package fr.eni.eni_encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.eni_encheres.bo.*;

public class RetraitDAO {
	
	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	private static String sql = "";
	private static ResultSet rs = null;
	
	private static RetraitDAO instance = null;
	private static Retrait retrait = null;

	public static RetraitDAO getInstance() {
		if (instance == null) {
			instance = new RetraitDAO();
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
	
	public static Retrait getRetraitByArticle(ArticleVendu art) {

		try {
			con = connectionBDD();
			sql = "select * from retraits where id_pn=? order by ville";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, art.getNoArticle());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				retrait = new Retrait();
				retrait.setRue(rs.getString("rue"));
				retrait.setVille(rs.getString("ville"));
				retrait.setCodePostal(rs.getString("code_postal"));
				retrait.setArticleVendu(ArticleVenduDAO.findById(rs.getInt("no_article")));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return retrait;
	}
}
