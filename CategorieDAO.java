package fr.eni.eni_encheres.dal;

import fr.eni.eni_encheres.bo.Categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CategorieDAO {
	
	private static Connection con = null;
	private static String sql = "";
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	
	private static CategorieDAO instance = null;
	private static Categorie categorie = null;

	public static CategorieDAO getInstance() {
		if (instance == null) {
			instance = new CategorieDAO();
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

    public void create(Categorie categorie){
	try {
		con = connectionBDD();
		sql = "INSERT INTO categorie (libelle) VALUES (?)";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, categorie.getLibelle());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
    }

    public Categorie read(int noCategorie){
	    
	try {
		con = connectionBDD();
		sql = "SELECT * FROM categorie WHERE no_categorie = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, noCategorie);
		
		rs = pstmt.executeQuery();

		if (rs.next()) {
			categorie = new Categorie();
			categorie.setNoCategorie(rs.getInt("no_categorie"));
			categorie.setLibelle(rs.getString("libelle"));
        	}
		
		rs.close();
		pstmt.close();
       		con.close();
		
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
	return new Categorie(categorie);
    }

    public void update(Categorie categorie){
	    
	try {
		con = connectionBDD();
		sql = "UPDATE categorie SET libelle = ? WHERE no_categorie = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, categorie.getLibelle());
		pstmt.setInt(2, categorie.getNoCategorie());
		pstmt.executeUpdate();

		pstmt.close();
		con.close();
		
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
    }

    public void delete(int noCategorie){
	    
	try {
		con = connectionBDD();
		sql = "DELETE FROM categorie WHERE no_categorie = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, noCategorie);
		pstmt.executeUpdate();

		pstmt.close();
		con.close();
		
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
    }

    public List<Categorie> getAll(){
	    
	List<Categorie> categories = new ArrayList<>();
	    
	try {
		con = connectionBDD();
		sql = "SELECT * FROM categorie";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			categorie = new Categorie();
			categorie.setNoCategorie(rs.getInt("no_categorie"));
		 	categorie.setLibelle(rs.getString("libelle"));
			categories.add(categorie);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
	return categories;    
    }	
}
