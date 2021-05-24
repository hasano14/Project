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
  //TODO: Make a unique ID and find a way to make it unique
  //TODO: Have the unique ID be able to add one from the current foodID.
  public String writeFile(String name, String fgroup, String date, String day, String drink){
    try{

      File readFile = new File(fileName);
      Scanner fileReader = new Scanner(readFile);

      while(fileReader.hasNextLine()){
        String data = fileReader.nextLine();
        idCounter++;
      }

      System.out.println(idCounter);

      fileReader.close();
      FileWriter myInputFile = new FileWriter(fileName, true);
      myInputFile.write(name + ";" + fgroup + ";" + date + ";" + day + ";" + drink + ";\n");
      myInputFile.close();
      return "Pass foodID";
    }catch(IOException e){
      return "Fail";
    }
  }
}
