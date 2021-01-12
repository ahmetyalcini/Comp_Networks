package tcp;

import java.io.*;
import java.net.*;


public class TCPClient {

    private String serverName = "localhost";
    private int serverPort = 8082;
    private Socket socket = null;

    public TCPClient() {
        try {
            socket = new Socket(serverName, serverPort);
            System.out.println("Connected to server " + socket.getRemoteSocketAddress());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            try {
                while(true){
                String object = dataInputStream.readUTF();

                System.out.println(object); 
            }
            } catch (Exception e) {
            }
            
                           
                     
            
            dataInputStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        TCPClient client1 = new TCPClient();
    }
}