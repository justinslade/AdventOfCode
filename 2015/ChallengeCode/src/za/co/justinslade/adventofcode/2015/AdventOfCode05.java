import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AdventOfCode05 {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        int totalNice = 0;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            if (line.contains("ab") || line.contains("cd") || line.contains("pq") || line.contains("xy")) {
                continue;
            }
            String[] split = line.split("");
            boolean containsDoubleLetter = false;
            for (int i = 1; i < split.length; i++) {
                if (split[i - 1].equals(split[i])) {
                    containsDoubleLetter = true;
                    break;
                }
            }
            if (!containsDoubleLetter) {
                continue;
            }
            if (line.replaceAll("[bcdfghjklmnpqrstvwxyz]", "").length() >= 3) {
                totalNice++;
            }
        }
        System.out.printf("Total nice strings are %d", totalNice);

    }
}
