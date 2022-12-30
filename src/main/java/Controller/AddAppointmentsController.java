package Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Appointments;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

/**
 * This class allows the scheduling to add appointments
 */
public class AddAppointmentsController implements Initializable {

    public TextField titleText;
    public TextField descriptionText;
    public TextField locationText;
    public TextField typeText;
    public ComboBox startTimeCombo;
    public DatePicker startDatePicker;
    public ComboBox endTimeCombo;
    public DatePicker endDatePicker;
    public ComboBox customerIdCombo;
    public ComboBox userIdCombo;
    public ComboBox contactIdCombo;
    Stage stage;
    Parent scene;

    /**
     * This method initializes the add appointment code
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

        ObservableList<Appointments> appointments = Appointments.getAllAppointments();
        startTimeCombo.setItems(appointments);
        startTimeCombo.setPromptText("You must choose a start time...");
        startTimeCombo.setVisibleRowCount(5);
        LocalTime start = LocalTime.of(4, 0);
        LocalTime end = LocalTime.of(22,0);
        while (start.isBefore(end.plusSeconds(1))) {
            startTimeCombo.getItems().add(start);
            start = start.plusMinutes(15);
        }

        ObservableList<Appointments> appointments2 = Appointments.getAllAppointments();
        endTimeCombo.setItems(appointments2);
        endTimeCombo.setVisibleRowCount(5);
        endTimeCombo.setPromptText("You must choose an end time...");
        LocalTime begin = LocalTime.of(6, 0);
        LocalTime finish = LocalTime.NOON;
        while (begin.isBefore(finish.plusSeconds(1))) {
            endTimeCombo.getItems().add(begin);
            begin = begin.plusMinutes(10);
        }

        ObservableList<Appointments> appointments3 = Appointments.getAllAppointments();
        customerIdCombo.setItems(appointments3);
        customerIdCombo.setVisibleRowCount(5);
        customerIdCombo.setPromptText("You must choose a customer ID...");

        ObservableList<Appointments> appointments4 = Appointments.getAllAppointments();
        userIdCombo.setItems(appointments4);
        userIdCombo.setVisibleRowCount(5);
        userIdCombo.setPromptText("You must choose a user ID...");

        ObservableList<Appointments> appointments5 = Appointments.getAllAppointments();
        contactIdCombo.setItems(appointments5);
        contactIdCombo.setVisibleRowCount(5);
        contactIdCombo.setPromptText("You must choose a contact ID...");



    }

    /**
     * This method starts the time combo box
     * @param actionEvent
     */
    public void startTimeCombo(ActionEvent actionEvent) {

    }

    /**
     * This method starts the date picker menu
     * @param actionEvent
     */
    public void startDatePicker(ActionEvent actionEvent) {
    }

    /**
     * This method runs the end time combo box
     * @param actionEvent
     */
    public void endTimeCombo(ActionEvent actionEvent) {

    }

    /**
     * This method runs the end date picker combo box
     * @param actionEvent
     */
    public void endDatePicker(ActionEvent actionEvent) {
    }

    /**
     * This method runs the customer ID combo box
     * @param actionEvent
     */
    public void customerIdCombo(ActionEvent actionEvent) {

    }

    /**
     *
     * @param actionEvent
     */
    public void userIdCombo(ActionEvent actionEvent) {

    }

    /**
     *
     * @param actionEvent
     */
    public void contactIdCombo(ActionEvent actionEvent) {

    }

    /**
     *
     * @param actionEvent
     * @throws IOException
     */
    public void saveAppointment(ActionEvent actionEvent) throws IOException {

        int autoAppointmentID = 0;
        int id = autoAppointmentID;
        String title = titleText.getText();
        if(title.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Title cannot be blank.");
            alert.showAndWait();
            return;
        }
        String description = descriptionText.getText();
        if(description.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Description cannot be blank.");
            alert.showAndWait();
            return;
        }
        String location = locationText.getText();
        if(location.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Location cannot be blank.");
            alert.showAndWait();
            return;
        }
        String type = typeText.getText();
        if(type.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Appointment type cannot be blank.");
            alert.showAndWait();
            return;
        }
        Double startTime = Double.valueOf(0);
        try {
            startTime = Double.parseDouble(String.valueOf(startTimeCombo.getItems()));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Start time must select a time");
            alert.showAndWait();
            return;
        }
        int startDate = 0;
        try {
            startDate = Integer.parseInt(String.valueOf(startDatePicker.getOnAction()));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Start date must select a date");
            alert.showAndWait();
            return;
        }
        Double endTime = Double.valueOf(0);
        try {
            endTime = Double.parseDouble(String.valueOf(endTimeCombo.getItems()));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("End time must select a time");
            alert.showAndWait();
            return;
        }
        int endDate = 0;
        try {
            endDate = Integer.parseInt(String.valueOf(endDatePicker.getOnAction()));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("End date must select a date");
            alert.showAndWait();
            return;
        }
        int customerID = 0;
        try {
            customerID = Integer.parseInt(String.valueOf(customerIdCombo.getItems()));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Must select a customer ID");
            alert.showAndWait();
            return;
        }
        int userID = 0;
        try {
            userID = Integer.parseInt(String.valueOf(userIdCombo.getItems()));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Must select a user ID");
            alert.showAndWait();
            return;
        }
        int contactID = 0;
        try {
            contactID = Integer.parseInt(String.valueOf(contactIdCombo.getItems()));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Must select a contact ID");
            alert.showAndWait();
            return;
        }

        Appointments.addAppointment(new Appointments(id, title, description, location, type, startTime, startDate, endTime, customerID, userID, contactID));


        autoAppointmentID = autoAppointmentID + 1;

        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/com/example/view/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    /**
     *
     * @param actionEvent
     * @throws IOException
     */
    public void cancelAppointment(ActionEvent actionEvent) throws IOException {

        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/com/example/view/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
}
