import java.util.Scanner;

public class SingleThread {
    // scanner obj for input staff
    private Scanner scanner = new Scanner(System.in);
    private int choice;
    private Matrix matrix;

    public SingleThread(){
        matrix = new Matrix();
    }
    public void createMenu(){
        // print the choice's list
        System.out.println("--------------------------");
        System.out.println("1. Create Matrix");
        System.out.println("2. Auto Generate Matrix");
        System.out.println("3. Multiply Matrix");
        System.out.println("4. Exit");
        System.out.println("--------------------------");
        System.out.println("Please choose the choice: ");
        choice = scanner.nextInt();

        switch (choice){
            case 1 -> { // Create Matrix
                System.out.println("--------------------------");
                System.out.println("-------Create Matrix------");
                System.out.println("--------------------------");
                System.out.print("Please input  number of row: ");
                int row = scanner.nextInt();
                System.out.print("Please input  number of column: ");
                int col = scanner.nextInt();
                matrix.createMatrix(row, col);
            } // Break case 1
            case 2 -> { // Auto Generate Matrix
                System.out.println("--------------------------");
                System.out.println("Auto Generate Matrix");
                System.out.println("--------------------------");
                System.out.print("Please input  number of row: ");
                int row = scanner.nextInt();
                System.out.print("Please input  number of column: ");
                int col = scanner.nextInt();

                matrix.generateMatrix(row, col);
            } // Break case 2
            case 3 -> { // Multiply Matrix
                matrix.multiply();
            } // Break case 3
            case 4 -> { // Exit
                System.exit(0);
            } // Break case 4
            // Else
            default -> System.out.println("InValid Input!");
        }
    }
}
