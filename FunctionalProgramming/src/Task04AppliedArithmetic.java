import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * On the first line, you are given a list of numbers.
 * On the next lines you are passed different commands that you need to apply to all numbers in the list:
 * "add" -> adds 1; "multiply" -> multiplies by 2;
 * "subtract" -> subtracts 1;
 * "print" -> prints all numbers on a new line.
 * The input will end with an "end" command, after which the result must be printed.
 *
 * @author Anton Hristov
 * @since 26.04.2023
 */

public class Task04AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> add = numbersList -> numbersList.stream().map(el -> el + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = numbersList -> numbersList.stream().map(el -> el - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = numbersList -> numbersList.stream().map(el -> el * 2).collect(Collectors.toList());
        Consumer<Integer> printer = number -> System.out.printf("%d ", number);
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            switch (input) {
                case "add": {
                    numbers = add.apply(numbers);
                    break;
                }
                case "subtract": {
                    numbers = subtract.apply(numbers);
                    break;
                }
                case "multiply": {
                    numbers = multiply.apply(numbers);
                    break;
                }
                case "print": {
                    numbers.forEach(printer);
                    System.out.println();
                    break;
                }
                default: {
                    System.out.println("Invalid command.");
                }
            }
            input = scanner.nextLine();
        }
        scanner.close();
    }
}

