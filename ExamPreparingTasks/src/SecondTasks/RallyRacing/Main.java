package SecondTasks.RallyRacing;

import java.util.Scanner;

public class Main {
    private static int kmPassed = 0;
    private static boolean finished = false;
    private static int carRowPos = 0;
    private static int carColPos = 0;
    private static int foundPortals = 0;
    private static int firstTunnelExitRow = 0;
    private static int firstTunnelExitCol = 0;
    private static int secondTunnelExitRow = 0;
    private static int secondTunnelExitCol = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();
        char[][] area = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            for (int j = 0; j < size; j++) {
                area[i] = line.toCharArray();
                if (area[i][j] == 'T') {
                    foundPortals++;
                    findNextTunnelExit(i, j);
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
             if (finished) {
                 System.out.printf("Racing car %s finished the stage!\n", carNumber);
                 break;
             }
             command = scanner.nextLine();
         }
         if (!finished) {
             System.out.printf("Racing car %s DNF.\n",carNumber);
         }
        System.out.printf("Distance covered %d km.\n",kmPassed);

         printXYMatrix(area);
    }

     public static void move(char[][] area, int rowMutator, int colMutator) {
         int nextRow = carRowPos + rowMutator;
         int nextCol = carColPos + colMutator;

         if (area[nextRow][nextCol] == '.'){
             area[nextRow][nextCol] = 'C';
             area[carRowPos][carColPos] = '.';
             carRowPos = nextRow;
             carColPos = nextCol;
             kmPassed+=10;
         }else if (area[nextRow][nextCol] == 'T') {
            moveThroughTunnel(area,nextRow,nextCol);
            kmPassed+=30;
         }else if (area[nextRow][nextCol] == 'F') {
            finished = true;
             area[nextRow][nextCol] = 'C';
             area[carRowPos][carColPos] = '.';
             carRowPos = nextRow;
             carColPos = nextCol;
             kmPassed+=10;
         }
     }

    public static void findNextTunnelExit(int rowPos, int colPos) {
        if (foundPortals == 1) {
            firstTunnelExitRow = rowPos;
            firstTunnelExitCol = colPos;
        } else if (foundPortals == 2) {
            secondTunnelExitRow = rowPos;
            secondTunnelExitCol = colPos;
        }
    }

    public static int whichTunnelEntrance(int rowPos, int colPos) {
        if (rowPos == firstTunnelExitRow && colPos == firstTunnelExitCol) {
            return 1;
        } else if (rowPos == secondTunnelExitRow && colPos == secondTunnelExitCol) {
            return 2;
        } else {
            return 0;
        }
    }

    public static void moveThroughTunnel(char[][] area, int nextRowPos, int nextColPos){
        if (whichTunnelEntrance(nextRowPos,nextColPos) == 1){
            area[nextRowPos][nextColPos] = '.';
            area[carRowPos][carColPos] = '.';
            area[secondTunnelExitRow][secondTunnelExitCol] = 'C';
            carRowPos = secondTunnelExitRow;
            carColPos = secondTunnelExitCol;
        }else if (whichTunnelEntrance(nextRowPos,nextColPos) == 2){
            area[nextRowPos][nextColPos] = '.';
            area[carRowPos][carColPos] = '.';
            area[firstTunnelExitRow][firstTunnelExitCol] = 'C';
            carRowPos = firstTunnelExitRow;
            carColPos = firstTunnelExitCol;
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
