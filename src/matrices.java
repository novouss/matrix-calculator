import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

class matrices implements Serializable{
    
    private static final long serialVersionUID = 1L;

    public int[][] add(int[][] mat1, int[][] mat2) {

        int[][] solve = new int[mat1.length][mat2[0].length];

        for (int row = 0; row < solve.length; row++) {
            for (int col = 0; col < solve[row].length; col++) {
                solve[row][col] = mat1[row][col] + mat2[row][col];
            }
        }

        return solve;

    }

    public int[][] subtract(int[][] mat1, int[][] mat2) {

        int[][] solve = new int[mat1.length][mat2[0].length];

        for (int row = 0; row < solve.length; row++) {
            for (int col = 0; col < solve[row].length; col++) {
                solve[row][col] = mat1[row][col] - mat2[row][col];
            }
        }
        
        return solve;
    }

    public int[][] multiply(int[][] mat1, int[][] mat2) {
        
        ArrayList<ArrayList<Integer>> solve = new ArrayList<>();

        // Create a loop that'll track the first matrix
        for (int row_1 = 0; row_1 < mat1.length; row_1++) {

            // Every time row_1 loops create a new row for solve
            solve.add(new ArrayList<>());
            for (int row = 0; row < mat1.length; row++) {

                int total = 0; // To track the added integers

                for (int col = 0; col < mat2.length; col++) {

                    // Multiply the values inside the array
                    total += mat1[row_1][col] * mat2[col][row];
                    
                }

                solve.get(row_1).add(total);
            }
        }

        return toArray(solve);
    }

    public int[][] divide(int[][] mat1, int[][] mat2) {

        ArrayList<ArrayList<Integer>> solve = new ArrayList<>();

        // IS CURRENTLY UNAVAILABLE FOR THE TIME BEING.

        return toArray(solve);
    }

    public int determinant(int[][] mat) {
        // Laplace Expansion. Read more here https://en.wikipedia.org/wiki/Laplace_expansion
        if (mat.length == 2) {
            // Given mat = [a, b], [c,d]
            // Multiply values opposite to its position (a*d) - (b*d)
            return (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]); 
        } else {
            // Recursive Method
            int total = 0;

            int[][] matrix = new int[mat.length - 1][mat[0].length - 1];

            for (int n = 0; n < mat.length; n++) {
                
                // Get the array excluding the first row and current column (n)
                // REALLY HIGH TIME-COMPLEXITY. WORK IN PROGRESS...
                for (int row = 1; row < mat.length; row++) {
                    for (int col = 0, count = 0; col < mat[row].length; col++) {
                        if (col != n) {
                            matrix[row - 1][count++] = mat[row][col];
                        }
                    }
                }


                if (n % 2 == 0) {
                    total += mat[0][n] * determinant(matrix);
                } else {
                    total -= mat[0][n] * determinant(matrix);
                }
                
            }

            return total;
        }
    }

    public Boolean isAddSubValid(int[][] mat1, int[][] mat2) {
        // Rows and Columns of the first matrix must be equal to the second matrix's rows and columns.
        // row_of_mat1 == row_of_mat2 and col_of_mat1 == col_of_mat2;
        return mat1.length == mat2.length && mat1[0].length == mat2[0].length;
    }

    public Boolean isMulDivValid(int[][] mat1, int[][] mat2) {
        // The number of columns of the first matrix must equal the number of rows of the second matrix.
        // col_of_mat1 == row_of_mat2
        return mat1[0].length == mat2.length;
    }
    
    public boolean isInverse(int[][] mat) {
        // If the determinant is zero, the matrix does not have an inverse.
        return determinant(mat) == 0;
    }

    public boolean isDeterminant(int[][] mat) {
        // Matrix must be a square, meaning the rows and columns should be the same.
        try {
            return mat.length == mat[0].length;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private int[][] toArray(ArrayList<ArrayList<Integer>> arr) {

        int[][] solve = new int[arr.size()][arr.get(0).size()];

        for (int row = 0; row < solve.length; row++) {
            System.out.println(arr.get(row).toString());
            for (int col = 0; col < solve[row].length; col++) {
                try {
                    solve[row][col] = arr.get(row).get(col);

                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e);
                    return new int[0][0];
                }
            }
        }

        return solve;
    }

    public void print(int[][] mat) {

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                System.out.print(mat[row][col] + " ");
            }
            System.out.println();
        }
    }

}
