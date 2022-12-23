package fr.eni.ventes_encheres.dal;

import fr.eni.bo.Categorie;

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
	
    private Connection connection;

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

    public void create(Categorie categorie) throws SQLException {
    	Connection con;
		try {
		con = connectionBDD();
		
        String sql = "INSERT INTO categorie (no_categorie, libelle) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, categorie.getNoCategorie());
        statement.setString(2, categorie.getLibelle());
        statement.executeUpdate();
        
        con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public Categorie read(int noCategorie) throws SQLException {
    	Connection con;
		try {
		con = connectionBDD();
        String sql = "SELECT * FROM categorie WHERE no_categorie = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, noCategorie);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("no_categorie");
            String libelle = resultSet.getString("libelle");
            return new Categorie(id, libelle);
        }
        return null;
        
        con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void update(Categorie categorie) throws SQLException {
    	Connection con;
		try {
		con = connectionBDD();
        String sql = "UPDATE categorie SET libelle = ? WHERE no_categorie = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, categorie.getLibelle());
        statement.setInt(2, categorie.getNoCategorie());
        statement.executeUpdate();
        
        con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void delete(int noCategorie) throws SQLException {
    	Connection con;
		try {
		con = connectionBDD();
        String sql = "DELETE FROM categorie WHERE no_categorie = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, noCategorie);
        statement.executeUpdate();
        
        con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public List<Categorie> getAll() throws SQLException {
    	Connection con;
		try {
		con = connectionBDD();
        String sql = "SELECT * FROM categorie";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Categorie> categories = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("no_categorie");
            String libelle = resultSet.getString("libelle");
            categories.add(new Categorie(id, libelle));
        }
        return categories;
        con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
