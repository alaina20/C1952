package model;

import java.util.Date;

public class FirstLevelDivisions extends LogIn {

    private int Division_ID;
    private String Division;
    private Date Create_Date;
    private Date Created_By;
    private Date Last_Update;
    private Date Last_Updated_By;
    private int Country_ID;

    public FirstLevelDivisions(int division_ID, String division, Date create_Date, Date created_By, Date last_Update, Date last_Updated_By, int country_ID) {
        Division_ID = division_ID;
        Division = division;
        Create_Date = create_Date;
        Created_By = created_By;
        Last_Update = last_Update;
        Last_Updated_By = last_Updated_By;
        Country_ID = country_ID;
    }

    public int getDivision_ID() {
        return Division_ID;
    }

    public void setDivision_ID(int division_ID) {
        Division_ID = division_ID;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
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

    public int getCountry_ID() {
        return Country_ID;
    }

    public void setCountry_ID(int country_ID) {
        Country_ID = country_ID;
    }

}
