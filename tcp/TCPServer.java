package tcp;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCPServer {

    private int port = 8081;
    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private int count =0;
    private int packet=0;

    public TCPServer() {
        try {
           
            packet = Packet();
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + serverSocket.getLocalPort() + "...");

            socket = serverSocket.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected to server...");
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                try {
                    while(true){
                        if(count==packet) {break;}
                            dataOutputStream.writeUTF("sa");
                            count++;
                            Thread.sleep(500);
                     }
                 
                    
                    } catch (Exception e) {

                    }
                 
           
            
           
            dataOutputStream.flush();
            dataOutputStream.close();
            socket.close();
                 

        } catch (IOException e) {
            System.out.println("Error : " + e);
        }
    }

    public static void main(String[] args) throws IOException {
        TCPServer server1 = new TCPServer();
    }
    
    private int Packet(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Kaç paket Gönderileceğini Giriniz.");
        return scan.nextInt();
    }
}