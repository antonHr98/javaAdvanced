package SecondTasks.StickyFingers;

import java.util.Scanner;

public class Main {
    private static int moneyStolen = 0;
    private static boolean busted = false;
    private static int thiefRowPos = 0;
    private static int thiefColPos = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] area = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            for (int j = 0; j < size; j++) {
                area[i] = line.toCharArray();
                if (area[i][j] == 'D') {
                    thiefRowPos = i;
                    thiefColPos = j;
                }
            }
        }

        for (String command : commands) {
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
            if (busted) {
                System.out.printf("You got caught with %d$, and you are going to jail.\n", moneyStolen);
                break;
            }
        }
        if (!busted) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n", moneyStolen);
        }
        printXYMatrixSeparatedBySingleSpace(area, size);
    }

    public static void move(char[][] area, int rowMutator, int colMutator) {
        int nextRow = thiefRowPos + rowMutator;
        int nextCol = thiefColPos + colMutator;

        if (isInBounds(area, nextRow, nextCol)) {
            if (area[nextRow][nextCol] == '+') {
                area[nextRow][nextCol] = 'D';
                area[thiefRowPos][thiefColPos] = '+';
                thiefRowPos = nextRow;
                thiefColPos = nextCol;
            } else if (area[nextRow][nextCol] == '$') {
                int houseMoney = nextRow * nextCol;
                moneyStolen += houseMoney;
                System.out.printf("You successfully stole %d$.\n",houseMoney);
                area[nextRow][nextCol] = 'D';
                area[thiefRowPos][thiefColPos] = '+';
                thiefRowPos = nextRow;
                thiefColPos = nextCol;

            } else if (area[nextRow][nextCol] == 'P') {
                busted = true;
                area[nextRow][nextCol] = '#';
                area[thiefRowPos][thiefColPos] = '+';
                thiefRowPos = nextRow;
                thiefColPos = nextCol;
            }
        } else {
            System.out.println("You cannot leave the town, there is police outside!");
        }
    }

    public static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }

    public static void printXYMatrixSeparatedBySingleSpace(char[][] matrix, int size) {
      for (int i=0;i<size;i++){
          for (int j=0;j<size;j++){
              System.out.print(matrix[i][j]);
              if (j!=matrix.length-1){
                  System.out.print(" ");
              }
          }
          System.out.println();
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
