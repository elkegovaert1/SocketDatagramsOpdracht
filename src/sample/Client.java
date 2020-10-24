package sample;

import java.io.*;
import java.net.*;
import java.util.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//push test
public class Client extends Application{
    private String username = "Default";
    private String hostName = "localhost";
    private int portNumber = 80;

    public Client() {}
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Chat");
        primaryStage.setScene(new Scene(root, 720, 420));
        primaryStage.show();
    }
    
    public void execute() {
        try {
            Socket socket = new Socket(hostName, portNumber);

            System.out.println("Connected to server");

            new ReadThread(socket, this).start();
            new WriteThread(socket, this).start();

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }

    }

    public static void main(String [] args) {

        Client client = new Client();
        Controller.setClient(client);
        //client.execute();
        launch(args);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


