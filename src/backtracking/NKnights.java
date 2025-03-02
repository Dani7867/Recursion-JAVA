package backtracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knight(board, 0, 0, n);
    }

    static void knight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        if (row == board.length) {
            return;
        }

        if (col == board.length) {
            knight(board, row + 1, 0, knights);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        knight(board, row, col + 1, knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        int[][] moves = {
                {-2, -1}, {-2, +1},
                {-1, -2}, {-1, +2}
        };

        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];
            if (isValid(board, newRow, newCol) && board[newRow][newCol]) {
                return false;
            }
        }

        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                System.out.print(element ? "K " : "X ");
            }
            System.out.println();
        }
    }
}
