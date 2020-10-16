/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix_effect;

/**
 *
 * @author dam
 */
public class Matrix_Effect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int option = 1;

        if (option == 1) {
            int vector_alter[] = vector_alter();

            int vector[] = random_vector(5, 5, 1);

            int new_vector[] = new_vector(vector, vector_alter);

            System.out.println("Vector de original: " + vector.length);
            show_vector(vector);

            System.out.println("Vector de nuevo: " + new_vector.length);
            show_vector(new_vector);

        } else {
            int matrix_alter[][] = matrix_alter();

            int matrix_3d[][][] = random_matrix(5, 5, 2);

            int new_matrix[][][] = new_matrix(matrix_3d, matrix_alter);

            System.out.println("Matriz original: ");
            show_matrix(matrix_3d);

            System.out.println("Matriz nueva: ");
            show_matrix(new_matrix);
        }

    }

    public static int[][][] random_matrix(int col, int row, int prof) {

        int[][][] matrix_3d = new int[row][col][prof];

        for (int z = 0; z < prof; z++) {
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    matrix_3d[x][y][z] = (int) (Math.random() * 9) + 1;
                }
            }
        }
        return matrix_3d;
    }

    public static int[][][] show_matrix(int[][][] matrix_3d) {

        int prof = matrix_3d[0][0].length;
        int col = matrix_3d[0].length;
        int row = matrix_3d.length;

        for (int z = 0; z < prof; z++) {

            System.out.println("Z: " + (z + 1) + "\n--------\n");

            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    System.out.print(matrix_3d[x][y][z] + " ");
                }

                System.out.println("");
            }
            System.out.println("");
        }

        return matrix_3d;
    }

    public static int[][] matrix_alter() {

        int matrix_alter[][] = {
            {1, 1, 1},
            {0, 2, 0},
            {1, 1, 1}
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.print(matrix_alter[i][j] + " ");
            }

            System.out.println("");
        }

        System.out.println("");

        return matrix_alter;
    }

    public static int[][][] new_matrix(int matrix_3d[][][], int matrix_alter[][]) {

        int prof = matrix_3d[0][0].length;
        int col = matrix_3d[0].length;
        int row = matrix_3d.length;

        int K = k_sum(matrix_alter);

        int[][][] new_matrix = new int[row][col][prof];

        for (int z = 0; z < prof; z++) {

            for (int x = 1; x < row - 1; x++) {
                for (int y = 1; y < col - 1; y++) {

                    //Start
                    int p_total = 0;

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {

                            p_total += matrix_3d[(x - 1) + i][(y - 1) + j][z]
                                    * matrix_alter[i][j];
                        }
                    }

                    if (p_total != 0) {
                        new_matrix[x][y][z] = p_total / K;
                    } else {
                        new_matrix[x][y][z] = p_total;
                    }
                }

            }

        }

        return new_matrix;
    }

    public static int k_sum(int matrix_alter[][]) {

        int k_sum = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                k_sum += matrix_alter[i][j];
            }
        }

        return k_sum;
    }

    public static int[] random_vector(int col, int row, int prof) {

        int vector[] = new int[col * row * prof];

        for (int i = 0; i < (col * row * prof); i++) {
            vector[i] = (int) (Math.random() * 9) + 1;
        }
        return vector;
    }

    public static int[] show_vector(int[] vector) {

        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }

        System.out.println("\n");

        return vector;
    }

    public static int[] vector_alter() {

        int vector_alter[] = {1, 1, 1, 0, 2, 0, 1, 1, 1};

        for (int i = 0; i < 9; i++) {
            System.out.print(vector_alter[i] + " ");
        }

        System.out.println("");

        return vector_alter;
    }

    public static int[] new_vector(int[] vector, int[] vector_alter) {

        int new_vector[] = new int[vector.length + vector_alter.length - 1];

        for (int i = 0; i < vector.length  + vector_alter.length - 1; i++) {
            int sum_p = 0;

            for (int j = 0; j < vector_alter.length; j++) {

                int pos = i + j - (vector_alter.length - 1);

                if (pos >= 0 && pos < vector.length) {
                        sum_p += (vector[pos] * vector_alter[j]);
                }
            }

            new_vector[i] = sum_p;
        }
        return new_vector;
    }
}
