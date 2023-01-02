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
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, categorie.getLibelle());
		pstmt.executeUpdate();

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
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, noCategorie);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
		    int id = resultSet.getInt("no_categorie");
		    String libelle = resultSet.getString("libelle");
        	}
		
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
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, categorie.getLibelle());
		statement.setInt(2, categorie.getNoCategorie());
		statement.executeUpdate();

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
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, noCategorie);
		statement.executeUpdate();

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
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
		    int id = resultSet.getInt("no_categorie");
		    String libelle = resultSet.getString("libelle");
		    categories.add(new Categorie(id, libelle));
		}
		
		con.close();
		
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
	return categories;    
    }	
}
