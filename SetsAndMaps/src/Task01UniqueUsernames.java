import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 */
public class Task01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numInputs = Integer.parseInt(scanner.nextLine());
        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < numInputs; i++) {
            usernames.add(scanner.nextLine());
        }
        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
