package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
/***
 * 
 * @author hpp
 */
public class Connexion {

    private static final String configurationFile = "BD.properties";
    private static Connection conn;

    private Connexion() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection() throws ParseException {

        try {
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
            // Load the database driver
            Class.forName(jdbcDriver);// Get a connection to the database
            conn = DriverManager.getConnection(dbUrl, username, password);
            SQLWarningsExceptions.printWarnings(conn);
            //conn.close() ;
            System.out.println("connexion �tabli");
        } catch (SQLException se) {
            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
        } catch (ClassNotFoundException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return conn;
    }
}
