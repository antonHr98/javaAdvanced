import java.util.*;

public class Task03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numInputs = Integer.parseInt(scanner.nextLine());
        Set<String> set = new TreeSet<>();
        for (int i=0;i<numInputs;i++){
            String[] input = scanner.nextLine().split("\\s+");
            set.addAll(Arrays.asList(input));
        }
        for (String element:set){
            System.out.print(element + " ");
        }
        scanner.close();
    }
}
