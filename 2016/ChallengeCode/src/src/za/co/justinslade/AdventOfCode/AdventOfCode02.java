package za.co.justinslade.AdventOfCode;


import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AdventOfCode02 {

    public static void main(String... args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder code = new StringBuilder();
        //<y, <x, number>>
        Map<Integer, Map<Integer, String>> keypad = new TreeMap<>();
        for (int i = 0; i < 3; i++) {
            TreeMap<Integer, String> row = new TreeMap<>();
            for (int i1 = 0; i1 < 3; i1++) {
                row.put(i1, String.valueOf(((i) * 3) + (i1 + 1)));
            }
            keypad.put(i, row);
        }
        int x = 1;
        int y = 1;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split("");
            for (int i = 1; i < split.length; i++) {
                String s = split[i];
                if ("U".equals(s)) {
                    y = Math.max(y - 1, 0);
                } else if ("D".equals(s)) {
                    y = Math.min(y + 1, 2);
                } else if ("L".equals(s)) {
                    x = Math.max(x - 1, 0);
                } else if ("R".equals(s)) {
                    x = Math.min(x + 1, 2);
                }
            }
            code.append(keypad.get(y).get(x));
        }
        System.out.println(code.toString());
    }

}
