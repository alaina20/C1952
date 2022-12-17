package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LogIn {

    private static ObservableList<Appointments> allAppointments = FXCollections.observableArrayList();
    private static ObservableList<Contacts> allContacts = FXCollections.observableArrayList();
    private static ObservableList<Users> allUsers = FXCollections.observableArrayList();
    private static ObservableList<Customers> allCustomers = FXCollections.observableArrayList();
    private static ObservableList<FirstLevelDivisions> allFirstLevelDivisions = FXCollections.observableArrayList();
    private static ObservableList<Countries> allCountries = FXCollections.observableArrayList();

    public static ObservableList<Appointments> getAllAppointments() {

        return allAppointments;

    }

    public static ObservableList<Contacts> getAllContacts() {

        return allContacts;

    }

    public static ObservableList<Users> getAllUsers() {

        return allUsers;

    }

    public static ObservableList<Customers> getAllCustomers() {

        return allCustomers;

    }

    public static ObservableList<FirstLevelDivisions> getAllFirstLevelDivisions() {

        return allFirstLevelDivisions;

    }

    public static ObservableList<Countries> getAllCountries() {

        return allCountries;

    }

    public static boolean deleteAppointments(Appointments selectedAppointment)
    {
        allAppointments.remove(selectedAppointment);
        {
            return false;
        }
    }

    public static boolean deleteContacts(Contacts selectedContact)
    {
        allContacts.remove(selectedContact);
        {
            return false;
        }
    }

    public static boolean deleteCountries(Countries selectedCountries)
    {
        allCountries.remove(selectedCountries);
        {
            return false;
        }
    }

    public static boolean deleteCustomers(Customers selectedCustomer)
    {
        allCustomers.remove(selectedCustomer);
        {
            return false;
        }
    }

    public static boolean deleteFirstLevelDivisions(FirstLevelDivisions selectedFirstLevelDivision)
    {
        allFirstLevelDivisions.remove(selectedFirstLevelDivision);
        {
            return false;
        }
    }

    public static boolean deleteUsers(Users selectedUser)
    {
        allUsers.remove(selectedUser);
        {
            return false;
        }
    }

    public static void updateAppointments(int indexOfAppointment, Appointments selectedAppointment) {

        int index = 0;
        for(Appointments a : LogIn.getAllAppointments()){
            if(a.getAppointment_ID() == selectedAppointment.getAppointment_ID()){
                allAppointments.set(index, selectedAppointment);
                return;
            }
            index++;
        }
    }

    public static void updateCustomer(int indexOfCustomer, Customers selectedCustomer) {

        indexOfCustomer = 0;
        for (Customers c : LogIn.getAllCustomers()) {
            if (c.getCustomer_ID() == selectedCustomer.getCustomer_ID()) {
                allCustomers.set(indexOfCustomer, selectedCustomer);
                return;
            }
            indexOfCustomer++;
        }
    }

    public static void addCustomer(Customers newCustomer){

        allCustomers.add(newCustomer);
    }

    public static void addAppointment(Appointments newAppointment){

        allAppointments.add(newAppointment);
    }

    public static boolean deleteCustomer(Customers selectedCustomer){

        allCustomers.remove(selectedCustomer);{
            return false;
        }
    }


}
