import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Write a program that is using a custom function (written by you) to find the smallest integer
 * in a sequence of integers. The input could have more than one space.
 * Your task is to collect the integers from the console, find the smallest one and print its index
 * (if more than one such elements exist, print the index of the rightmost one).\
 *
 * @author Anton Hristov
 * @since 26.04.2023
 */

public class Task07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> minElementIndex = integerList -> {
            int minElement = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < integerList.size(); i++) {
                if (integerList.get(i) <= minElement) {
                    minElement = integerList.get(i);
                    minIndex = i;
                }
            }
            return minIndex;
        };
        System.out.println(minElementIndex.apply(list));
        scanner.close();
    }
}
