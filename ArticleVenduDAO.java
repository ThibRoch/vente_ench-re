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
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO ARTICLES_VENDUS VALUES (?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, vendeur.getNoArticle());
			pstmt.setString(2, vendeur.getNomArticle());
			pstmt.setString(3, vendeur.getDescription());
			pstmt.setDate(4, (Date) vendeur.getDateDebutEnchere());
			pstmt.setDate(5, (Date) vendeur.getDateFinEnchere());
			pstmt.setInt(6, vendeur.getMiseAPrix());
			pstmt.setInt(7, vendeur.getPrixVente());
			pstmt.setInt(8, vendeur.getVendeur().getNoUtilsateur());
			pstmt.setInt(9, vendeur.getNoCategorie());

			pstmt.executeUpdate();
			con.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void deleteByNoArticle(int noArticle) {
		Connection con;
		try {
			con = connectionBDD();

			PreparedStatement pstmt = con.prepareStatement("DELETE INTO ARTICLES_VENDUS WHERE no_article like ?");
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

			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM ARTICLES_VENDUS");

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				ArticleVendu articleVendu = new ArticleVendu();
				articleVendu.setNoArticle(res.getInt("noArticle"));
				articleVendu.setNomArticle(res.getString("nomArticle"));
				articleVendu.setDescription(res.getString("description"));
				articleVendu.setDateDebutEnchere((Date) res.getDate("date_debut_encheres "));
				articleVendu.setDateFinEnchere((Date) res.getDate("date_fin_encheres "));
				articleVendu.setMiseAPrix(res.getInt("miseAPrix"));
				articleVendu.setPrixVente(res.getInt("prixVente"));
				UtilisateurDAOJdbcImpl.findByPseudo(res.getString("vendeur"));
				// articleVendu.setVendeur(res.getInt("vendeur"));
				articlesVendus.add(articleVendu);

			}
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
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Utilisateur where no_article=?");
			pstmt.setInt(1, noArticle);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				articleVendu = new ArticleVendu();
				articleVendu.setNoArticle(res.getInt(0));
				articleVendu.setNomArticle(res.getString("nomArticle"));
				articleVendu.setDescription(res.getString("description"));
				articleVendu.setDateDebutEnchere((Date) res.getDate("date_debut_encheres "));
				articleVendu.setDateFinEnchere((Date) res.getDate("date_fin_encheres "));
				articleVendu.setMiseAPrix(res.getInt(0));
				articleVendu.setPrixVente(res.getInt(0));

			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return articleVendu;
	}

}
