package DAO;
/*
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Users;

import java.util.Calendar;

public class UserDaoImpl {
    static boolean act;
    public static User getUser(String userName) throws SQLException, Exception{
        DBConnection.makeConnection();
        String sqlStatement="select * FROM users WHERE User_Name = '" + userName+ "'";
        Query.makeQuery(sqlStatement);
        User userResult;
        ResultSet result=Query.getResult();
        while(result.next()){
            int userid=result.getInt("User_ID");
            String userNameG=result.getString("User_Name");
            String password=result.getString("Password");
            int active=result.getInt("active");
            if(active==1) act=true;
            String createDate=result.getString("createDate");
            String createdBy=result.getString("createBy");
            String lastUpdate=result.getString("lastUpdate");
            String lastUpdateby=result.getString("lastUpdateBy");
            Calendar createDateCalendar=stringToCalendar(createDate);
            Calendar lastUpdateCalendar=stringToCalendar(lastUpdate);
            userResult= new User(userid, userName, password, act, createDateCalendar, createdBy, lastUpdateCalendar, lastUpdateby);
            return userResult;
        }
        DBConnection.closeConnection();
        return null;
    }
    public static ObservableList<User> getAllUsers() throws SQLException, Exception Exception{
        ObservableList<User> allUsers= FXCollections.observableArrayList();
        DBConnection.makeConnection();
        String sqlStatement="select * from user";
        Query.makeQuery(sqlStatement);
        ResultSet result=Query.getResult();
        while(result.next()){
            int userid=result.getInt("User_ID");
            String userNameG=result.getString("User_Name");
            String password=result.getString("Password");
            int active=result.getInt("active");
            if(active==1) act=true;
            String createDate=result.getString("createDate");
            String createdBy=result.getString("createBy");
            String lastUpdate=result.getString("lastUpdate");
            String lastUpdateby=result.getString("lastUpdateBy");
            Calendar createDateCalendar=stringToCalendar(createDate);
            Calendar lastUpdateCalendar=stringToCalendar(lastUpdate);
            User userResult= new User(userid, userName, password, act, createDateCalendar, createdBy, lastUpdateCalendar, lastUpdateby);
            allUsers.add(userResult);

        }
        DBConnection.closeConnection();
        return allUsers;
    }
}*/
