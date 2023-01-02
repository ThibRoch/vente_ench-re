package fr.eni.encheres_commun.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.encheres_commun.bo.*;

public class UtilisateurDAO {

	private static UtilisateurDAO instance = null;

	public static UtilisateurDAO getInstance() {
		if (instance == null)
			instance = new UtilisateurDAO();

		return (UtilisateurDAO) instance;
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
	
	public static Utilisateur login(String email, String motDePasse) {
		Connection con = null;
		Utilisateur user = null;

		try {

			con = connectionBDD();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Utilisateurs WHERE email=? and password=?");
			pstmt.setString(1, email);
			pstmt.setString(2, motDePasse);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new Utilisateur();
				user.setNoUtilsateur(rs.getInt("no_utilisateur"));
				user.setPseudo(rs.getString("pseudo"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setTelephone(rs.getString("telephone"));
				user.setRue(rs.getString("rue"));
				user.setCodePostal(rs.getString("code_postal"));
				user.setVille(rs.getString("ville"));
				user.setMotDePasse(rs.getString("mot_de_passe"));
				user.setCredit(rs.getInt("credit"));
				user.setAdmin(rs.getBoolean("admin"));
			}
			con.close();

		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();

		}
		return user;
	}

	
	public static void create(Utilisateur user) {
		Connection con = null;
		
		try {
			
			con = connectionBDD();
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO Utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, user.getPseudo());
			pstmt.setString(2, user.getNom());
			pstmt.setString(3, user.getPrenom());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getTelephone());
			pstmt.setString(6, user.getRue());
			pstmt.setString(7, user.getCodePostal());
			pstmt.setString(8, user.getVille());
			pstmt.setString(9, user.getMotDePasse());
			pstmt.setInt(10, user.getCredit());
			pstmt.setBoolean(11, user.isAdmin());

			pstmt.executeUpdate();

			con.close();

		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();

		}
	}

	
	public static void deleteByPseudo(String pseudo) {
		Connection con = null;

		try{
			con = connectionBDD();
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM Utilisateurs WHERE pseudo=?");
			pstmt.setString(1, pseudo);
			pstmt.executeUpdate();

			con.close();

		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();

		}
	}

	
	public static void update(Utilisateur user) throws ClassNotFoundException {
		Connection con = null;
		
		try {
			con = connectionBDD();
			PreparedStatement pstmt = con.prepareStatement(
					"UPDATE Utilisateur set pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?");
			pstmt.setString(1, user.getPseudo());
			pstmt.setString(2, user.getNom());
			pstmt.setString(3, user.getPrenom());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getTelephone());
			pstmt.setString(6, user.getRue());
			pstmt.setString(7, user.getCodePostal());
			pstmt.setString(8, user.getVille());
			pstmt.setString(9, user.getMotDePasse());
			pstmt.executeUpdate();

			con.close();

		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();

		}
	}

	
	public List<Utilisateur> findAll(String field, String sens) {

		List<Utilisateur> users = new ArrayList<Utilisateur>();
		Connection con = null;

		try {
			con = connectionBDD();
			PreparedStatement pstmt;
			Utilisateur user = null;

			if (field != null && sens != null)
				pstmt = con.prepareStatement("SELECT * FROM Utilisateur order by" + field + " " + sens);
			else
				pstmt = con.prepareStatement("SELECT * FROM Utilisateur");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				user = new Utilisateur();
				user.setNoUtilsateur(rs.getInt("no_utilisateur"));
				user.setPseudo(rs.getString("pseudo"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setTelephone(rs.getString("telephone"));
				user.setRue(rs.getString("rue"));
				user.setCodePostal(rs.getString("code_postal"));
				user.setVille(rs.getString("ville"));
				user.setMotDePasse(rs.getString("mot_de_passe"));
				user.setCredit(rs.getInt("credit"));
				user.setAdmin(rs.getBoolean("admin"));

				users.add(user);
			}
			con.close();

		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();

		}
		return users;
	}

	
	public static Utilisateur findByPseudo(String pseudo) {
		Connection con = null;
		Utilisateur user = null;

		try {
			con = connectionBDD();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Utilisateurs WHERE pseudo=?");
			pstmt.setString(1, pseudo);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new Utilisateur();
				user.setNoUtilsateur(rs.getInt("no_utilisateur"));
				user.setPseudo(rs.getString("pseudo"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setTelephone(rs.getString("telephone"));
				user.setRue(rs.getString("rue"));
				user.setCodePostal(rs.getString("code_postal"));
				user.setVille(rs.getString("ville"));
				user.setMotDePasse(rs.getString("mot_de_passe"));
				user.setCredit(rs.getInt("credit"));
				user.setAdmin(rs.getBoolean("admin"));
			}
			con.close();

		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();

		}
		return user;
	}

	
	public static Utilisateur findByEmail(String email) {
		Connection con = null;
		Utilisateur user = null;

		try {
			con = connectionBDD();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Utilisateurs WHERE email=?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new Utilisateur();
				user.setNoUtilsateur(rs.getInt("no_utilisateur"));
				user.setPseudo(rs.getString("pseudo"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setTelephone(rs.getString("telephone"));
				user.setRue(rs.getString("rue"));
				user.setCodePostal(rs.getString("code_postal"));
				user.setVille(rs.getString("ville"));
				user.setMotDePasse(rs.getString("mot_de_passe"));
				user.setCredit(rs.getInt("credit"));
				user.setAdmin(rs.getBoolean("admin"));
			}
			con.close();

		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();

		}
		return user;
	}
}