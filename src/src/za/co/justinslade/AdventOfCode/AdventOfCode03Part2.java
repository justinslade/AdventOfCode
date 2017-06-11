package za.co.justinslade.AdventOfCode;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AdventOfCode03Part2 {

    public static void main(String... args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        int possibleTriangle = 0;
        int total = 0;
        ArrayList<Integer> col1 = new ArrayList<>();
        ArrayList<Integer> col2 = new ArrayList<>();
        ArrayList<Integer> col3 = new ArrayList<>();
        while ((line = buffer.readLine()) != null) {
            total++;
            col1.add(Integer.parseInt(line.substring(0, 3).trim()));
            col2.add(Integer.parseInt(line.substring(5, 8).trim()));
            col3.add(Integer.parseInt(line.substring(10, line.length()).trim()));
        }
        for (int i = 0; i < col1.size(); i += 3) {
            if (isATriangle(col1.get(i),col1.get(i+1),col1.get(i+2))) {
                possibleTriangle++;
            }
        }
        for (int i = 0; i < col2.size(); i += 3) {
            if (isATriangle(col2.get(i),col2.get(i+1),col2.get(i+2))) {
                possibleTriangle++;
            }
        }
        for (int i = 0; i < col3.size(); i += 3) {
            if (isATriangle(col3.get(i),col3.get(i+1),col3.get(i+2))) {
                possibleTriangle++;
            }
        }
        System.out.println(possibleTriangle);
        System.out.println(total);
    }

    private static boolean isATriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

}
