package FirstTasks.Exam;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> foodSupplies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(foodSupplies::push);

        ArrayDeque<Integer> stamina = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(stamina::offer);

        Map<String, Integer> peaks = new LinkedHashMap<>();
        peaks.put("Vihren", 0);
        peaks.put("Kutelo", 0);
        peaks.put("Banski Suhodol", 0);
        peaks.put("Polezhan", 0);
        peaks.put("Kamenitza", 0);

        int daysPassed = 0;
        int currentPeak = 1;
        boolean fiveInAWeek = false;

        while (daysPassed < 7) {
            int sum = foodSupplies.peek() + stamina.peek();

            switch (currentPeak) {
                case (1): {
                    if (sum >= 80) {
                        currentPeak++;
                        peaks.put("Vihren", peaks.get("Vihren") + 1);
                    }
                    break;
                }
                case (2): {
                    if (sum >= 90) {
                        currentPeak++;
                        peaks.put("Kutelo", peaks.get("Kutelo") + 1);
                    }
                    break;
                }
                case (3): {
                    if (sum >= 100) {
                        currentPeak++;
                        peaks.put("Banski Suhodol", peaks.get("Banski Suhodol") + 1);
                    }
                    break;
                }
                case (4): {
                    if (sum >= 60) {
                        currentPeak++;
                        peaks.put("Polezhan", peaks.get("Polezhan") + 1);
                    }
                    break;
                }
                case (5): {
                    if (sum >= 70) {
                        currentPeak++;
                        peaks.put("Kamenitza", peaks.get("Kamenitza") + 1);
                    }
                    break;
                }
                default: {
                    break;
                }
            }
            foodSupplies.pop();
            stamina.poll();
            daysPassed++;
            if (enoughPeaks(peaks)){
                fiveInAWeek = true;
                break;
            }
        }

        if (fiveInAWeek){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
            System.out.println("Conquered peaks:");
            for (Map.Entry<String, Integer> entry : peaks.entrySet()) {
                System.out.println(entry.getKey());
            }
        }else{
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

    }
    public static boolean enoughPeaks(Map<String, Integer> peaks) {
        int countConqueredPeeks = 0;
        for (Map.Entry<String, Integer> entry : peaks.entrySet()) {
            if (entry.getValue() > 0) {
                countConqueredPeeks++;
            }
        }
        return countConqueredPeeks >= 5;
    }
}
