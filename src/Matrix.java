import java.util.*;
import java.util.concurrent.TimeUnit;

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

    public ArrayList[][] generateMatrix(int n, int m) {
        Random random = new Random();
        // redim arraylist size
        ArrayList[][] matrix = new ArrayList[n][m];

        // user input matrix
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                matrix[i][j] = new ArrayList<>();
                matrix[i][j].add(random.nextInt(2));
            }
        }
        return matrix;
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
        matrix1 = generateMatrix(n1, m1);

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
        matrix2 = generateMatrix(n2, m2);

        //initial new matrix
        ArrayList[][] mulMatrix = new ArrayList[n1][m2];

        // start timer
        Date start = new Date();
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
        Date end = new Date();
        long timeTaken = end.getTime() - start.getTime();

        System.out.println("Here is the multiplication result:");
        display(mulMatrix, n1, m2);

        System.out.println();
        System.out.println("EXECUTION TIME--------------");
        System.out.println(timeTaken + " ms");
        System.out.printf("%02d min, %02d sec, %03d ms%n",
                TimeUnit.MILLISECONDS.toMinutes(timeTaken),
                TimeUnit.MILLISECONDS.toSeconds(timeTaken) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeTaken)),
                timeTaken % 1000);

        System.out.println("----------------------------");
    }

    public void multiMultiply(){
        // create matrix 1
        System.out.print("Please input matrix1's number of row: ");
        int n1 = scanner.nextInt();
        System.out.print("Please input matrix1's number of column: ");
        int m1 = scanner.nextInt();
        // initialize matrix1
        ArrayList[][] matrix1 = new ArrayList[n1][m1];
        matrix1 = generateMatrix(n1, m1);

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
        matrix2 = generateMatrix(n2, m2);

        //initial new matrix
        ArrayList[][] mulMatrix = new ArrayList[n1][m2];

        Date start = new Date();
        // Create 10 threads
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            threads.add(new Thread(new MultiThread(mulMatrix, matrix1, matrix2, i)));
        }

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Date end = new Date();
        long timeTaken = end.getTime() - start.getTime();

        System.out.println("Here is the multiplication result:");
        display(mulMatrix, n1, m2);

        System.out.println();
        System.out.println("EXECUTION TIME--------------");
        System.out.println(timeTaken + " ms");
        System.out.printf("%02d min, %02d sec, %03d ms%n",
                TimeUnit.MILLISECONDS.toMinutes(timeTaken),
                TimeUnit.MILLISECONDS.toSeconds(timeTaken) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeTaken)),
                timeTaken % 1000);

        System.out.println("----------------------------");
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
