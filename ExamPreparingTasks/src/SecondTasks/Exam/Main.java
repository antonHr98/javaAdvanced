package SecondTasks.Exam;

import java.util.Scanner;

public class Main {
    private static int destroyedBattleCruisers = 0;
    private static int minesHit = 0;
    private static boolean criticalDamage = false;
    private static int subRowPos = 0;
    private static int subColPos = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] area = new char[size][size];

        for (int i = 0; i < size; i++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int j = 0; j < size; j++) {
                area[i][j] = line[j];
                if (area[i][j] == 'S') {
                    subRowPos = i;
                    subColPos = j;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            switch (command) {
                case "up": {
                    move(area, -1, 0);
                    break;
                }
                case "down": {
                    move(area, 1, 0);
                    break;
                }
                case "left": {
                    move(area, 0, -1);
                    break;
                }
                case "right": {
                    move(area, 0, 1);
                    break;
                }
                default: {
                    System.out.println("No such command possible.");
                    break;
                }
            }
            if (criticalDamage) {
                System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!\n",subRowPos,subColPos);
                break;
            }
            if (destroyedBattleCruisers==3) {
                System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                break;
            }
            command = scanner.nextLine();
        }
        printXYMatrix(area);
    }

    public static void move(char[][] area, int rowMutator, int colMutator) {
        int nextRow = subRowPos + rowMutator;
        int nextCol = subColPos + colMutator;

        if (area[nextRow][nextCol] == '-'){
            area[nextRow][nextCol] = 'S';
            area[subRowPos][subColPos] = '-';
            subRowPos = nextRow;
            subColPos = nextCol;
        }else if (area[nextRow][nextCol] == '*') {
            minesHit++;
            area[nextRow][nextCol] = 'S';
            area[subRowPos][subColPos] = '-';
            subRowPos = nextRow;
            subColPos = nextCol;

        } else if (area[nextRow][nextCol] == 'C') {
            destroyedBattleCruisers++;
            area[nextRow][nextCol] = 'S';
            area[subRowPos][subColPos] = '-';
            subRowPos = nextRow;
            subColPos = nextCol;
        }
        if (minesHit==3) {
            criticalDamage = true;
        }
    }

    public static void printXYMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char i : arr) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

}
