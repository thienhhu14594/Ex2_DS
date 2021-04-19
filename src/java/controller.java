
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import java.sql.SQLException;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class controller {

    @FXML TextField id;
    @FXML TextField name;
    @FXML TextField year;
    @FXML TextField id1;
    @FXML TextField year1;

    @FXML Button insert;
    @FXML Button search;
    @FXML Button show;

    public void initialize() {
    }

    public void insertButton() throws SQLException {
        if (name.getText().equals("") || id.getText().equals("") || year.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("The insert information text field cannot be empty");
            alert.setContentText("Please insert information into all the text field!");
            alert.showAndWait();
            return;
        }

        if (!function.checkInt(year.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("The year must be integer");
            alert.setContentText("Please insert integer into year text field!");
            alert.showAndWait();
            return;
        }

        student student = new student();
        student.setId(id.getText());
        student.setName(name.getText());
        student.setYear(Integer.valueOf(year.getText()));
        function.insert(student);
    }

    public void searchButton() throws SQLException {
        if (id1.getText().equals("")) { return; }
        student student = function.search(id1.getText());
        if (student == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("No student found");
            alert.setContentText("No student was found with ID: " + id1.getText());
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Found a student");
            alert.setHeaderText("Student information");
            alert.setContentText("ID: " + student.getId()
                                 + "\nName: " + student.getName()
                                 + "\nYear: " +student.getYear());
            alert.showAndWait();
        }
    }

    public void showButton() throws SQLException {
        if (year1.getText().equals("")) { return; }
        if (!function.checkInt(year1.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("The year must be integer");
            alert.setContentText("Please insert integer into year text field!");
            alert.showAndWait();
            return;
        }
        int t = function.show(Integer.valueOf(year1.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Total number of student");
        alert.setHeaderText("Information");
        alert.setContentText("Number of students enroll the year " + year1.getText() + " is: " + t);
        alert.showAndWait();
    }

}

