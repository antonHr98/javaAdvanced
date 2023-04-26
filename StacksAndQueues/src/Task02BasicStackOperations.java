import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 */

public class Task02BasicStackOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = input[0]; //Num of elements to push
        int S = input[1]; //Num of elements to pop
        int X = input[2]; //Element to check

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < S; i++) {
            stack.pop();
        }
        if (stack.contains(X)) {
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
