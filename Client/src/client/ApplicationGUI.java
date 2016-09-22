/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Entities.Message;
import Entities.MessageRainbowTable;
import Entities.Rainbowtable;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo-Ov
 */


public class ApplicationGUI extends javax.swing.JFrame {
    
    
    public static String MY_IP;
    public static int BALANCER_PORT = 1112;
    public static int MY_RESPONSE_PORT = 1110;
    public static String BALANCER_IP = "localhost";
    /**
     * Creates new form ApplicationGUI
     */
    public ApplicationGUI() {
        try {
            InetAddress IP = InetAddress.getLocalHost();
            MY_IP = IP.getHostAddress();
            initComponents();
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Error obteniendo la IP", "ERROR" , JOptionPane.ERROR_MESSAGE);
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
        btnContrasena = new javax.swing.JButton();
        txtContrasena = new javax.swing.JTextField();
        txtHash = new javax.swing.JTextField();
        btnHash = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        btnInterrumpirConexion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnRainbowTable = new javax.swing.JButton();
        borrarRainbowBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Proyecto"));

        btnContrasena.setText("Cifrar");
        btnContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContrasenaActionPerformed(evt);
            }
        });

        txtContrasena.setName("password"); // NOI18N

        btnHash.setText("Decriptar");
        btnHash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHashMouseClicked(evt);
            }
        });

        jLabel1.setText("Contraseña");

        jLabel2.setText("Hash");

        jLabel3.setFont(new java.awt.Font("Almonte Snow", 1, 24)); // NOI18N
        jLabel3.setText("Brutal Force Application");

        btnBorrar.setText("Borrar Contenido");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnInterrumpirConexion.setText("Interrumpir Conexión");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnInterrumpirConexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHash)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(btnContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHash, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 172, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHash, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInterrumpirConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnSalir.setFont(new java.awt.Font("Tempus Sans ITC", 2, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRainbowTable.setText("Mostrar Rainbow Table");
        btnRainbowTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRainbowTableMouseClicked(evt);
            }
        });

        borrarRainbowBtn.setText("Borrar Rainbow Table");
        borrarRainbowBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrarRainbowBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRainbowTable)
                        .addGap(31, 31, 31)
                        .addComponent(borrarRainbowBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRainbowTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrarRainbowBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        txtContrasena.setText("");
        txtHash.setText("");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContrasenaActionPerformed
        try {
            Socket socket = new Socket(BALANCER_IP, BALANCER_PORT);
            System.out.println("Enviando peticion de cifrar");
            String pass = txtContrasena.getText();
            Message msg = new Message("CRYPT", pass, MY_IP, MY_RESPONSE_PORT);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(msg);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            msg = (Message)objectInputStream.readObject();
            String type = msg.getType();
            switch(type){
                case "ACK":
                    socket.close();
                    ServerSocket serverSocket = new ServerSocket(MY_RESPONSE_PORT);
                    socket = serverSocket.accept();
                    objectInputStream = new ObjectInputStream(socket.getInputStream());
                    msg = (Message)objectInputStream.readObject();
                    JOptionPane.showMessageDialog(null, "HASH: " + (String)msg.getData(), "EXITO" , JOptionPane.PLAIN_MESSAGE);
                    break;
                case "RESULT":
                    JOptionPane.showMessageDialog(null, "HASH: " + (String)msg.getData(), "EXITO" , JOptionPane.PLAIN_MESSAGE);
                    break;
                case "ERROR":
                    JOptionPane.showMessageDialog(null, (String)msg.getData(), "ERROR" , JOptionPane.ERROR_MESSAGE);
                    break;
            }
            socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ApplicationGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApplicationGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnContrasenaActionPerformed

    private void btnHashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHashMouseClicked
        try {
            Socket socket = new Socket(BALANCER_IP, BALANCER_PORT);
            System.out.println("Enviando peticion de descrifrar");
            String hash = txtHash.getText();
            Message msg = new Message("DECRYPT", hash, MY_IP, MY_RESPONSE_PORT);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(msg);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            msg = (Message)objectInputStream.readObject();
            String type = msg.getType();
            switch(type){
                case "ACK":
                    socket.close();
                    System.out.println(">>Esperando respuesta");
                    ServerSocket serverSocket = new ServerSocket(MY_RESPONSE_PORT);
                    socket = serverSocket.accept();
                    objectInputStream = new ObjectInputStream(socket.getInputStream());
                    msg = (Message)objectInputStream.readObject();
                    JOptionPane.showMessageDialog(null, "PASSWORD: " + (String)msg.getData(), "EXITO" , JOptionPane.PLAIN_MESSAGE);
                    socket.close();
                    serverSocket.close();
                    break;
                case "RESULT":
                    JOptionPane.showMessageDialog(null, "PASSWORD: " + (String)msg.getData(), "EXITO" , JOptionPane.PLAIN_MESSAGE);
                    socket.close();
                    break;
                case "ERROR":
                    JOptionPane.showMessageDialog(null, (String)msg.getData(), "ERROR" , JOptionPane.ERROR_MESSAGE);
                    socket.close();
                    break;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ApplicationGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApplicationGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHashMouseClicked

    private void btnRainbowTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRainbowTableMouseClicked
        try {
            Socket socket = new Socket(BALANCER_IP, BALANCER_PORT);
            System.out.println("Enviando peticion de rainbowtable");
            String hash = txtHash.getText();
            Message msg = new Message("GET_RAINBOWTABLE", hash, MY_IP, MY_RESPONSE_PORT);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(msg);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            MessageRainbowTable msgRainbow = (MessageRainbowTable)objectInputStream.readObject();
            String type = msgRainbow.getType();
            switch(type){
                case "RESULT":
                    for(Rainbowtable rainbowtable: msgRainbow.getData()){
                        System.out.println(rainbowtable.getPassword() + " -> " + rainbowtable.getHash());
                    }
                    break;
                case "ERROR":
                    JOptionPane.showMessageDialog(null, (String)msg.getData(), "ERROR" , JOptionPane.ERROR_MESSAGE);
                    break;
            }
            socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ApplicationGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApplicationGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRainbowTableMouseClicked

    private void borrarRainbowBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarRainbowBtnMouseClicked
        try {
            Socket socket = new Socket(BALANCER_IP, BALANCER_PORT);
            System.out.println("Enviando peticion de descrifrar");
            String hash = txtHash.getText();
            Message msg = new Message("DELETE_RAINBOWTABLE", hash, MY_IP, MY_RESPONSE_PORT);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(msg);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            msg = (Message)objectInputStream.readObject();
            String type = msg.getType();
            switch(type){
                case "RESULT":
                    JOptionPane.showMessageDialog(null, (String)msg.getData(), "EXITO" , JOptionPane.PLAIN_MESSAGE);
                    break;
                case "ERROR":
                    JOptionPane.showMessageDialog(null, (String)msg.getData(), "ERROR" , JOptionPane.ERROR_MESSAGE);
                    break;
            }
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ApplicationGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApplicationGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_borrarRainbowBtnMouseClicked

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
            java.util.logging.Logger.getLogger(ApplicationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // arguments supply message and hostname
                new ApplicationGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrarRainbowBtn;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnContrasena;
    private javax.swing.JButton btnHash;
    private javax.swing.JButton btnInterrumpirConexion;
    private javax.swing.JButton btnRainbowTable;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtHash;
    // End of variables declaration//GEN-END:variables

}