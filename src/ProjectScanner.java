/*
    Name: Phu Phan, Duc Ho
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
        String userInput;
        // Make an ArrayList of String[] to store data
        ArrayList<String[]> strArray = new ArrayList<>();
        // Scanner for user input
        Scanner sc = new Scanner(System.in);
        scImplementation scAnalyzer = new scImplementation();
        try{
            // Read user input files name.
            // These files are from scl_progs
           System.out.println("Please enter the file name for input: ");
           System.out.println("Enter areacir.scl for demonstration.");
           userInput = sc.nextLine();
            // Create object of File
            File myFile = new File("scl_progs/"+userInput);
            // Scanner to read in the file
            Scanner fileReader = new Scanner(myFile);
            // Read in the file
            while(fileReader.hasNextLine()){
                // Append the data to ArrayList
                strArray.add(fileReader.nextLine().split(" "));
            }
        }
        // Error exception
        catch (FileNotFoundException e) {
            System.out.println("Please check the path. File not found!");
            e.printStackTrace();
        }
        // Remove the comment in the input file
        boolean comFound = false;
        for(int i=0;i<strArray.size();++i){
            for(int j=0;j<strArray.get(i).length;++j){
                if((strArray.get(i))[j].equals("/*")){
                    comFound = true;
                }
                if((strArray.get(i))[j].equals("*/")){
                    comFound = false;
                }
                if(comFound == true){
                    (strArray.get(i))[j] = "";
                }
            }
        }
        // Loop through the arrayList and analyze each token
        for(int i=0;i<strArray.size();++i){
            for(int j=0;j< strArray.get(i).length;++j){
                scAnalyzer.scanner((strArray.get(i))[j]);
            }
            System.out.println("");
        }
    }
}
