package fr.eni.ventes_encheres.dal;

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

import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;

public class EnchereDAO {

	private Connection connection;

	private static EnchereDAO instance = null;

	private EnchereDAO() {
	}

	public static EnchereDAO getInstance() {
		if (instance == null) {
			instance = new EnchereDAO();
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

	public EnchereDAO(Connection connection) {
		this.connection = connection;
	}

	public void addEnchere(Enchere enchere) throws SQLException {
		Connection con;
		String sql = "INSERT INTO encheres (date_enchere, nom_article, montant_enchere, utilisateur) VALUES (?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			con = connectionBDD();

			statement.setDate(1, (Date) enchere.getDateEnchère());
			statement.setString(2, enchere.getNomArticle());
			statement.setInt(3, enchere.getMontantEnchère());
			statement.setString(4, enchere.getUtilisateur().getUsername());
			statement.executeUpdate();

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Enchere> getEncheres() throws SQLException {
		Connection con;
		String sql = "SELECT * FROM encheres";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			con = connectionBDD();
			ResultSet resultSet = statement.executeQuery();
			List<Enchere> encheres = new ArrayList<>();
			while (resultSet.next()) {
				Enchere enchere = new Enchere();
				enchere.setDateEnchère(resultSet.getDate("date_enchere"));
				enchere.setNomArticle(resultSet.getString("nom_article"));
				enchere.setMontantEnchère(resultSet.getInt("montant_enchere"));
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setUsername(resultSet.getString("utilisateur"));
				enchere.setUtilisateur(utilisateur);
				encheres.add(enchere);
			}
			return encheres;

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
