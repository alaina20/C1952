package Controller;

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
import model.Appointments;
import model.Countries;
import model.Customers;
import model.FirstLevelDivisions;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

/**
 * This class allows the schedule to add customers
 */
public class AddCustomerController implements Initializable {

    public static int autoCustomerId = 1;
    @FXML public TextField customerID;
    @FXML private TextField customerPhoneNumberText;
    @FXML public ComboBox countryCombo;
    @FXML public ComboBox stateCombo;

    Stage stage;
    Parent scene;

    @FXML
    private TextField customerNameText;
    @FXML
    private TextField customerAddressText;
    @FXML
    private TextField customerPostalCodeText;

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

        ObservableList<Countries> countries = Countries.getAllCountries();
        countryCombo.setItems(countries);
        countryCombo.setVisibleRowCount(5);
        countryCombo.setPromptText("Choose a Country...");

        ObservableList<FirstLevelDivisions> firstLevelDivisions = FirstLevelDivisions.getAllFirstLevelDivisions();
        stateCombo.setItems(firstLevelDivisions);
        stateCombo.setVisibleRowCount(5);
        stateCombo.setPromptText("Choose a State/Province...");
        //FirstLevelDivisions fld = getAProvince("France");
        stateCombo.getSelectionModel().selectFirst();
        //firstLevelDivisionsComboBox.setValue();

    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void saveCustomer (ActionEvent event) throws IOException {

        int autoCustomerID = autoCustomerId + 1;
        int id = autoCustomerID;
        String name = customerNameText.getText();
        if(name.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Name cannot be blank.");
            alert.showAndWait();
            return;
        }
        String address = customerAddressText.getText();
        if(address.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Address cannot be blank.");
            alert.showAndWait();
            return;
        }
        int phoneNumber = 0;
        try {
            phoneNumber = Integer.parseInt(customerPhoneNumberText.getText());
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Phone number must be a number");
            alert.showAndWait();
            return;
        }
        String postalCode = customerPostalCodeText.getText();
        if(postalCode.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Postal code cannot be blank");
            alert.showAndWait();
            return;
        }
        String country = String.valueOf(countryCombo.getItems());
        if(country.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Must select a country");
            alert.showAndWait();
            return;
        }
        String state = String.valueOf(stateCombo.getItems());
        if(state.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Must select a state/province");
            alert.showAndWait();
            return;
        }

        Customers.addCustomer(new Customers(id, name, address, phoneNumber, postalCode, country, state));

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/com/example/view/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void cancelCustomer (ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/com/example/view/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void countryComboBox (ActionEvent event) throws IOException {

    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void stateProvinceComboBox (ActionEvent event) throws IOException {

    }
}
