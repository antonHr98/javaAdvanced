import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Write a program that reverses a collection and removes elements that are divisible by a given integer n.
 *
 * @author Anton Hristov
 * @since 26.04.2023
 */

public class Task05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> predicate = number -> number % n == 0;
        numbers.removeIf(predicate);
        Collections.reverse(numbers);
        numbers.forEach(number -> System.out.print(number + " "));
        scanner.close();
    }
}
