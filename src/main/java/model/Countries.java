package model;

import java.util.Date;

public class Countries extends LogIn {

    private int Country_ID;
    private String Country;
    private Date Create_Date;
    private Date Created_By;
    private Date Last_Update;
    private Date Last_Updated_By;

    public Countries(int country_ID, String country, Date create_Date, Date created_By, Date last_Update, Date last_Updated_By) {
        Country_ID = country_ID;
        Country = country;
        Create_Date = create_Date;
        Created_By = created_By;
        Last_Update = last_Update;
        Last_Updated_By = last_Updated_By;
    }

    public int getCountry_ID() {
        return Country_ID;
    }

    public void setCountry_ID(int country_ID) {
        Country_ID = country_ID;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
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

    /*@Override
    public String toString(){
        return ("#" + Integer.toString(Country_ID) + " " + Country + " [" + team + "]");
    }*/

}
