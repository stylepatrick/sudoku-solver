package sudoku;

public class WrongFileException extends Exception {

    WrongFileException() {
        System.out.println("Wrong input file!");
    }
}
