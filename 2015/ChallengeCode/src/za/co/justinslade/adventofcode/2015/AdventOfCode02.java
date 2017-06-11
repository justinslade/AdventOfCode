import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AdventOfCode02 {

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
            int side1 = 2*l*h;
            int side2 = 2*l*w;
            int side3 = 2*h*w;
            int smallest = Math.min(Math.min(l*h, l*w), h*w);
            totalNeeded += side1 + side2 + side3 + smallest;
        }
        System.out.printf("Total wrapping paper needed is %d", totalNeeded);
    }
}
