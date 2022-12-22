package fr.eni.ventes_encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.bo.Retrait;
import fr.eni.bo.Utilisateur;

public class RetraitDAO {
	private static RetraitDAO instance = null;

	private RetraitDAO() {

	}

	public static RetraitDAO getInstance() {
		if (instance == null) {
			instance = new RetraitDAO();
		}
		return instance;
	}

	public List<Retrait> getAdresseByUtilisateur(Utilisateur u) {
		Connection cnx = null;
		PreparedStatement stmt;
		ResultSet rs;
		List<Retrait> lst = new ArrayList<Retrait>();
		Retrait ad;

		try {
			cnx = connectionBDD();
			stmt = cnx.prepareStatement("select * from adresses where id_pn=? order by ville");
			stmt.setInt(1, u.getId());
			rs = stmt.executeQuery();
			while (rs.next()) {
				ad = new Retrait(rs.getInt("id"), rs.getString("rue"), rs.getString("ville"), u);
				lst.add(ad);
			}
			u.setRetrait(lst);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
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

}
