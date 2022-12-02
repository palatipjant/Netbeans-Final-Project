/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package librarymain.libraryproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wenda
 */
public class AdminFrame extends javax.swing.JFrame {
    String[] AdminArray = null;
    List<String> AdminID = new ArrayList<>();
    List<String> AdminName = new ArrayList<>();
    List<String> AdminEmail = new ArrayList<>();
    List<String> AdminBorrowDate = new ArrayList<>();
    List<String> AdminReturnDate = new ArrayList<>();
    List<String> AdminPhone = new ArrayList<>();
    /**
     * Creates new form AdminFrame
     */
    public AdminFrame() {
        initComponents();
        ShowReturn();
    }
    
    private void ShowReturn() {
        
        try {
            Scanner ReturnFile = new Scanner(new File("BorrowList.txt"));
            while (ReturnFile.hasNextLine())
            {
              String s = ReturnFile.nextLine();  
              AdminArray = s.split(",");
              
              if (AdminArray[4].equals("not returned yet")) {
                    AdminID.add(AdminArray[0]);
                    AdminName.add(AdminArray[1]);
                    AdminEmail.add(AdminArray[5]);
                    AdminBorrowDate.add(AdminArray[3]);
                    AdminReturnDate.add(AdminArray[4]);
                    AdminPhone.add(AdminArray[6]);
              }
          
              
            } 
            ReturnFile.close();
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "User Database Not Found", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yy");  
        libraData.setFormattedDate(myDateObj.format(myFormatObj));
        
        DefaultTableModel AdminModel = (DefaultTableModel) AdminTable.getModel();
        for (int i = 0; i < AdminID.size(); i++){
            final LocalDate Borrow = LocalDate.parse(AdminBorrowDate.get(i), myFormatObj);
            final LocalDate today = LocalDate.parse(libraData.getFormattedDate(), myFormatObj);
            final long daysInBetween = ChronoUnit.DAYS.between(Borrow, today);
            String shownumberofdays = daysInBetween + " days";
            Object[] BorrowRow = { AdminID.get(i), AdminName.get(i), 
                AdminEmail.get(i), AdminBorrowDate.get(i), AdminReturnDate.get(i), AdminPhone.get(i), shownumberofdays };
            AdminModel.addRow(BorrowRow);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAdminHead = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AdminTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 227, 227));
        setMaximumSize(new java.awt.Dimension(700, 495));
        setMinimumSize(new java.awt.Dimension(700, 495));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 227, 227));
        jPanel1.setMaximumSize(new java.awt.Dimension(700, 495));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 495));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 495));

        lblAdminHead.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAdminHead.setText("Manage Borrow Book");

        AdminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Email", "Date", "Status", "Phone No.", "Number of days"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AdminTable.setGridColor(new java.awt.Color(51, 51, 51));
        AdminTable.setSelectionBackground(new java.awt.Color(255, 227, 227));
        AdminTable.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(AdminTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(lblAdminHead)
                .addContainerGap(237, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdminHead)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AdminTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdminHead;
    // End of variables declaration//GEN-END:variables
}
