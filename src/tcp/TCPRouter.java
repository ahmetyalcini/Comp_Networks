/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ozan
 */
public class TCPRouter {
    
    private String serverName = "localhost";
    private int serverPort = 8081;
    private Socket socket = null;
    //////Server
    private int port = 8082;
    private Socket socket2 = null;
    private ServerSocket serverSocket = null;
    
    public TCPRouter() {
        try {      
            socket = new Socket(serverName, serverPort);//Client
            
            System.out.println("Connected to server " + socket.getRemoteSocketAddress());
            //Client
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //Server
            serverSocket = new ServerSocket(port);//Server
            System.out.println("Server started on port " + serverSocket.getLocalPort() + "...");
            socket2 = serverSocket.accept();
            System.out.println("Client " + socket2.getRemoteSocketAddress() + " connected to server...");
            DataOutputStream dataOutputStream = new DataOutputStream(socket2.getOutputStream());
            try {
                while(true){
                    String object = dataInputStream.readUTF();//Client
                    dataOutputStream.writeUTF(object);//Server
                }
            } catch (Exception e) {
            }
            dataOutputStream.flush();
            dataOutputStream.close();
            socket2.close();
            dataInputStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    
    
    public static void main(String[] args) throws IOException {
        TCPRouter router1 = new TCPRouter();
    }
}
