package com.example.server_db_admin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class FileWriters {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    public static void main(String[] args) throws IOException {
        FileWriters run = new FileWriters();
        run.updateTextFile(run.getMonth(),"errorOverView.txt");
        run.updateTextFile(run.getMonth(),"connectionsOverView.txt");
        run.writeConnections("Richard@gmail.com");
        run.writeConnections("Mats@gmail.com");
        run.writeConnections("Mats@gmail.com");
        run.writeConnections("Mats@gmail.com");
        run.writeConnections("Mats@gmail.com");
        run.writeConnections("Mats@gmail.com");
        run.writeConnections("Mats@gmail.com");
        run.writeConnections("Mats@gmail.com");
        run.writeConnections("Mats@gmail.com");
        run.writeConnections("Jonte@gmail.com");
        run.writeConnections("Jonte@gmail.com");
        run.writeConnections("Jonte@gmail.com");
        run.writeConnections("Jonte@gmail.com");
        run.writeConnections("Jonte@gmail.com");
        run.writeConnections("Jonte@gmail.com");
        run.writeConnections("Jonte@gmail.com");

        run.writeConnections("Måns@gmail.com");
        run.writeConnections("Måns@gmail.com");
        run.writeConnections("Måns@gmail.com");
        run.writeConnections("Måns@gmail.com");
        run.writeConnections("Måns@gmail.com");
        run.writeConnections("Måns@gmail.com");
        run.writeConnections("Måns@gmail.com");
        run.writeConnections("Måns@gmail.com");
        run.writeConnections("Måns@gmail.com");
        run.writeConnections("Måns@gmail.com");
        run.writeConnections("Måns@gmail.com");
        run.writeConnections("Måns@gmail.com");
        run.writeConnections("Måns@gmail.com");

    }

    public void writeConnections(String connection){
        Date date = new Date(System.currentTimeMillis());
        String errorDate = formatter.format(date);
        try(FileWriter fileWriter = new FileWriter("connectionList.txt", true)) {
            fileWriter.write("[" + errorDate + "] Connected: " + connection + "\n");
            updateTextFile(getMonth(),"connectionsOverView.txt");
        }
        catch(IOException e){
        }
    }

    public void writeToBackLog(String error){
        Date date = new Date(System.currentTimeMillis());
        String errorDate = formatter.format(date);
        try(FileWriter fileWriter = new FileWriter("backlog.txt", true)) {
            fileWriter.write("[" + errorDate + "] Description: " + error + "\n");
            updateTextFile(getMonth(),"errorOverView.txt");
        }
        catch(IOException e){
        }
    }

    public void updateTextFile(int x, String path) throws IOException {
        ArrayList<String> add = new ArrayList<>();
        add = readFromFile(path);
        int number;
        switch (x){
            case 0:
                number = Integer.parseInt(add.get(1));
                number++;
                add.set(1,String.valueOf(number));
                break;
            case 1:
                number = Integer.parseInt(add.get(3));
                number++;
                add.set(3,String.valueOf(number));
                break;
            case 2:
                number = Integer.parseInt(add.get(5));
                number++;
                add.set(5,String.valueOf(number));
                break;
            case 3:
                number = Integer.parseInt(add.get(7));
                number++;
                add.set(7,String.valueOf(number));
                break;
            case 4:
                number = Integer.parseInt(add.get(9));
                number++;
                add.set(9,String.valueOf(number));
                break;
            case 5:
                number = Integer.parseInt(add.get(11));
                number++;
                add.set(11,String.valueOf(number));
                break;
            case 6:
                number = Integer.parseInt(add.get(13));
                number++;
                add.set(13,String.valueOf(number));
                break;
            case 7:
                number = Integer.parseInt(add.get(15));
                number++;
                add.set(15,String.valueOf(number));
                break;
            case 8:
                number = Integer.parseInt(add.get(17));
                number++;
                add.set(17,String.valueOf(number));
                break;
            case 9:
                number = Integer.parseInt(add.get(19));
                number++;
                add.set(19,String.valueOf(number));
                break;
            case 10:
                number = Integer.parseInt(add.get(21));
                number++;
                add.set(21,String.valueOf(number));
                break;
            case 11:
                number = Integer.parseInt(add.get(23));
                number++;
                add.set(23,String.valueOf(number));
                break;
            default:
                break;
        }
        writeToFile(add,path);

    }

    public void writeToFile(ArrayList<String> updatedValues, String path) throws IOException {
        try(FileWriter fileWriter = new FileWriter(path)) {
            for (String s: updatedValues) {
                fileWriter.write(s + "\n");
            }
        }
    }

    public ArrayList<String> readFromFile(String path) throws IOException {
        ArrayList<String> tempReader = new ArrayList<>();
        Scanner s = new Scanner(new File(path));
        tempReader = new ArrayList<>();
        while (s.hasNextLine()){
            tempReader.add(s.nextLine());
        }
        s.close();
        return tempReader;
    }


    public int getMonth(){
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        return month;
    }
}
