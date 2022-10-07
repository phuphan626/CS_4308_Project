/*
    This is the scanner class. It has the scan function for scanning the input,
    and it will call the lex function to analyze the lexeme and return the token for that lexeme
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class scImplementation {
    // Default constructor
    public scImplementation(){};
    // Symbol table
    public Map<String,String> reservedWords = new HashMap<>(){
        {
            put("+","Addition operator");
            put("-","Subtraction operator");
            put("*","Multiplication operator");
            put("=","Assignment operator");
            put("/","Division operator");
            put("set","Reserved words");
            put("import","Reserved words");
            put("endfun","Reserved words");
            put("function","Reserved words");
            put("main","Reserved words");
            put("is","Reserved words");
            put("implementations","Reserved words");
            put("variables","Reserved words");
            put("exit","Reserved words");
            put("display","Reserved words");
            put("input","Reserved words");
            put("begin","Reserved words");
            put("while","Reserved words");
            put("for","Reserved words");
            put("symbol","Reserved words");
            put("define","Reserved words");
            put("of","Reserved words");
            put("type","Reserved words");
            put("double","Reserved words");
            put("integer","Reserved words");
            put("float","Reserved words");
            put(","," A comma");
            put("."," A period");
            put(";"," A semicolon");
            put(":"," A colon");
            put("?"," A question mark");
            put("!"," A exclamation");
            put("("," A right parenthesis");
            put(")"," A back parenthesis");
            put("\""," A double quote");
            put("\'"," A single quote");
            put(">"," Greater than");
            put("<"," Less than");
            put("^"," A caret");
        }
    };
    // Identifier table
    Map<String,String> identifier = new HashMap<>();
    Map<String,String> numericalConst = new HashMap<>();
    Map<String,String> headerFile = new HashMap<>();
    // Lexeme analyzer method
    public void lex(String str){
        ArrayList<String> tokenList = new ArrayList<>();
        // Use an associative array for key value pair
        Pattern headerFiles = Pattern.compile("[a-z]\\.h",Pattern.CASE_INSENSITIVE);
        Matcher hfMatcher = headerFiles.matcher(str);
        boolean hfFound = hfMatcher.find();
        Pattern numericalConstant = Pattern.compile("[0-9]+.[0-9]*",Pattern.CASE_INSENSITIVE);
        Matcher numMatcher = numericalConstant.matcher(str);
        boolean numFound = numMatcher.find();
        // Regex for the header files
        if(reservedWords.containsKey(str)){
            System.out.print(str);
            System.out.println("->"+reservedWords.get(str));
        }
        if(hfFound){
            headerFile.put(str,"Header file");
            System.out.print(str);
            System.out.print("->"+headerFile.get(str)+" ");
        }
        else if(numFound){
            numericalConst.put(str,"Numerical constant");
            System.out.print(str);
            System.out.print("->"+numericalConst.get(str)+" ");
        }
        else if(!reservedWords.containsKey(str) && !identifier.containsKey(str)){
            identifier.put(str,"Identifier");
            System.out.print(str);
            System.out.print("->"+identifier.get(str)+" ");
        }
    }
}
