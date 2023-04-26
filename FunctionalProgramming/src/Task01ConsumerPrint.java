import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;
/**
 * Write a Program that reads a collection of strings, separated by one or more whitespaces, from the console and then
 * prints them onto the console. Each string should be printed on a new line. Use a Consumer<T>.
 *
 * @author Anton Hristov
 * @since 26.04.2023
* */
public class Task01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Consumer<String> consumer = System.out::println;

        input.stream().forEach(consumer);
        scanner.close();
    }
}
