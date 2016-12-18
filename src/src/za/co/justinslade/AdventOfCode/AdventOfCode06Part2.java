package za.co.justinslade.AdventOfCode;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

public class AdventOfCode06Part2 {

    public static void main(String... args) throws IOException {

        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        TreeMap<Integer, TreeMap<String, Integer>> listOfLetters = new TreeMap<>();
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split("");
            for (int i = 1; i < split.length; i++) {
                if (!listOfLetters.containsKey(i - 1)) {
                    listOfLetters.put(i - 1, new TreeMap<String, Integer>());
                }
                TreeMap<String, Integer> stringIntegerTreeMap = listOfLetters.get(i - 1);
                String key = split[i];
                if (!stringIntegerTreeMap.containsKey(key)) {
                    stringIntegerTreeMap.put(key, 1);
                } else {
                    stringIntegerTreeMap.put(key, stringIntegerTreeMap.get(key) + 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder(8);
        Iterator<Integer> iterator = listOfLetters.keySet().iterator();
        while (iterator.hasNext()) {
            TreeMap<String, Integer> stringIntegerTreeMap = listOfLetters.get(iterator.next());
            Iterator<String> iterator1 = stringIntegerTreeMap.keySet().iterator();
            String letter = "";
            int frequency = 0;
            while (iterator1.hasNext()) {
                String next = iterator1.next();
                Integer integer = stringIntegerTreeMap.get(next);
                if (integer < frequency || frequency == 0) {
                    frequency = integer;
                    letter = next;
                }
            }
            sb.append(letter);
        }
        System.out.println(sb.toString());
    }


}
