package sudoku;

public class Sudoku {

    private static final int BOARD_SIZE = 9;

    public static int[][] solveSudoku(int[][] board) throws NotSolvableException {
        if (isSudokuSolvable(board)) {
            return board;
        } else {
            throw new NotSolvableException();
        }
    }

    public static void printSolvedSudokuToConsole(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            String line;
            for (int j = 0; j < BOARD_SIZE; j++) {
                line = board[i][j] + "|";
                if (j == 2 || j == 5 || j == 8) {
                    line = line.substring(0, line.length() - 1) + " ";
                }
                System.out.print(line);
            }
            System.out.println();
            if (i == 2 || i == 5) {
                System.out.println();
            }
        }
    }

    private static boolean isSudokuSolvable(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 0) {
                    for (int tryNumber = 1; tryNumber <= BOARD_SIZE; tryNumber++) {
                        if (isValid(board, i, j, tryNumber)) {
                            board[i][j] = tryNumber;
                            if (isSudokuSolvable(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isRowValid(int[][] board, int row, int number) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == number) {
                return false;
            }
        }
        return true;
    }

    private static boolean isColumnValid(int[][] board, int column, int number) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][column] == number) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBoxValid(int[][] board, int row, int column, int number) {
        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxColumn; j < boxColumn + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int column, int number) {
        return isRowValid(board, row, number) && isColumnValid(board, column, number) && isBoxValid(board, row, column, number);
    }
}
