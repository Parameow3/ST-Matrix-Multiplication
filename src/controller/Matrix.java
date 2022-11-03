package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    private Scanner scanner = new Scanner(System.in);
    /**
     *
     * @param n
     * @param m
     */
    public void createMatrix(int n, int m){
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
        System.out.println("_ Matrix " + n + "x" + m + " _");
        System.out.println("-------------------------");
    }

    /**
     *
     * @param matrix1
     * @param matrix2
     */
    public void multiply(ArrayList matrix1, ArrayList matrix2){

    }

    /**
     *
     * @param matrix1
     * @param matrix2
     */
    public void display(ArrayList matrix1, ArrayList matrix2){

    }
}
