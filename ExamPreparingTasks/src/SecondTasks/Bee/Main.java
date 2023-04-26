package SecondTasks.Bee;

import java.util.Scanner;

public class Main {

    private static int pollinatedFlowers = 0;
    private static int beeRowPos = 0;
    private static int beeColPos = 0;
    private static boolean inField = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] area = new char[size][size];

        for (int i = 0; i < size; i++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int j = 0; j < size; j++) {
                area[i][j] = line[j];
                if (area[i][j] == 'B') {
                    beeRowPos = i;
                    beeColPos = j;
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
            if (!inField) {
                System.out.println("The bee got lost!");
                break;
            }
            command = scanner.nextLine();
        }

        if (pollinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n",
                    5 - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinatedFlowers);
        }

        printXYMatrix(area);
    }

    public static void move(char[][] area, int rowMutator, int colMutator) {
        boolean gotBonus = false;
        int nextRow = beeRowPos + rowMutator;
        int nextCol = beeColPos + colMutator;
        if (!isInBounds(area, nextRow, nextCol)) {
            area[beeRowPos][beeColPos] = '.';
            inField = false;
            return;
        }
        if (area[nextRow][nextCol] == 'O') {
            gotBonus = true;
        } else if (area[nextRow][nextCol] == 'f') {
            pollinatedFlowers++;
        }
        area[nextRow][nextCol] = 'B';
        area[beeRowPos][beeColPos] = '.';
        beeRowPos = nextRow;
        beeColPos = nextCol;
        if (gotBonus) {
            move(area, rowMutator, colMutator);
        }
    }

    public static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
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
