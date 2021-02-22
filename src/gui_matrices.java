
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
        setTitle("Basic Matrices Created by: [Raymond Gorospe]");

        tabbed_pane = new javax.swing.JTabbedPane();

        basicOperations();
        determinants();
        transpose();
        matrixOfMinors();
        adjoint();
        inverse();

        tabbed_pane.addTab("BASIC OPERATIONS", basic_op_panel);
        tabbed_pane.addTab("DETERMINANTS", deter_panel);
        tabbed_pane.addTab("TRANSPOSE", trans_panel);
        tabbed_pane.addTab("MATRIX OF MINORS", matOfMin_panel);
        tabbed_pane.addTab("ADJOINT", adj_panel);
        tabbed_pane.addTab("INVERSE", inv_panel);
        getContentPane().add(tabbed_pane);
        tabbed_pane.setBounds(0, 0, 760, 400);

        setBounds(0, 0, 760, 400);
    }

    private void basicOperations() {
        add_btn = new javax.swing.JButton();
        sub_btn = new javax.swing.JButton();
        mul_btn = new javax.swing.JButton();
        div_btn = new javax.swing.JButton();

        matrix_solve = new javax.swing.JTextArea();
        matrix_1 = new javax.swing.JTextArea();
        matrix_2 = new javax.swing.JTextArea();

        matrix_solve_scroll = new javax.swing.JScrollPane();
        matrix_1_scroll = new javax.swing.JScrollPane();
        matrix_2_scroll = new javax.swing.JScrollPane();

        basic_op_panel = new javax.swing.JPanel();
        basic_op_desc = new java.awt.Label();

        basic_op_panel.setLayout(null);

        basic_op_panel.add(add_btn);
        add_btn.setBounds(120, 270, 50, 50);
        add_btn.setText("+");

        add_btn.addActionListener((java.awt.event.ActionEvent evt) -> {
            basicOpPerform(evt);
        });

        basic_op_panel.add(sub_btn);
        sub_btn.setBounds(180, 270, 50, 50);
        sub_btn.setText("-");

        sub_btn.addActionListener((java.awt.event.ActionEvent evt) -> {
            basicOpPerform(evt);
        });

        basic_op_panel.add(mul_btn);
        mul_btn.setBounds(240, 270, 50, 50);
        mul_btn.setText("*");

        mul_btn.addActionListener((java.awt.event.ActionEvent evt) -> {
            basicOpPerform(evt);
        });

        basic_op_panel.add(div_btn);
        div_btn.setBounds(300, 270, 50, 50);
        div_btn.setText("/");

        div_btn.addActionListener((java.awt.event.ActionEvent evt) -> {
            basicOpPerform(evt);
        });

        basic_op_panel.add(matrix_solve);
        matrix_solve.setEditable(false);
        matrix_solve.setFont(font_style);
            
        basic_op_panel.add(matrix_solve_scroll);
        matrix_solve_scroll.setViewportView(matrix_solve);
        matrix_solve_scroll.setBounds(520, 60, 210, 200);

        basic_op_panel.add(matrix_1);
        matrix_1.setFont(font_style);

        basic_op_panel.add(matrix_1_scroll);
        matrix_1_scroll.setViewportView(matrix_1);
        matrix_1_scroll.setBounds(10, 60, 210, 200);

        basic_op_panel.add(matrix_2);
        matrix_2.setFont(font_style);

        basic_op_panel.add(matrix_2_scroll);
        matrix_2_scroll.setViewportView(matrix_2);
        matrix_2_scroll.setBounds(250, 60, 210, 200);

        basic_op_panel.add(basic_op_desc);
        basic_op_desc.setText("BASIC OPERTATIONS");
        basic_op_desc.setFont(new java.awt.Font(font_face, 1, 24));
        basic_op_desc.setBounds(10, 10, 730, 40);
        
    }

    private void determinants() {
        deter_panel = new javax.swing.JPanel();
        
        deter_solve = new javax.swing.JTextArea();
        deter_input = new javax.swing.JTextArea();
        
        deter_solve_scroll = new javax.swing.JScrollPane();
        deter_input_scroll = new javax.swing.JScrollPane();

        deter_desc = new java.awt.Label();

        deter_panel.setLayout(null);

        deter_panel.add(deter_solve);
        deter_solve.setEditable(false);
        deter_solve.setFont(font_style);

        deter_panel.add(deter_solve_scroll);
        deter_solve_scroll.setViewportView(deter_solve);
        deter_solve_scroll.setBounds(520, 20, 210, 200);

        deter_panel.add(deter_input);
        deter_input.setFont(font_style);

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

        deter_panel.add(deter_desc);
        deter_desc.setText("DETERMINANTS");
        deter_desc.setBounds(10, 10, 300, 40);
        deter_desc.setFont(new java.awt.Font(font_face, 1, 24));

    }

    private void transpose() {
        trans_panel = new javax.swing.JPanel();

        trans_solve = new javax.swing.JTextArea();
        trans_input = new javax.swing.JTextArea();

        trans_solve_scroll = new javax.swing.JScrollPane();
        trans_input_scroll = new javax.swing.JScrollPane();

        trans_desc = new java.awt.Label();

        trans_panel.setLayout(null);

        trans_panel.add(trans_solve);
        trans_solve.setEditable(false);
        trans_solve.setFont(font_style);

        trans_panel.add(trans_solve_scroll);
        trans_solve_scroll.setViewportView(trans_solve);
        trans_solve_scroll.setBounds(520, 20, 210, 200);

        trans_panel.add(trans_input);
        trans_input.setFont(font_style);
        
        trans_panel.add(trans_input_scroll);
        trans_input_scroll.setViewportView(trans_input);
        trans_input_scroll.setBounds(300, 20, 210, 200);

        trans_input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                
                if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    trans_solve.setText("");
                } else {
                    transPerform(evt);
                }

            }
        });

        trans_panel.add(trans_desc);
        trans_desc.setText("TRANSPOSE");
        trans_desc.setBounds(10, 10, 300, 40);
        trans_desc.setFont(new java.awt.Font(font_face, 1, 24));
    }

    private void matrixOfMinors() {
        matOfMin_panel = new javax.swing.JPanel();

        matOfMin_solve = new javax.swing.JTextArea();
        matOfMin_input = new javax.swing.JTextArea();

        matOfMin_solve_scroll = new javax.swing.JScrollPane();
        matOfMin_input_scroll = new javax.swing.JScrollPane();

        matOfMin_desc = new java.awt.Label();

        matOfMin_panel.setLayout(null);

        matOfMin_panel.add(matOfMin_solve);
        matOfMin_solve.setEditable(false);
        matOfMin_solve.setFont(font_style);

        matOfMin_panel.add(matOfMin_solve_scroll);
        matOfMin_solve_scroll.setViewportView(matOfMin_solve);
        matOfMin_solve_scroll.setBounds(520, 20, 210, 200);

        matOfMin_panel.add(matOfMin_input);
        matOfMin_input.setFont(font_style);
        
        matOfMin_panel.add(matOfMin_input_scroll);
        matOfMin_input_scroll.setViewportView(matOfMin_input);
        matOfMin_input_scroll.setBounds(300, 20, 210, 200);

        matOfMin_input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                
                if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    matOfMin_solve.setText("");
                } else {
                    matOfMinPerform(evt);
                }

            }
        });

        matOfMin_panel.add(matOfMin_desc);
        matOfMin_desc.setText("MATRIX OF MINORS");
        matOfMin_desc.setBounds(10, 10, 300, 40);
        matOfMin_desc.setFont(new java.awt.Font(font_face, 1, 24));
    }

    private void adjoint() {
        adj_panel = new javax.swing.JPanel();

        adj_solve = new javax.swing.JTextArea();
        adj_input = new javax.swing.JTextArea();

        adj_solve_scroll = new javax.swing.JScrollPane();
        adj_input_scroll = new javax.swing.JScrollPane();

        adj_desc = new java.awt.Label();

        adj_panel.setLayout(null);

        adj_panel.add(adj_solve);
        adj_solve.setEditable(false);
        adj_solve.setFont(font_style);

        adj_panel.add(adj_solve_scroll);
        adj_solve_scroll.setViewportView(adj_solve);
        adj_solve_scroll.setBounds(520, 20, 210, 200);

        adj_panel.add(adj_input);
        adj_input.setFont(font_style);
        
        adj_panel.add(adj_input_scroll);
        adj_input_scroll.setViewportView(adj_input);
        adj_input_scroll.setBounds(300, 20, 210, 200);

        adj_input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                
                if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    adj_solve.setText("");
                } else {
                    adjPerform(evt);
                }

            }
        });

        adj_panel.add(adj_desc);
        adj_desc.setText("ADJOINT");
        adj_desc.setBounds(10, 10, 300, 40);
        adj_desc.setFont(new java.awt.Font(font_face, 1, 24));

    }

    private void inverse() {
        inv_panel = new javax.swing.JPanel();

        inv_solve = new javax.swing.JTextArea();
        inv_input = new javax.swing.JTextArea();

        inv_solve_scroll = new javax.swing.JScrollPane();
        inv_input_scroll = new javax.swing.JScrollPane();

        inv_desc = new java.awt.Label();

        inv_panel.setLayout(null);

        inv_panel.add(inv_solve);
        inv_solve.setEditable(false);
        inv_solve.setFont(font_style);

        inv_panel.add(inv_solve_scroll);
        inv_solve_scroll.setViewportView(inv_solve);
        inv_solve_scroll.setBounds(520, 20, 210, 200);

        inv_panel.add(inv_input);
        inv_input.setFont(font_style);
        
        inv_panel.add(inv_input_scroll);
        inv_input_scroll.setViewportView(inv_input);
        inv_input_scroll.setBounds(300, 20, 210, 200);

        inv_input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                
                if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    inv_solve.setText("");
                } else {
                    invPerform(evt);
                }

            }
        });

        inv_panel.add(inv_desc);
        inv_desc.setText("INVERSE");
        inv_desc.setBounds(10, 10, 300, 40);
        inv_desc.setFont(new java.awt.Font(font_face, 1, 24));
    }

    private void basicOpPerform(java.awt.event.ActionEvent evt) {
        int[][] mat1 = toArray(matrix_1);
        int[][] mat2 = toArray(matrix_2);

        int[][] solve = new int[0][0];
        boolean valid = true;

        switch(evt.getActionCommand()) {
            case "+":
                valid = matrices.isAddSubValid(mat1, mat2);
                if (valid) solve = matrices.add(mat1, mat2);
                break;
            case "-":
                valid = matrices.isAddSubValid(mat1, mat2);
                if (valid) solve = matrices.subtract(mat1, mat2);
                break;
            case "*":
                valid = matrices.isMulDivValid(mat1, mat2);
                if (valid) solve = matrices.multiply(mat1, mat2);
                break;
            case "/":
                valid = matrices.isMulDivValid(mat1, mat2);
                // if (valid) solve = matrices.subtract(mat1, mat2);
                break;
        }
            
        matrix_solve.setText((valid) ? matrices.print(solve) : "Error!");
        matrix_1.setText("");
        matrix_2.setText("");

    }

    private void deterPerform(java.awt.event.KeyEvent evt) {

        int[][] matrix = toArray(deter_input);

        if (matrix.length > 1 && matrix[0].length > 1 && matrices.isDeterminant(matrix)) {
            deter_solve.setText(matrices.getDeterminant(matrix) + "");
        } else {
            deter_solve.setText("Error!");
        }

    }

    private void transPerform(java.awt.event.KeyEvent evt) {

        int[][] matrix = toArray(trans_input);

        if (matrix.length > 0) {
            int[][] solve = matrices.getTranspose(matrix);
            trans_solve.setText(matrices.print(solve) + "");
        } else {
            trans_solve.setText("Error!");
        }

    }

    private void matOfMinPerform(java.awt.event.KeyEvent evt) {
        
        int[][] matrix = toArray(matOfMin_input);

        if (matrix.length > 1 && matrix[0].length > 1 && matrices.isDeterminant(matrix)) {
            int[][] solve = matrices.getDeterminantOfMinors(matrix);
            matOfMin_solve.setText(matrices.print(solve) + "");
        } else {
            matOfMin_solve.setText("Error!");
        }
    }

    private void adjPerform(java.awt.event.KeyEvent evt) {

        int[][] matrix = toArray(adj_input);

        if (matrix.length > 1 && matrix[0].length > 1 && matrices.isDeterminant(matrix)) {
            int[][] solve = matrices.getAdjoint(matrix);
            adj_solve.setText(matrices.print(solve) + "");
        } else {
            adj_solve.setText("Error!");
        }
    }

    private void invPerform(java.awt.event.KeyEvent evt) {

        int[][] matrix = toArray(inv_input);

        if (matrix.length > 1 && matrix[0].length > 1 && matrices.isDeterminant(matrix)) {
            String[][] solve = matrices.getInverse(matrix);
            inv_solve.setText(matrices.print(solve) + "");
        } else {
            inv_solve.setText("Error!");
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
    private java.awt.Font font_style = new java.awt.Font(font_face, 0, 12);
    public static matrices matrices = new matrices();
    
    // Basic Operations
    private javax.swing.JButton add_btn;
    private javax.swing.JButton sub_btn;
    private javax.swing.JButton mul_btn;
    private javax.swing.JButton div_btn;

    private javax.swing.JTextArea matrix_solve;
    private javax.swing.JTextArea matrix_1;
    private javax.swing.JTextArea matrix_2;

    private javax.swing.JScrollPane matrix_solve_scroll;
    private javax.swing.JScrollPane matrix_1_scroll;
    private javax.swing.JScrollPane matrix_2_scroll;

    private javax.swing.JPanel basic_op_panel;
    private java.awt.Label basic_op_desc;

    // Determinants
    private javax.swing.JTextArea deter_solve;
    private javax.swing.JTextArea deter_input;

    private javax.swing.JScrollPane deter_solve_scroll;
    private javax.swing.JScrollPane deter_input_scroll;

    private javax.swing.JPanel deter_panel;
    private java.awt.Label deter_desc;

    // Transpose
    private javax.swing.JTextArea trans_solve;
    private javax.swing.JTextArea trans_input;

    private javax.swing.JScrollPane trans_solve_scroll;
    private javax.swing.JScrollPane trans_input_scroll;

    private javax.swing.JPanel trans_panel;
    private java.awt.Label trans_desc;

    // Matrix of Minors
    private javax.swing.JTextArea matOfMin_solve;
    private javax.swing.JTextArea matOfMin_input;

    private javax.swing.JScrollPane matOfMin_solve_scroll;
    private javax.swing.JScrollPane matOfMin_input_scroll;

    private javax.swing.JPanel matOfMin_panel;
    private java.awt.Label matOfMin_desc;

    // Adjoint
    private javax.swing.JTextArea adj_solve;
    private javax.swing.JTextArea adj_input;

    private javax.swing.JScrollPane adj_solve_scroll;
    private javax.swing.JScrollPane adj_input_scroll;

    private javax.swing.JPanel adj_panel;
    private java.awt.Label adj_desc;

    // Inverse
    private javax.swing.JTextArea inv_solve;
    private javax.swing.JTextArea inv_input;

    private javax.swing.JScrollPane inv_solve_scroll;
    private javax.swing.JScrollPane inv_input_scroll;

    private javax.swing.JPanel inv_panel;
    private java.awt.Label inv_desc;
    // End of variable declaration
}
