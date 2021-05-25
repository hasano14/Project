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

public class Opera
{
  private String fileName = "Data/input.txt";
  // public Opera()
  // {
  // this
  // }

  //To open and read file
  //Returns true if file exists
  public boolean fileTest()
  {
    try{
      File myInputFile = new File(fileName);
      File myOutputFile = new File(fileName);

      if(myInputFile.createNewFile() == false && myOutputFile.createNewFile() == false){
        return true;
      }
      else{
        System.out.println("File Created");
      }
    }
    catch (IOException e){
      System.out.println("An error occurred.");
    }
    return false;
  }

  //Return foodID
  /*
    Cross checking the new foodID with the foodID there is. Using boolean to check, if check remains true,
    goes on with the change but false, need to change the foodID to something that is unique
  */
  public String addFood(String name, String fgroup, String date, String day, String drink){
    try{
      File readFile = new File(fileName);
      Scanner fileReader = new Scanner(readFile);
      int idCounter = 0;
      int[] tempID = new int[10000];
      int foodID = 0;
      fileReader.nextLine();

      while(fileReader.hasNextLine()){
        String[] data = fileReader.nextLine().split(";");
        tempID[idCounter] = Integer.parseInt(data[0]);
        idCounter++;
      }

      foodID = idCounter + 1;
      for(int i = 0; i < tempID.length; i++){
        if(foodID == tempID[i]){
          foodID++;
        }
      }

      fileReader.close();
      FileWriter myInputFile = new FileWriter(fileName, true);
      myInputFile.write(foodID + ";" + name + ";" + fgroup + ";" + date + ";" + day + ";" + drink + ";\n");
      myInputFile.close();
      return Integer.toString(foodID);
    }catch(IOException e){
      return "Fail";
    }
  }

  //Update by ID
  /*
    To get the update by ID, get the foodID, cross check with input.txt,
    after getting the input.txt, return the information to the main to check which one to change.
    After updating, send both the before and after data to a method where it can basically
    adding the new data to tempfile while the before update data gets skipped.
  */
  public String[] updateFood(int foodID){
    File readFile = new File(fileName);
    String[] empty = null;

    BufferedReader bReaderFile = null;

    String strCurrentLine;
    try{
      bReaderFile = new BufferedReader(new FileReader(readFile));

      bReaderFile.readLine();

      while((strCurrentLine = bReaderFile.readLine()) != null){
        String[] data = strCurrentLine.split(";");
        if(foodID == Integer.parseInt(data[0])){
          bReaderFile.close();
          return data;
        }
      }
      bReaderFile.close();
    }catch (IOException e){
      e.printStackTrace();
    }

    return empty;
  }

  //Overloading the first one after getting the data
  //TODO: The input.txt is wrong +bug
  public boolean updateFood(String[] foodData){
    File readFile = new File(fileName);
    File updateData = new File("Data/update.txt");
    String strCurrentLine;

    BufferedReader bReaderFile = null;
    BufferedWriter bUpdateFile = null;

    try{
      bReaderFile = new BufferedReader(new FileReader(readFile));
      bUpdateFile = new BufferedWriter(new FileWriter(updateData));

      bUpdateFile.write(bReaderFile.readLine() + System.getProperty("line.separator"));//The header line

      while((strCurrentLine = bReaderFile.readLine()) != null){
        String[] data = strCurrentLine.split(";");
        if(foodData[0] == data[0]){
          String tempString = (foodData[0] + ";" + foodData[1] + ";" + foodData[2] + ";"+ foodData[3] + ";"+ foodData[4] + ";"+ foodData[5] + ";"+ foodData[6] + ";");
          bUpdateFile.write(tempString + System.getProperty("line.separator"));
          continue;
        }
        bUpdateFile.write(bReaderFile.readLine() + System.getProperty("line.separator"));
      }
      bReaderFile.close();
      bUpdateFile.close();
      return true;
    }catch (IOException e){
      e.printStackTrace();
    }finally{
      try{
        bReaderFile.close();
        bUpdateFile.close();
        readFile.delete();
        updateData.renameTo(readFile);
        return true;
      }catch(IOException ex){
        ex.printStackTrace();
      }
    }
    return false;
  }

  //Delete by ID
  public boolean deleteFood(int foodID){
    File readFile1 = new File(fileName); //Geting the input.txt to be checked
    File deleteFile = new File("Data/delete.txt"); //Temporarily put the data into the delete.txt

    BufferedReader reader1 = null;
    BufferedWriter writer = null;

    String strCurrentLine;
    try{
      reader1 = new BufferedReader(new FileReader(readFile1)); //To get the buffer reader from input.txt
      writer = new BufferedWriter(new FileWriter(deleteFile)); //To write into the delete.txt

      String headerLine = reader1.readLine();
      writer.write(headerLine + System.getProperty("line.separator"));

      while((strCurrentLine = reader1.readLine()) != null){
        String[] data = strCurrentLine.split(";");
        if(foodID == Integer.parseInt(data[0])) continue;
        writer.write(strCurrentLine + System.getProperty("line.separator"));
      }

    }catch (IOException e){
      e.printStackTrace();
      return false;
    }finally{
      try{
        if(reader1 != null)
          reader1.close();
          writer.close();
          readFile1.delete();
          deleteFile.renameTo(readFile1);
          return true;
      } catch (IOException ex){
        ex.printStackTrace();
      }
    }
    return false;
  }
}
