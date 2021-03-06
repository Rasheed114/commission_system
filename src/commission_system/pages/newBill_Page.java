/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commission_system.pages;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import commission_system.controllers.BillProductDetailsJpaController;
import commission_system.pages.ProductList;
import commission_system.controllers.BillsJpaController;
import commission_system.controllers.DataUtility;
import commission_system.controllers.DealerJpaController;
import commission_system.objects.BillProductDetails;
import commission_system.objects.Bills;
import commission_system.objects.Dealer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.text.*;
import java.awt.print.*;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultCaret;
import static javax.swing.text.DefaultEditorKit.downAction;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 *
 */
public class newBill_Page extends javax.swing.JFrame {

    /**
     * Creates new form newBill_Page
     */
    BigDecimal dealer_id = null, driver_id = null;
    int billNum=-1;
    private Icon myIcon1;
    private Icon myIcon2;
    private Icon myIcon3;
    private Icon myIcon4;
    
    private KeyStroke tab  = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
    private KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
    private InputMap im ;
    private BigDecimal bill_id;
    private String bill_name;

    public JTextField getBill_num() {
        return bill_num;
    }

    public void setBill_num(JTextField bill_num) {
        this.bill_num = bill_num;
    }
    
    

    public newBill_Page() {
        initComponents();
        BillsJpaController billCont;
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("commission_systemPU");
        billCont = new BillsJpaController(factory);

        this.bill_num.setText(billCont.getBillsCount() + "");

    }

    public void setDealer_id(BigDecimal dealer_id) {
        this.dealer_id = dealer_id;
    }

    public void setDealer_name(JTextField dealer_name) {
        this.dealer_name = dealer_name;
    }

    public void setDriver_name(JTextField driver_name) {
        this.driver_name = driver_name;
    }

    public BigDecimal getDealer_id() {
        return dealer_id;
    }
    
    public void setBillID(BigDecimal bill_id) {
        this.bill_id = bill_id;
    }

        public void setBill_Name(String bill_name) {
        this.bill_name = bill_name;
    }
    public BigDecimal getBillID() {
        return bill_id;
    }
    
    public JTextField getDealer_name() {
        return dealer_name;
    }
    
    public String getBillName() {
        return bill_name;
    }

    public JTextField getDriver_name() {
        return driver_name;
    }

    public BigDecimal getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(BigDecimal driver_id) {
        this.driver_id = driver_id;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }
    
   
    
    
    
    /*
public static class Printer implements Printable {
    final Component comp;

    public Printer(Component comp){
        this.comp = comp;
    }

        private Printer() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    @Override
    public int print(Graphics g, PageFormat format, int page_index) 
            throws PrinterException {
        if (page_index > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        // get the bounds of the component 
        Dimension dim = comp.getSize();
        double cHeight = dim.getHeight();
        double cWidth = dim.getWidth();

        // get the bounds of the printable area
        double pHeight = format.getImageableHeight();
        double pWidth = format.getImageableWidth();

        double pXStart = format.getImageableX();
        double pYStart = format.getImageableY();

        double xRatio = pWidth / cWidth;
        double yRatio = pHeight / cHeight;


        Graphics2D g2 = (Graphics2D) g;
        g2.translate(pXStart, pYStart);
        g2.scale(xRatio, yRatio);
        comp.paint(g2);

        return Printable.PAGE_EXISTS;
    }
    
    
}
*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        issue_date = new org.jdesktop.swingx.JXDatePicker();
        dealer_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        driver_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ref_num = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bill_num = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        last_payment = new javax.swing.JLabel();
        previous_balance = new javax.swing.JLabel();
        current_balance = new javax.swing.JLabel();
        current_balance_value = new javax.swing.JLabel();
        last_pay_value = new javax.swing.JLabel();
        prev_balance_value = new javax.swing.JLabel();
        save_bill = new javax.swing.JButton();
        printRecord = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Bill_Search = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jPanel1CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("?????? ????????????");
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel1KeyPressed(evt);
            }
        });

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "?????? ??????????","??????????", "?????? ??????????????","?????? ??????????????","????????????","??????????","???????????? ????????????","??????????????"
            }
        ));
        jTable1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        jTable1.setAutoscrolls(false);
        jTable1.setDropMode(javax.swing.DropMode.INSERT_ROWS);
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTable1ComponentAdded(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jTable1CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        issue_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issue_dateActionPerformed(evt);
            }
        });
        issue_date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                is_dateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                issue_dateKeyReleased(evt);
            }
        });

        dealer_name.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dealer_name.setToolTipText("");
        dealer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealer_nameActionPerformed(evt);
            }
        });
        dealer_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dealer_nameKeyPressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("?????? ????????????");

        driver_name.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        driver_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driver_nameActionPerformed(evt);
            }
        });
        driver_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                driver_nameKeyPressed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("?????? ????????????");

        ref_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ref_numActionPerformed(evt);
            }
        });
        ref_num.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ref_numKeyPressed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("?????????? ??????????????");

        bill_num.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        bill_num.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                bill_numComponentShown(evt);
            }
        });
        bill_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_numActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("?????? ????????????????");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        last_payment.setBackground(new java.awt.Color(255, 255, 255));
        last_payment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        last_payment.setText("?????? ????????");

        previous_balance.setBackground(new java.awt.Color(255, 255, 255));
        previous_balance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        previous_balance.setText("???????????? ????????????");

        current_balance.setBackground(new java.awt.Color(255, 255, 255));
        current_balance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        current_balance.setText("???????????? ????????????");
        current_balance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                current_balanceKeyPressed(evt);
            }
        });

        current_balance_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        current_balance_value.setText("0");

        last_pay_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        last_pay_value.setText("0");

        prev_balance_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prev_balance_value.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(382, Short.MAX_VALUE)
                .addComponent(last_pay_value, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(last_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(current_balance_value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(current_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(prev_balance_value, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previous_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(previous_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(prev_balance_value, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addComponent(last_payment))
                    .addComponent(last_pay_value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(current_balance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(current_balance_value, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        save_bill.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        save_bill.setText("??????????");
        save_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_billActionPerformed(evt);
            }
        });

        printRecord.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printRecord.setText("??????????");
        printRecord.setMaximumSize(new java.awt.Dimension(71, 71));
        printRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printRecordActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\rashe\\OneDrive\\Desktop\\Capt3113ure.PNG")); // NOI18N
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\rashe\\OneDrive\\Desktop\\Capt33ure.PNG")); // NOI18N
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Bill_Search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Bill_Search.setText("?????? ????????????");
        Bill_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bill_SearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(972, 972, 972))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ref_num)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(bill_num)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(issue_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(10, 10, 10)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(507, 507, 507)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dealer_name)
                                    .addComponent(driver_name, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(printRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 151, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(Bill_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(68, 68, 68)
                                        .addComponent(save_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bill_num, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(issue_date, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dealer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(driver_name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ref_num, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(save_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bill_Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(printRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)))))
                .addGap(98, 98, 98))
        );

        issue_date.setDate(new Date());
        dealer_name.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        driver_name.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        ref_num.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        bill_num.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        bill_num.setEnabled(false);
        jPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanel3.setBorder(BorderFactory.createLineBorder(Color.gray));

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jMenu1.setText("??????????????");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jMenuBar1.add(Box.createHorizontalGlue());

        jMenuBar1.add(jMenu1);

        jMenu2.setText("??????");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenu1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
//        BillsJpaController billCont;
//        EntityManagerFactory factory;
//        factory = Persistence.createEntityManagerFactory("commission_systemPU");
//        billCont = new BillsJpaController(factory);
//
//        this.bill_num.setText(billCont.getBillsCount() + "");
        //this.bill_num.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
//        System.out.print("hanan");
                BillsJpaController billCont;
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("commission_systemPU");
        billCont = new BillsJpaController(factory);

        this.bill_num.setText(billCont.getBillsCount() + "");
    }//GEN-LAST:event_formWindowActivated

    private void printRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printRecordActionPerformed
        
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Data");
            
            job.setPrintable(new Printable(){
                
                public int print (Graphics pg,PageFormat pf,int pageNum){
                
                pf.setOrientation(PageFormat.LANDSCAPE);
                
                if(pageNum>0){
                return Printable.NO_SUCH_PAGE;
                
                }
                
                java.awt.Graphics2D g2 = (java.awt.Graphics2D)pg;
                g2.translate(pf.getImageableX(),pf.getImageableY());
                g2.scale(.25,0.37);
                jPanel1.paint(g2);
                
                return Printable.PAGE_EXISTS;
                
                }
    });
            
        boolean ok = job.printDialog();
        if(ok){
            try{
                job.print();
            }
            catch(PrinterException ex){}
        }

    }//GEN-LAST:event_printRecordActionPerformed

    private void save_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_billActionPerformed
        try {
            // TODO add your handling code here:
            // DEFINE NEW BILL + ITS DETAILS
            // ALTER DEALER DATA FROM NEW ONW
            //
            if (this.dealer_name.getText().isEmpty()) {
                String st = "???????????? ???????????? ?????? ????????????!";
                JOptionPane.showMessageDialog(null, st);
                return;

            }
            BillsJpaController billCont;
            EntityManagerFactory factory;
            factory = Persistence.createEntityManagerFactory("commission_systemPU");
            billCont = new BillsJpaController(factory);

            Bills newBill = new Bills();
            newBill.setBillIssueDate(this.issue_date.getDate());
            newBill.setDealerId(this.dealer_id != null ? this.dealer_id.intValue() : null);
            //newBill.setBoxNumber(this.box_num.getText());
            //newBill.setBoxPrice(this.box_price.getText());
            newBill.setRefNum(this.ref_num.getText());
            newBill.setDriverName(this.driver_name.getText());

            newBill.setPreviousBalance(this.prev_balance_value.getText());
            newBill.setLastPayment(this.last_pay_value.getText());
            //newBill.setBillId();
            int billsCount = Integer.parseInt(this.bill_num.getText());
            newBill.setBillId(billsCount);

            //ADD LAST ROW IF NOT COUNTED
            if (jTable1.getModel().getValueAt(jTable1.getRowCount() - 1, 0).toString() == null || (jTable1.getModel().getValueAt(jTable1.getRowCount() - 1, 0).toString()).isEmpty()|| this.getCurrent_balance_value().getText()=="0") {
                int sum = Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getRowCount() - 1, 4) != null ? jTable1.getModel().getValueAt(jTable1.getRowCount() - 1, 4).toString() : "0") * Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getRowCount() - 1, 5) != null ? jTable1.getModel().getValueAt(jTable1.getRowCount() - 1, 5).toString() : "0");
                int balance = Integer.parseInt(this.getCurrent_balance_value().getText());
                balance += sum;
                balance+= Integer.parseInt(this.prev_balance_value.getText());
                this.getCurrent_balance_value().setText(balance + "");

            }
            newBill.setCurrentBalance(this.current_balance_value.getText());

            billCont.create(newBill);

            int rowCount = this.jTable1.getRowCount();

            for (int row = 0; row < rowCount; row++) {

                if (this.jTable1.getModel().getValueAt(row, 0) == null) {
                    break;
                }

                String quantity = "";
                try {
                    quantity = this.jTable1.getModel().getValueAt(row, 4).toString();
                } catch (java.lang.NullPointerException x) {
                    break;
                }
                String price = this.jTable1.getModel().getValueAt(row, 5).toString();

                BillProductDetails x = new BillProductDetails();
                x.setBillId(billsCount);
                x.setProductId(Integer.parseInt(this.jTable1.getModel().getValueAt(row, 0).toString()));
                x.setFarmerId(Integer.parseInt(this.jTable1.getModel().getValueAt(row, 2).toString()));
                x.setPrice(price);
                x.setQuantity(quantity);

                BillProductDetailsJpaController billdCont;
                //EntityManagerFactory factory;
                factory = Persistence.createEntityManagerFactory("commission_systemPU");
                billdCont = new BillProductDetailsJpaController(factory);
                x.setId(billdCont.getBillProductDetailsCount());
                billdCont.create(x);
            }
            //TODO:
            //save dealers new balance

            DealerJpaController dealerCont;
            dealerCont = new DealerJpaController(factory);

            Dealer x = dealerCont.findDealer(this.dealer_id.intValue());
            x.setBalance(this.current_balance_value.getText());

            dealerCont.edit(x);

            String st = "???? ?????????? ???????????????? ??????????";
            JOptionPane.showMessageDialog(null, st);
            this.setVisible(false);
            new HomePage().setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(newBill_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_save_billActionPerformed

    private void current_balanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_current_balanceKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_current_balanceKeyPressed

    private void bill_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bill_numActionPerformed

    private void bill_numComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_bill_numComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_bill_numComponentShown

    private void ref_numKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ref_numKeyPressed
        // TODO add your handling code here:

        int key=evt.getKeyCode();
        if(key==10)
        jTable1.requestFocus();
    }//GEN-LAST:event_ref_numKeyPressed

    private void ref_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ref_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ref_numActionPerformed

    private void driver_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_driver_nameKeyPressed
         int key=evt.getKeyCode();
              if(key==10)
              issue_date.requestFocus();
    }//GEN-LAST:event_driver_nameKeyPressed

    private void driver_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driver_nameActionPerformed
        // TODO add your handling code here:
        DriversList drivers = new DriversList(this, true);
        drivers.setVisible(true);
    }//GEN-LAST:event_driver_nameActionPerformed

    private void dealer_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dealer_nameKeyPressed
        // TODO add your handling code here:
        int key=evt.getKeyCode();
        if(key==10)
        driver_name.requestFocus();
    }//GEN-LAST:event_dealer_nameKeyPressed

    private void dealer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealer_nameActionPerformed
        // TODO add your handling code here:

        DealerList dealers = new DealerList((java.awt.Frame) this, true);
        dealers.setVisible(true);
    }//GEN-LAST:event_dealer_nameActionPerformed

    
    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
        
        
        
        
        
        
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyReleased

   
    
    
    
    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
            int selectedColumn = jTable1.getSelectedColumn();
            int selectedRow = jTable1.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            
             im = jTable1.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
            
            
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

//           if(selectedColumn >= jTable1.getColumnCount() - 1){
//                im.put(enter, im.get(enter)); 
//            
//            }
            
//             KeyStroke tab  = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
//             KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
           



            
            if (selectedColumn == jTable1.getColumnCount() - 1) {

                try {
                    
                    im.put(enter, im.get(tab));

                    //CALCULATE TOTAL PRICE FOR SINGLE ITEM
                    int sum = Integer.parseInt(model.getValueAt(selectedRow, 4) != null ? model.getValueAt(selectedRow, 4).toString() : "0")
                            * Integer.parseInt(model.getValueAt(selectedRow, 5) != null ? model.getValueAt(selectedRow, 5).toString() : "0");
                    model.setValueAt(sum + "", selectedRow, selectedColumn - 1);

                    //CALCULATE CURRENT BALANCE
                    int balance = Integer.parseInt(this.getCurrent_balance_value().getText());
                    balance += sum;
                    this.getCurrent_balance_value().setText(balance + "");
                    
                    
                    //ADD NEW EMPTAY ROW
                    Object[] row = {null, null, null, null, null, null, null, null};
                    model.addRow(row);
                    
                   //  System.out.println(model.getRowCount());
                   
                   jTable1.scrollRectToVisible(jTable1.getCellRect(jTable1.getRowCount()-1, 0, true));
                    
                   jTable1.setColumnSelectionInterval(0, 0);// select first column at first index

                   jTable1.editCellAt(model.getRowCount() - 1, 0);
                   jTable1.setRowSelectionInterval(model.getRowCount(), model.getRowCount());

                 } catch (Exception e) {
                }//

            }
            
            
       //            jTable1.editCellAt(model.getRowCount() - 1, x);
            

            // Insert new row on clicking last column
            if (selectedColumn == 0) {

                ProductList products = new ProductList(this, true);
                products.setVisible(true);

            }//clicking on product code
            if (selectedColumn == 2) {

                FarmerList products = new FarmerList(this, true);
                products.setVisible(true);

            }//clicking on product code

        }

    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1CaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1CaretPositionChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTable1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1ComponentAdded

    private void jLabel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyPressed
        // TODO add your handling code here:
        int key=evt.getKeyCode();
        if(key==10)
        dealer_name.requestFocus();
    }//GEN-LAST:event_jLabel1KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
     /*   
        JButton button = new JButton();
button.setBorderPainted(false);
button.setBorder(null);
//button.setFocusable(false);
button.setMargin(new Insets(0, 0, 0, 0));
button.setContentAreaFilled(false);
button.setIcon(myIcon1);
button.setRolloverIcon(myIcon2);
button.setPressedIcon(myIcon3);
button.setDisabledIcon(myIcon4);
button.setBorder(null);
button.setFocusPainted(false);
*/
     
     
     
     
     
     
     
     
     
     
     
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        /*
        JButton button = new JButton();
button.setBorderPainted(false);
button.setBorder(null);
//button.setFocusable(false);
button.setMargin(new Insets(0, 0, 0, 0));
button.setContentAreaFilled(false);
button.setIcon(myIcon1);
button.setRolloverIcon(myIcon2);
button.setPressedIcon(myIcon3);
button.setDisabledIcon(myIcon4);
button.setBorder(null);
button.setFocusPainted(false);
*/
        
        
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jPanel1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jPanel1CaretPositionChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel1CaretPositionChanged

    private void issue_dateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_issue_dateKeyReleased

        // TODO add your handling code here:
        //   int key=evt.getKeyCode();
        //   if(key==10)
        //   ref_num.requestFocus();
    }//GEN-LAST:event_issue_dateKeyReleased

    private void is_dateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_is_dateKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            issue_date.setVisible(true);

        }
        int key=evt.getKeyCode();
        if(key==10)
        ref_num.requestFocus();

    }//GEN-LAST:event_is_dateKeyPressed

    private void issue_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issue_dateActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_issue_dateActionPerformed

    private void Bill_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bill_SearchActionPerformed
        // TODO add your handling code here:
          Bills_List bills = new Bills_List((java.awt.Frame) this, true);
        bills.setVisible(true);
        
        
        
    }//GEN-LAST:event_Bill_SearchActionPerformed

    
    
    
    
    
    
    
    
    /*
    
    private void printRecord(JPanel panel){

    PrinterJob printerJob = PrinterJob.getPrinterJob();

    printerJob.setJobName("Print Record");


    printerJob.setPrintable(new Printable(){
    @Override
    public int print(Graphics graphics , PageFormat pageFormat, int pageIndex) throws PrinterException { 

    if (pageIndex>0){

    return Printable.NO_SUCH_PAGE;
}


Graphics2D graphics2D = (Graphics2D)graphics;

graphics2D.translate(pageFormat.getImageableX()*2,pageFormat.getImageableY()*2);

graphics2D.scale(0.5,0.5);

panel.paint(graphics2D);

return Printable.PAGE_EXISTS;
    }

        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });

boolean returningResult = printerJob.printDialog();
        boolean returnipngResult = false;

if (returnipngResult){
try
{
    
        printerJob.print();
    
}catch(PrinterException printerException){

    JOptionPane.showMessageDialog(this, "Print Error:  "+printerEception.getMessage());
}
    }



            }



    
   */ 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(newBill_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newBill_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newBill_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newBill_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new newBill_Page().setVisible(true);
        });
    }

    public JLabel getCurrent_balance_value() {
        return current_balance_value;
    }

    public JLabel getLast_pay_value() {
        return last_pay_value;
    }

    public JLabel getPrev_balance_value() {
        return prev_balance_value;
    
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bill_Search;
    private javax.swing.JTextField bill_num;
    private javax.swing.JLabel current_balance;
    private javax.swing.JLabel current_balance_value;
    private javax.swing.JTextField dealer_name;
    private javax.swing.JTextField driver_name;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private org.jdesktop.swingx.JXDatePicker issue_date;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel last_pay_value;
    private javax.swing.JLabel last_payment;
    private javax.swing.JLabel prev_balance_value;
    private javax.swing.JLabel previous_balance;
    private javax.swing.JButton printRecord;
    private javax.swing.JTextField ref_num;
    private javax.swing.JButton save_bill;
    // End of variables declaration//GEN-END:variables

  


}


