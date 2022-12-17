package Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Countries;
import model.FirstLevelDivisions;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.chrono.MinguoChronology;
import java.util.ResourceBundle;

public class AddCustomerController implements Initializable {

    public static int autoCustomerId = 1;

    Stage stage;
    Parent scene;

    @FXML
    private TextField customerNameText;
    @FXML
    private TextField customerAddressText;
    @FXML
    private TextField customerPostalCodeText;
    @FXML
    private TextField customerPhoneNumber;

    public ComboBox<Countries> countriesComboBox;
    public ComboBox<FirstLevelDivisions> firstLevelDivisionsComboBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<Countries> countries = Countries.getAllCountries();
        countriesComboBox.setItems(countries);
        //countriesComboBox.setVisibleRowCount(5);
        countriesComboBox.setPromptText("You must choose a Country...");

        ObservableList<FirstLevelDivisions> firstLevelDivisions = FirstLevelDivisions.getAllFirstLevelDivisions();
        firstLevelDivisionsComboBox.setItems(firstLevelDivisions);
        //firstLevelDivisionsComboBox.setVisibleRowCount(5);
        firstLevelDivisionsComboBox.setPromptText("You must choose a State/Province...");
        //FirstLevelDivisions fld = getAProvince("France");
        firstLevelDivisionsComboBox.getSelectionModel().selectFirst();
        //firstLevelDivisionsComboBox.setValue();

        LocalTime start = LocalTime.of(6, 0);
        LocalTime end = LocalTime.NOON;

        /*while(start.isBefore(end.plusSeconds(1))){
            countriesComboBox.getItems().add(start);
            start = start.plusMinutes(10);
        }*/
        //countriesComboBox.getSelectionModel().select(LocalTime.of(8, 0));



    }

    @FXML
    public void saveCustomer (ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    public void cancelCustomer (ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    public void countryComboBox (ActionEvent event) throws IOException {

        ObservableList<Countries> countries = Countries.getAllCountries();
        countriesComboBox.setItems(countries);
        countriesComboBox.setVisibleRowCount(5);
        countriesComboBox.setPromptText("You must choose a country");

    }

    @FXML
    public void stateProvinceComboBox (ActionEvent event) throws IOException {

        ObservableList<FirstLevelDivisions> firstLevelDivisions = FirstLevelDivisions.getAllFirstLevelDivisions();
        firstLevelDivisionsComboBox.setItems(firstLevelDivisions);
        firstLevelDivisionsComboBox.setVisibleRowCount(5);
        firstLevelDivisionsComboBox.setPromptText("You must select a state or province");

    }
}
