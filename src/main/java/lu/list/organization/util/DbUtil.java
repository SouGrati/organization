package lu.list.organization.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbUtil {
	
	static Connection connection = null;
	
	static{
		try {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/TestDb");
			connection = dataSource.getConnection();
		} catch (NamingException nameException) {
			nameException.printStackTrace();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
