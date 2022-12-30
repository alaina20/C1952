package Controller;

import com.example.c1952.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Appointments;
import model.Customers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

/**
 * This class holds all the appointments that have been made in the scheduler
 */
public class AppointmentsController implements Initializable {
    public TableView appointmentsTable;
    public RadioButton viewByWeek;
    public RadioButton viewByMonth;
    public RadioButton viewAll;
    Stage stage;
    Parent scene;

    /**
     *
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    /**
     *
     * @param actionEvent
     * @throws IOException
     */
    public void addAppointment(ActionEvent actionEvent) throws IOException {

        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/view/AddAppointments.fxml"));
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

    /**
     *
     * @param actionEvent
     * @throws IOException
     */
    public void updateAppointment(ActionEvent actionEvent) throws IOException {

        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = load(getClass().getResource("/com/example/view/UpdateAppointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     *
     * @param actionEvent
     * @throws IOException
     */
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
            scene = load(getClass().getResource("/com/example/view/Appointments.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

            //custom message displayed inthe user interface with appointID and type of appointment cancelled

    }

    /**
     *
     * @param actionEvent
     * @throws IOException
     */
    public void customerTable(ActionEvent actionEvent) throws IOException {

        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = load(getClass().getResource("/com/example/view/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    /**
     *
     * @param actionEvent
     */
    public void appointmentByWeek(ActionEvent actionEvent) {


        if (viewByWeek.isSelected()) {


        }
    }

    /**
     *
     * @param actionEvent
     */
    public void appointmentByMonth(ActionEvent actionEvent) {

        if (viewByMonth.isSelected()) {


        }
    }

    /**
     *
     * @param actionEvent
     */
    public void allAppointments(ActionEvent actionEvent) {

        if (viewAll.isSelected()) {


        }
    }
}
