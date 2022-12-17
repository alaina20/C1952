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
import model.Customers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

import static Controller.AddCustomerController.autoCustomerId;

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

    public void sendAppointmentUpdate (Appointments appointments) {

        this.sendAppointmentUpdate = appointments;
        titleText.setText(appointments.getTitle());
        descriptionText.setText(String.valueOf(appointments.getDescription()));
        locationText.setText(String.valueOf(appointments.getLocation()));
        typeText.setText(String.valueOf(appointments.getType()));

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        titleText.setText(appointmentUpdate.getTitle());
        descriptionText.setText(appointmentUpdate.getDescription());
        locationText.setText(appointmentUpdate.getLocation());
        typeText.setText(appointmentUpdate.getType());

        startTimeCombo.setPromptText("Choose a Time");
        LocalTime start = LocalTime.of(6, 0);
        LocalTime end = LocalTime.NOON;

        while(start.isBefore(end.plusSeconds(1))){
            startTimeCombo.getItems().add(start);
            start = start.plusMinutes(10);
        }
        startTimeCombo.getSelectionModel().select((LocalTime.of(8, 0)));

        endTimeCombo.setPromptText("Choose a Time");
        while(start.isBefore(end.plusSeconds(1))){
            endTimeCombo.getItems().add(start);
            start = start.plusMinutes(10);
        }
        endTimeCombo.getSelectionModel().select((LocalTime.of(8, 0)));

    }

    public void startDatePicker(ActionEvent actionEvent) {
    }

    public void endTimeCombo(ActionEvent actionEvent) {

        ObservableList<Appointments> appointments = Appointments.getAllAppointments();
        endTimeCombo.setItems(appointments);
        endTimeCombo.setVisibleRowCount(5);
        endTimeCombo.setPromptText("You must choose a start time...");

        LocalTime start = LocalTime.of(6, 0);
        LocalTime end = LocalTime.NOON;

        while (start.isBefore(end.plusSeconds(1))) {
            endTimeCombo.getItems().add(start);
            start = start.plusMinutes(10);

            endTimeCombo.getSelectionModel().select(LocalTime.of(8, 0));
        }
    }

    public void endDatePicker(ActionEvent actionEvent) {
    }

    public void customerIdCombo(ActionEvent actionEvent) {

        ObservableList<Appointments> appointments = Appointments.getAllAppointments();
        customerCombo.setItems(appointments);
        customerCombo.setVisibleRowCount(5);
        customerCombo.setPromptText("You must choose a customer ID...");

    }

    public void userIdCombo(ActionEvent actionEvent) {

        ObservableList<Appointments> appointments = Appointments.getAllAppointments();
        userCombo.setItems(appointments);
        userCombo.setVisibleRowCount(5);
        userCombo.setPromptText("You must choose a user ID...");

    }

    public void contactIdCombo(ActionEvent actionEvent) {

        ObservableList<Appointments> appointments = Appointments.getAllAppointments();
        contactCombo.setItems(appointments);
        contactCombo.setVisibleRowCount(5);
        contactCombo.setPromptText("You must choose a contact ID...");

    }

    public void startTimeCombo(ActionEvent actionEvent) throws IOException {

        ObservableList<Appointments> appointments = Appointments.getAllAppointments();
        startTimeCombo.setItems(appointments);
        startTimeCombo.setVisibleRowCount(5);
        startTimeCombo.setPromptText("You must choose a start time...");

        LocalTime start = LocalTime.of(6, 0);
        LocalTime end = LocalTime.NOON;

        while (start.isBefore(end.plusSeconds(1))) {
            startTimeCombo.getItems().add(start);
            start = start.plusMinutes(10);

            startTimeCombo.getSelectionModel().select(LocalTime.of(8, 0));
        }
    }

        public void saveUpdate(ActionEvent actionEvent) throws IOException {

        int indexOfAppointment = Appointments.getAllAppointments().indexOf(sendAppointmentUpdate);
        int autoAppointmentId = 0;
        int appointment_ID = sendAppointmentUpdate.getAppointment_ID();
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

        newAppointment = new Appointments (appointment_ID, title, description, location, type, startTime, startDate, endTime, customerID, userID, contactID);

        Appointments.updateAppointments(indexOfAppointment, newAppointment);

        autoAppointmentId = autoAppointmentId + 1;

        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void cancelUpdate (ActionEvent actionEvent) throws IOException {

        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }
}


