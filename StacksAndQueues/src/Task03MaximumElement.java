import java.util.*;

/**
 *   You have an empty sequence, and you will be given N commands. Each command is one of the following types:
 *
 * · "1 X" - Push the element X into the stack.
 * · "2" - Delete the element present at the top of the stack.
 * · "3" - Print the maximum element in the stack.
 *  INPUT:
 * · The first line of input contains an integer N, where 1 ≤ N ≤ 105.
 * · The next N lines contain commands. All commands will be valid and in the format described.
 * · The element X will be in the range 1 ≤ X ≤ 109.
 * · The type of the command will be in the range 1 ≤ Type ≤ 3.
 *  OUTPUT:
 * · For each command of type "3", print the maximum element in the stack on a new line.
 */

public class Task03MaximumElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int totalCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < totalCommands; i++) {
            int[] commandElements = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            switch (commandElements[0]) {
                case 1:{
                    stack.push(commandElements[1]);
                    break;
                }
                case 2:{
                    stack.pop();
                    break;
                }
                case 3:{
                    System.out.println(Collections.max(stack));
                }
                default:
                    break;
            }
        }
    }
}
