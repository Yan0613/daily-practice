import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.security.*;

import javax.swing.*;

public class Server {
    private static final String RSA = "RSA";
    private Key privateKey;
    private Key communicationKey;

    // --------------------------------------------------------------------------
    private ServerSocket serverSocket;
    private ArrayList<ClientHandler> clients = new ArrayList<>();

    private JFrame frame;
    private JTextArea logArea;

    public Server(int port) {
        try {
            privateKey = Encryption.readPrivateKey("./keypairs/pkcs8_key");
            // this.communicationKey = Encryption.pkEncrypt(privateKey,encrypedSeed);

            serverSocket = new ServerSocket(port);

            createGUI();

            logMessage("Server is running on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                logMessage("New client connected: " + clientSocket);

                ClientHandler clientHandler = new ClientHandler(clientSocket, this, privateKey);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createGUI() {
        frame = new JFrame("Chat Room - Server");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            client.sendMessage(sender.getClientInfo() + ": " + message);
        }
        logMessage(sender.getClientInfo() + ": " + message);
    }

    public ArrayList<ClientHandler> getClients() {
        return clients;
    }

    public void clientDisconnected(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        logMessage("Client disconnected: " + clientHandler.getClientSocket());
    }

    private void logMessage(String message) {
        logArea.append(getCurrentTime() + " " + message + "\n");
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return "[" + sdf.format(new Date()) + "]";
    }

    public static void main(String[] args) {
        int port = 2222;
        new Server(port);
    }
}
