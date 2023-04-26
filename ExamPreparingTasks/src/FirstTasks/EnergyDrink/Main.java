package FirstTasks.EnergyDrink;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> caffeine = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(caffeine::push);

        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(energyDrinks::offer);

        int intake = 0;
        int remainingIntake = 300;
        while (!caffeine.isEmpty() && !energyDrinks.isEmpty()) {
            int drinkIntake = caffeine.peek() * energyDrinks.peek();
            if (drinkIntake + intake <= remainingIntake) {
                intake += drinkIntake;
                caffeine.pop();
                energyDrinks.poll();
            } else {
                int drinkToMove = energyDrinks.poll();
                energyDrinks.offerLast(drinkToMove);
                caffeine.pop();
                if (intake >= 30) {
                    intake -= 30;
                }
            }
        }
        if (!energyDrinks.isEmpty()){
            System.out.print("Drinks left: ");
            for(int drink: energyDrinks){
                System.out.print(energyDrinks.poll());
                if (energyDrinks.size()>0){
                    System.out.print(", ");
                }else{
                    System.out.println();
                }
            }
        }else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.\n",intake);
    }
}
