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

import fr.eni.BO.ArticleVendu;
import fr.eni.BO.Utilisateur;

public class ArticleVenduDAO extends ArticleVendu {

	private static ArticleVenduDAO instance = null;
	private static String sql = "";

	private ArticleVenduDAO() {
	}

	public static ArticleVenduDAO getInstance() {
		if (instance == null) {
			instance = new ArticleVenduDAO();
		}
		return instance;
	}

	private static Connection connectionBDD() throws ClassNotFoundException, SQLException {
		Connection con = null;
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

	public void saveEnchere(ArticleVendu vendeur) {
		Connection con;
		try {
			con = connectionBDD();
			sql = "INSERT INTO ARTICLES_VENDUS VALUES (?,?,?,?,?,?,?,?,)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vendeur.getNomArticle());
			pstmt.setString(2, vendeur.getDescription());
			pstmt.setDate(3, (Date) vendeur.getDateDebutEnchere());
			pstmt.setDate(4, (Date) vendeur.getDateFinEnchere());
			pstmt.setInt(5, vendeur.getMiseAPrix());
			pstmt.setInt(6, vendeur.getPrixVente());
			pstmt.setInt(7, vendeur.getVendeur().getNoUtilsateur());
			pstmt.setInt(8, vendeur.getNoCategorie());
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void deleteByNoArticle(int noArticle) {
		Connection con;
		try {
			con = connectionBDD();
			sql = "DELETE INTO ARTICLES_VENDUS WHERE no_article like ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, noArticle);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<ArticleVendu> findAll(Utilisateur vendeur) {

		List<ArticleVendu> articlesVendus = new ArrayList<ArticleVendu>();

		try {
			Connection con = connectionBDD();
			sql = "SELECT * FROM ARTICLES_VENDUS";

			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVendu articleVendu = new ArticleVendu();
				articleVendu.setNoArticle(rs.getInt("noArticle"));
				articleVendu.setNomArticle(rs.getString("nomArticle"));
				articleVendu.setDescription(rs.getString("description"));
				articleVendu.setDateDebutEnchere((Date) rs.getDate("date_debut_encheres "));
				articleVendu.setDateFinEnchere((Date) rs.getDate("date_fin_encheres "));
				articleVendu.setMiseAPrix(rs.getInt("miseAPrix"));
				articleVendu.setPrixVente(rs.getInt("prixVente"));
				UtilisateurDAO.findByPseudo(rs.getString("vendeur"));
				// articleVendu.setVendeur(rs.getInt("vendeur"));
				articlesVendus.add(articleVendu);

			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return articlesVendus;
	}

	public ArticleVendu findById(int noArticle) {

		ArticleVendu articleVendu = null;

		try {
			Connection con = connectionBDD();
			sql = "SELECT * FROM Utilisateur where no_article=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, noArticle);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				articleVendu = new ArticleVendu();
				articleVendu.setNoArticle(rs.getInt(0));
				articleVendu.setNomArticle(rs.getString("nomArticle"));
				articleVendu.setDescription(rs.getString("description"));
				articleVendu.setDateDebutEnchere((Date) rs.getDate("date_debut_encheres "));
				articleVendu.setDateFinEnchere((Date) rs.getDate("date_fin_encheres "));
				articleVendu.setMiseAPrix(rs.getInt(0));
				articleVendu.setPrixVente(rs.getInt(0));
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return articleVendu;
	}
}
