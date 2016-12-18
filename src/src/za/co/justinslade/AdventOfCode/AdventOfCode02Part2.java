package za.co.justinslade.AdventOfCode;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class AdventOfCode02Part2 {

    public static void main(String... args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder code = new StringBuilder();
        String[][] keypad = {
                {"x", "x", "1", "x", "x"},
                {"x", "2", "3", "4", "x"},
                {"5", "6", "7", "8", "9"},
                {"x", "A", "B", "C", "x"},
                {"x", "x", "D", "x", "x"}
        };
        int x = 0;
        int y = 2;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split("");
            for (int i = 1; i < split.length; i++) {
                String s = split[i];
                if ("U".equals(s)) {
                    if (y != 0 && !"x".equals(keypad[y - 1][x])) {
                        y--;
                    }
                } else if ("D".equals(s)) {
                    if (y != 4 && !"x".equals(keypad[y + 1][x])) {
                        y++;
                    }
                } else if ("L".equals(s)) {
                    if (x != 0 && !"x".equals(keypad[y][x - 1])) {
                        x--;
                    }
                } else if ("R".equals(s)) {
                    if (x != 4 && !"x".equals(keypad[y][x + 1])) {
                        x++;
                    }
                }
            }
            code.append(keypad[y][x]);
        }
        System.out.println(code.toString());
    }

}
