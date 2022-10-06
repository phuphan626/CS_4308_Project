/*
    Name: Phu Phan
    Instructor: Jose Garrido
    Course: CS-4308-W03 - Fall 2022
    Project: Scanner Implementation
 */
// Import libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class ProjectScanner {
    public static void main(String[] args){
        // Make an ArrayList of String to store data
        // String userInput;
        ArrayList<String[]> strArray = new ArrayList<>();
        // Scanner sc = new Scanner(System.in);
        scImplementation scAnalyzer = new scImplementation();
        try{
           // System.out.println("Please enter the file name for input: ");
           // userInput = sc.nextLine();
            // Create object of File
            File myFile = new File("src/areacir.scl");
            // Scanner to read in the file
            Scanner fileReader = new Scanner(myFile);
            // Read in the file
            while(fileReader.hasNextLine()){
                // Append the data to ArrayList
                strArray.add(fileReader.nextLine().split(" "));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Please check the path. File not found!");
            e.printStackTrace();
        }
        for(int i=0;i<strArray.size();++i){
            for(int j=0; j<strArray.get(i).length; j++){
                System.out.print(scAnalyzer.scan(((strArray.get(i))[j])));System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
}
