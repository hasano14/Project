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
  public String addFood(String name, String fgroup, String date, String day, String drink){
    try{
      File readFile = new File(fileName);
      Scanner fileReader = new Scanner(readFile);
      int idCounter = 0;
      int[] tempID = new int[10000];
      int foodID = 0;
      String headerLine = fileReader.nextLine();

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

  //TODO: When deleting an id, anything above it will deduct by one. For example, delete 2, so anything more than 2 will decrease by one
  /*Ways to do this:
    Getting the input.txt then use it to check with the id to be deleted.
    While checking the id, paste the lines into the tempfile, if the id is found,
    don't copy to the tempfile. After complete, delete the input file and rename the tempfile to input.txt
  */
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
        return false;
      }
    }
  }
}
