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
	private static CategorieDAO instance = null;

	private CategorieDAO() {
	}

	public static CategorieDAO getInstance() {
		if (instance == null) {
			instance = new CategorieDAO();
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

    public void create(Categorie categorie){
    	Connection con;
	try {
		con = connectionBDD();

		String sql = "INSERT INTO categorie (libelle) VALUES (?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, categorie.getLibelle());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
    }

    public Categorie read(int noCategorie){
    	Connection con;
	int id = 0;
	String libelle = null;
	    
	try {
		con = connectionBDD();
		String sql = "SELECT * FROM categorie WHERE no_categorie = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, noCategorie);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
		    id = resultSet.getInt("no_categorie");
		    libelle = resultSet.getString("libelle");
        	}
		
		rs.close();
		pstmt.close();
       		con.close();
		
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
	return new Categorie(id, libelle);
    }

    public void update(Categorie categorie){
    	Connection con;
	    
	try {
		con = connectionBDD();
		String sql = "UPDATE categorie SET libelle = ? WHERE no_categorie = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
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
    	Connection con;
	    
	try {
		con = connectionBDD();
		String sql = "DELETE FROM categorie WHERE no_categorie = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, noCategorie);
		pstmt.executeUpdate();

		pstmt.close();
		con.close();
		
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
    }

    public List<Categorie> getAll(){
    	Connection con;
	List<Categorie> categories = new ArrayList<>();
	    
	try {
		con = connectionBDD();
		String sql = "SELECT * FROM categorie";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
		    int id = rs.getInt("no_categorie");
		    String libelle = rs.getString("libelle");
		    categories.add(new Categorie(id, libelle));
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
