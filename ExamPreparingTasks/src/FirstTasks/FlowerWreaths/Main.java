package FirstTasks.FlowerWreaths;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> roses = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(roses::offer);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(lilies::push);

        int countWraiths = 0;
        int excessFlowers = 0;
        while (!roses.isEmpty() && !lilies.isEmpty()) {
            int sum = roses.peek() + lilies.peek();
            if (sum == 15) {
                countWraiths++;
                roses.poll();
                lilies.pop();
            } else if (sum > 15) {
                int currentLilie = lilies.pop() - 2;
                lilies.push(currentLilie);
            } else {
                excessFlowers += sum;
                roses.poll();
                lilies.pop();
            }
        }
        while (excessFlowers >= 15) {
            countWraiths++;
            excessFlowers -= 15;
        }

        if (countWraiths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", countWraiths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - countWraiths);
        }
        scanner.close();
    }
}
