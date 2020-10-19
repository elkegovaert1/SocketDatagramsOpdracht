package sample;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    private String username;
    private String hostName = "localhost";
    private int portNumber = 80;

    public Client() {}

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

        /*while ((fromServer = in.readLine()) != null) {
            // lijst van berichten in strings
            berichten.add(fromServer);
            // update view

            fromUser = stdIn.readLine();
            if (fromUser != null) {
                System.out.println("Client: " + fromUser);
                out.println(fromUser);
            }
        }*/

    }

    public static void main(String [] args) throws IOException {
        List<String> berichten = new ArrayList<>();

        Client client = new Client();
        client.execute();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


