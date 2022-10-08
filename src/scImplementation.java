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
        {   // Arithmetic operations
            put("+","Addition operator");
            put("-","Subtraction operator");
            put("*","Multiplication operator");
            put("=","Assignment operator");
            put("/","Division operator");
            // Reserved words
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
            put("create","Reserved words");
            put("return","Reserved words");
            put("call","Reserved word");
            put("using","Reserved words");
            put("structures","Reserved words");
            put("pointer","Reserved words");
            put("NULL","Keyword");
            put("global","Keyword");
            put("constants","Keyword");
            put("specifications","Keyword");
            put("struct","Keyword");
            put("endstruct","Keyword");
            put("definetype","Keyword");
            put("for","Reserved words");
            put("while","Reserved words");
            put("if","Reserved words");
            put("else","Reserved words");
            put("endif","Reserved words");
            put("equal","Reserved words");
            put("do","Reserved words");
            put("endwhile","Reserved words");
            put("endfor","Reserved words");
            put("to","Reserved words");
            put("true","Reserved words");
            put("false","Reserved words");
            put("forward","Reserved words");
            put("declarations","Reserved words");
            put("destroy","Reserved words");
            put("parameters","Reserved words");
            put("files","Reserved words");
            put("address","Reserved words");
            // Special characters
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
    // Identifier, numerical constant, and headerFile table
    Map<String,String> identifier = new HashMap<>();
    Map<String,String> numericalConst = new HashMap<>();
    Map<String,String> headerFile = new HashMap<>();
    // Lexeme analyzer method
    private void lex(String str){
        // Use an associative array for key value pair
        Pattern headerFiles = Pattern.compile("[a-z]\\.h",Pattern.CASE_INSENSITIVE);
        Matcher hfMatcher = headerFiles.matcher(str);
        boolean hfFound = hfMatcher.find();
        Pattern numericalConstant = Pattern.compile("[0-9]+.[0-9]*",Pattern.CASE_INSENSITIVE);
        Matcher numMatcher = numericalConstant.matcher(str);
        boolean numFound = numMatcher.find();
        // Check if the lexeme is a reserved word, keyword, special character
        if(reservedWords.containsKey(str)){
            System.out.print(str);
            System.out.println("->"+reservedWords.get(str));
        }
        // Check header file
        if(hfFound){
            headerFile.put(str,"Header file");
            System.out.print(str);
            System.out.print("->"+headerFile.get(str)+" ");
        }
        // Check for numerical constant
        else if(numFound){
            numericalConst.put(str,"Numerical constant");
            System.out.print(str);
            System.out.print("->"+numericalConst.get(str)+" ");
        }
        // Check for identifier
        else if(!reservedWords.containsKey(str) && !identifier.containsKey(str)){
            identifier.put(str,"Identifier");
            System.out.print(str);
            System.out.print("->"+identifier.get(str)+" ");
        }
    }
    // Scanner function
    public void scanner(String str){
        lex(str);
    }
}
