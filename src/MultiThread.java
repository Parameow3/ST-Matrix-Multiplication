import java.util.ArrayList;

public class MultiThread  implements Runnable {
    private ArrayList[][] matrix1;
    private ArrayList[][] matrix2;
    private ArrayList[][] result;
    private int threadNumber;
    private int tempSum = 0;

    public MultiThread(ArrayList[][] result, ArrayList[][] matrix1, ArrayList[][] matrix2, int threadNumber){
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        int row1 = matrix1.length; // Get number of rows from matrix1
        int column1 = matrix1[0].length; // Get number of columns from matrix1
        int row2 = matrix2.length; // Get number of rows from matrix2
        int column2 = matrix2[0].length; // Get number of columns from matrix2

        // Perform matrix multiplication
        for (int i = threadNumber; i < row1; i += 16) {
            for (int j = 0; j < column2; j++) {
                for (int k = 0; k < column1; k++) {
                    tempSum = tempSum +  ((int) matrix1[i][k].get(0) * (int) matrix2[k][j].get(0));
                }
                result[i][j] = new ArrayList<>();
                result[i][j].add(tempSum);
                tempSum = 0;
            }
        }
    }
}
