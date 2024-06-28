import java.util.*;

public class TicTacToe {
    static char[][] board;
    static char curr_pl;

    public TicTacToe() {
        this.curr_pl = 'X';
    }

    public static void buildarr() {
        board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void displayBoard() {
        System.out.println(" ------------------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print(" | ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println(" ------------------------");
        }
    }

    public static void swch_pl() {
        curr_pl = (curr_pl == 'X') ? 'O' : 'X';
    }

    public static boolean makeMove(int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
                board[row][col] != ' ') {
            return false;
        }
        board[row][col] = curr_pl;
        return true;
    }

    public static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == curr_pl && board[i][1] == curr_pl && board[i][2] == curr_pl) {
                return true;
            }
            if (board[0][i] == curr_pl && board[1][i] == curr_pl && board[2][i] == curr_pl) {
                return true;
            }
        }
        if (board[0][0] == curr_pl && board[1][1] == curr_pl && board[2][2] == curr_pl) {
            return true;
        }
        if (board[0][2] == curr_pl && board[1][1] == curr_pl && board[2][0] == curr_pl) {
            return true;
        }
        return false;
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        buildarr();
        TicTacToe ticTacToe = new TicTacToe();
        do {
            displayBoard();
            System.out.println("Player " + ticTacToe.curr_pl + "'s turn.");
            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();
            if (makeMove(row, col)) {
                if (checkWin()) {
                    displayBoard();
                    System.out.println("Player " + ticTacToe.curr_pl + " wins!");
                    break;
                } else if (isBoardFull()) {
                    displayBoard();
                    System.out.println("It's a draw!");
                    break;
                } else {
                    swch_pl();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        } while (true);
        scanner.close();
    }
}