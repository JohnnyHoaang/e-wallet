 package com.mycompany.ewalletproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.Console;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Stage stage;
    private static Scene scene;
    private static Connection conn;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("LandingPage"), 600, 400);
        this.stage = stage;
        stage.setScene(scene);
        stage.setTitle("E-WALLET APP");
        stage.getIcons().add(new Image(App.class.getResourceAsStream("e-wallet.png")));
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        if ((fxml.equals("SeeNotes")) || (fxml.equals("OpenWallet")) || (fxml.equals("LoadWallet"))){
            stage.setHeight(610);
            stage.setWidth(810);
            scene.setRoot(loadFXML(fxml));
        }
        else{
            stage.setHeight(400);
            stage.setWidth(600);
            scene.setRoot(loadFXML(fxml));
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    private static Connection connectToDB(String username, String password) throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@198.168.52.211:1521/pdbora19c.dawsoncollege.qc.ca",
                username, password );
    }
    public static Connection getConnection() throws SQLException{
        App.conn.setAutoCommit(true);
        return App.conn;
    }
    public static void main(String[] args) throws SQLException{
        Scanner reader = new Scanner(System.in);
        Console console = System.console();
       try {
         String username = console.readLine("Username: ");
          String password = new String(console.readPassword("Password: "));
           App.conn = connectToDB(username, password);
            launch();
        } catch (Exception e) {
           e.printStackTrace();
        }
       finally{
           reader.close();
           App.conn.close();
        }
    }

}