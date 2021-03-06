
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.net.URL;


import static javafx.application.Application.launch;

public class Pizza extends Application{

    public void switchUI(String fileName, Label locator){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fileName));
            Stage stage = (Stage) locator.getScene().getWindow();
            Scene scene = new Scene(root, 1600,900);
            stage.setScene(scene);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

   /* public void inCaseOfClose(){
        try {
            currentStage.setOnCloseRequest(e -> closeProgram());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void closeProgram(){
        if(customer.getcID() == null){
            currentStage.close();
        }
        else{
            if (customer.getType().equals("guest")){
                String SQL = "DELETE FROM customers where customerID = " + customer.getcID();
                try {
                    db.statement.executeUpdate(SQL);
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
*/
    public ObservableList<Order> getOrders(){
        ObservableList<Order> orders = FXCollections.observableArrayList();
        orders.removeAll(orders);
        for(int i = 0; i < cart.getNumOrders(); i++){
            orders.add(cart.getOrder(i));
        }
        return orders;
    }

    public static Cart cart = new Cart();

    Database db = new Database();

    public static Customer customer = new Customer();
    private Stage currentStage;


    //audio files
    String mediaFile = "Sample/src/Sounds/ErrorSound.wav";
    Media media = new Media(new File(mediaFile).toURI().toString());
    MediaPlayer errorSound = new MediaPlayer(media);
    String mediaFile2 = "Sample/src/Sounds/WelcomeSound.wav";
    Media media2 = new Media(new File(mediaFile2).toURI().toString());
    MediaPlayer welcomeSound = new MediaPlayer(media2);

    public Pizza(){

    }

    public void setCustomerInfo(String firstN, String lastN, String email, String pass, String address, String creditCard, String phone, String cID){
        customer.setFirstName(firstN);
        customer.setLastName(lastN);
        customer.setEmail(email);
        customer.setPass(pass);
        customer.setAddress(address);
        customer.setCreditCard(creditCard);
        customer.setPhone(phone);
        customer.setcID(cID);
    }

    public void setCurrentStage(Stage currentStage) {
        this.currentStage = currentStage;
    }

    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/LoginPane.fxml"));
            Scene scene = new Scene(root, 1600, 900);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Pizza Ordering");
            primaryStage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
        /*reader = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1. Customer 2. createAccount");
            choice = reader.nextInt();
            if (choice == 1) {
                Customer customer = new Customer();
                if (customer.login()) {
                    if (customer.getValidation().equals("true")) {
                        System.out.println("Login Successful!");
                        //then show menu

                    }
                } else {
                    System.out.println("invalid login. Would you like to create an account? press 3");
                    choice = reader.nextInt();
                    if (choice == 3) {
                        customer.createAccount();
                    }
                }


            }
            if (choice == 2){
                Customer customer = new Customer();
                customer.createAccount();
                //show menu
            }
        }while (choice != 4) ;
        }*/
    }
}





