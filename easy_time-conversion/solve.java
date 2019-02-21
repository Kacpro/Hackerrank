import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        String stringPattern = "(\\d\\d):(\\d\\d):(\\d\\d)([AP]M)";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            if (matcher.group(1).equals("12") && matcher.group(4).equals("PM")) {
                return matcher.group(1) + ":" +
                       matcher.group(2) + ":" +
                       matcher.group(3); 
            }

            if (matcher.group(1).equals("12") && matcher.group(4).equals("AM")) {
                return "00" + ":" +
                       matcher.group(2) + ":" +
                       matcher.group(3); 
            }

            if (matcher.group(4).equals("PM")) {
                Integer newHour = Integer.parseInt(matcher.group(1)) + 12;
                return newHour + ":" +
                       matcher.group(2) + ":" +
                       matcher.group(3); 
            }

            return matcher.group(1) + ":" +
                   matcher.group(2) + ":" +
                   matcher.group(3); 
        }
        return null;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}

