package fr.eni.ventes_encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ventes_encheres.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO{

	private static UtilisateurDAOJdbcImpl instance =null;
	
	public static UtilisateurDAO getInstance() {
		if (instance ==null)
			instance = new UtilisateurDAOJdbcImpl();
		
		return instance;
	}
	
	@Override
	public Utilisateur login(String email, String motDePasse){
		Utilisateur user = null;
		
		try (Connection con= ConnectionProvider.getConnection()){
			
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Utilisateurs WHERE email=? and password=?");
			pstmt.setString(1, email);
			pstmt.setString(2, motDePasse);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user=new Utilisateur();
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
					
		} catch (SQLException se) {
			se.printStackTrace();
			
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return user;
	}
	
	@Override
	public void create(Utilisateur user) {
		try (Connection con= ConnectionProvider.getConnection()){
			
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO Utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
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
			
		}catch(SQLException se) {
			se.printStackTrace();
			
		}catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	@Override
	public void deleteByPseudo(String pseudo) {
		
		try (Connection con= ConnectionProvider.getConnection()){
			
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM Utilisateurs WHERE pseudo=?");
			pstmt.setString(1, pseudo);
			pstmt.executeUpdate();
			
			con.close();
			
		}catch(SQLException se) {
			se.printStackTrace();	
			
		}catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	@Override
	public void update(Utilisateur user) {
		try (Connection con= ConnectionProvider.getConnection()){
			
			PreparedStatement pstmt = con.prepareStatement("UPDATE Utilisateur set pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?");
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
			
		}catch(SQLException se) {
			se.printStackTrace();	
			
		}catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	@Override
	public List<Utilisateur> findAll(String field, String sens) {
		
		List<Utilisateur> users = new ArrayList<Utilisateur>();
		
		try (Connection con= ConnectionProvider.getConnection()){
			PreparedStatement pstmt;
			Utilisateur user = null;
			
			if(field!= null && sens!=null)
				pstmt=con.prepareStatement("SELECT * FROM Utilisateur order by" + field + " " + sens);
			else
				pstmt=con.prepareStatement("SELECT * FROM Utilisateur");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user=new Utilisateur();
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
			
		}catch(SQLException se) {
			se.printStackTrace();	
			
		}catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return users;
	}
	
	@Override
	public Utilisateur findByPseudo(String pseudo) {
		Utilisateur user = null;
		
		try (Connection con= ConnectionProvider.getConnection()){
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Utilisateurs WHERE pseudo=?");
			pstmt.setString(1, pseudo);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user=new Utilisateur();
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
			
		}catch(SQLException se) {
			se.printStackTrace();	
			
		}catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return user;
	}
	
	@Override
	public Utilisateur findByEmail(String email) {
		Utilisateur user = null;
		
		try (Connection con= ConnectionProvider.getConnection()){
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Utilisateurs WHERE email=?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user=new Utilisateur();
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
			
		}catch(SQLException se) {
			se.printStackTrace();	
			
		}catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return user;
	}
}