import java.util.*;

public class Task02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setLengths = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int set1Length = setLengths[0];
        int set2Length = setLengths[1];

        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();

        for (int i=0;i<set1Length;i++){
            set1.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i=0;i<set2Length;i++){
            set2.add(Integer.parseInt(scanner.nextLine()));
        }
        Set<Integer> repeatingElements = new LinkedHashSet<>();
        for(int element1 : set1){
            for (int element2 : set2){
                if (element1==element2){
                    repeatingElements.add(element1);
                }
            }
        }
        for (int element : repeatingElements){
            System.out.printf("%d ",element);
        }
    }
}
