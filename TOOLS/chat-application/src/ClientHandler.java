import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.security.*;
import java.util.Base64;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private Server server;

    private Key communicationKey;
    private BufferedReader reader;
    private BufferedWriter writer;

    public ClientHandler(Socket socket, Server server, Key privatekey) {
        this.clientSocket = socket;
        this.server = server;

        try {
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            String enseed = reader.readLine();
            byte[] aesSeed = Encryption.pkDecrypt(privatekey, Base64.getDecoder().decode(enseed));
            this.communicationKey = Encryption.generateAESKey(aesSeed);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public String getClientInfo() {
        return "Client " + clientSocket.getInetAddress() + ":" + clientSocket.getPort();
    }

    // receive message form client

    @Override
    public void run() {
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                // decryped message and broadcast message
                String deprecatedMessage = Encryption.decrypt(communicationKey, message);
                System.out.printf("deprecatedMessage:" + deprecatedMessage);
                server.broadcastMessage(deprecatedMessage, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } finally {
            server.clientDisconnected(this);
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
