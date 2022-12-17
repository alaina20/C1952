package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class LogInController implements Initializable {

    Stage stage;
    Parent scene;
    @FXML
    private TextField userIdTxt;

    @FXML
    private TextField passwordTxt;

    @FXML
    private Label timeZoneLbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Locale timeZoneLbl = new Locale("fr", "FR");
        ResourceBundle rb = ResourceBundle.getBundle("Main/Nat", Locale.getDefault());

        //write code of at least two different lambda expressions to improve your code
        //write code that provides ability to track user activity by recording all user log-in attempts, dates, and time stamps and whether each attempt was successful in a file named login_activity.txt. Append each new record to the existing file, and save to the root folder of the application
        //provide javadoc for entire program and create index.html file of your comments
        //create a README.txt file that includes: title and purpose of application, author contact information student application version and date, IDE including version number full JDK of version used and JavaFX version compatible with JDK version, directions for how to run the program, a description of the additional report of your choice you ran in part A3f, the MySQL Connector driver version number, including the update number


    }

    @FXML
    public void logIn (ActionEvent event) throws IOException {

        String userId = userIdTxt.getText();
        if(userId.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            //alert.setTitle("Information Dialog");
            //alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("UserId cannot be blank.");

            alert.showAndWait();
            return;
        }

        String password = passwordTxt.getText();
        if(password.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            //alert.setTitle("Information Dialog");
            //alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("Password cannot be blank.");

            alert.showAndWait();
            return;
        }

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }


}