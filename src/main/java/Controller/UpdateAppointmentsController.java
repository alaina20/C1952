package Controller;

//import static Controller.AddAppointmentsController.autoAppointmentId;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
 * This class allows customers to be updated in the scheduler
 */
public class UpdateAppointmentsController implements Initializable {


    @ FXML public DatePicker startDatePicker;
    @FXML public ComboBox endTimeCombo;
    @FXML public DatePicker endDatePicker;
    @FXML public ComboBox customerCombo;
    @FXML public ComboBox userCombo;
    @FXML public ComboBox contactCombo;
    @FXML public ComboBox startTimeCombo;
    Stage stage;
    Parent scene;
    @FXML
    private TextField titleText;
    @FXML
    private TextField descriptionText;
    @FXML
    private TextField locationText;
    @FXML
    private TextField typeText;

    public static Appointments appointmentUpdate;
    private Appointments sendAppointmentUpdate;
    public ComboBox<Appointments> startTime;

    /**
     *
     * @param appointments
     */
    public void sendAppointmentUpdate (Appointments appointments) {

        this.sendAppointmentUpdate = appointments;
        titleText.setText(appointments.getTitle());
        descriptionText.setText(String.valueOf(appointments.getDescription()));
        locationText.setText(String.valueOf(appointments.getLocation()));
        typeText.setText(String.valueOf(appointments.getType()));

    }

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

        ObservableList<Appointments> appointments = Appointments.getAllAppointments();
        startTimeCombo.setItems(appointments);
        startTimeCombo.setPromptText("You must choose a start time...");
        startTimeCombo.setVisibleRowCount(5);
        LocalTime start = LocalTime.of(6, 0);
        LocalTime end = LocalTime.NOON;
        while (start.isBefore(end.plusSeconds(1))) {
            startTimeCombo.getItems().add(start);
            start = start.plusMinutes(10);
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
        customerCombo.setItems(appointments3);
        customerCombo.setVisibleRowCount(5);
        customerCombo.setPromptText("You must choose a customer ID...");

        ObservableList<Appointments> appointments4 = Appointments.getAllAppointments();
        userCombo.setItems(appointments4);
        userCombo.setVisibleRowCount(5);
        userCombo.setPromptText("You must choose a user ID...");

        ObservableList<Appointments> appointments5 = Appointments.getAllAppointments();
        contactCombo.setItems(appointments5);
        contactCombo.setVisibleRowCount(5);
        contactCombo.setPromptText("You must choose a contact ID...");

    }

    /**
     *
     * @param actionEvent
     */
    public void startDatePicker(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent
     */
    public void endTimeCombo(ActionEvent actionEvent) {

    }

    /**
     *
     * @param actionEvent
     */
    public void endDatePicker(ActionEvent actionEvent) {
    }

    /**
     *
     * @param actionEvent
     */
    public void customerIdCombo(ActionEvent actionEvent) {

        ObservableList<Appointments> appointments = Appointments.getAllAppointments();
        customerCombo.setItems(appointments);
        customerCombo.setVisibleRowCount(5);
        customerCombo.setPromptText("You must choose a customer ID...");

    }

    /**
     *
     * @param actionEvent
     */
    public void userIdCombo(ActionEvent actionEvent) {

        ObservableList<Appointments> appointments = Appointments.getAllAppointments();
        userCombo.setItems(appointments);
        userCombo.setVisibleRowCount(5);
        userCombo.setPromptText("You must choose a user ID...");

    }

    /**
     *
     * @param actionEvent
     */
    public void contactIdCombo(ActionEvent actionEvent) {

        ObservableList<Appointments> appointments = Appointments.getAllAppointments();
        contactCombo.setItems(appointments);
        contactCombo.setVisibleRowCount(5);
        contactCombo.setPromptText("You must choose a contact ID...");

    }

    /**
     *
     * @param actionEvent
     * @throws IOException
     */
    public void startTimeCombo(ActionEvent actionEvent) throws IOException {

    }

    /**
     *
     * @param actionEvent
     * @throws IOException
     */
        public void saveUpdate(ActionEvent actionEvent) throws IOException {

        int indexOfAppointment = Appointments.getAllAppointments().indexOf(sendAppointmentUpdate);
        int autoAppointmentId = 0;
        //int appointment_ID = sendAppointmentUpdate.getAppointment_ID();
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
            customerID = Integer.parseInt(String.valueOf(customerCombo.getItems()));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Must select a customer ID");
            alert.showAndWait();
            return;
        }
        int userID = 0;
        try {
            userID = Integer.parseInt(String.valueOf(userCombo.getItems()));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Must select a user ID");
            alert.showAndWait();
            return;
        }
        int contactID = 0;
        try {
            contactID = Integer.parseInt(String.valueOf(contactCombo.getItems()));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Must select a contact ID");
            alert.showAndWait();
            return;
        }

        Appointments newAppointment = null;

       // newAppointment = new Appointments (appointment_ID, title, description, location, type, startTime, startDate, endTime, customerID, userID, contactID);

        Appointments.updateAppointments(indexOfAppointment, newAppointment);

        autoAppointmentId = autoAppointmentId + 1;

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
    public void cancelUpdate (ActionEvent actionEvent) throws IOException {

        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/com/example/view/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }
}


