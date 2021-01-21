import java.io.Serializable;

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

    public int[][] sub(int[][] mat1, int[][] mat2) {

        int[][] solve = new int[mat1.length][mat2[0].length];

        for (int row = 0; row < solve.length; row++) {
            for (int col = 0; col < solve[row].length; col++) {

                solve[row][col] = mat1[row][col] - mat2[row][col];

            }
        }
        
        return solve;
    }

    public int[][] mul(int[][] mat1, int[][] mat2) {
        
        int[][] solve = new int[mat1.length][mat2[0].length];

        return solve;
    }

    public Boolean valid(int[][] mat1, int[][] mat2) {

        if (mat1.length != mat2.length) return false; // Checks length of height

        for (int row = 0; row < mat1.length; row++) {
            if (mat1[row].length != mat2[row].length) return false; // Checks length of width for each row
        }

        return true;
        
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
