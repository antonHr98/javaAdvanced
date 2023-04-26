package FirstTasks.Cooking;

import java.util.*;


public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(liquids::offer);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::push);

        Map<String, Integer> foods = new TreeMap<>();
        foods.put("Bread", 0);
        foods.put("Cake", 0);
        foods.put("Pastry", 0);
        foods.put("Fruit Pie", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int sum = liquids.peek() + ingredients.peek();
            switch (sum) {
                case 25: {
                    foods.put("Bread", foods.get("Bread") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                }
                case 50: {
                    foods.put("Cake", foods.get("Cake") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                }
                case 75: {
                    foods.put("Pastry", foods.get("Pastry") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                }
                case 100: {
                    foods.put("Fruit Pie", foods.get("Fruit Pie") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                }
                default: {
                    liquids.poll();
                    int ingredientToIncrease = ingredients.pop() + 3;
                    ingredients.push(ingredientToIncrease);
                    break;
                }
            }
        }

        int countCookedFoods = 0;
        for (Map.Entry<String, Integer> entry : foods.entrySet()) {
            if (entry.getValue()>0){
                countCookedFoods++;
            }
        }

        if (countCookedFoods>=4){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (!liquids.isEmpty()){
            System.out.print("Liquids left: ");
            for(int liquid : liquids){
                System.out.print(liquids.poll());
                if (liquids.size()>0){
                    System.out.print(", ");
                }else{
                    System.out.println();
                }
            }
        }else{
            System.out.println("Liquids left: none");
        }

        if (!ingredients.isEmpty()){
            System.out.print("Ingredients left: ");
            for(int ingredient : ingredients){
                System.out.print(ingredients.pop());
                if (ingredients.size()>0){
                    System.out.print(", ");
                }else{
                    System.out.println();
                }
            }

        }else{
            System.out.println("Ingredients left: none");
        }

        for (Map.Entry<String, Integer> entry : foods.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }
        scanner.close();
    }
}