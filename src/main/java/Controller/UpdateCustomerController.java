package Controller;

import static Controller.AddCustomerController.autoCustomerId;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateCustomerController implements Initializable {

    public ComboBox countryCombo;
    public ComboBox stateCombo;
    Stage stage;
    Parent scene;
    Customers sendCustomerUpdate;

    @FXML
    private TextField customerNameText;
    @FXML
    private TextField addressText;
    @FXML
    private TextField postalCodeText;
    @FXML
    private TextField phoneNumberText;

    public static Customers customerUpdate;

    public void sendCustomerUpdate (Customers customers) {

        this.sendCustomerUpdate = customers;
        customerNameText.setText(customers.getCustomer_Name());
        addressText.setText(String.valueOf(customers.getAddress()));
        postalCodeText.setText(String.valueOf(customers.getPostal_Code()));
        phoneNumberText.setText(String.valueOf(customers.getPhone()));

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        customerNameText.setText(customerUpdate.getCustomer_Name());
        addressText.setText(customerUpdate.getAddress());
        postalCodeText.setText(Integer.toString(customerUpdate.getPostal_Code()));
        phoneNumberText.setText(Integer.toString(customerUpdate.getPhone()));
        ObservableList<Countries> countries = Countries.getAllCountries();
        countryCombo.setItems(countries);
        countryCombo.setVisibleRowCount(5);
        countryCombo.setPromptText("You must select a country");
        ObservableList<FirstLevelDivisions> firstLevelDivisions = FirstLevelDivisions.getAllFirstLevelDivisions();
        stateCombo.setItems(firstLevelDivisions);
        stateCombo.setVisibleRowCount(5);
        stateCombo.setPromptText("You must select a state or province");


    }

    @FXML
    public void saveCustomer (ActionEvent event) throws IOException {

        int indexOfCustomer = Customers.getAllCustomers().indexOf(sendCustomerUpdate);
        int customer_ID = sendCustomerUpdate.getCustomer_ID();
        String customer_Name = customerNameText.getText();
        if(customer_Name.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Name cannot be blank.");
            alert.showAndWait();
            return;
        }
        int postal_Code = 0;
        try {
            postal_Code = Integer.parseInt(postalCodeText.getText());
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Postal code must be a number");
            alert.showAndWait();
            return;
        }
        int phone = 0;
        try {
            phone = Integer.parseInt(phoneNumberText.getText());
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Price must be a number");
            alert.showAndWait();
            return;
        }
        String address = addressText.getText();
        if(address.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Address cannot be blank.");
            alert.showAndWait();
            return;
        }

        Customers newCustomer = null;

        newCustomer = new Customers (customer_ID, customer_Name, address, postal_Code, phone);

        Customers.updateCustomer(indexOfCustomer, newCustomer);

        autoCustomerId = autoCustomerId + 1;

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    public void cancelCustomerUpdate (ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void countriesComboBox(ActionEvent actionEvent) {

        ObservableList<Countries> countries = Countries.getAllCountries();
        countryCombo.setItems(countries);
        countryCombo.setVisibleRowCount(5);
        countryCombo.setPromptText("You must choose a country");
    }

    public void firstLevelDivisionComboBox(ActionEvent actionEvent) {

        ObservableList<FirstLevelDivisions> firstLevelDivisions = FirstLevelDivisions.getAllFirstLevelDivisions();
        stateCombo.setItems(firstLevelDivisions);
        stateCombo.setVisibleRowCount(5);
        stateCombo.setPromptText("You must select a state or province");
    }
}
