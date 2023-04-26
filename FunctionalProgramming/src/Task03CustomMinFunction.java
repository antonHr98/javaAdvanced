import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Write a simple program that reads a set of numbers from the console and finds the smallest of the numbers
 * using a simple Function<Integer[], Integer>.
 *
 * @author Anton Hristov
 * @since 26.04.2023
 *
 */
public class Task03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> smallestNumber = (int[] arr)->{
            int min = Integer.MAX_VALUE;
            for (int element : arr){
                if (element<min){
                    min = element;
                }
            }
            return min;
        };
        System.out.println(smallestNumber.apply(numbers));

    }
}
