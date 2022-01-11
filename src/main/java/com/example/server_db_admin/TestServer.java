package com.example.server_db_admin;

import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

    public static void main(String[] args) {

        TestServer main = new TestServer();
        main.start();
    }

    public void start() {
        try {
            ServerSocket server = new ServerSocket(2345);
            while (true) {
                Socket client = server.accept();
                Server handler = new Server(client);
                handler.start();
            }

        } catch (Exception e) {
            System.err.println("Exception caught:" + e);
        }
    }
}
