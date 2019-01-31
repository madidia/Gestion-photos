package src.connexion;


import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * The BenchmarkProperties class describes the properties of the benchmark to
 * run.
 */
public class DatabaseAccessProperties {

    private Properties prop = new Properties();
    private final String jdbcDriver;
    private final String dbUrl;
    private final String username, password;
    /**
     * 
     * @param propertiesFile : fichier de propriétés
     */

    public DatabaseAccessProperties(String propertiesFile) {
        try {
            prop = new Properties();
            prop.load(new FileInputStream(propertiesFile));
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: "
                    + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IOException: "
                    + e.getMessage());
            e.printStackTrace();
        }
        jdbcDriver = prop.getProperty("jdbc.driver");
        dbUrl = prop.getProperty("database.url");
        
       username = prop.getProperty("database.username");
       password = prop.getProperty("database.password");
   
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public String getDatabaseUrl() {
        return dbUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public char[] passwordExample() {        
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        console.printf("Testing password%n");
        char passwordArray[] = console.readPassword("Enter your secret password: ");
        console.printf("Password entered was: %s%n", new String(passwordArray));
		return passwordArray;
    }

}
