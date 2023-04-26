package SecondTasks.Bomb;

import java.util.Scanner;

public class Main {
    private static int sapperRowPos = 0;
    private static int sapperColPos = 0;
    private static int bombsDeactivated = 0;
    private static int totalBombs = 0;
    private static boolean gameOver = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] field = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            for (int j = 0; j < size; j++) {
                field[i] = line.toCharArray();
                if (field[i][j] == 's') {
                    sapperRowPos = i;
                    sapperColPos = j;
                }
                if (field[i][j] == 'B') {
                    totalBombs++;
                }
            }
        }

        for (String command : commands) {
            switch (command) {
                case "up": {
                    moveSapper(field, -1, 0);
                    break;
                }
                case "down": {
                    moveSapper(field, 1, 0);
                    break;
                }
                case "left": {
                    moveSapper(field, 0, -1);
                    break;
                }
                case "right": {
                    moveSapper(field, 0, 1);
                    break;
                }
                default: {
                    System.out.println("No such command possible.");
                    break;
                }
            }
            if (gameOver) {
                break;
            }
        }
        if (bombsDeactivated == totalBombs) {
            System.out.println("Congratulations! You found all bombs!");
        } else {
            if (gameOver) {
                System.out.printf("END! %d bombs left on the field%n", totalBombs - bombsDeactivated);
            } else {
                System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n"
                        , totalBombs - bombsDeactivated, sapperRowPos, sapperColPos);
            }
        }
    }

    public static void moveSapper(char[][] field, int rowMutator, int colMutator) {
        int nextRow = sapperRowPos + rowMutator;
        int nextCol = sapperColPos + colMutator;

        if (isInBounds(field, nextRow, nextCol)) {
            if (field[nextRow][nextCol] == 'B') {
                field[nextRow][nextCol] = '+';
                bombsDeactivated++;
                System.out.println("You found a bomb!");
            } else if (field[nextRow][nextCol] == 'e') {
                gameOver = true;
            }
            field[sapperRowPos][sapperColPos] = '+';
            sapperRowPos = nextRow;
            sapperColPos = nextCol;
        }
    }

    public static boolean isInBounds(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}
