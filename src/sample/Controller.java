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

    static Client client;
    static Server server;

    public void initialize() {}

    public void setUsername(ActionEvent event) {
        client = new Client();
        client.setUsername(usernameInput.getText());
        client.execute();
    }

    public void verzendBericht(ActionEvent event) {
        System.out.println(bericht.getText());
        server.broadcastWithoutExclude(bericht.getText());
    }

    public String getUsername() {
        return client.getUsername();
    }
    public static void setClient(Client c) {
    	client=c;
    }
    public static void setServer(Server s) {
    	server = s;
    }
}
