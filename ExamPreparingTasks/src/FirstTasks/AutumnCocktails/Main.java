package FirstTasks.AutumnCocktails;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::offer);

        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(freshness::push);

        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        while (!ingredients.isEmpty() && !freshness.isEmpty()) {
            int sum = ingredients.peek() * freshness.peek();
            switch (sum) {
                case 150: {
                    cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                    ingredients.poll();
                    freshness.pop();
                    break;
                }
                case 250: {
                    cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                    ingredients.poll();
                    freshness.pop();
                    break;
                }
                case 300: {
                    cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                    ingredients.poll();
                    freshness.pop();
                    break;
                }
                case 400: {
                    cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                    ingredients.poll();
                    freshness.pop();
                    break;
                }
                default: {
                    freshness.pop();
                    int ingredientToIncrease = ingredients.pop() + 5;
                    ingredients.offer(ingredientToIncrease);
                    break;
                }
            }
        }
        if (enoughCocktails(cocktails)) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredients.isEmpty()) {
            int sumIngredients = 0;
            for (int num : ingredients) {
                sumIngredients += num;
            }
            System.out.printf("Ingredients left: %d%n", sumIngredients);
        }
        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue());
            }
        }
        scanner.close();
    }

    public static boolean enoughCocktails(Map<String, Integer> cocktails) {
        int countMadeCocktails = 0;
        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {
            if (entry.getValue() > 0) {
                countMadeCocktails++;
            }
        }
        return countMadeCocktails >= 4;
    }
}
