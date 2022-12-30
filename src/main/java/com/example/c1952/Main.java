package com.example.c1952;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Locale;

/**
 * This class creates the application that displays and manages scheduling
 */
public class Main extends Application {
    /**
     * This class starts the code that runs on the main program
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/view/LogIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("LogIn");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * This method runs the main code
     * @param args
     */
    public static void main(String[] args) {


        //LocalDateTime otherDT = LocalDateTime.of(lDate, lTime);
        //ZonedDateTime zdt = otherDT.atZone(ZoneId.of("American/New_York"));
        //Locale france = new Locale("fr", "FR");
        //ResourceBundle rb = ResourceBundle.getBundle("Main/Nat", Locale.getDefault());
        //System.out.println(rb.getString("hello") + " " + rb.getStringArray("world"));

       /* LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        LocalDateTime nowDateTime = LocalDateTime.of(nowDate, nowTime);
        System.out.println("It's currently " + nowDateTime + "where I am");*/
        launch();/*
    }

    LocalDateTime nowDateTime = LocalDateTime.now();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm");

    ZonedDateTime zTotalityDateTime = ZonedDateTime.of(eclipseDay, ZoneId.of("US/Pacific"));
    System.out.println("Date and time totality begins with time zone: " + zTotalityDateTime);
    ZonedDateTime followingThursdayDateTime =
            zTotalityDateTime.with(TemporalAdjusters.next(   // adjust date time
                    DayOfWeek.THURSDAY));                        // to next Thursday
    System.out.println("Thursday following the totality: " +
    followingThursdayDateTime);

    //Creating a reminder for an event in the future
    //Totality begins in Austin, TX in 2024 at 1:35pm and 56 seconds;
    //Specify year, month, dayOfMonth, hour, minute, second, nano, zone
    ZonedDateTime totalityAustin =
            ZonedDateTime.of(2024, 4, 8, 13, 35, 56, 0, ZoneId.of("US/Central"));
    System.out.println("Next total eclipse in the US, date/time in Austin, TX: " +
    totalityAustin);
    // Reminder for a month before
    Period period = Period.ofMonths(1);
    System.out.println("Period is " + period);
    ZonedDateTime reminder = totalityAustin.minus(period);
    System.out.println("DateTime of 1 month reminder: " + reminder);

    Locale locFR = new Locale("fr"); // French
    locFR.getDisplayCountry(locFR);
    locFR.getDisplayLanguage(locFR);*/
    }
}