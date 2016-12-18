package za.co.justinslade.AdventOfCode;


import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class AdventOfCode01Part2 {


    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;

    public static void main(String... args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            int direction = NORTH;
            ArrayList<Pair<Integer, Integer>> seen = new ArrayList<>();

            int currentX = 0;
            int currentY = 0;
            line = line.trim();
            String[] split = line.split(", ");
            for (int i = 0; i < split.length; i++) {
                String turn = split[i].substring(0, 1);
                int walkDistance = Integer.parseInt(split[i].substring(1));
                if ("l".equals(turn.toLowerCase())) {
                    direction = (direction + 3) % 4;
                } else {
                    direction = (direction + 1) % 4;
                }
                for (int i1 = 0; i1 < walkDistance; i1++) {
                    switch (direction) {
                        case NORTH:
                            currentY += 1;
                            break;
                        case EAST:
                            currentX += 1;
                            break;
                        case SOUTH:
                            currentY -= 1;
                            break;
                        case WEST:
                            currentX -= 1;
                            break;
                    }
                    Pair<Integer, Integer> pair = new Pair<>(currentX, currentY);
                    if (seen.contains(pair)) {
                        System.out.println(Math.abs(currentX) + Math.abs(currentY));
                        return;
                    } else {
                        seen.add(pair);
                    }
                }
            }
        }
    }

}
