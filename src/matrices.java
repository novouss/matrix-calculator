import java.io.Serializable;
import java.util.ArrayList;

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

    public int[][] division(int[][] mat1, int[][] mat2) {

        ArrayList<ArrayList<Integer>> solve = new ArrayList<>();

        return toArray(solve);
    }

    public Boolean isAddSubValid(int[][] mat1, int[][] mat2) {
        // The number of columns of the first matrix must equal to the number of columns of the second matrix.
        // mat1.length == mat2.length
        // Both matrices must have the same number of rows.
        // mat1[0].length == mat2[0].length
        return mat1.length == mat2.length && mat1[0].length == mat2[0].length;
    }

    public Boolean isMulDivValid(int[][] mat1, int[][] mat2) {
        // The number of columns of the first matrix must equal the number of rows of the second matrix.
        // mat1.columns == mat2.rows
        return mat1[0].length == mat2.length;
    }    

    private static int[][] toArray(ArrayList<ArrayList<Integer>> arr) {

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
