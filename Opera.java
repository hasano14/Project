import java.io.*;
import java.util.*;

public class Opera
{
  // public Opera()
  // {
  // this
  // }


  //To open and read file
  //Returns true if file exists
  public boolean fileTest()
  {
    try{
      File dir = new File("Data");
      dir.mkdirs();
      File myInputFile = new File(dir, "input.txt");
      File myOutputFile = new File(dir, "output.txt");

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
  public String writeFile(String Name, ){

    return "Testing";
  }
}
