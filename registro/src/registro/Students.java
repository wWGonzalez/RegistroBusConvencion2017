/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import static SQL.ShareConnection.connection;

/**
 *
 * @author luis
 */
public class Students extends javax.swing.JFrame {
    /// SQL ///
        java.sql.PreparedStatement statement = null;
        java.sql.ResultSet result = null;
        String sql = null;
        /// SQL ///
    public Students(){
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        
        javax.swing.JPanel base = new javax.swing.JPanel();
        java.awt.GridLayout l = new java.awt.GridLayout(7,0);
        l.setVgap(-5);
        base.setLayout(l);
        base.setBackground(Color.white);
        
        ////////////////////////////////////////////////////////////////////////
        javax.swing.JLabel title =  new javax.swing.JLabel("Registro de estudiante", SwingConstants.CENTER);
        title.setFont(new java.awt.Font("Calibri", java.awt.Font.PLAIN, 55));
        title.setForeground(java.awt.Color.LIGHT_GRAY);
        //firstADD
        base.add(title);
        
        ////////////////////////////////////////////////////////////////////////
        /*
        javax.swing.JPanel whitePanel = new javax.swing.JPanel();
        whitePanel.setBackground(Color.white);
        //secondADD
        base.add(whitePanel);
        */
        
        ////////////////////////////////////////////////////////////////////////
        javax.swing.JLabel carne = new javax.swing.JLabel("Carne:\t");
        carne.setFont(new java.awt.Font("Calibri", java.awt.Font.PLAIN, 18));
        javax.swing.JTextField carneEnter = new javax.swing.JTextField(30);
        javax.swing.JPanel enterArea1 = new javax.swing.JPanel();
        enterArea1.setBackground(Color.white);
        enterArea1.setLayout(new java.awt.FlowLayout());
        enterArea1.add(carne);
        enterArea1.add(carneEnter);
        //thirdADD
        base.add(enterArea1);
        
        ////////////////////////////////////////////////////////////////////////
        javax.swing.JLabel name = new javax.swing.JLabel("Nombres:\t");
        name.setFont(new java.awt.Font("Calibri", java.awt.Font.PLAIN, 18));
        javax.swing.JTextField nameEnter = new javax.swing.JTextField(30);
        javax.swing.JPanel enterArea2 = new javax.swing.JPanel();
        enterArea2.setBackground(Color.white);
        enterArea2.setLayout(new java.awt.FlowLayout());
        enterArea2.add(name);
        enterArea2.add(nameEnter);
        //fourthADD
        base.add(enterArea2);
        
        
        
        ////////////////////////////////////////////////////////////////////////
        javax.swing.JLabel lastName = new javax.swing.JLabel("Apellidos:\t");
        lastName.setFont(new java.awt.Font("Calibri", java.awt.Font.PLAIN, 18));
        javax.swing.JTextField lastNameEnter = new javax.swing.JTextField(30);
        javax.swing.JPanel enterArea3 = new javax.swing.JPanel();
        enterArea3.setBackground(Color.white);
        enterArea3.setLayout(new java.awt.FlowLayout());
        enterArea3.add(lastName);
        enterArea3.add(lastNameEnter);
        //fifthADD
        base.add(enterArea3);
        
        
        ////////////////////////////////////////////////////////////////////////
        javax.swing.JLabel telephone = new javax.swing.JLabel("Telefono:\t");
        telephone.setFont(new java.awt.Font("Calibri", java.awt.Font.PLAIN, 18));
        javax.swing.JTextField telephoneEnter = new javax.swing.JTextField(30);
        javax.swing.JPanel enterArea4 = new javax.swing.JPanel();
        enterArea4.setBackground(Color.white);
        enterArea4.setLayout(new java.awt.FlowLayout());
        enterArea4.add(telephone);
        enterArea4.add(telephoneEnter);
        //sixthADD
        base.add(enterArea4);
        
        
        ////////////////////////////////////////////////////////////////////////
        javax.swing.JLabel email = new javax.swing.JLabel("Correo:\t");
        email.setFont(new java.awt.Font("Calibri", java.awt.Font.PLAIN, 18));
        javax.swing.JTextField emailEnter = new javax.swing.JTextField(30);
        javax.swing.JPanel enterArea5 = new javax.swing.JPanel();
        enterArea5.setBackground(Color.white);
        enterArea5.setLayout(new java.awt.FlowLayout());
        enterArea5.add(email);
        enterArea5.add(emailEnter);
        //seventhADD
        base.add(enterArea5);
        
        
        ////////////////////////////////////////////////////////////////////////
        javax.swing.JButton save = new javax.swing.JButton("Guardar");
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //////////////////
                sql = "insert into mydb.Reg_Estudiantes(carne,nombres,apellidos,telefono,correo) values(?,?,?,?,?)";
                try {
                    statement = connection.getConn().prepareStatement(sql);
                    statement.setString(1, carneEnter.getText());
                    statement.setString(2, nameEnter.getText());
                    statement.setString(3, lastName.getText());
                    statement.setString(4, telephoneEnter.getText());
                    statement.setString(5, emailEnter.getText());
                    
                    result = statement.executeQuery();
                    statement.close();
                    //para ingresar un estudiante debe existir un ciclo
                    result.close();
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(null, "error al ingresar los datos: " + ex.getMessage());
                }
                        
                //////////////////
            }
        });
        /// finalADD
        base.add(save);
        
        
        //ADDS
        add(base);
        base.updateUI();
    }
}
