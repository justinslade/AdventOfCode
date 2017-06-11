import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class AdventOfCode03Part2 {

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
            int santaX = 0;
            int santaY = 0;
            int roboSantaX = 0;
            int roboSantaY = 0;
            boolean isSantaMoving = true;
            Map<Integer, Map<Integer, Integer>> grid = new TreeMap<>();
            addPresent(grid, santaX, santaY);
            addPresent(grid, roboSantaX, roboSantaY);
            String[] split = line.split("");
            for (String s : split) {
                if (isSantaMoving) {
                    if ("^".equals(s)) {
                        santaY++;
                    } else if ("<".equals(s)) {
                        santaX--;
                    } else if ("v".equals(s)) {
                        santaY--;
                    } else if (">".equals(s)) {
                        santaX++;
                    }
                    addPresent(grid, santaX, santaY);
                } else {
                    if ("^".equals(s)) {
                        roboSantaY++;
                    } else if ("<".equals(s)) {
                        roboSantaX--;
                    } else if ("v".equals(s)) {
                        roboSantaY--;
                    } else if (">".equals(s)) {
                        roboSantaX++;
                    }
                    addPresent(grid, roboSantaX, roboSantaY);
                }
                isSantaMoving = !isSantaMoving;
            }
            int totalHousesWithPresents = 0;
            for (Map<Integer, Integer> integerIntegerMap : grid.values()) {
                totalHousesWithPresents += integerIntegerMap.size();
            }
            System.out.printf("Total houses with presents is %d", totalHousesWithPresents);
        }

    }
}
