package fr.eni.eni_encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.eni_encheres.bo.*;

public class UtilisateurDAO {

	private static Connection con = null;
	private static String sql = "";
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	
	private static UtilisateurDAO instance = null;
	private static Utilisateur user = null;
	
	public static UtilisateurDAO getInstance() {
		if (instance == null)
			instance = new UtilisateurDAO();
		
		return (UtilisateurDAO) instance;
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
	
	public static Utilisateur login(String email, String motDePasse) {
		Utilisateur user = null;

		try {
			con = connectionBDD();
			sql = "SELECT * FROM Utilisateurs WHERE email=? and password=?";
	
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, motDePasse);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new Utilisateur();
				user.setNoUtilisateur(rs.getInt("no_utilisateur"));
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
			
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static void create(Utilisateur user) {
		
		try {
			con = connectionBDD();
			sql = "INSERT INTO Utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
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
			
			pstmt.close();
			con.close();

		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteByPseudo(String pseudo) {

		try{
			con = connectionBDD();
			sql = "DELETE FROM Utilisateurs WHERE pseudo=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pseudo);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();

		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void update(Utilisateur user){
		
		try {
			con = connectionBDD();
			sql = "UPDATE Utilisateur set pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=? WHERE id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getPseudo());
			pstmt.setString(2, user.getNom());
			pstmt.setString(3, user.getPrenom());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getTelephone());
			pstmt.setString(6, user.getRue());
			pstmt.setString(7, user.getCodePostal());
			pstmt.setString(8, user.getVille());
			pstmt.setString(9, user.getMotDePasse());
			pstmt.setInt(10, user.getNoUtilisateur());
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();

		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Utilisateur> findAll(String field, String sens) {

		List<Utilisateur> users = new ArrayList<Utilisateur>();

		try {
			con = connectionBDD();

			if (field != null && sens != null)
				sql = "SELECT * FROM Utilisateur order by" + field + " " + sens;
			else
				sql = "SELECT * FROM Utilisateur";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				user = new Utilisateur();
				user.setNoUtilisateur(rs.getInt("no_utilisateur"));
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
			
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}

	public static Utilisateur findByPseudo(String pseudo) {

		try {
			con = connectionBDD();
			sql = "SELECT * FROM Utilisateurs WHERE pseudo=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pseudo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new Utilisateur();
				user.setNoUtilisateur(rs.getInt("no_utilisateur"));
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
			
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static Utilisateur findByEmail(String email) {

		try {
			con = connectionBDD();
			sql = "SELECT * FROM Utilisateurs WHERE email=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new Utilisateur();
				user.setNoUtilisateur(rs.getInt("no_utilisateur"));
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
			
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}
}
