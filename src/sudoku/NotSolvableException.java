package sudoku;

public class NotSolvableException extends Exception {

    NotSolvableException() {
        System.out.println("Sudoku not solvable!");
    }

}
