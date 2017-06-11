import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class AdventOfCode03 {

    public static void addPresent(Map<Integer, Map<Integer, Integer>> grid, int x, int y) {
        int presentNumber = 1;
        if (!grid.containsKey(x)) {
            grid.put(x, new TreeMap<>());
        }
        if (grid.get(x).containsKey(y)) {
            presentNumber += grid.get(x).get(y);
            grid.get(x).remove(y);
        }
        grid.get(x).put(y, presentNumber);
    }

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            int x = 0;
            int y = 0;
            Map<Integer, Map<Integer, Integer>> grid = new TreeMap<>();
            addPresent(grid, x, y);
            String[] split = line.split("");
            for (String s : split) {
                if ("^".equals(s)) {
                    y++;
                } else if ("<".equals(s)) {
                    x--;
                } else if ("v".equals(s)) {
                    y--;
                } else if (">".equals(s)) {
                    x++;
                }
                addPresent(grid, x, y);
            }
            int totalHousesWithPresents = 0;
            for (Map<Integer, Integer> integerIntegerMap : grid.values()) {
                totalHousesWithPresents += integerIntegerMap.size();
            }
            System.out.printf("Total houses with presents is %d", totalHousesWithPresents);
        }

    }
}
