package FirstTasks.Bouquets;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(tulips::push);

        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(daffodils::offer);

        int countBouquets = 0;
        int storedFlowers = 0;
        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int sum = daffodils.peek() + tulips.peek();
            if (sum == 15) {
                countBouquets++;
                tulips.pop();
                daffodils.poll();
            } else if (sum > 15) {
                int tulip = tulips.pop() - 2;
                tulips.push(tulip);
            } else {
                storedFlowers += sum;
                tulips.pop();
                daffodils.poll();
            }
        }
        while (storedFlowers >= 15) {
            countBouquets++;
            storedFlowers -= 15;
        }
        if (countBouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!\n", countBouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - countBouquets);
        }
    }
}
