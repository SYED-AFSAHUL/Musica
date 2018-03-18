/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ankush
 */
public class album extends javax.swing.JFrame {

    /**
     * Creates new form album
     */
    String albumID;
    String result;
    String g_id;
    
    public album() {
        initComponents();
        this.albumID = "0e6faf3a-f752-43b3-89f2-4ff0fcd21296";
        viewAlbum(albumID);
    }
    
    public album(String albumID) {
        initComponents();
        this.albumID = albumID;
        viewAlbum(albumID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Album");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(168, 19, 60, 17);

        jLabel2.setText("name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 80, 110, 30);

        jLabel3.setText("r year");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 110, 70, 30);

        jLabel4.setText("no of songs");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 140, 70, 30);

        jLabel5.setText("grp");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(140, 170, 80, 40);

        jButton1.setText("BACK TO SEARCH PAGE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 260, 170, 23);

        jLabel6.setText("Songs:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(330, 80, 60, 30);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(320, 140, 82, 25);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(280, 100, 82, 25);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(270, 110, 82, 20);

        jLabel10.setText("Group");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 180, 70, 14);

        jLabel11.setText("No of songs");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(40, 150, 90, 14);

        jLabel12.setText("Release year");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(40, 120, 80, 14);

        jLabel13.setText("limbo");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(330, 120, 40, 20);

        jLabel14.setText("closer");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(330, 150, 40, 14);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicm/images44.png"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(240, 180, 310, 200);

        jLabel16.setText("Name:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(40, 90, 40, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:  search
        this.dispose();
        new search().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened
public void viewAlbum(String albumID){
        //album
        try {
            String sql="Select * from album where album_id = '"+ albumID+"';";
            System.out.println(sql);
            Class.forName("com.mysql.jdbc.Driver");
            //Connection con= (Connection) DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=music;user=root;password=dbpass");
            Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/music??autoReconnect=true&useSSL=false"+"&user=root&password=dbpass");
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                jLabel2.setText(rs.getString("name"));
                jLabel3.setText(rs.getString("release_yr"));
                jLabel4.setText(rs.getString("no_of_songs"));
                g_id = rs.getString("g_id");
                
            }
        }catch (Exception e){
            System.out.println("error");
            e.printStackTrace();
        }
        
       if(g_id.equals("-1")){
           jLabel5.setText("--");
       }else{
           //album
            try {
                String sql="Select name from groups where g_id = "+ g_id+";";
                Class.forName("com.mysql.jdbc.Driver");
                //Connection con= (Connection) DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=music;user=root;password=dbpass");
                Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/music??autoReconnect=true&useSSL=false"+"&user=root&password=dbpass");
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while(rs.next()) {
                    jLabel5.setText(rs.getString("name"));
                }
            }catch (Exception e){
                System.out.println("error");
                e.printStackTrace();
            }
        }
    }
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
            java.util.logging.Logger.getLogger(album.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(album.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(album.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(album.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new album().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}