package FirstTasks.MagicBox;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstBox::offer);

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondBox::push);

        int sumClaimedItems = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int currentSum = firstBox.peek() + secondBox.peek();
            if (currentSum % 2 == 0) {
                sumClaimedItems += currentSum;
                firstBox.poll();
                secondBox.pop();
            } else {
                int itemToMove = secondBox.pop();
                firstBox.offer(itemToMove);
            }
        }
        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (secondBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (sumClaimedItems>=90){
            System.out.printf("Wow, your prey was epic! Value: %d",sumClaimedItems);
        }else{
            System.out.printf("Poor prey... Value: %d",sumClaimedItems);
        }
    }
}
