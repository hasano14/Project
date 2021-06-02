/* CRUD operations java */

/*
  Crud
  1. Create
  2. Read
  3. Update
  4. Delete
  5. Search

  1.1 Create a new record
  1.2 Data to insert
    1.2.1 Image (Save as png with foodID)
    1.2.2 Name (Name of the food)
    1.2.3 Food Group (General food groups)
    1.2.4 Date (DD/MM/YYYY)
    1.2.5 Day (Breakfast/Brunch/Lunch/Tea/Supper/Dinner/Late Night)
    1.2.6 Drink
  1.3 Insert data into file
    1.3.1 Use ';' to break the data
  1.4 Using foodID (increment) to diff the data.

  2.1 Read data from the file
  2.2 View/Search existing data
  2.3 Search By foodID
    2.3.1 If exist will show and can do further actions
      2.3.1.1 If exist, the actions can be update or delete (starts from here)

  3.1 Update existing data
  3.2 Start from the view/search the existing food
    3.2.1 If exist, will show, if not won't show

  4.1 Delete existing data
  4.2 Starts from search by ID (View/Search)

  5.1 General search by past meals
    5.1.1 Search by the foodID
    5.1.2 Search by Date, Drinks
    5.1.3 Shows in a table of all related ones
    5.1.4 Further actions can be taken from the table
  5.2 Filter search the meals
    5.2.1 Search by the name of the food groups
*/

import java.io.*;
import java.util.*;

public class Opera {
  private String fileName;
  private String updateFileName;

  public Opera() {
    this.fileName = "Data/input.txt";
    this.updateFileName = "Data/update.txt";
  }

  // To open and read file
  // Returns true if file exists
  public boolean fileTest() {
    try {
      File myInputFile = new File(fileName);

      if (myInputFile.createNewFile() == false) {
        return true;
      } else {
        System.out.println("File Created");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
    return false;
  }

  // Return foodID
  /*
   * The addFood method is by getting the data and putting it in the highest
   * maxID+1 so that it won't duplicate.
   */
  public int addFood(String name, String fgroup, String date, String day, String drink) {
    String strCurrentLine;
    String holder;
    ArrayList<Integer> tempID = new ArrayList<Integer>();

    try {
      File inputFile = new File(fileName);
      FileWriter fr = null;
      Scanner fileReader = new Scanner(inputFile);
      fileReader.nextLine();
      if (fileReader.hasNextLine()) {
        while (fileReader.hasNextLine()) {
          strCurrentLine = fileReader.nextLine();
          String[] data = strCurrentLine.split(";");
          int tempIntHolder = Integer.parseInt(data[0]);
          tempID.add(tempIntHolder);
        }
        int maxID = Collections.max(tempID);
        maxID++;
        fileReader.close();
        holder = (maxID + ";" + name + ";" + fgroup + ";" + date + ";" + day + ";" + drink + ";"
            + System.getProperty("line.separator"));
        fr = new FileWriter(inputFile, true);
        fr.write(holder);
        fr.close();
        return maxID;
      } else {
        fileReader.close();
        fr = new FileWriter(inputFile, true);
        fr.write("1;" + name + ";" + fgroup + ";" + date + ";" + day + ";" + drink + ";"
            + System.getProperty("line.separator"));
        fr.close();
        return 1;
      }
    } catch (IOException e) {
      e.printStackTrace();
      return 0;
    }
  }

  // View All
  public void viewAll() {
    File file = new File(fileName);

    try {
      Scanner fileReader = new Scanner(file);
      fileReader.nextLine();
      while (fileReader.hasNextLine()) {
        System.out.println(fileReader.nextLine());
      }
      fileReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Update by ID
  /*
   * To get the update by ID, get the foodID, cross check with input.txt, after
   * getting the input.txt, return the information to the main to check which one
   * to change. After updating, send both the before and after data to a method
   * where it can basically adding the new data to tempfile while the before
   * update data gets skipped.
   */
  public String[] updateFood(int foodID) {
    String[] empty = null; // Making an empty array to pass when there is no items in file
    String[] notFound = { "Not Found" }; // Return not found when item is not found in the file

    try {
      File inputFile = new File(fileName);
      Scanner fileReader = new Scanner(inputFile);
      String strCurrentLine;

      fileReader.nextLine(); // Getting header
      if (fileReader.hasNextLine()) {
        while (fileReader.hasNextLine()) {
          strCurrentLine = fileReader.nextLine();
          String[] data = strCurrentLine.split(";");
          if (foodID == Integer.parseInt(data[0])) {
            fileReader.close();
            return data;
          }
        }
      } else {
        fileReader.close();
        return empty;
      }
      fileReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return notFound;
  }

  // Overloading the first one after getting the data
  public boolean updateFood(String[] foodData) {
    String strCurrentLine;
    String holder = (foodData[0] + ";" + foodData[1] + ";" + foodData[2] + ";" + foodData[3] + ";" + foodData[4] + ";"
        + foodData[5] + ";" + System.getProperty("line.separator"));
    try {
      File inputFile = new File(fileName);
      File updateFile = new File(updateFileName);
      FileWriter fw = new FileWriter(updateFile, true);
      Scanner fileReader = new Scanner(inputFile);

      fw.write(fileReader.nextLine() + System.getProperty("line.separator"));
      if (fileReader.hasNextLine()) {
        while (fileReader.hasNextLine()) {
          strCurrentLine = fileReader.nextLine();
          String[] data = strCurrentLine.split(";");
          if (data[0].equals(foodData[0])) {
            fw.write(holder);
            continue;
          }
          fw.write(strCurrentLine + System.getProperty("line.separator"));
        }
      }
      fw.close();
      fileReader.close();
      inputFile.delete();
      updateFile.renameTo(inputFile);
      return true;

    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  // Delete by ID
  public boolean deleteFood(int foodID) {
    File readFile1 = new File(fileName); // Geting the input.txt to be checked
    File deleteFile = new File("Data/delete.txt"); // Temporarily put the data into the delete.txt

    BufferedReader reader1 = null;
    BufferedWriter writer = null;

    String strCurrentLine;
    try {
      reader1 = new BufferedReader(new FileReader(readFile1)); // To get the buffer reader from input.txt
      writer = new BufferedWriter(new FileWriter(deleteFile)); // To write into the delete.txt

      String headerLine = reader1.readLine();
      writer.write(headerLine + System.getProperty("line.separator"));

      while ((strCurrentLine = reader1.readLine()) != null) {
        String[] data = strCurrentLine.split(";");
        if (foodID == Integer.parseInt(data[0]))
          continue;
        writer.write(strCurrentLine + System.getProperty("line.separator"));
      }

    } catch (IOException e) {
      e.printStackTrace();
      return false;
    } finally {
      try {
        if (reader1 != null)
          reader1.close();
        writer.close();
        readFile1.delete();
        deleteFile.renameTo(readFile1);
        return true;
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return false;
  }

  // Search by ID
  public void foodIDSearch(int foodID) {
    File inputFile = new File(fileName);
    String currentLine;

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
            fileReader.close();
            break;
          }
        }
        System.out.println("Can't find data with the foodID");
        System.out.println();
      } else {
        System.out.println("Empty Field");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Search by Food Group
  public void foodGroupSearch(String foodGroup) {
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