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
import model.Countries;
import model.FirstLevelDivisions;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<Appointments> appointments = Appointments.getAllAppointments();
        startTimeCombo.setItems(appointments);
        startTimeCombo.setVisibleRowCount(5);
        startTimeCombo.setPromptText("You must choose a start time...");

        ObservableList<Appointments> appointments2 = Appointments.getAllAppointments();
        endTimeCombo.setItems(appointments2);
        endTimeCombo.setVisibleRowCount(5);
        endTimeCombo.setPromptText("You must choose an end time...");
        //FirstLevelDivisions fld = getAProvince("France");
        //firstLevelDivisionsComboBox.getSelectionModel().selectFirst();
        //firstLevelDivisionsComboBox.setValue();

        ObservableList<Appointments> appointments3 = Appointments.getAllAppointments();
        endTimeCombo.setItems(appointments2);
        endTimeCombo.setVisibleRowCount(5);
        endTimeCombo.setPromptText("You must choose an end time...");

        LocalTime start = LocalTime.of(6, 0);
        LocalTime end = LocalTime.NOON;

        /*while(start.isBefore(end.plusSeconds(1))){
            countriesComboBox.getItems().add(start);
            start = start.plusMinutes(10);
        }*/
        //countriesComboBox.getSelectionModel().select(LocalTime.of(8, 0));

    }

    public void startTimeCombo(ActionEvent actionEvent) {

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
        customerIdCombo.setItems(appointments);
        customerIdCombo.setVisibleRowCount(5);
        customerIdCombo.setPromptText("You must choose a customer ID...");
    }

    public void userIdCombo(ActionEvent actionEvent) {

        ObservableList<Appointments> appointments = Appointments.getAllAppointments();
        userIdCombo.setItems(appointments);
        userIdCombo.setVisibleRowCount(5);
        userIdCombo.setPromptText("You must choose a user ID...");
    }

    public void contactIdCombo(ActionEvent actionEvent) {

        ObservableList<Appointments> appointments = Appointments.getAllAppointments();
        contactIdCombo.setItems(appointments);
        contactIdCombo.setVisibleRowCount(5);
        contactIdCombo.setPromptText("You must choose a contact ID...");

    }

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
        //write code that doesn't allow appointments to be scheduled outside of normal business hours (8am-10pm EST)
        //write code that doesnt allow scheduling appointments that overlap for customers
        //write code that provides an alert when appointment is within 15 minutes of users logging in. includes appointmentId, date, and time. If no appointment then display custom message saying no upcomoing appointments
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
        scene = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    public void cancelAppointment(ActionEvent actionEvent) throws IOException {

        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
}
