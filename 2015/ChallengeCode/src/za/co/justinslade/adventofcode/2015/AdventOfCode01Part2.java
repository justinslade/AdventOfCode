import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AdventOfCode01Part2 {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split("");
            int floor = 0;
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                if ("(".equals(s)) {
                    floor++;
                } else if (")".equals(s)) {
                    floor--;
                }
                if (floor < 0) {
                    System.out.printf("The floor went into minus at %d", i + 1);
                    break;
                }
            }
        }
    }
}
