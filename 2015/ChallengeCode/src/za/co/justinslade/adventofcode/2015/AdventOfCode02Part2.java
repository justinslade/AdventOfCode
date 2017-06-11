import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AdventOfCode02Part2 {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        int totalNeeded = 0;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split("x");
            int l = Integer.parseInt(split[0]);
            int w = Integer.parseInt(split[1]);
            int h = Integer.parseInt(split[2]);
            int ribbonLength;
            int bowLength = l * w * h;
            if (Math.max(Math.max(l, w), h) == l) {
                ribbonLength = 2 * w + 2 * h;
            } else if (Math.max(Math.max(l, w), h) == h) {
                ribbonLength = 2 * w + 2 * l;
            } else {
                ribbonLength = 2 * h + 2 * l;
            }
            totalNeeded += ribbonLength + bowLength;
        }
        System.out.printf("Total ribbon needed is %d", totalNeeded);
    }
}
