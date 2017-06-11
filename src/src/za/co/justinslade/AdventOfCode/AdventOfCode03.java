package za.co.justinslade.AdventOfCode;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class AdventOfCode03 {

    public static void main(String... args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        int possibleTriangle = 0;
        int total = 0;
        while ((line = buffer.readLine()) != null) {
            total++;
            int a = Integer.parseInt(line.substring(0,3).trim());
            int b = Integer.parseInt(line.substring(5,8).trim());
            int c = Integer.parseInt(line.substring(10,line.length()).trim());
            if (a + b > c && a + c > b && b + c > a) {
                possibleTriangle++;
            }
        }
        System.out.println(possibleTriangle);
        System.out.println(total);
    }

}
