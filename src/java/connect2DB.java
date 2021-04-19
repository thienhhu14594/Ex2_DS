
import javafx.scene.control.Alert;

import java.sql.*;

public class connect2DB {

    ////////////////////////////////////
    static String databaseName = "DS";//
    static String username = "sa";    //
    static String password = "123";   //
    ////////////////////////////////////

    public static Connection connect() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=" + databaseName + ";";

            Connection connection = DriverManager.getConnection(url, username, password);

            return connection;

        } catch (SQLException throwables) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("The database info has not establish!");
            alert.setContentText("Please input your database name, username and password for server authentication in connect2DB.java!");
            alert.showAndWait();
        }
        return null;
    }

    public static void disconnect(Connection connection) throws SQLException {
        connection.close();
    }


}
