import sudoku.FileService;
import sudoku.NotSolvableException;
import sudoku.Sudoku;
import sudoku.WrongFileException;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0 && args[0] != null) {
            try {
                int[][] board = FileService.readFile(args[0]);
                int[][] solvedBoard = Sudoku.solveSudoku(board);
                Sudoku.printSolvedSudokuToConsole(solvedBoard);
                FileService.writeFile(solvedBoard);
            } catch (WrongFileException | NotSolvableException ignored) {
            }
        } else {
            System.out.println("No argument for input file set!");
        }
    }
}
