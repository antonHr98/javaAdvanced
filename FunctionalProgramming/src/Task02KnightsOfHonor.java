import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Write a program that reads a collection of names as strings from the console and then appends "Sir" in front of
 * every name and prints it back onto the console. Use a Consumer<T>.
 *
 * @author Anton Hristov
 * @since 26.04.2023
 *
 * */
public class Task02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        Consumer<String> consumer = System.out::println;
        List<String> inputSir = input.stream()
                .map(s -> "Sir " + s)
                .collect(Collectors.toList());
        inputSir.stream().forEach(consumer);
    }
}
