package sample;

import java.io.*;
import java.net.*;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;

            //System.out.println("\nEnter your name: ");
            //String userName = stdIn.readLine();
            Controller con = new Controller();
            String userName = null;
            if(con.getUsername() != null) {
                userName = con.getUsername();
                client.setUsername(userName);
                writer.println(userName);
            }
            

            String bericht;
            do {
                System.out.print("[" + userName + "]: ");
                bericht = stdIn.readLine();

                writer.println(bericht);

            } while (!bericht.equals("bye"));

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
