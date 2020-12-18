package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket s = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = s.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out

        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // Read message sent by the client
        String str = inServer.readLine();
        int x = Integer.parseInt(str);
        int j=1;
        while( j<=x)
        { 
            int r=0;
            j++;
            for (int i=1;i<=j;i++)
        {
            if ((j%i)==0)
                r++;
            
        }
            if (r==2)
                System.out.println(j);
        }          


        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
    }
}
