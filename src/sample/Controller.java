package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    // buttons
    @FXML
    private Button backButton;

    @FXML
    private Button sendButton;

    @FXML
    private Button usernameButton;

    // lists
    @FXML
    private ListView users;

    @FXML
    private ListView chat;

    // textfield
    @FXML
    private TextField bericht;

    @FXML
    private TextField usernameInput;

    Client client;
    Server server;

    public void initialize() {}

    public void setUsername(ActionEvent event) {
        client = new Client();
        client.execute();
    }

    public void verzendBericht(ActionEvent event) {
        System.out.println(bericht.getText());
    }

    public String getUsername() {
        return usernameInput.getText();
    }

}
