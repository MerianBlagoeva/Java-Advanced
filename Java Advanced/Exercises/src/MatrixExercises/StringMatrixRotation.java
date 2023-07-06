package MatrixExercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String rotationCommand = sc.nextLine();
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(rotationCommand);
        int degrees = 0;
        if (matcher.find()) {
            degrees = Integer.parseInt(matcher.group());
        }
        int rotationCount = degrees / 90;


        String command = sc.nextLine();
        List<String> words = new ArrayList<>();
        while (!command.equals("END")) {
            words.add(command);
            command = sc.nextLine();
        }


        String longest = words.stream().max(Comparator.comparing(String::length))
                .orElse("");


        char[][] matrix = new char[words.size()][longest.length()];

        for (int i = 0; i < words.size(); i++) {
            char[] wordChars = words.get(i).toCharArray();
            System.arraycopy(wordChars, 0, matrix[i], 0, wordChars.length);
            for (int j = wordChars.length; j < longest.length(); j++) {
                matrix[i][j] = ' ';
            }
        }
        for (int i = 0; i < rotationCount; i++) {
            matrix = rotateMatrix(matrix);
        }

        for (char[] array : matrix) {
            for (char element : array) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    public static char[][] rotateMatrix(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        char[][] rotatedMatrix = new char[cols][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                rotatedMatrix[col][rows - row - 1] = matrix[row][col];
            }
        }

        return rotatedMatrix;
    }
}
