/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Main;

import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.Personnel.EmployeeProfile;
import TheBusiness.Personnel.Profile;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.UserAccountManagement.UserAccount;
import TheBusiness.UserAccountManagement.UserAccountDirectory;
import UserInterface.Main.WorkSpaceProfiles.BusinessManagerWorkAreaJPanel;
import UserInterface.Main.WorkSpaceProfiles.MarketingManagerWorkAreaJPanel1;
import UserInterface.Main.WorkSpaceProfiles.SalesPersonWorkAreaJPanel;
import javax.swing.JPanel;
import java.util.*;
import java.util.stream.*;
import TheBusiness.ProductManagement.Product;
import TheBusiness.OrderManagement.Order;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SolutionOrders.SolutionOrder;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.MarketModel.SolutionOfferCatalog;
/* */

/**
 *
 * @author kal bugrara
 */

public class PricingMainFrame extends javax.swing.JFrame {
    
    Business business;
    
    CustomerDirectory customerDirectory;
    MarketCatalog marketCatalog;
    MasterOrderList masterOrderList;
    PersonDirectory personDirectory;
    SalesPersonDirectory salesPersonDirectory;
    MasterSolutionOrderList masterSolutionOrderList;
    SolutionOfferCatalog solutionOfferCatalog;
    /* */
    
    
    
    public PricingMainFrame() {
        initComponents();
        business = ConfigureABusiness.initialize();
        
        
        this.customerDirectory = business.getCustomerDirectory();
        this.marketCatalog = business.getMarketCatalog();
        this.masterOrderList = business.getMasterOrderList();
        this.personDirectory = business.getPersonDirectory();
        this.salesPersonDirectory = business.getSalesPersonDirectory();
        this.masterSolutionOrderList = business.getMasterSolutionOrderList();
        this.solutionOfferCatalog = business.getSolutionOfferCatalog();
        
        UseCases usecase = new UseCases(business);
        
        
        /* */
        
        /* Question No 2 */
        HashMap<String, Integer> topThreeCustomer = new HashMap<>();        
        for(CustomerProfile c : this.customerDirectory.getCustomerlist()) {
                topThreeCustomer.put(c.getPerson().getName(), c.getNumberOfOrdersAboveTotalTarget());
        }
        List<Map.Entry<String, Integer>> sortedEntries = topThreeCustomer.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toList());
        System.out.println("Top Three Customers (Question 2)");
        System.out.println("--------------------------------");
        int count = 1;
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            if (count <= 3) {
                System.out.println(count +  ") " + entry.getKey());
                count++;
            } else {
                break;
            }
        }
        System.out.println("\n");
        /* */
        
        /* Question No 3 */
        System.out.println("Top Three Sales Person (Question 3)");
        System.out.println("-----------------------------------");
        HashMap<String, Integer> topThreeSalesPerson = new HashMap<>(); 
        for(SalesPersonProfile s : this.salesPersonDirectory.getSalespersonlist()) {
            int salesCount = 0;
            for(Order o : this.masterOrderList.getOrders()) {
                if(s.getPerson().getName().equals(o.getSalesperson().getPerson().getName())) {
                    if(o.isOrderAboveTotalTarget()) {
                        salesCount = salesCount + 1;
                    }
                }
            }
            topThreeSalesPerson.put(s.getPerson().getName(), salesCount);
        }
        List<Map.Entry<String, Integer>> sortedEntriesSalesPersons = topThreeSalesPerson.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        int j = 1;
        for (Map.Entry<String, Integer> entry : sortedEntriesSalesPersons) {
            if (j <= 3) {
                System.out.println(j + ") " + entry.getKey());
                j++;
            } else {
                break;
            }
        }        
        System.out.println("\n");
        /* */
        
        /* Question No 4 */
        System.out.println("Market Revenues (Question 4)");
        System.out.println("----------------------------");
        int i = 1;
        for(Market m : this.marketCatalog.getMarkets()) {
            int sum = 0;
            for(Order o : this.masterOrderList.getOrders()) {
                if(m.getName().equals(o.getMarketName())) {
                    sum = sum + o.getOrderPricePerformance();
                }
            }
            System.out.println(i + ") " + m.getName() + " : " + sum);
            i = i + 1;
        }
        /* */
        
        /* Question No 5 */
        
        /* */
        System.out.println("\n");
        System.out.println(business);
    }
    
    
    public void insert(JPanel jpanel) {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SplitHomeArea = new javax.swing.JSplitPane();
        actionsidejpanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        UserNameTextField = new javax.swing.JTextField();
        PasswordTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CardSequencePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        actionsidejpanel.setBackground(new java.awt.Color(0, 153, 153));
        actionsidejpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        actionsidejpanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 70, 30));

        jLabel1.setText("User Name");
        actionsidejpanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        UserNameTextField.setText("sales");
        actionsidejpanel.add(UserNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, -1));

        PasswordTextField.setText("XXXX");
        actionsidejpanel.add(PasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 130, -1));

        jLabel2.setText("Password");
        actionsidejpanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        SplitHomeArea.setLeftComponent(actionsidejpanel);

        CardSequencePanel.setLayout(new java.awt.CardLayout());
        SplitHomeArea.setRightComponent(CardSequencePanel);

        getContentPane().add(SplitHomeArea, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        //      WorkAreaJPanel ura = new WorkAreaJPanel(workareajpanl);
        
        String un = UserNameTextField.getText();
        String pw = PasswordTextField.getText();
        
        UserAccountDirectory uad = business.getUserAccountDirectory();
        UserAccount useraccount = uad.AuthenticateUser(un, pw);
        if (useraccount == null) {
            return;
        }
        SalesPersonWorkAreaJPanel salesworkarea;
        MarketingManagerWorkAreaJPanel1 marketingworkarea;
        BusinessManagerWorkAreaJPanel bzmanagerworkarea;
        String r = useraccount.getRole();
        Profile profile = useraccount.getAssociatedPersonProfile();
        //       if (r.equalsIgnoreCase("sales")) {
        
        if (profile instanceof SalesPersonProfile) {

            SalesPersonProfile spp = (SalesPersonProfile) profile;
            salesworkarea = new SalesPersonWorkAreaJPanel(business, spp, CardSequencePanel);
            CardSequencePanel.removeAll();
            CardSequencePanel.add("Sales", salesworkarea);
            ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

        }

        if (profile instanceof MarketingPersonProfile) {
            marketingworkarea = new MarketingManagerWorkAreaJPanel1(business, CardSequencePanel);
            CardSequencePanel.removeAll();
            CardSequencePanel.add("Marketing", marketingworkarea);
            ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

        }

        if (profile instanceof EmployeeProfile) {

            bzmanagerworkarea = new BusinessManagerWorkAreaJPanel(business, CardSequencePanel);
            CardSequencePanel.removeAll();
            CardSequencePanel.add("Admin", bzmanagerworkarea);
            ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

        }

    }//GEN-LAST:event_LoginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PricingMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PricingMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PricingMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PricingMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PricingMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardSequencePanel;
    private javax.swing.JTextField PasswordTextField;
    private javax.swing.JSplitPane SplitHomeArea;
    private javax.swing.JTextField UserNameTextField;
    private javax.swing.JPanel actionsidejpanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
