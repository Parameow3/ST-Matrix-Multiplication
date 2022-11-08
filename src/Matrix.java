import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private Scanner scanner = new Scanner(System.in);
    /**
     *
     * @param n
     * @param m
     */
    public ArrayList[][] createMatrix(int n, int m){
        // redim arraylist size
        ArrayList[][] matrix = new ArrayList[n][m];

        // user input matrix
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                matrix[i][j] = new ArrayList<>();
                System.out.print("Please Input matrix" + "[" + i + "]" + "[" + j + "]: ");
                matrix[i][j].add(scanner.nextInt());
            }
        }
        display(matrix, n, m);

        return matrix;
    }

    public void generateMatrix(int n, int m) {
        Random random = new Random();
        // redim arraylist size
        ArrayList[][] matrix = new ArrayList[n][m];

        // user input matrix
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                matrix[i][j] = new ArrayList<>();
                matrix[i][j].add(random.nextInt(50));
            }
        }
        display(matrix, n, m);
    }

    /**
     *
     */
    public void multiply(){
        // create matrix 1
        System.out.print("Please input matrix1's number of row: ");
        int n1 = scanner.nextInt();
        System.out.print("Please input matrix1's number of column: ");
        int m1 = scanner.nextInt();
        // initialize matrix1
        ArrayList[][] matrix1 = new ArrayList[n1][m1];
        matrix1 = createMatrix(n1, m1);

        // create matrix 2
        boolean isMultiple = false;
        int n2 = 0;
        // check the m1 and n2 to make sure that matrix can multiply
        while (!isMultiple) {
            System.out.print("Please input matrix2's number of row: ");
            n2 = scanner.nextInt();
            if (n2 == m1)
                isMultiple = true;
            else
                System.out.println("Your [matrix2's number of row] is not equal to [matrix1's number of column]!");
        }
        System.out.print("Please input matrix2's number of column: ");
        int m2 = scanner.nextInt();
        // initialize matrix2
        ArrayList[][] matrix2 = new ArrayList[n2][m2];
        matrix2 = createMatrix(n2, m2);

        //initial new matrix
        ArrayList[][] mulMatrix = new ArrayList[n1][m2];

        // multiplication start
        int tempSum = 0;
        for(int i = 0; i < n1; i++) {
            for (int k = 0; k < m2; k++){
                for (int j = 0; j < m1; j++) {
                    tempSum = tempSum + ((int) matrix1[i][j].get(0) * (int) matrix2[j][k].get(0));
                }
                mulMatrix[i][k] = new ArrayList<>();
                mulMatrix[i][k].add(tempSum);
                tempSum = 0;
            }
        }
        System.out.println("Here is the multiplication result:");
        display(mulMatrix, n1, m2);
    }

    /**
     *
     * @param matrix
     * @param n
     * @param m
     */
    public void display(ArrayList[][] matrix, int n, int m){
        System.out.println("-----------------");
        System.out.println("_ Matrix " + n + "x" + m + " _");
        System.out.print("-----------------");
        for (int i = 0; i < n; i++){
            System.out.println("");
            System.out.print("|");
            for (int j = 0; j < m; j++){
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println("");
        System.out.println("-------------------------");
    }
}
