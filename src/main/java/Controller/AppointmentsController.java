package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Appointments;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppointmentsController implements Initializable {
    public TableView appointmentsTable;
    Stage stage;
    Parent scene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void addAppointment(ActionEvent actionEvent) throws IOException {

        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/AddAppointments.fxml"));
            loader.load();

            stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();}
        catch(NumberFormatException e)
        {
            System.out.println("Please enter valid values in text fields!");
            System.out.println("Exception: " + e);
        }

    }

    public void updateAppointment(ActionEvent actionEvent) throws IOException {

        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/UpdateAppointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void deleteAppointment(ActionEvent actionEvent) throws IOException {

            Appointments selectedAppointment = (Appointments) appointmentsTable.getSelectionModel().getSelectedItem();
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Delete");
                alert.setContentText("Do you want to delete this appointment?");
                alert.showAndWait();
            }

            Appointments.deleteAppointments(selectedAppointment);

            stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

            //custom message displayed inthe user interface with appointID and type of appointment cancelled

    }

    public void customerTable(ActionEvent actionEvent) throws IOException {

        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void appointmentByWeek(ActionEvent actionEvent) {
    }

    public void appointmentByMonth(ActionEvent actionEvent) {
    }

    public void allAppointments(ActionEvent actionEvent) {
    }
}
