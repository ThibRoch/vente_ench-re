package fr.eni.ventes_encheres.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class ConnectionProvider {
	private static DataSource ds;

	/**
	 * Au chargement de la classe, la DataSource est recherchée dans l'arbre JNDI
	 */
	static {
		Context ctxt;
		try {
			ctxt = new InitialContext();
			ConnectionProvider.ds =(DataSource)ctxt.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException ne) {
			ne.printStackTrace();
			throw new RuntimeException("Impossible d'accèder à la base de données");
		}
	}

	/**
	 * 
	 * @return Connection à la base de données
	 * 			=> issue du pool de connexions
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return ConnectionProvider.ds.getConnection();
	}
}
