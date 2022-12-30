package DAO;
/*
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String databaseName="client_schedule";
    private static final String DB_URL="jdbc:mysql://localhost:3306/"+databaseName;
    private static final String username="sqlUser";
    private static final String password="Passw0rd!";
    private static final String driver="com.mysql.jdbc.Driver";
    static Connection conn;
    public static void makeConnection() throws ClassNotFoundException, SQLException, Exception{
        Class.forName(driver);
        conn=(Connection) DriverManager.getConnection(DB_URL,username,password);
        System.out.println("Connection Successful");
    }
    public static void closeConnection() throws ClassNotFoundException,SQLException, Exception{
        conn.close();
        System.out.println("Connection Closed");
    }

    Public static void makeConnection2()throws ClassNotFoundException, SQLException, Exception{
        MysqlDataSource d = new MysqlDataSource();
        d.setUser(username);
        d.setPassword(password);
        d.setUrl(DB_URL);
        d.setDatabaseName(databaseName);
        conn = (Connection) d.getConnection();
        System.out.println("Connection Successful");
    }
}*/
