package za.co.justinslade.AdventOfCode;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AdventOfCode19 {


    public static void main(String... args) throws IOException {
        int input = 5;
        List<Integer> ints = new LinkedList<>();
        for (int i = 0; i < input; i++) {
            ints.add(i +1);
        }
        int remainder = input % 2;
        for (int i = 0; i < (input / 2) + remainder; i++) {
            ints.add(i);
        }

    }
}
