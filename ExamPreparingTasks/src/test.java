import java.util.Scanner;
import java.util.function.Function;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] mat = new int[4][7];

        for (int i = 0; i < 4; i++) {
            for (int j = 0;j < 7;j++) {
                System.out.print(mat[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
