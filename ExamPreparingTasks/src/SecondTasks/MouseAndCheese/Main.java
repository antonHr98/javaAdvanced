package SecondTasks.MouseAndCheese;

import java.util.Scanner;

public class Main {

    private static int cheeseEaten = 0;
    private static int mouseRowPos = 0;
    private static int mouseColPos = 0;
    private static boolean inField = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] area = new char[size][size];

        for (int i = 0; i < size; i++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int j = 0; j < size; j++) {
                area[i][j] = line[j];
                if (area[i][j] == 'M') {
                    mouseRowPos = i;
                    mouseColPos = j;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "up": {
                    moveMouse(area, -1, 0);
                    break;
                }
                case "down": {
                    moveMouse(area, 1, 0);
                    break;
                }
                case "left": {
                    moveMouse(area, 0, -1);
                    break;
                }
                case "right": {
                    moveMouse(area, 0, 1);
                    break;
                }
                default: {
                    System.out.println("No such command possible.");
                    break;
                }
            }
            if (!inField) {
                break;
            }
            command = scanner.nextLine();
        }
        if (!inField) {
            System.out.println("Where is the mouse?");
        }
        if (cheeseEaten >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        }
        printXYMatrix(area);
    }

    public static void moveMouse(char[][] area, int rowMutator, int colMutator) {
        int nextRow = mouseRowPos + rowMutator;
        int nextCol = mouseColPos + colMutator;
        boolean gotBonus = false;
        if (!isInBounds(area, nextRow, nextCol)) {
            area[mouseRowPos][mouseColPos] = '-';
            inField = false;
            return;
        }

        if (area[nextRow][nextCol] == 'c') {
            cheeseEaten++;
        } else if (area[nextRow][nextCol] == 'B') {
            gotBonus = true;
        }
        area[mouseRowPos][mouseColPos] = '-';
        area[nextRow][nextCol] = 'M';
        mouseRowPos = nextRow;
        mouseColPos = nextCol;
        if (gotBonus) {
            moveMouse(area, rowMutator, colMutator);
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

    public static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }
}
