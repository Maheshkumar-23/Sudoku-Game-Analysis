import java.util.Scanner;

public class Main {
    private static final int SIZE = 9;
    private static int[][] board = new int[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Sudoku board row by row elements");
        
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        
        while (!isSolved()) {
            printBoard();
            System.out.println("Enter row (0-8), column (0-8), and number (1-9): ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            int num = sc.nextInt();
            
            if (isValidMove(row, col, num)) {
                board[row][col] = num;
            } else {
                System.out.println("Invalid step");
            }
        }
        printBoard();
        System.out.println("Congrats! You have completed the Sudoku.");
    }

    private static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col, int num) {
        if (board[row][col] != 0) return false;
        
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSolved() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
          


       //       1 9 7 8 3 4 5 6 2
              8 2 6 1 9 5 3 4 7 
              4 3 5 2 6 9 7 8 1
              6 8 2 5 7 1 4 9 3
              3 7 4 6 8 2 9 1 5 
              9 5 1 7 4 3 6 2 8
              5 1 9 3 2 6 8 7 4
              2 4 8 9 5 7 1 3 6
              7 6 3 4 1 8 3 5 9    //
