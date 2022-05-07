package backend;

public class Validate {
	
public static String Validation(String input){
        
        String output = "";
        
        for(int i = 0; i < input.length(); i++){
            output += checker(input.charAt(i));
        }
        
        return output;
    }
    
    private static char checker (char c){
        
        int i = (int)c;
        
        if( (i>=0 && i<=31) || (i>=35 && i<=38) || (i>=42 && i<=43) || (i>=60 && i<=62) || (i>=91 && i<=95) || (i>=123 && i<=126))
        	return ' ';
        else{
            return c;
        }
        
    }
}
