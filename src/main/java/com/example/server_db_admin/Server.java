package com.example.server_db_admin;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Server extends Thread {

    Socket client;
    BufferedReader reader;
    PrintWriter writer;

    Server(Socket client) {
        this.client = client;
    }

    public void run() {
        try {

            while (true) {

                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                InetAddress inetAddress = client.getLocalAddress();
                System.out.println("Client connected: " + inetAddress);

                int value = Integer.parseInt(reader.readLine());
                switch (value) {
                    case 1:
                        sendFile("backlog");
                        break;
                    case 2:
                        sendFile("connectionList");
                        break;
                    case 3:
                        sendFile("connectionsOverView");
                        break;
                    case 4:
                        sendFile("errorOverView");
                        break;
                    case 5:
                        login();
                        break;
                    default:
                        break;
                }
                client.close();
            }


        } catch (Exception e) {
            System.err.println("Exception caught: client disconnected.");

        }
    }

    private void login(){
        try {
            writer = new PrintWriter(client.getOutputStream(), true);
            String userName = reader.readLine();
            String password = reader.readLine();

            if(userName.equals("admin") && password.equals("admin")){
                writer.println("1");
            } else {
                writer.println("2");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendFile(String file) {
        try {
            FileInputStream input = new FileInputStream(file + ".txt");
            BufferedInputStream b_input = new BufferedInputStream(input);
            BufferedOutputStream output = new BufferedOutputStream(client.getOutputStream());
            int len;
            while ((len = b_input.read()) != -1) {
                output.write(len);
            }
            output.flush();
            output.close();
            input.close();

        } catch (Exception error) {
            error.printStackTrace();
        }
    }

}
