import java.util.*;

/**
 *
 */

public class Task4BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int elementsToAdd = input[0];
        int elementsToRemove = input[1];
        int elementToSearch = input[2];

        int[] stackNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < elementsToAdd; i++) {
            queue.offer(stackNumbers[i]);
        }
        for (int i=0;i<elementsToRemove;i++){
            queue.poll();
        }
        if (queue.isEmpty()){
            System.out.println("0");
        }
        else if (queue.contains(elementToSearch)){
            System.out.println("true");
        }else{
            System.out.println(Collections.min(queue));
        }
        scanner.close();
    }
}


