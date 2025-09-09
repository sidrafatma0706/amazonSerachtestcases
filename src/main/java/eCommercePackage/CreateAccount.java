package eCommercePackage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class CreateAccount {

    public static void main(String[] args) {
        Properties props = new Properties();

        try {
            // Load DB credentials from properties file
        	InputStream fis = CreateAccount.class.getClassLoader().getResourceAsStream("db.properties");
        	if (fis == null) {
        	    throw new FileNotFoundException("db.properties not found in resources folder");
        	}
        	props.load(fis);
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            // Establish DB connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Database Connected Successfully!");

            // SQL insert query
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"sidra");
            pstmt.setString(2, "Sidra@123");
            pstmt.executeUpdate();


            // Loop to create 10 accounts
            for (int i = 2; i <= 10; i++) {
                String username = "user" + i;
                String userPass = "pass" + i;

                pstmt.setString(1, username);
                pstmt.setString(2, userPass);
                pstmt.executeUpdate();

                System.out.println("Inserted: " + username + " / " + userPass);
            }

            pstmt.close();
            conn.close();
            System.out.println("✅ All 10 users inserted successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
