
import javafx.scene.control.Alert;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class function {
    public static void initializeDatabase() throws SQLException {
        Connection connection = connect2DB.connect();
        Statement statement = connection.createStatement();
        String sql = "if object_id('dbo.student', 'U') IS NOT NULL \n" +
                "drop table dbo.student;\n" +
                "create table student (\n" +
                "\tname nvarchar(50),\n" +
                "\tid nvarchar(20),\n" +
                "\tyear int,\n" +
                "\tprimary key (id)\n" +
                ")\n" +
                "insert into student ([id],[name],[year])\n" +
                "values\n" +
                "\t('1', 'Thien', 2018),\n" +
                "\t('2', 'Meo', 2019),\n" +
                "\t('3', 'Hai', 2018);";
        statement.executeUpdate(sql);
    }

    public static boolean checkInt(String i) {
        try {
            int j = Integer.valueOf(i);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void insert(student student) throws SQLException {
        String name = student.getName();
        String id = student.getId();
        int year = student.getYear();
        Connection connection = connect2DB.connect();
        Statement statement = connection.createStatement();
        String sql = "insert into student ([id],[name],[year])\n"
                    + "values ('" + id + "', '" + name +"', " + year + ");";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Cannot insert student information");
            alert.setContentText("The student with ID: " + id + " already exist!");
            alert.showAndWait();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!");
        alert.setContentText("You have insert a student");
        alert.showAndWait();
        connect2DB.disconnect(connection);
        return;
    }

    public static student search(String id) throws SQLException {
        Connection connection = connect2DB.connect();
        Statement statement = connection.createStatement();
        String sql = "select * from student where id = '" + id + "'";

        ResultSet result = statement.executeQuery(sql);
        student student = new student();

        while (result.next()) {
            student.setId(result.getString("Id"));
            student.setName(result.getString("Name"));
            student.setYear(result.getInt("Year"));
            connect2DB.disconnect(connection);
            return student;
        }
        connect2DB.disconnect(connection);
        return null;
    }

    public static int show(int year) throws SQLException {
        Connection connection = connect2DB.connect();
        Statement statement = connection.createStatement();
        String sql = "select count(*) as t from student where year = " + year;
        ResultSet result = statement.executeQuery(sql);
        int t=0;
        while (result.next()) {
            t = result.getInt("t");
        }
        connect2DB.disconnect(connection);
        return t;
    }

}
