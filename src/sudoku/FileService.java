package sudoku;

import java.io.*;

public class FileService {

    private static final int BOARD_SIZE = 9;
    public static int[][] readFile(String fileName) throws WrongFileException {
        int[][] inputBoard = new int[BOARD_SIZE][BOARD_SIZE];
        try {
            FileReader reader = new FileReader(fileName);
            int ch = reader.read();
            int row = 0;
            int column = 0;
            while (ch > 0) {
                while (ch >= 0 && ch != '\r') {
                    if (column >= 9 || row >= 9) {
                        throw new WrongFileException();
                    }
                    if (ch > 0 && ch != 32) { // 32 ASCII for blank space
                        if (Character.isAlphabetic((char) ch)) {
                            throw new WrongFileException();
                        }
                        inputBoard[row][column] = Integer.parseInt(String.valueOf((char) ch));
                        column++;
                    }
                    ch = reader.read();
                }
                row++;
                column = 0;
                ch = reader.read(); // skip CR
                ch = reader.read(); // skip LF
            }
            reader.close();
            if (row == BOARD_SIZE) {
                return inputBoard;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        throw new WrongFileException();
    }

    public static void writeFile(int[][] board) {
        try {
            FileWriter writer = new FileWriter("output.txt");
            for (int i = 0; i < BOARD_SIZE; i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < BOARD_SIZE; j++) {
                    line.append(board[i][j]).append(" ");
                }
                line.append("\r");
                writer.write(line.toString());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
