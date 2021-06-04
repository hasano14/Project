/*
    General search
    Search by ID
    Search by Food Group
*/

import java.util.*;
import java.io.*;

public class Search {
    private static String fileName = "Data/input.txt";

    // Search by ID
    public static void foodIDSearch(int foodID) {
        File inputFile = new File(fileName);
        String currentLine;
        boolean exist = false;

        try {
            Scanner fileReader = new Scanner(inputFile);

            fileReader.nextLine();

            if (fileReader.hasNextLine()) {
                while (fileReader.hasNextLine()) {
                    currentLine = fileReader.nextLine();
                    String[] data = currentLine.split(";");
                    if (foodID == Integer.parseInt(data[0])) {
                        System.out.println("ID: " + data[0]);
                        System.out.println("Name: " + data[1]);
                        System.out.println("Group: " + data[2]);
                        System.out.println("Date: " + data[3]);
                        System.out.println("Day: " + data[4]);
                        System.out.println("Drink: " + data[5]);
                        System.out.println();
                        exist = true;
                        fileReader.close();
                        break;
                    }
                }
                if(!exist){
                    System.out.println("Can't find data with the foodID");
                    System.out.println();
                }
                
            } else {
                System.out.println("Empty Field");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search by Food Group
    public static void foodGroupSearch(String foodGroup) {
        File inputFile = new File(fileName);
        ArrayList<String> line = new ArrayList<String>();
        String currentLine;
        try {
            Scanner fileReader = new Scanner(inputFile);

            fileReader.nextLine();
            if (fileReader.hasNextLine()) {
                while (fileReader.hasNextLine()) {
                    currentLine = fileReader.nextLine();
                    String[] data = currentLine.split(";");
                    if (data[2].equals(foodGroup)) {
                        line.add(currentLine);
                    }
                }
            }

            if (!line.isEmpty()) {
                for (int i = 0; i < line.size(); i++) {
                    String[] data = line.get(i).split(";");
                    System.out.println("ID: " + data[0]);
                    System.out.println("Name: " + data[1]);
                    System.out.println("Group: " + data[2]);
                    System.out.println("Date: " + data[3]);
                    System.out.println("Day: " + data[4]);
                    System.out.println("Drink: " + data[5]);
                    System.out.println();
                }
            } else {
                System.out.println("No Food In Food Group");
            }

            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
