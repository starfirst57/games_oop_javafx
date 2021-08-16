package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        int index = diagonalSearch(board);
        if (index > 0 ) {
            return verticalSearch(board, index) || horizontalSearch(board, index);
        }
        return false;
    }
    private static int diagonalSearch(int[][] board) {
        int result = -1;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                result = i;
                break;
            }
        }
        return result;
    }
    private static boolean horizontalSearch(int[][] board, int index) {
        for (int i = 0; i < board[index].length; i++) {
            if (board[index][i] != 1) {
                return false;
            }
        }
        return true;
    }
    private static boolean verticalSearch(int[][] board, int index) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][index] != 1) {
                return false;
            }
        }
        return true;
    }
}
