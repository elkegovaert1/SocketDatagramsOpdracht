package sample;

import java.io.*;
import java.net.*;
import java.util.*;


public class Server {
    private int port;
    private Set<String> usernames = new HashSet<>();
    private Set<UserThread> userThreads = new HashSet<>();

    public Server(int port) {
        this.port = port;
    }

    public void execute() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            while (true) {
                Socket socket = serverSocket.accept();

                UserThread newUser = new UserThread(socket,this);
                userThreads.add(newUser);
                newUser.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(80);
        server.execute();

    }

    void broadcast(String message, UserThread excludeUser) {
        for (UserThread user : userThreads) {
            if (user != excludeUser) {
                user.sendMessage(message);
            }
        }
    }

    void addUserName(String userName) {
        usernames.add(userName);
    }

    void removeUser(String userName, UserThread user) {
        boolean removed = usernames.remove(userName);
        if (removed) {
            userThreads.remove(user);
        }
    }

    Set<String> getUserNames() {
        return this.usernames;
    }

    boolean hasUsers() {
        return !this.usernames.isEmpty();
    }
}
