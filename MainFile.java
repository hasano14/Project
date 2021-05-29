import java.util.*;
import java.io.*;
import java.lang.*;

public class MainFile{

  public static void main(String args[]) throws IOException, InputMismatchException
  {
    Scanner input = null;
    boolean fileCheck;
    int userOptions = 0;

    Opera operaAction = new Opera();
    fileCheck = operaAction.fileTest();
    while(userOptions != 99){
      userOptions = 0;
      System.out.println("|Choose Action:");
      System.out.println("|1 - Insert New");
      System.out.println("|2 - View");
      System.out.println("|3 - Update");
      System.out.println("|4 - Delete");
      System.out.println("|99 - Exit");
      System.out.print("? ");
      input = new Scanner(System.in);

      if(fileCheck == true){
        if(input.hasNextInt()){
          userOptions = input.nextInt();
          // switch(userOptions){
          //   case 1:
          //     int newFoodID;
          //     newFoodID = operaAction.addFood("Nasi Lemak", "Meal", "21.05.2021", "Breakfast", "Milo"); //Sample
          //     System.out.println("Created New FoodID: " + newFoodID + "\n");
          //     break;
          //
          //   case 2:
          //     System.out.println("Printing All");
          //     operaAction.viewAll();
          //     break;
          //   case 3:
          //     int foodID;
          //
          //     System.out.print("FoodID to be updated: ");
          //     foodID = input.nextInt();
          //     String[] dataHolder = operaAction.updateFood(foodID);
          //     if(dataHolder != null && !dataHolder[0].equals("Not Found")){
          //       System.out.println("Data Has Been Extracted: " + dataHolder[1]);
          //       dataHolder[1] = "Nasi Ayam"; //Sample of change
          //       boolean result = operaAction.updateFood(dataHolder); //
          //       if(result == true){
          //         System.out.println("Data has been updated");
          //       }else
          //         System.out.println("Update Has Failed");
          //     }
          //     else if(dataHolder[0].equals("Not Found")){
          //       System.out.println("!! FoodID Not Found !!\n");
          //     }
          //     else{
          //       System.out.println("!! ERROR !!");
          //     }
          //     break;
          //
          //   case 4:
          //     int foodID;
          //     boolean result;
          //
          //     System.out.print("FoodID to delete: ");
          //     foodID = input.nextInt();
          //     result = operaAction.deleteFood(foodID);
          //
          //     if(result == true)
          //       System.out.println(foodID + " was successfully deleted\n");
          //     else
          //       System.out.println(foodID + " was failed to delete\n");
          //     break;
          // }
          //Insert New
          if(userOptions == 1){
            int newFoodID;
            newFoodID = operaAction.addFood("Nasi Lemak", "Meal", "21.05.2021", "Breakfast", "Milo"); //Sample
            System.out.println("Created New FoodID: " + newFoodID + "\n");
          }

          //View
          else if(userOptions == 2){
            System.out.println("Printing All");
            operaAction.viewAll();
          }

          //Update
          else if(userOptions == 3){
            int foodID;

            System.out.print("FoodID to be updated: ");
            foodID = input.nextInt();
            String[] dataHolder = operaAction.updateFood(foodID);
            if(dataHolder != null && !dataHolder[0].equals("Not Found")){
              System.out.println("Data Has Been Extracted: " + dataHolder[1]);
              dataHolder[1] = "Nasi Ayam"; //Sample of change
              boolean result = operaAction.updateFood(dataHolder); //
              if(result == true){
                System.out.println("Data has been updated");
              }else
                System.out.println("Update Has Failed");
            }
            else if(dataHolder[0].equals("Not Found")){
              System.out.println("!! FoodID Not Found !!\n");
            }
            else{
              System.out.println("!! ERROR !!");
            }
          }

          //Delete by foodID
          else if(userOptions == 4){
            int foodID;
            boolean result;

            System.out.print("FoodID to delete: ");
            foodID = input.nextInt();
            result = operaAction.deleteFood(foodID);

            if(result == true)
              System.out.println(foodID + " was successfully deleted\n");
            else
              System.out.println(foodID + " was failed to delete\n");
          }

          //Exit the program
          else if(userOptions == 99){
            break;
          }
          else{
            System.out.println("\n!! INVALID INPUT !!\n");
            userOptions = 0;
          }
        }
        else{
          System.out.println("\n!! INVALID INPUT !!\n");
        }
      }
      else if(fileCheck == false){
        System.out.println("File Does Not Exist\n");
      }
      else{
          System.out.println("!! ERROR !!");
      }
    }
    System.out.println("Ending Program");
  }
}
