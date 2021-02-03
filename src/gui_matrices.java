
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;

public class gui_matrices extends javax.swing.JFrame implements Serializable{
    
    private static final long serialVersionUID = 1L;

    public gui_matrices() {
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);

        tabbed_pane = new javax.swing.JTabbedPane();

        basicOperations();
        determinants();

        tabbed_pane.addTab("BASIC OPERATIONS", basic_op_panel);
        tabbed_pane.addTab("DETERMINANTS", deter_panel);
        getContentPane().add(tabbed_pane);
        tabbed_pane.setBounds(0, 0, 760, 400);

        setBounds(0, 0, 760, 400);
    }

    private void basicOperations() {
        btnADD = new javax.swing.JButton();
        btnSUB = new javax.swing.JButton();
        btnMUL = new javax.swing.JButton();
        btnDIV = new javax.swing.JButton();

        matrix_solve = new javax.swing.JTextArea();
        matrix_1 = new javax.swing.JTextArea();
        matrix_2 = new javax.swing.JTextArea();

        matrix_solve_scroll = new javax.swing.JScrollPane();
        matrix_1_scroll = new javax.swing.JScrollPane();
        matrix_2_scroll = new javax.swing.JScrollPane();

        basic_op_panel = new javax.swing.JPanel();
        basic_op_text = new java.awt.Label();

        basic_op_panel.setLayout(null);

        basic_op_panel.add(btnADD);
        btnADD.setBounds(120, 270, 50, 50);
        btnADD.setText("+");

        btnADD.addActionListener((java.awt.event.ActionEvent evt) -> {
            basicOpPerform(evt);
        });

        basic_op_panel.add(btnSUB);
        btnSUB.setBounds(180, 270, 50, 50);
        btnSUB.setText("-");

        btnSUB.addActionListener((java.awt.event.ActionEvent evt) -> {
            basicOpPerform(evt);
        });

        basic_op_panel.add(btnMUL);
        btnMUL.setBounds(240, 270, 50, 50);
        btnMUL.setText("*");

        btnMUL.addActionListener((java.awt.event.ActionEvent evt) -> {
            basicOpPerform(evt);
        });

        basic_op_panel.add(btnDIV);
        btnDIV.setBounds(300, 270, 50, 50);
        btnDIV.setText("/");

        btnDIV.addActionListener((java.awt.event.ActionEvent evt) -> {
            basicOpPerform(evt);
        });

        basic_op_panel.add(matrix_solve);
        matrix_solve.setEditable(false);
        matrix_solve.setFont(fontStyle);
            
        basic_op_panel.add(matrix_solve_scroll);
        matrix_solve_scroll.setViewportView(matrix_solve);
        matrix_solve_scroll.setBounds(520, 60, 210, 200);

        basic_op_panel.add(matrix_1);
        matrix_1.setFont(fontStyle);

        basic_op_panel.add(matrix_1_scroll);
        matrix_1_scroll.setViewportView(matrix_1);
        matrix_1_scroll.setBounds(10, 60, 210, 200);

        basic_op_panel.add(matrix_2);
        matrix_2.setFont(fontStyle);

        basic_op_panel.add(matrix_2_scroll);
        matrix_2_scroll.setViewportView(matrix_2);
        matrix_2_scroll.setBounds(250, 60, 210, 200);

        basic_op_panel.add(basic_op_text);
        basic_op_text.setText("BASIC OPERATIONS");
        basic_op_text.setFont(new java.awt.Font(font_face, 1, 24));
        basic_op_text.setBounds(10, 10, 730, 40);
        
    }

    private void determinants() {
        deter_panel = new javax.swing.JPanel();
        
        deter_solve = new javax.swing.JTextArea();
        deter_input = new javax.swing.JTextArea();
        
        deter_solve_scroll = new javax.swing.JScrollPane();
        deter_input_scroll = new javax.swing.JScrollPane();

        deter_text = new java.awt.Label();

        deter_panel.setLayout(null);

        deter_panel.add(deter_solve);
        deter_solve.setEditable(false);
        deter_solve.setFont(fontStyle);

        deter_panel.add(deter_solve_scroll);
        deter_solve_scroll.setViewportView(deter_solve);
        deter_solve_scroll.setBounds(520, 20, 210, 200);

        deter_panel.add(deter_input);
        deter_input.setFont(fontStyle);

        deter_panel.add(deter_input_scroll);
        deter_input_scroll.setViewportView(deter_input);
        deter_input_scroll.setBounds(300, 20, 210, 200);

        deter_input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {

                if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    deter_solve.setText("");
                } else {
                    deterPerform(evt);
                }
                
            }
        });

        deter_panel.add(deter_text);
        deter_text.setText("DETERMINANTS");
        deter_text.setBounds(10, 10, 300, 40);
        deter_text.setFont(new java.awt.Font(font_face, 1, 24));

    }

    private void basicOpPerform(java.awt.event.ActionEvent evt) {
        int[][] mat1 = toArray(matrix_1);
        int[][] mat2 = toArray(matrix_2);

        int[][] solve = new int[0][0];
        boolean valid = true;

        switch(evt.getActionCommand()) {
            case "+":
                valid = operations.isAddSubValid(mat1, mat2);
                if (valid) solve = operations.add(mat1, mat2);
                break;
            case "-":
                valid = operations.isAddSubValid(mat1, mat2);
                if (valid) solve = operations.subtract(mat1, mat2);
                break;
            case "*":
                valid = operations.isMulDivValid(mat1, mat2);
                if (valid) solve = operations.multiply(mat1, mat2);
                break;
            case "/":
                valid = operations.isMulDivValid(mat1, mat2);
                // if (valid) solve = operations.subtract(mat1, mat2);
                break;
        }
            
        matrix_solve.setText((valid) ? toString(solve) : "Error!");
        matrix_1.setText("");
        matrix_2.setText("");

    }

    private void deterPerform(java.awt.event.KeyEvent evt) {

        int[][] matrix = toArray(deter_input);

        if (matrix.length > 1 && matrix[0].length > 1 && operations.isDeterminant(matrix)) {
            deter_solve.setText(operations.determinant(matrix) + "");
        } else {
            deter_solve.setText("Error!");
        }

    }

    private static ArrayList<ArrayList<Integer>> intSplit(javax.swing.JTextArea textarea) {
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>());
        String text = textarea.getText() + "\n";
        String temp = "";

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
                arr.get(row++).add(Integer.parseInt(temp));
                arr.add(new ArrayList<>());
                temp = "";
            }

        }

        if (temp.length() != 0) arr.get(arr.size() - 1).add(Integer.parseInt(temp));

        return arr;
    }

    private static int[][] toArray(javax.swing.JTextArea textarea) {

        ArrayList<ArrayList<Integer>> arr = intSplit(textarea);

        int[][] solve = new int[arr.size()][arr.get(0).size()];

        for (int row = 0; row < solve.length; row++) {
            for (int col = 0; col < solve[row].length; col++) {

                try {
                    solve[row][col] = arr.get(row).get(col);

                } catch (IndexOutOfBoundsException e) {
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
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui_matrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui_matrices().setVisible(true);
            }
        });
        
    }
    
    // Variable declaration
    private javax.swing.JTabbedPane tabbed_pane;
    private String font_face = "Monospaced";
    private java.awt.Font fontStyle = new java.awt.Font(font_face, 0, 12);
    
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnSUB;
    private javax.swing.JButton btnMUL;
    private javax.swing.JButton btnDIV;

    private javax.swing.JTextArea matrix_solve;
    private javax.swing.JTextArea matrix_1;
    private javax.swing.JTextArea matrix_2;

    private javax.swing.JScrollPane matrix_solve_scroll;
    private javax.swing.JScrollPane matrix_1_scroll;
    private javax.swing.JScrollPane matrix_2_scroll;

    private javax.swing.JPanel basic_op_panel;
    private java.awt.Label basic_op_text;

    private javax.swing.JTextArea deter_solve;
    private javax.swing.JTextArea deter_input;

    private javax.swing.JScrollPane deter_solve_scroll;
    private javax.swing.JScrollPane deter_input_scroll;

    private javax.swing.JPanel deter_panel;
    private java.awt.Label deter_text;

    public static matrices operations = new matrices();
    // End of variable declaration
}
