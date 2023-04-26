import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Write a program that reads N integers from the console and reverses them using a stack.
 * Use the ArrayDeque<Integer> class. Just put the input numbers in the stack and pop them.
*/

public class Task01ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String number : numbers) {
            stack.push(Integer.parseInt(number));
        }
        for (int i=0;i< numbers.length;i++){
            System.out.print(stack.pop());
            if (!stack.isEmpty()){
                System.out.print(' ');
            }
        }
        scanner.close();
    }
}
