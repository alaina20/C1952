package model;

import java.util.Date;

public class Users {

    private int User_ID;
    private String User_Name;
    private String Password;
    private Date Create_Date;
    private Date Created_By;
    private Date Last_Update;
    private Date Last_Updated_By;

    public Users(int user_ID, String user_Name, String password, Date create_Date, Date created_By, Date last_Update, Date last_Updated_By) {
        User_ID = user_ID;
        User_Name = user_Name;
        Password = password;
        Create_Date = create_Date;
        Created_By = created_By;
        Last_Update = last_Update;
        Last_Updated_By = last_Updated_By;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
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

}
