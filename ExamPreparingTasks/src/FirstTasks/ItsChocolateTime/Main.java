package FirstTasks.ItsChocolateTime;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkAmounts = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .forEach(milkAmounts::offer);

        ArrayDeque<Double> cacaoPowderAmounts = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .forEach(cacaoPowderAmounts::push);

        Map<String, Double> chocolates = new TreeMap<>();
        chocolates.put("Milk Chocolate", 0.0);
        chocolates.put("Dark Chocolate", 0.0);
        chocolates.put("Baking Chocolate", 0.0);

        while (!milkAmounts.isEmpty() && !cacaoPowderAmounts.isEmpty()) {
            double currentCacaoPercentage = cacaoPowderAmounts.peek() / (milkAmounts.peek() + cacaoPowderAmounts.peek());

            if (currentCacaoPercentage == 0.3) {
                chocolates.put("Milk Chocolate", chocolates.get("Milk Chocolate") + 1);
                milkAmounts.poll();
                cacaoPowderAmounts.pop();

            } else if (currentCacaoPercentage == 0.5) {
                chocolates.put("Dark Chocolate", chocolates.get("Dark Chocolate") + 1);
                milkAmounts.poll();
                cacaoPowderAmounts.pop();

            } else if (currentCacaoPercentage == 1.0) {
                chocolates.put("Baking Chocolate", chocolates.get("Baking Chocolate") + 1);
                milkAmounts.poll();
                cacaoPowderAmounts.pop();

            } else {
                double milkAmountToIncrease = milkAmounts.poll() + 10;
                cacaoPowderAmounts.pop();
                milkAmounts.offerLast(milkAmountToIncrease);
            }
        }

        if (enoughChocolates(chocolates)) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        for (Map.Entry<String, Double> entry : chocolates.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.printf(" # %s --> %.0f%n", entry.getKey(), entry.getValue());
            }
        }
    }

    public static boolean enoughChocolates(Map<String, Double> cocktails) {
        int countMadeChocolates = 0;
        for (Map.Entry<String, Double> entry : cocktails.entrySet()) {
            if (entry.getValue() > 0) {
                countMadeChocolates++;
            }
        }
        return countMadeChocolates >= 3;
    }
}
