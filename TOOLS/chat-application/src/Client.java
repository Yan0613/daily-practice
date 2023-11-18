import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.security.Key;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    private static final String RSA = "RSA";
    private static final String SERVER_PUBLIC_KEY = "MIGeMA0GCSqGSIb3DQEBAQUAA4GMADCBiAKBgGk9wUQ4G9PChyL5SUkCyuHjTNOglEy5h4KEi0xpgjxi/UbIH27NXLXOr94JP1N5pa1BbaVSxlvpuCDF0jF9jlZw5IbBg1OW2R1zUACK+NrUIAYHWtagG7KB/YcyNXHOZ6Icv2lXXd7MbIao3ShrUVXo3u+5BJFCEibd8a/JD/KpAgMBAAE=";
    private PublicKey serverPublicKey;
    private Key communicationKey;
    //-------------------------------------------------------------
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    private JFrame frame;
    private JTextArea chatArea;
    private JTextField messageField;

    public Client(String serverAddress, int serverPort) {
        try {
            serverPublicKey = Encryption.readPublicKey(SERVER_PUBLIC_KEY);
            socket = new Socket(serverAddress, serverPort);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            createGUI();
            logMessage("Connected to server at " + serverAddress + ":" + serverPort);
            new Thread(new IncomingReader()).start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createGUI() {
        frame = new JFrame("Chat Room - Client " + socket.getLocalPort());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        frame.add(messageField, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void sendMessage() {
        try {
            String message = messageField.getText();
            writer.write(getCurrentTime() + socket.getLocalPort() + ":" + message + "\n");
            writer.flush();
            messageField.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return "[" + sdf.format(new Date()) + "]";
    }

    private void logMessage(String message) {
        chatArea.append(message + "\n");
    }

    private class IncomingReader implements Runnable {
        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    logMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 2222;
        new Client(serverAddress, serverPort);
    }
}
