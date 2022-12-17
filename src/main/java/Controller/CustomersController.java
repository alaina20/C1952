package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Customers;
import model.LogIn;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomersController implements Initializable {

    Stage stage;
    Parent scene;

    public Customers updateCustomer;
    @FXML
    private TableView<Customers> customerTableView;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void addCustomer (ActionEvent event) throws IOException {

        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/AddCustomer.fxml"));
            loader.load();

            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();}
        catch(NumberFormatException e)
        {
            System.out.println("Please enter valid values in text fields!");
            System.out.println("Exception: " + e);
        }

    }

    @FXML
    public void updateCustomer (ActionEvent event) throws IOException {

        Customers updateCustomer = customerTableView.getSelectionModel().getSelectedItem();
        if (updateCustomer == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please select a customer to update");
            alert.show();

        }
        else {
            UpdateCustomerController.customerUpdate = updateCustomer;

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/UpdateCustomer.fxml"));
            loader.load();

            UpdateCustomerController UCController = loader.getController();
            UCController.sendCustomerUpdate(customerTableView.getSelectionModel().getSelectedItem());


            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
        }

    }

    @FXML
    public void deleteCustomer (ActionEvent event) throws IOException {

        LogIn selectedCustomer = customerTableView.getSelectionModel().getSelectedItem();

        if(!(selectedCustomer.getAllCustomers().isEmpty())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Delete");
            alert.setContentText("Customers appointments must be deleted before deleting customer!");
            alert.showAndWait();

            return;
        }

        Customers deleteCustomer = customerTableView.getSelectionModel().getSelectedItem();

        if (deleteCustomer == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please select a customer to delete");
            alert.show();

            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete");
        alert.setContentText("Do you want to delete this Customer?");
        alert.showAndWait();
        Customers.deleteCustomer((Customers) selectedCustomer);

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
}
