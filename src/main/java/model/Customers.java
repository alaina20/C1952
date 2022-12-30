package model;

import java.util.Date;

public class Customers extends LogIn {

    private int Customer_ID;
    private String Customer_Name;
    private String Address;
    private int Postal_Code;
    private int Phone;
    private Date Create_Date;
    private Date Created_By;
    private Date Last_Update;
    private Date Last_Updated_By;
    private int Division_ID;

    public Customers(int customer_ID, String customer_Name, String address, int postal_Code, int phone, Date create_Date, Date created_By, Date last_Update, Date last_Updated_By, int division_ID) {
        Customer_ID = customer_ID;
        Customer_Name = customer_Name;
        Address = address;
        Postal_Code = postal_Code;
        Phone = phone;
        Create_Date = create_Date;
        Created_By = created_By;
        Last_Update = last_Update;
        Last_Updated_By = last_Updated_By;
        Division_ID = division_ID;
    }

    public Customers(int customer_id, String customer_name, String address, int postal_code, int phone) {
        super();
    }

    public Customers(int id, String name, String address, int phoneNumber, String postalCode, String country, String state) {
        super();
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPostal_Code() {
        return Postal_Code;
    }

    public void setPostal_Code(int postal_Code) {
        Postal_Code = postal_Code;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public Date getCreate_Date() {
        return Create_Date;
    }

    public void setCreate_Date(Date create_Date) {
        Create_Date = create_Date;
    }

    public Date getCreated_By() {
        return Created_By;
    }

    public void setCreated_By(Date created_By) {
        Created_By = created_By;
    }

    public Date getLast_Update() {
        return Last_Update;
    }

    public void setLast_Update(Date last_Update) {
        Last_Update = last_Update;
    }

    public Date getLast_Updated_By() {
        return Last_Updated_By;
    }

    public void setLast_Updated_By(Date last_Updated_By) {
        Last_Updated_By = last_Updated_By;
    }

    public int getDivision_ID() {
        return Division_ID;
    }

    public void setDivision_ID(int division_ID) {
        Division_ID = division_ID;
    }


}
