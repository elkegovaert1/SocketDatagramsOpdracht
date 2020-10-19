package sample;

import java.io.*;
import java.net.*;

/**
 * This thread is responsible for reading user's input and send it
 * to the server.
 * It runs in an infinite loop until the user types 'bye' to quit.
 *
 * @author www.codejava.net
 */
public class WriteThread extends Thread {
    private PrintWriter writer;
    private Socket socket;
    private Client client;

    public WriteThread(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;

        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void run() {

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;

            System.out.println("\nEnter your name: ");
            String userName = stdIn.readLine();
            client.setUsername(userName);
            writer.println(userName);

            String bericht;
            do {
                System.out.print("[" + userName + "]: ");
                bericht = stdIn.readLine();

                writer.println(bericht);

            } while (!bericht.equals("bye"));

            try {
                socket.close();
            } catch (IOException ex) {
                System.out.println("Error writing to server: " + ex.getMessage());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
