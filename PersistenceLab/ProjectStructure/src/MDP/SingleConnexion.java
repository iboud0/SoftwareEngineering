package MDP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnexion {
    String db = "travelManagement";
    String user = "root";
    String pwd = "";
    String url = "jdbc:mysql://localhost:3306/" + db;
    private static Connection connection = null;

    private SingleConnexion() {
        try {
            connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("instance cree!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        if (connection == null)
            new SingleConnexion();
        return connection;
    }
}
