package ru.job4j.puzzle;

public class Win {

    public static boolean checkRow(int[][] board1, int row) {
        boolean rsl = true;
        for (int index1 = 0; index1 < board1.length; index1++) {
            if (board1[row][index1] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean checkColumn(int[][] board1, int column) {
        boolean rsl = true;
        for (int index1 = 0; index1 < board1.length; index1++) {
            if (board1[index1][column] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int index1 = 0; index1 < board.length; index1++) {
            if (board[index1][index1] == 1) {
                if (checkColumn(board, index1) || checkRow(board, index1)) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }
}
