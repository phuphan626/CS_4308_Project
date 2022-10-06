/*
    This is the scanner class. It has the scan function for scanning the input,
    and it will call the lex function to analyze the lexeme and return the token for that lexeme
 */
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class scImplementation {
    // Default constructor
    public scImplementation(){};
    // Lexeme analyzer method
    public String lex(String str){
        StringBuilder result = new StringBuilder();
        // Use an associative array for key value pair
        Map<String,String> opCode = new HashMap<>(){
            {
                put("+","Addition operator");
                put("-","Subtraction operator");
                put("*","Multiplication operator");
                put("=","Assignment operator");
                put("/","Division operator");
            }
        };
        Map<String,String> keywords = new HashMap<>(){
            {
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
            }
        };
        Map<String,String> specialChar = new HashMap<>(){
            {
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
        if(opCode.containsKey(str)){
            result.append(str);
            result.append(" ");
            result.append(opCode.get(str));
        }
        if(specialChar.containsKey(str)){
            result.append(str);
            result.append(" ");
            result.append(specialChar.get(str));
        }
        if(keywords.containsKey(str)){
            result.append(str);
            result.append(" ");
            result.append(keywords.get(str));
        }
        return result.toString();
    }
    // Scanner method
    public String scan(String str){
        return lex(str);
    }
}
