package za.co.justinslade.AdventOfCode;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AdventOfCode01 {


    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;

    public static void main(String... args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            int direction = NORTH;
            int currentX = 0;
            int currentY = 0;
            String[] split = line.split(", ");
            for (int i = 0; i < split.length; i++) {
                String turn = split[i].substring(0,1);
                int walkDistance = Integer.parseInt(split[i].substring(1));
                if ("l".equals(turn.toLowerCase())){
                    direction = (direction + 3) % 4;
                } else {
                    direction = (direction + 1) % 4;
                }
                switch (direction){
                    case NORTH:
                        currentY += walkDistance;
                        break;
                    case EAST:
                        currentX += walkDistance;
                        break;
                    case SOUTH:
                        currentY -= walkDistance;
                        break;
                    case WEST:
                        currentX -=walkDistance;
                        break;
                }
            }
            System.out.print(Math.abs(currentX) + Math.abs(currentY));
        }
    }

}
