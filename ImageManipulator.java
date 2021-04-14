import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Dr. Gothard
 * Utility for simplying ImageManipulation project.
 */
public class ImageManipulator {
    /**
     * Skips comments and whitespace to return the next number from the 
     *     input file.
     * @param input the FileInputStream to read from
     * @return the next number in the file (skipping comments and whitespace)
     */
    static int getNextNumber (FileInputStream input) throws IOException{
        int b = input.read();
        String numberChars = "";
  
        // Skip comments and whitespace
        while (b == '#' || Character.isWhitespace((char)b)){
  
           // Skip entire line
           if (b == '#') {
              while (b != '\n') b = input.read();
           }
           // eat the whitespace (or hard return)
           b = input.read();
        }
  
        // b is not a comment or whitespace. 
        //     Reads in the number, character at a time.
        while ((Character.isDigit(b))) {
           numberChars = numberChars + (char)b;
           b = input.read();
        }
        return Integer.parseInt(numberChars);
     }      
}
