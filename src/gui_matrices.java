
import java.io.Serializable;
import java.util.ArrayList;

public class gui_matrices extends javax.swing.JFrame implements Serializable{
    
    private static final long serialVersionUID = 1L;

    public gui_matrices() {
        initComponents();
    }

    private void initComponents() {
        btnADD = new javax.swing.JButton();
        btnSUB = new javax.swing.JButton();
        btnMUL = new javax.swing.JButton();
        btnDIV = new javax.swing.JButton();

        matrix_solve = new javax.swing.JTextArea();
        matrix_1 = new javax.swing.JTextArea();
        matrix_2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        getContentPane().add(btnADD);
        btnADD.setBounds(130, 230, 50, 50);
        btnADD.setText("+");

        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPreformed(evt);
            }
        });

        getContentPane().add(btnSUB);
        btnSUB.setBounds(190, 230, 50, 50);
        btnSUB.setText("-");

        btnSUB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubActionPerformed(evt);
            }
        });

        getContentPane().add(btnMUL);
        btnMUL.setBounds(250, 230, 50, 50);
        btnMUL.setText("*");

        getContentPane().add(btnDIV);
        btnDIV.setBounds(310, 230, 50, 50);
        btnDIV.setText("/");


        getContentPane().add(matrix_solve);
        matrix_solve.setBounds(540, 20, 210, 200);
        matrix_solve.setEditable(false);
        
        getContentPane().add(matrix_1);
        matrix_1.setBounds(20, 20, 210, 200);
        
        getContentPane().add(matrix_2);
        matrix_2.setBounds(260, 20, 210, 200);

        setBounds(0, 0, 782, 330);
    }

    private void btnAddActionPreformed(java.awt.event.ActionEvent evt) {

        int[][] mat1 = toArray(matrix_1);
        int[][] mat2 = toArray(matrix_2);

        if (operations.valid(mat1, mat2)){
        
            int[][] solve = operations.add(mat1, mat2);

            matrix_solve.setText(toString(solve));
            matrix_1.setText("");
            matrix_2.setText("");

        } else matrix_solve.setText("Error!");

    }

    private void btnSubActionPerformed(java.awt.event.ActionEvent evt) {
        
        int[][] mat1 = toArray(matrix_1);
        int[][] mat2 = toArray(matrix_2);

        if (operations.valid(mat1, mat2)){
        
            int[][] solve = operations.sub(mat1, mat2);

            matrix_solve.setText(toString(solve));
            matrix_1.setText("");
            matrix_2.setText("");

        } else matrix_solve.setText("Error!");
    }

    private static ArrayList<ArrayList<Integer>> intSplit(javax.swing.JTextArea txtarea) {
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>());
        String text = txtarea.getText() + "\n", temp = "";

        for (int index = 0, row = 0 ; index < text.length() - 1; index++) {

            // Track and keep numbers
            if ((text.charAt(index) >= 48 && text.charAt(index) <= 57) || text.charAt(index) == '-') {
                temp += text.charAt(index);
            } 

            // Convert the kept numbers and create a new column.
            if (text.charAt(index) != ' ' && text.charAt(index + 1) == ' ' && temp.length() != 0) { 
                arr.get(row).add(Integer.parseInt(temp));
                temp = "";
            } 
            
            // Create a new row
            if (text.charAt(index) == '\n' && text.charAt(index + 1) != '\n' && temp.length() != 0) {
                arr.get(row).add(Integer.parseInt(temp));
                arr.add(new ArrayList<>());
                temp = "";
                ++row;
            }

        }

        if (temp.length() != 0) arr.get(arr.size() - 1).add(Integer.parseInt(temp));

        return arr;
    }

    private static int[][] toArray(javax.swing.JTextArea txtarea) {

        ArrayList<ArrayList<Integer>> arr = intSplit(txtarea);

        int[][] solve = new int[arr.size()][arr.get(0).size()];

        for (int row = 0; row < solve.length; row++) {
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

    private static String toString(int[][] matrix) {
        String solve = "";

        for(int index = 0; index < matrix.length; index++) {

            for (int i : matrix[index]) {
                solve += i + " ";
            }

            solve += "\n";
        }
        
        return solve;
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gui_matrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui_matrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui_matrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui_matrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui_matrices().setVisible(true);
            }
        });
        
    }

    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnSUB;
    private javax.swing.JButton btnMUL;
    private javax.swing.JButton btnDIV;

    private javax.swing.JTextArea matrix_solve;
    private javax.swing.JTextArea matrix_1;
    private javax.swing.JTextArea matrix_2;

    public static matrices operations = new matrices();
}
