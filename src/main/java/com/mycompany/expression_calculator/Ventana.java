/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.expression_calculator;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Ventana principal de la calculadora
 * @author SpaceBa
 */
public class Ventana extends javax.swing.JFrame {
    Random puerto = new Random();
    int puerto_propio = puerto.nextInt(5000, 10000);

    Cliente cliente = new Cliente(puerto_propio);


    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        Thread hilo_cliente = new Thread(cliente);
        hilo_cliente.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        upload_button = new javax.swing.JButton();
        send_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        expression_label = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        foto_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        result_label = new javax.swing.JTextField();
        request_button = new javax.swing.JButton();
        name_label = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Result");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        upload_button.setText("Upload a picture");
        upload_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_buttonActionPerformed(evt);
            }
        });

        send_button.setText("Send");
        send_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    send_buttonActionPerformed(evt);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Calculator");

        expression_label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expression_labelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Name:");

        foto_button.setText("Take a picture");
        foto_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foto_buttonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Result");

        result_label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                result_labelActionPerformed(evt);
            }
        });

        request_button.setText("Consult");
        request_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                request_buttonActionPerformed(evt);
            }
        });

        name_label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_labelActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Enter the expression you want to evaluate:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(116, 116, 116))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(expression_label)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(upload_button)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(send_button)
                                            .addGap(12, 12, 12)
                                            .addComponent(foto_button))))
                                .addComponent(result_label))
                            .addComponent(request_button))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addGap(9, 9, 9)
                .addComponent(expression_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(send_button)
                    .addComponent(upload_button)
                    .addComponent(foto_button))
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(result_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(request_button)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void expression_labelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expression_labelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_expression_labelActionPerformed

    private void result_labelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_result_labelActionPerformed
    }//GEN-LAST:event_result_labelActionPerformed

    private void name_labelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_labelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_labelActionPerformed

    private void upload_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upload_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_upload_buttonActionPerformed

    /**
     * Metodo que realiza las acciones cuando el boton enviar es presionado
     * @param evt
     * @throws InterruptedException
     */
    private void send_buttonActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {//GEN-FIRST:event_send_buttonActionPerformed
        String name = this.name_label.getText();
        String read_expression = this.expression_label.getText();
        String expression = "(" + read_expression + ")";
        Date date = new Date();
        Boolean type = false;
        cliente.setFecha(date);
        cliente.setOperacion(expression);
        cliente.setNombre(name);
        cliente.respuesta = false;

        if(!(this.expression_label.getText().equals(""))){
            char caracter_evaluado;
            type = false;
            for (int i = 0; i < expression.length(); i++){
                caracter_evaluado = expression.charAt(i);
                if(caracter_evaluado == 'v' || caracter_evaluado == 'f'){
                    type = true;
                    break;
                }
            }
        }else{
            this.expression_label.setText("No valid");
        }

        cliente.enviar(expression, name, date, type);
        while(cliente.respuesta == false){
            this.result_label.setText("Calculado resultado");
        }
        cliente.respuesta = false;
        this.result_label.setText(cliente.operacion);


    }//GEN-LAST:event_send_buttonActionPerformed

    private void foto_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final Camera camera = new Camera(expression_label);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        camera.startCamera();
                    }
                }).start();
            }
        });

    }//GEN-LAST:event_foto_buttonActionPerformed

    private void request_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        CSV_Manage csvread = new CSV_Manage();
        csvread.readCSV("file.csv", name_label.getText()); // Modify the readCSV method to return content
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField expression_label;
    private javax.swing.JButton foto_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField name_label;
    private javax.swing.JButton request_button;
    private javax.swing.JTextField result_label;
    private javax.swing.JButton send_button;
    private javax.swing.JButton upload_button;
    // End of variables declaration//GEN-END:variables
}
