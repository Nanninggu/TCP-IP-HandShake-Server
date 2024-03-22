package com.example.TCP.IP_HandShake_Check_Server;

import com.example.TCP.Sleep.Sleep;

import java.io.*;
import java.net.*;

public class Implement {
    public static void main(String[] args) {
        try {
            // Create a server socket, bind it to localhost on port 8080
            ServerSocket serverSocket = new ServerSocket(9999);

            // Wait for a client connection
            System.out.println("Waiting for client connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            String Port_Info = String.valueOf(clientSocket.getPort());
            InetAddress IP_Address = clientSocket.getInetAddress();
            String LocalPort = String.valueOf(serverSocket.getLocalPort());

            System.out.println(Port_Info + " Port_Info"); // 클라이언트에서 전달된 Port 정보
            System.out.println(IP_Address + " IP_Address"); // 클라이언트 IP
            System.out.println(LocalPort + " LocalPort"); // 서버가 현재 열고있는 Listen Port

            Sleep.sleep(); // 10초 대기

            // Open input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Perform handshake
            out.println("SYN");
            System.out.println("⏩⏩⏩⏩⏩ Server: SYN sent ⏩⏩⏩⏩⏩");
            Sleep sleep = new Sleep();
            Sleep.sleep(); // 10초 대기

            String response = in.readLine();
            if ("ACK".equals(response)) {
                System.out.println("⏪⏪⏪⏪⏪ Server: ACK received ⏪⏪⏪⏪⏪");
                Sleep.sleep(); // 10초 대기
            }

            // Close the connection gracefully with FIN/ACK exchange
            out.println("FIN");
            System.out.println("⏩⏩⏩⏩⏩ Server: FIN sent ⏩⏩⏩⏩⏩");
            Sleep.sleep(); // 10초 대기

            response = in.readLine();
            if ("ACK".equals(response)) {
                System.out.println("⏪⏪⏪⏪⏪ Server: ACK received, connection closed ⏪⏪⏪⏪⏪");
                Sleep.sleep(); // 10초 대기
            }

            response = in.readLine();
            if ("Close".equals(response)) {
                System.out.println("서버를 종료 합니다.");
                // Close resources
                in.close();
                out.close();
                clientSocket.close();
                serverSocket.close();
            }

            String IP_Address_End = String.valueOf(serverSocket.getInetAddress()); // 해당 연결된 IP Address를 찾는다.
//            String LocalPort = String.valueOf(serverSocket.getLocalPort()); // 해당 연결된 Port Number를 찾는다.
            System.out.println(IP_Address_End + " IP_Address_End");
            System.out.println(LocalPort + " LocalPort");
            System.out.println(IP_Address + " 클라이언트에서 달고 들어오는 IP info");

            // Close resources
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("END");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}