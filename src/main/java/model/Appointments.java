package model;

import java.util.Date;

public class Appointments extends LogIn {

    /*
    Timestamp.valueOf
    Timestamp.toLocalDateTime
     */

    private int Appointment_ID;
    private String Title;
    private String Description;
    private String Location;
    private String Type;
    private Double Start;
    private Double End;
    private Date Create_Date;
    private Date Created_By;
    private Double Last_Update;
    private Double Last_Updated_By;
    private int Customer_ID;
    private int User_ID;
    private int Contact_ID;

    public Appointments(int appointment_ID, String title, String description, String location, String type, Double start, Double end, Date create_Date, Date created_By, Double last_Update, Double last_Updated_By, int customer_ID, int user_ID, int contact_ID) {
        Appointment_ID = appointment_ID;
        Title = title;
        Description = description;
        Location = location;
        Type = type;
        Start = start;
        End = end;
        Create_Date = create_Date;
        Created_By = created_By;
        Last_Update = last_Update;
        Last_Updated_By = last_Updated_By;
        Customer_ID = customer_ID;
        User_ID = user_ID;
        Contact_ID = contact_ID;
    }

    public Appointments(int appointment_id, String title, String description, String location, String type, Double startTime, int startDate, Double endTime, int customerID, int userID, int contactID) {
        super();
    }

    public int getAppointment_ID() {
        return Appointment_ID;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getLocation() {
        return Location;
    }

    public String getType() {
        return Type;
    }

    public Double getStart() {
        return Start;
    }

    public Double getEnd() {
        return End;
    }

    public Date getCreate_Date() {
        return Create_Date;
    }

    public Date getCreated_By() {
        return Created_By;
    }

    public Double getLast_Update() {
        return Last_Update;
    }

    public Double getLast_Updated_By() {
        return Last_Updated_By;
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public int getContact_ID() {
        return Contact_ID;
    }

    public void setAppointment_ID(int appointment_ID) {
        Appointment_ID = appointment_ID;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setStart(Double start) {
        Start = start;
    }

    public void setEnd(Double end) {
        End = end;
    }

    public void setCreate_Date(Date create_Date) {
        Create_Date = create_Date;
    }

    public void setCreated_By(Date created_By) {
        Created_By = created_By;
    }

    public void setLast_Update(Double last_Update) {
        Last_Update = last_Update;
    }

    public void setLast_Updated_By(Double last_Updated_By) {
        Last_Updated_By = last_Updated_By;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public void setContact_ID(int contact_ID) {
        Contact_ID = contact_ID;
    }

}
