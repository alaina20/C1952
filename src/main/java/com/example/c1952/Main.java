package com.example.c1952;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Locale;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/LogIn.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        Locale france = new Locale("fr", "FR");
        //ResourceBundle rb = ResourceBundle.getBundle("Main/Nat", Locale.getDefault());
        //System.out.println(rb.getString("hello") + " " + rb.getStringArray("world"));

       /* LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        LocalDateTime nowDateTime = LocalDateTime.of(nowDate, nowTime);
        System.out.println("It's currently " + nowDateTime + "where I am");
        launch();
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
    // Totality begins in Austin, TX in 2024 at 1:35pm and 56 seconds;
    // Specify year, month, dayOfMonth, hour, minute, second, nano, zone
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