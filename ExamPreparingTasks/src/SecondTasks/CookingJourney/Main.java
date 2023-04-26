package SecondTasks.CookingJourney;

import java.util.Scanner;

public class Main {
    private static int money = 0;
    private static boolean inField = true;
    private static int playerRowPos = 0;
    private static int playerColPos = 0;
    private static int foundPortals = 0;
    private static int firstPortalRow = 0;
    private static int firstPortalCol = 0;
    private static int secondPortalRow = 0;
    private static int secondPortalCol = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] area = new char[size][size];

        for (int i = 0; i < size; i++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int j = 0; j < size; j++) {
                area[i][j] = line[j];
                if (area[i][j] == 'P') {
                    foundPortals++;
                    findNextPortal(i, j);
                }else if (area[i][j] == 'S'){
                    playerRowPos = i;
                    playerColPos = j;
                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end")) {
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
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }
            if (money>=50){
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Money: %d\n",money);
        printXYMatrix(area);
    }

    public static void move(char[][] area, int rowMutator, int colMutator) {
        int nextRow = playerRowPos + rowMutator;
        int nextCol = playerColPos + colMutator;
        if (!isInBounds(area, nextRow, nextCol)) {
            area[playerRowPos][playerColPos] = '-';
            inField = false;
            return;
        }
        if (area[nextRow][nextCol] == '-') {
            area[nextRow][nextCol] = 'S';
            area[playerRowPos][playerColPos] = '-';
            playerRowPos = nextRow;
            playerColPos = nextCol;
        } else if (area[nextRow][nextCol] == 'P') {
            moveThroughPortal(area, nextRow, nextCol);
        } else if (isClient(area[nextRow][nextCol])) {
            money += Character.getNumericValue(area[nextRow][nextCol]);
            area[nextRow][nextCol] = 'S';
            area[playerRowPos][playerColPos] = '-';
            playerRowPos = nextRow;
            playerColPos = nextCol;
        }
    }


    public static void findNextPortal(int rowPos, int colPos) {
        if (foundPortals == 1) {
            firstPortalRow = rowPos;
            firstPortalCol = colPos;
        } else if (foundPortals == 2) {
            secondPortalRow = rowPos;
            secondPortalCol = colPos;
        }
    }

    public static int whichPortal(int rowPos, int colPos) {
        if (rowPos == firstPortalRow && colPos == firstPortalCol) {
            return 1;
        } else if (rowPos == secondPortalRow && colPos == secondPortalCol) {
            return 2;
        } else {
            return 0;
        }
    }

    public static void moveThroughPortal(char[][] area, int nextRowPos, int nextColPos) {
        if (whichPortal(nextRowPos, nextColPos) == 1) {
            area[nextRowPos][nextColPos] = '-';
            area[playerRowPos][playerColPos] = '-';
            area[secondPortalRow][secondPortalCol] = 'S';
            playerRowPos = secondPortalRow;
            playerColPos = secondPortalCol;
        } else if (whichPortal(nextRowPos, nextColPos) == 2) {
            area[nextRowPos][nextColPos] = '-';
            area[playerRowPos][playerColPos] = '-';
            area[firstPortalRow][firstPortalCol] = 'S';
            playerRowPos = firstPortalRow;
            playerColPos = firstPortalCol;
        }
    }

    public static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }

    public static boolean isClient(char location) {
        return (location == '1' || location == '2' || location == '3' || location == '4' || location == '5' || location == '6'
                || location == '7' || location == '8' || location == '9');
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
