package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//https://www.codejava.net/java-se/networking/how-to-create-a-chat-console-application-in-java-using-socket

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Chat");
        primaryStage.setScene(new Scene(root, 720, 420));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

// brechtwillems@hotmail.be
