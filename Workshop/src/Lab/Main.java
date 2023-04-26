package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integers = new ArrayList<>();

        SmartArray smartArray = new SmartArray();

        smartArray.add(4);
        smartArray.add(56);
        smartArray.add(34);
        smartArray.add(65);
        smartArray.add(13);

        for (int i = 0; i < smartArray.arraySize(); i++) {
            System.out.println(smartArray.get(i));
        }
    }
}

