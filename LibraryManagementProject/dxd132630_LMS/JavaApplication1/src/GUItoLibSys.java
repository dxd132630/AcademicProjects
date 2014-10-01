import java.awt.Color;
import java.sql.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class GUItoLibSys extends javax.swing.JFrame {
static Connection conn = null;
static Connection conn1=null;
String Book_id=null,BL_Date_out=null,BL_Due_Date=null,BL_Date_in,Title, Author_name=null,Auth_Fname=null, Auth_Minit=null, Auth_Lname=null,Branch_name,Address,Borrower_Fname, Borrower_Lname,Borrower_Address, Borrower_Phone, BL_book_id;
int Branch_id,No_of_copies,Card_no,BL_Branch_id,BL_Card_no,Loan_id;
int linect = 0;
    public GUItoLibSys() {
        super("LMS 10.1");
        super.setBackground(Color.blue);
        super.setIconImage(new ImageIcon("C:\\Users\\Deepti\\Desktop\\images.jpg").getImage());
        initComponents();
        this.jTable1.setAutoCreateRowSorter(true);
        this.jTable4.setAutoCreateRowSorter(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField17 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(153, 204, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTabbedPane1.setName("LMS 10.1"); // NOI18N
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1000, 700));
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel2.setText("Book_id");

        jLabel3.setText("Title");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jLabel16.setText("Fname");

        jLabel17.setText("Minit");

        jLabel18.setText("Lname");

        jRadioButton1.setBackground(new java.awt.Color(102, 102, 255));
        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("Author");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(102, 102, 255));
        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("Author_Full_name");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText(" Result:");

        jTable1.setBackground(new java.awt.Color(153, 204, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book_id", "Title", "Author(s)", "branch_id", "Copies at each branch", "Available copies at each branch "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setGridColor(new java.awt.Color(204, 204, 255));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        jButton8.setText("Clear");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButton1)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel2))))
                                        .addGap(56, 56, 56))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jRadioButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField16))
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel18))
                                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))))
                        .addGap(0, 373, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(372, 372, 372)
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Book_Search", jPanel1);

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel5.setText("Book_id");

        jLabel6.setText("Branch_id");

        jLabel7.setText("Card_no");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jButton3.setText("Check_out");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book_id", "Branch_id", "No of copies at Branch", "No of copies Available"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jButton14.setText("Search");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(14, 14, 14)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton14))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Check_out", jPanel2);

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jLabel8.setText("Book_id");

        jLabel9.setText("Card_no");

        jLabel10.setText("Borrower Fname");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setText("Borrower Lname");

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jTable2.setBackground(new java.awt.Color(153, 204, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book_id", "Branch_id", "card_no", "Date_out", "Due_Date", "Date_in"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setToolTipText("Enter the date_in filed in YYYY-MM-DD format!");
        jTable2.setColumnSelectionAllowed(true);
        jTable2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable2InputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jTable2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable2PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton9.setText("Reset");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Check in");
        jButton10.setToolTipText("Enter date in YYYY-MM-DD format!");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Refresh");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(jButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Check_in", jPanel3);

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));

        jLabel12.setText("Fname");

        jLabel13.setText("Lname");

        jLabel14.setText("Address");

        jLabel15.setText("Phone");

        jButton6.setText("Register");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Reset");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7))
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addComponent(jTextField12)))
                .addContainerGap(490, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton6))
                .addContainerGap(418, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Borrower_Management", jPanel4);

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));

        jRadioButton3.setBackground(new java.awt.Color(102, 102, 255));
        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("All");

        jRadioButton4.setBackground(new java.awt.Color(102, 102, 255));
        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Due");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton5.setBackground(new java.awt.Color(102, 102, 255));
        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Paid");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jButton12.setText("Pay Fine");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Refresh");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Card_no", "Fine_amt", "Paid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton12))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(jButton13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton5)
                        .addGap(30, 30, 30)
                        .addComponent(jButton12)))
                .addContainerGap(372, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fine and Due", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("LMS 10.1");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
              
    }//GEN-LAST:event_jTextField1ActionPerformed


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String s_book_id,s_title;
        int s_branch_id=0;
        s_book_id=jTextField1.getText();
        s_title=jTextField2.getText();
        String sqlstatement=null;
        if(!jRadioButton1.isSelected() && !jRadioButton2.isSelected()){
            Auth_Fname=jTextField3.getText();
            Auth_Minit=jTextField15.getText();
            Auth_Lname=jTextField16.getText();
            Author_name=jTextField17.getText();
        }
       //if both the radio buttons are not selected
        
         if(jRadioButton1.isSelected() || jRadioButton2.isSelected()){
            if(this.jRadioButton1.isSelected())
                {
                Auth_Fname=jTextField3.getText();
                Auth_Minit=jTextField15.getText();
                Auth_Lname=jTextField16.getText();
                    Author_name="";
                    if(Auth_Fname.equals("") && Auth_Minit.equals("") && Auth_Lname.equals("") && s_book_id.equals("") && s_title.equals(""))
                        JOptionPane.showMessageDialog(null,"Please enter Fname and(or) Minit and(or) Lname!");
                } 
                    else if(this.jRadioButton2.isSelected()){
                    Author_name=jTextField17.getText();
                    Auth_Fname="";
                     Auth_Minit="";
                     Auth_Lname="";
                     if(Author_name.equals("")&& s_book_id.equals("") && s_title.equals(""))
                     JOptionPane.showMessageDialog(null,"Please enter the Author name or organization name"); 
             }
         
        }
         else  if(Auth_Fname.equals("") && Auth_Minit.equals("") && Auth_Lname.equals("") && Author_name.equals("")&& s_book_id.equals("") && s_title.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Invalid usage:Specify Book_id or Title or Author names or any combination of it!");
        }
       if(!Auth_Fname.equals("") || !Auth_Minit.equals("") || !Auth_Lname.equals("") || !Author_name.equals("") || !s_book_id.equals("") || !s_title.equals(""))
       {    
       try{
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
                Statement stmt = conn.createStatement();
                stmt.execute("use Library;");
                 sqlstatement="select b.book_id,b.title,group_concat(a.author_name separator ',') authors,c.branch_id,c.no_of_copies from book b,book_copies c,book_authors a where b.book_id=c.book_id and b.book_id in (Select a1.book_id from book_authors a1 where a1.author_name LIKE \"%"+Author_name+"%\" and a1.fname LIKE \"%"+Auth_Fname+"%\" and a1.minit LIKE \"%"+Auth_Minit+"%\" and a1.lname LIKE \"%"+Auth_Lname+"%\" and a1.book_id LIKE \"%"+s_book_id+"%\") and b.title LIKE \"%"+s_title+"%\" and  b.book_id=a.book_id group by c.branch_id,b.book_id order by b.book_id;";           
                
                 if(Auth_Minit.equals("") && Auth_Lname.equals("") && !Auth_Fname.equals(""))   
                    sqlstatement="select b.book_id,b.title,group_concat(a.author_name separator ',') authors,c.branch_id,c.no_of_copies from book b,book_copies c,book_authors a where b.book_id=c.book_id and b.book_id in (Select a1.book_id from book_authors a1 where a1.author_name LIKE \"%"+Author_name+"%\" and a1.fname LIKE \"%"+Auth_Fname+"%\" and a1.book_id LIKE \"%"+s_book_id+"%\") and b.title LIKE \"%"+s_title+"%\" and  b.book_id=a.book_id group by c.branch_id,b.book_id order by b.book_id;";
                 else if(Auth_Minit.equals("") && !Auth_Lname.equals("") || !Auth_Fname.equals(""))   
                    sqlstatement="select b.book_id,b.title,group_concat(a.author_name separator ',') authors,c.branch_id,c.no_of_copies from book b,book_copies c,book_authors a where b.book_id=c.book_id and b.book_id in (Select a1.book_id from book_authors a1 where a1.author_name LIKE \"%"+Author_name+"%\" and a1.fname LIKE \"%"+Auth_Fname+"%\" and a1.lname LIKE \"%"+Auth_Lname+"%\" and a1.book_id LIKE \"%"+s_book_id+"%\") and b.title LIKE \"%"+s_title+"%\" and  b.book_id=a.book_id group by c.branch_id,b.book_id order by b.book_id;";
                 
                 else if(Auth_Minit.equals("") && Auth_Lname.equals("") && Auth_Fname.equals(""))   
                    sqlstatement="select b.book_id,b.title,group_concat(a.author_name separator ',') authors,c.branch_id,c.no_of_copies from book b,book_copies c,book_authors a where b.book_id=c.book_id and b.book_id in (Select a1.book_id from book_authors a1 where a1.author_name LIKE \"%"+Author_name+"%\" and a1.book_id LIKE \"%"+s_book_id+"%\") and b.title LIKE \"%"+s_title+"%\" and  b.book_id=a.book_id group by c.branch_id,b.book_id order by b.book_id;";
                   String sqlstatement1=null;
                    try (ResultSet rs = stmt.executeQuery(sqlstatement)) {
                          
                    String rs_book_id,rs_book_id_temp,rs_title,rs_Author_fn,rs_Author_mn,rs_Author_ln,Authors = null;
                   
                    int rs_Branch_id=0,rs_No_of_copies_ava=0,rs_No_of_copies=0,No_of_copies_ava=0,No_of_copies_borrow=0;
                        
                        while (rs.next()) {
                            rs_book_id = rs.getString("book_id");
                            rs_title=rs.getString("title");
                            Authors=rs.getString(3);
                            rs_Branch_id=rs.getInt("branch_id");
                            rs_No_of_copies=rs.getInt("no_of_copies");
                            linect++;
                            No_of_copies_borrow=findTheactivebook(rs_book_id,rs_Branch_id);
                           rs_No_of_copies_ava=rs_No_of_copies-No_of_copies_borrow;
                             DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                                
                             Object[] a = {rs_book_id,rs_title,Authors,rs_Branch_id,rs_No_of_copies,rs_No_of_copies_ava};
                            model.addRow(a);
                          }
                        if(linect==0)
                        JOptionPane.showMessageDialog(null,"Record Not found!");
                    }
                    catch(SQLException ex1) {
                     JOptionPane.showMessageDialog(null,ex1);
               }
                       
                         conn.close();
                         linect=0;                      
               }
               catch(SQLException ex) {
                     JOptionPane.showMessageDialog(null,ex);
               }
       }
     
    }//GEN-LAST:event_jButton1ActionPerformed
public int findTheactivebook(String bid, int brid) throws SQLException{
    conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
    Statement stmt1 = conn1.createStatement();
   stmt1.execute("use Library;");
    int No_of_copies_borrow=0;
     String sqlstatement1="select count(branch_id),branch_id,book_id from book_loans where book_id=\""+bid+"\"  and branch_id=\""+brid+"\" and  DATE_IN IS NULL AND DATE_OUT<=CURDATE() group by book_id,branch_id;";
                           
                            try(ResultSet rss=stmt1.executeQuery(sqlstatement1)){
                                while(rss.next()){
                                     No_of_copies_borrow=rss.getInt(1);
                                }
                                rss.close();
                            }
                            catch(SQLException ex1) {
                            JOptionPane.showMessageDialog(null,ex1);
                            }
                            conn1.close();
              return No_of_copies_borrow;
    
}
    
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String co_book_id,co_branch_id,co_card_no;
        int no_book_copies_available=0;
        co_book_id=jTextField4.getText();
        co_branch_id=jTextField5.getText();
        co_card_no=jTextField6.getText();
        if(co_book_id.equals("") || co_branch_id.equals("") || co_card_no.equals("")){
            this.jLabel5.setText("book_id*");
            this.jLabel6.setText("branch_id*");
            this.jLabel7.setText("card_no*");
            JOptionPane.showMessageDialog(null,"Please enter all the mandatory fields! \n *:book_id,branch_id,card_no");
            this.jLabel5.setText("book_id");
            this.jLabel6.setText("branch_id");
            this.jLabel7.setText("card_no");
        }
        else if (!co_book_id.equals("") && !co_branch_id.equals("") && !co_card_no.equals("")){
           int count=0,count1=0,No_of_books_currently_checked=0,max_checkout_of_book=0;
            String sqlstatement="select card_no,count(card_no)as no_of_books_checked from book_loans  where Date_in IS NULL and Date_out<=CURDATE() and card_no="+co_card_no+" group by card_no having count(card_no)>=3;";
            max_checkout_of_book=activeCheckoutofCardno(sqlstatement,co_card_no);
               if(max_checkout_of_book==0){
                String sqlstatement2="select * from book_copies where book_id=\""+co_book_id+"\" and branch_id="+co_branch_id+";";
                try {
                    no_book_copies_available=book_availability(sqlstatement2,co_book_id,co_branch_id);
                } catch (SQLException ex) {
                    Logger.getLogger(GUItoLibSys.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(no_book_copies_available>=1){
                    try{
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
                    Statement stmt = conn.createStatement();
                    stmt.execute("use Library;");
                    String sqlstatement3="insert into book_loans values(default,\""+co_book_id+"\",+"+co_branch_id+","+co_card_no+",CURDATE(),DATE_ADD(CURDATE(), INTERVAL 14 DAY),NULL);";
                    int rss1=0;
                    rss1 = stmt.executeUpdate(sqlstatement3);  
                            if(rss1==1){
                                    JOptionPane.showMessageDialog(null,"Book "+co_book_id+"Successfully checked out!");
                                }
                            else{
                                JOptionPane.showMessageDialog(null,"Failed to check out!");
                            }
                            conn.close();
                     }
                    catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
                    }
                }
               }
            }
            else
            JOptionPane.showMessageDialog(null,"All the fields are mandatory!");
            
       
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private int activeCheckoutofCardno(String statement,String card_num){
        int active_checkout=0;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            Statement stmt = conn.createStatement();
            stmt.execute("use Library;");
            try (ResultSet rs = stmt.executeQuery(statement)) {
                
                if (rs.first()){
                do{
                      JOptionPane.showMessageDialog(null,"Card_no: "+card_num+" Already has 3 books checked out.No more checkout allowed!!");               
                      active_checkout=1;
                    } while(rs.next()) ;
                }
                
                rs.close();
                conn.close();
            }
        }
            catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
		}
           return active_checkout; 
    }
    private int book_availability(String statement,String book_ids,String branch_ids ) throws SQLException{
        int num_of_book_avai=0,count=0,activebooks=0,temp=0;
        activebooks=findTheactivebook(book_ids, Integer.parseInt(branch_ids));
         try{
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            Statement stmt = conn.createStatement();
            stmt.execute("use Library;");
            try (ResultSet rs = stmt.executeQuery(statement)) {
                while(rs.next()){
                    count++;
                    temp=rs.getInt(3);
                    }
                num_of_book_avai=temp-activebooks;
                if(num_of_book_avai==0)
                    JOptionPane.showMessageDialog(null,"No more copies of Book_id: "+book_ids+" exists int the branch "+branch_ids+" !!");               
                
                rs.close();
                conn.close();
            }
         }
         catch(SQLException ex) {
		JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
	}
         
       return num_of_book_avai; 
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
            DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0); 
         
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField15.setText("");
            jTextField16.setText("");
            jTextField17.setText("");
            this.buttonGroup2.clearSelection();
     
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       String cin_book_id,cin_card_no,cin_Fname,cin_Lname;
       cin_book_id=this.jTextField7.getText();
       cin_card_no=this.jTextField8.getText();
       cin_Fname=this.jTextField9.getText();
       cin_Lname=this.jTextField10.getText();
       if(cin_book_id.equals("") && cin_card_no.equals("") && cin_Fname.equals("") && cin_Lname.equals("")){
           this.jLabel8.setText("Book_id*");
           this.jLabel9.setText("Card_no*");
           this.jLabel10.setText("Borrower_Fname*");
           this.jLabel4.setText("Borrower_Lname*");
           JOptionPane.showMessageDialog(null,"Invalid usage!! Enter *book_id or card_no or Borrower name or any combination of it!");
            this.jLabel8.setText("Book_id");
            this.jLabel9.setText("Card_no");
            this.jLabel10.setText("Borrower_Fname");
            this.jLabel4.setText("Borrower_Lname");
           }
       else if (!cin_book_id.equals("") || !cin_card_no.equals("") || !cin_Fname.equals("") || !cin_Lname.equals("")){
           int count=0;
           String book_id,branch_id,card_no,date_out,due_date,date_in;
           try {
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
               Statement stmt = conn.createStatement();
          stmt.execute("use Library;");
          String statement="select b.book_id,b.branch_id,br.card_no,br.Fname,br.Lname,b.date_out,b.due_date,b.date_in from book_loans b,borrower br where br.card_no=b.card_no and b.book_id LIKE \"%"+cin_book_id+"%\" and br.card_no like \"%"+cin_card_no+"%\" and Fname LIKE \"%"+cin_Fname+"%\" and Lname LIKE \"%"+cin_Lname+"%\";";
          try (ResultSet rs = stmt.executeQuery(statement)) {
                if(rs.first()){
                 do{
                    count++;
                    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                            book_id=rs.getString("book_id");
                            branch_id=rs.getString("branch_id");
                            card_no=rs.getString("card_no");
                            date_out=rs.getString("date_out");
                            due_date=rs.getString("due_date");
                            date_in=rs.getString("date_in");
                            Object[] a = {book_id,branch_id,card_no,date_out,due_date,date_in};
                            model.addRow(a);
                }while(rs.next());
                }
                else
                   JOptionPane.showMessageDialog(null,"No book checked out with this details! Please check the data entered!");
                JOptionPane.showMessageDialog(null,"Please enter the date for check in in the \"Date-in\" filed of respective card holder");
                rs.close();
                conn.close();
            }
          
           } catch (SQLException ex) {
               Logger.getLogger(GUItoLibSys.class.getName()).log(Level.SEVERE, null, ex);
           }
                   
       } 
     
       
    }//GEN-LAST:event_jButton5ActionPerformed

  
    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
            jTextField7.setText("");
            jTextField8.setText("");
            jTextField9.setText("");
            jTextField10.setText("");
            this.jTable2.clearSelection();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); 
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTable2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable2InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2InputMethodTextChanged

    private void jTable2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2PropertyChange

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int rowNumber=this.jTable2.getEditingRow();
        this.jTable2.createToolTip();
        int columnnumber=jTable2.getEditingColumn();
        
        jTable2.getCellEditor().stopCellEditing();
        String cin_date_in,cin_book_id,cin_card_no,cin_branch_id;
        cin_date_in=(String) jTable2.getValueAt(rowNumber,columnnumber );
        
        cin_book_id=(String ) jTable2.getValueAt(rowNumber,0);
        cin_branch_id=(String) jTable2.getValueAt(rowNumber,1);
        cin_card_no=(String) jTable2.getValueAt(rowNumber,2);
        
                try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            Statement stmt = conn.createStatement();
            stmt.execute("use Library;");
            String Statement="update book_loans set date_in=\""+cin_date_in+"\" where card_no="+cin_card_no+" and book_id=\""+cin_book_id+"\" and branch_id="+cin_branch_id+" and date_out<= CURDATE();";
            int rss1=0;
                    rss1 = stmt.executeUpdate(Statement);  
                            if(rss1==1){
                                JOptionPane.showMessageDialog(null,"Book Checked in successfully!");
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Book Already checked in!Another check in not possible");
                               // jTable2.getCellEditor().stopCellEditing();
                            }
        }   
        catch(SQLException ex) {
                        JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
		}
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
         String cin_book_id,cin_card_no,cin_Fname,cin_Lname;
         DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); 
       cin_book_id=this.jTextField7.getText();
       cin_card_no=this.jTextField8.getText();
       cin_Fname=this.jTextField9.getText();
       cin_Lname=this.jTextField10.getText();
       if (!cin_book_id.equals("") || !cin_card_no.equals("") || !cin_Fname.equals("") || !cin_Lname.equals("")){
           int count=0;
           String book_id,branch_id,card_no,date_out,due_date,date_in;
           try {
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
               Statement stmt = conn.createStatement();
          stmt.execute("use Library;");
          String statement="select b.book_id,b.branch_id,br.card_no,br.Fname,br.Lname,b.date_out,b.due_date,b.date_in from book_loans b,borrower br where br.card_no=b.card_no and b.book_id LIKE \"%"+cin_book_id+"%\" and br.card_no like \"%"+cin_card_no+"%\" and Fname LIKE \"%"+cin_Fname+"%\" and Lname LIKE \"%"+cin_Lname+"%\";";
          try (ResultSet rs = stmt.executeQuery(statement)) {
                if(rs.first()){
                 do{
                    count++;
                    
                            book_id=rs.getString("book_id");
                            branch_id=rs.getString("branch_id");
                            card_no=rs.getString("card_no");
                            date_out=rs.getString("date_out");
                            due_date=rs.getString("due_date");
                            date_in=rs.getString("date_in");
                            Object[] a = {book_id,branch_id,card_no,date_out,due_date,date_in};
                            model.addRow(a);
                }while(rs.next());
                }

                rs.close();
                conn.close();
            }
          
           } catch (SQLException ex) {
               Logger.getLogger(GUItoLibSys.class.getName()).log(Level.SEVERE, null, ex);
           }
                   
       } 
     

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
        jTextField14.setText("");
        this.jLabel12.setText("Fname");
        this.jLabel13.setText("Lname");
        this.jLabel14.setText("Address");

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String b_Fname,b_Lname,b_Address,b_Phone_no,cno;
        int card_no=0;
        b_Fname=jTextField11.getText();
        b_Lname=jTextField12.getText();
        b_Address=jTextField13.getText();
        b_Phone_no=jTextField14.getText();
        if(b_Fname.equals("")|| b_Lname.equals("") || b_Address.equals(""))
        {
            this.jLabel12.setText("Fname*");
            this.jLabel13.setText("Lname*");
            this.jLabel14.setText("Address*");
            JOptionPane.showMessageDialog(null,"Please enter all the mandatory fields! \n *:Fname,Lname,Address");
        }
        else{
            try{
                int count=0;
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
                Statement stmt = conn.createStatement();
                stmt.execute("use Library;");
                String sqlstatement="select card_no from borrower where Fname=\""+b_Fname+"\" and Lname=\""+b_Lname+"\";";
                try (ResultSet rs = stmt.executeQuery(sqlstatement)) {

                    while(rs.next()) {
                        count++;
                        cno= rs.getString("card_no");
                        JOptionPane.showMessageDialog(null,"*"+b_Fname+" "+b_Lname+" already exists with card_no: "+cno);
                    }
                    rs.close();
                }
                if(count==0){
                    int rss=0;
                    while(true){
                        Random rnd = new Random();
                        card_no= 9000 + rnd.nextInt(1000);
                        sqlstatement="insert into borrower values ("+card_no+",\""+b_Fname+"\",\""+b_Lname+"\",\""+b_Address+"\",\""+b_Phone_no+"\");";

                        rss=stmt.executeUpdate(sqlstatement);
                        if(rss==1)
                        {
                            int new_card_no=card_no;
                            JOptionPane.showMessageDialog(null," "+b_Fname+" "+b_Lname+" entry is created with card_no: "+new_card_no);
                            break;
                        }
                        else
                        JOptionPane.showMessageDialog(null,"Failed to check out! Card number not found!");
                    }
                }
                conn.close();
                linect=0;
            }
            catch(SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        String paid,card_no;
        String fine_amt;
        String [] loan_ids=new String[3];
        String temp = null;
        int rowNumber=this.jTable3.getEditingRow();
        int columnnumber=jTable3.getEditingColumn();
        paid=(String) jTable3.getValueAt(rowNumber,columnnumber );
        card_no=(String) jTable3.getValueAt(rowNumber,0);
        if(paid.contains("1")){
            JOptionPane.showMessageDialog(null,"Fine is already paid for this card holder!\n");
        }
        else{
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            Statement stmt = conn.createStatement();
            stmt.execute("use Library;");
            loan_ids=get_loan_ids(card_no);
            String Statement;
            int rss1=0;
            for(int i=0;i<3;i++){
                temp=loan_ids[i];
                Statement="update fine set paid=TRUE where loan_id="+temp+";";
                    rss1 = stmt.executeUpdate(Statement);  
                }
            conn.close();
        }   
        catch(SQLException ex) {
                        
                        JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
		}
        
        }
//        jTable4.getCellEditor().stopCellEditing();
    }//GEN-LAST:event_jButton12ActionPerformed

    public String [] get_loan_ids(String card_no){
        String[] loan_ids=new String[3];
        int i=0,count=0;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            Statement stmt = conn.createStatement();
            stmt.execute("use Library;");
            String Statement=" select loan_id from book_loans where card_no="+card_no+";";
            try  (ResultSet rs = stmt.executeQuery(Statement)) {
             if(rs.first()) {
                 do{
                  loan_ids[i]=rs.getString("loan_id");
                 }while(rs.next());
             }
             rs.close();
            }
            conn.close();
        }
         catch(SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
		}
    return loan_ids;
        
    }
    public void refreshThefineAmount(){
        
    }
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        String cno,fine,paid;
        String sqlstatement = null;
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0); 
        refreshThefineAmount();
        if(this.jRadioButton3.isSelected()){
            sqlstatement="select l.card_no,sum(f.fine_amt),f.paid from book_loans l,fine f where f.loan_id=l.loan_id group by l.card_no;";
        }
        else if (this.jRadioButton4.isSelected()){
            sqlstatement="select l.card_no,sum(f.fine_amt),f.paid from book_loans l,fine f where f.loan_id=l.loan_id and f.paid=0 group by l.card_no;";
        }
        else if (this.jRadioButton5.isSelected()){
            sqlstatement="select l.card_no,sum(f.fine_amt),f.paid from book_loans l,fine f where f.loan_id=l.loan_id and f.paid=1 group by l.card_no;";
        }
            try{
                int count=0;
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
                Statement stmt = conn.createStatement();
                stmt.execute("use Library;");
                
                try (ResultSet rs = stmt.executeQuery(sqlstatement)) {
                    while(rs.next()) {
                        count++;
                        cno=rs.getString(1);
                        fine=rs.getString(2);
                        paid=rs.getString(3);
                        Object[] a = {cno,fine,paid};
                        model.addRow(a);
                        
                    }
                    rs.close();
                }
                conn.close();
                linect=0;
            }
            catch(SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
            }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
         String s_book_id="",s_branch_id_temp="";
        int s_branch_id=1;
        s_book_id=jTextField4.getText();
        s_branch_id_temp=this.jTextField5.getText();
        String sqlstatement=null;
       if(s_book_id.equals("") && s_branch_id_temp.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Invalid usage:Specify Book_id or Branch_id or combination of it!");
        }
       if(!s_book_id.equals("") || !s_branch_id_temp.equals(""))
       {    
       try{
                if(!s_branch_id_temp.equals(""))
                    s_branch_id=Integer.parseInt(s_branch_id_temp);
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
                Statement stmt = conn.createStatement();
                stmt.execute("use Library;");
                 sqlstatement="select b.book_id,c.branch_id,c.no_of_copies from book b,book_copies c where b.book_id=c.book_id and b.book_id LIKE \"%"+s_book_id+"%\" and c.branch_id="+s_branch_id+" order by b.book_id;";           
                    try (ResultSet rs = stmt.executeQuery(sqlstatement)) {
                          
                    String rs_book_id,rs_book_id_temp;
                   
                    int rs_Branch_id=0,rs_No_of_copies_ava=0,rs_No_of_copies=0,No_of_copies_ava=0,No_of_copies_borrow=0;
                        
                        while (rs.next()) {
                            rs_book_id = rs.getString("book_id");
                            rs_Branch_id=rs.getInt("branch_id");
                            rs_No_of_copies=rs.getInt("no_of_copies");
                            linect++;
                            No_of_copies_borrow=findTheactivebook(rs_book_id,rs_Branch_id);
                           rs_No_of_copies_ava=rs_No_of_copies-No_of_copies_borrow;
                             DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
                                
                             Object[] a = {rs_book_id,rs_Branch_id,rs_No_of_copies,rs_No_of_copies_ava};
                            model.addRow(a);
                          }
                        if(linect==0)
                        JOptionPane.showMessageDialog(null,"Record Not found!");
                    }
                    catch(SQLException ex1) {
                     JOptionPane.showMessageDialog(null,ex1);
               }
                       
                         conn.close();
                         linect=0;                      
               }
               catch(SQLException ex) {
                     JOptionPane.showMessageDialog(null,ex);
               }
       }
    }//GEN-LAST:event_jButton14ActionPerformed

    public static void main(String args[]) {
        GUItoLibSys GS=new GUItoLibSys();       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
   
                new GUItoLibSys().setVisible(true);
                
                }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

    
}
