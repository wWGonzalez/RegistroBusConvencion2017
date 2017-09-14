/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro;

import javax.swing.*;
import net.proteanit.sql.DbUtils;

import SQL.ShareConnection;
import java.awt.Toolkit;

import java.awt.event.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis
 */
public class RegistroEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form RegistroEstudiante
     */
        java.sql.PreparedStatement statement = null;
        java.sql.ResultSet result = null;
        String sql = null;
        String cicloId = "";//Guarda el id del ciclo
        String date="";
        
        String idEstudiante="";
        String nombre="";
        String carne="";
        String apellido="";
        
        Integer contarCiclo=0;
          AsignarBus bus = new AsignarBus();
          CrearBus cbus= new CrearBus();
          CrearCiclo c = new CrearCiclo();
        
    public RegistroEstudiante() {
        initComponents();
        UpdateTable();
        
        setDate();
       setCombobox();
       
        
      //  jComboBox1.removeAllItems();
        //setCombobox();//Establece los ciclos de la carrera en el comboBox
    }
    
    
    //Cuenta si hay datos en la tabla ciclo y en la tabla Bus
    public void datosInicio(){
        this.contar();
        if(this.contarCiclo==0){
         
            JOptionPane.showMessageDialog(rootPane, "Antes de iniciar Registre Ciclos y Bus");
                 c.setVisible(true);
                 cbus.setVisible(true);
                 
                }
                else{
            this.setTitle("Registrar Estudiante");
            this.setVisible(true);
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

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCarne = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Ciclo" }));
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel1.setText("Seleccionar ciclo");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Datos Estudiante")));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Carne:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, -1, -1));

        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, -1, -1));

        jLabel4.setText("Apellido:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 106, -1, -1));

        jLabel5.setText("Telefono:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 144, -1, -1));

        txtCarne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarneActionPerformed(evt);
            }
        });
        jPanel1.add(txtCarne, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 27, 251, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 65, 251, -1));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 103, 251, -1));

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 141, 251, -1));

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 125, 31));

        jLabel6.setText("Fecha");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 179, -1, -1));

        jLabelDate.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jPanel1.add(jLabelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 179, 141, 14));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel7.setText("Buscar Estudiante Por Carne");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jToolBar1.setRollover(true);

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar2");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/umgLogo.png"))); // NOI18N

        jMenu1.setText("Agrear");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Agregar Ciclo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Agregar Bus");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Asistencia");

        jMenuItem3.setText("Registro de Asistencia");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Mostrar Asistenca");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(33, 33, 33)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jButton3))))))
                .addContainerGap(147, Short.MAX_VALUE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButton3))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
       String tmp = (String)this.jComboBox1.getSelectedItem();
      this.sql= "select * from convencion.ciclo where ciclo.ciclo=?";
             
        try{
            statement = ShareConnection.connection.getConn().prepareStatement(sql);
            statement.setString(1, tmp);
            result = statement.executeQuery();
            if(result.next()){
                this.cicloId=result.getString("ciclo.id");
                //this.txtTelefono.setText(cicloId);
                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
        
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    
    
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
       
   //Muestra mensaje en caso de que no seleccionen ningun ciclo
       if(this.cicloId!=""){
           
           if(this.txtCarne.getText().equals("")){
                 JOptionPane.showMessageDialog(rootPane, "Falta Numero de carne");
           }else{
               
                   guardarEstudiante();
                   this.limpiarTxt();
                            
           }
           
       }else
       {
           JOptionPane.showMessageDialog(rootPane, "Seleccione un ciclo");
       }
   
         
         
         
        
       //jComboBox1.removeAllItems();//Limpia los datos del comboBox antes de actualizar los items
       // setCombobox();//Actualiza los items del  comboboBox
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        
        if(this.txtTelefono.getText().length()>7){
            evt.consume();
         JOptionPane.showMessageDialog(rootPane, "Rectifique Numero de Telefono");

        }
        
        
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        this.enviarCiclo();
        this.abrirRegistroBus();
       // this.abrirRegistroBus();
    }//GEN-LAST:event_jTable1MouseClicked

  
    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1MousePressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtCarneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarneActionPerformed

    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained
        // TODO add your handling code here:
         
      
    }//GEN-LAST:event_jTable1FocusGained

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
       // this.buscar("carne", this.txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.buscar("carne", this.txtBuscar.getText());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        UpdateTableSearch(this.txtBuscar.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Asistencia asist = new Asistencia();
        this.setVisible(false);
        asist.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        CrearBus bus =new CrearBus();
        bus.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

   
    
    private void guardarEstudiante(){
        sql = "Insert Into estudiante values(?,?,?,?,?,?,?,?)";
            try {
                statement = ShareConnection.connection.getConn().prepareStatement(sql);
                statement.setString(1, "0");
                statement.setString(2, this.txtCarne.getText());
                statement.setString(3, this.txtNombre.getText());
                statement.setString(4, this.txtApellido.getText());
                statement.setString(5, this.txtTelefono.getText());
                statement.setString(6, date);
                statement.setString(7, this.cicloId);
                 statement.setString(8, "200");
                
                statement.execute();
               
                statement.close();
                UpdateTable();
                
                JOptionPane.showMessageDialog(rootPane, "Estudiante Guardado Correctamente");
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + ex.getMessage());
            }
    }//Finaliza  guardarEstudiante
    
    
    public void setCombobox(){
          try{
            this.sql="select * from ciclo";
            statement = ShareConnection.connection.getConn().prepareStatement(sql);
            result = statement.executeQuery();
            
            while(result.next()){
                String ciclo = result.getString("ciclo");
                this.jComboBox1.addItem(ciclo);
            }
            statement.close();
            result.close();
        }catch(Exception e){
            
        }
          
          
            
    }//finaliza seComboBox
    
    
    
    //Contar datos de la tabla ciclo
    
    public void contar(){
      try{
            this.sql="SELECT count(*) as cantidadCiclos FROM convencion.ciclo;";
            statement = ShareConnection.connection.getConn().prepareStatement(sql);
            result = statement.executeQuery();
            
            while(result.next()){
                 contarCiclo= result.getInt("cantidadCiclos");
               // this.txtTelefono.setText(contarCiclo.toString()); //Muestra la cantidad obtenida de la base de datos
            }
            this.statement.close();
            result.close();
        }catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + ex.getMessage());
            }
    }
    
    //establece la fecha y la guarda en la variable date
    public void setDate(){
        Calendar cal =new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        //this.jTextField1.setText(year+"-"+(month+1)+"-"+day);
        this.date = year+"-"+(month+1)+"-"+day;
        this.jLabelDate.setText(date);
        //this.jTextField2.setText(date);
        
        
    }//Finaliza metodo setDate
    
    
    
    
    //Metodo para Actualizar Tabla
    public void UpdateTable(){
        this.sql = "SELECT carne,nombre,apellido,ciclo.ciclo FROM convencion.estudiante inner join ciclo \n" +
        "on ciclo.id = estudiante.Ciclo_id";
        
        try{
        statement = ShareConnection.connection.getConn().prepareStatement(sql);
        result = statement.executeQuery(sql);
        this.jTable1.setModel(DbUtils.resultSetToTableModel(result));
        
        
        }catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + ex.getMessage());
            }
               
    }//Finaliza metodo para actualizar tabla
    
    
    public void UpdateTableSearch(String carne){
        this.sql = "SELECT carne,nombre,apellido,ciclo.ciclo FROM convencion.estudiante inner join ciclo \n" +
        "on ciclo.id = estudiante.Ciclo_id where carne='"+carne+"' ";
        
        try{
        statement = ShareConnection.connection.getConn().prepareStatement(sql);
        result = statement.executeQuery(sql);
        this.jTable1.setModel(DbUtils.resultSetToTableModel(result));
        
        
        }catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + ex.getMessage());
            }
               
    }//Finaliza metodo para actualizar tabla
    
    
    
     
    public void abrirRegistroBus(){
         bus.setVisible(true);
         bus.txtCarne.setText(this.carne);
         bus.txtNombre.setText(nombre);
         bus.txtApellido.setText(apellido);
         bus.estudianteId = this.idEstudiante;
    }
    
    //Guarda los datos en variables globales
    public void enviarCiclo(){
       try{
            int row=this.jTable1.getSelectedRow();
            String Table_click=(this.jTable1.getModel().getValueAt(row,  0).toString());
            String sql="select * from convencion.estudiante where carne='"+Table_click+"' ";
            statement = ShareConnection.connection.getConn().prepareStatement(sql);
             result = statement.executeQuery();    
             if(result.next()){
                 idEstudiante=result.getString("idEstudiante");
                 carne=result.getString("carne");
                 nombre=result.getString("nombre");
                 this.apellido=result.getString("apellido");
                 
                 
                // this.txtTelefono.setText(idEstudiante);
                // this.txtCarne.setText(carne);
                
            //  bus.setVisible(true);
             // bus.txtID.setText(add1);
                
                //this.setVisible(false);
                 
             }
            // statement.close();
        }catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + ex.getMessage());
            
        }
     
    }
    
    
    
    //Busca en la tabla
    
   public void buscar(String columna,String busqueda){
       try{
           this.sql="SELECT carne,nombre,apellido,ciclo.ciclo FROM convencion.estudiante inner join ciclo\n" +
"on ciclo.id = estudiante.Ciclo_id where "+columna+"=?";
           statement = ShareConnection.connection.getConn().prepareStatement(sql);
           statement.setString(1, busqueda);
           result=statement.executeQuery();
           
           
           if(result.next()){
               String add1 = result.getString("carne");
               this.txtCarne.setText(add1);
               String add2 = result.getString("nombre");
               this.txtNombre.setText(add2);
               String add3 = result.getString("apellido");
               this.txtApellido.setText(add3);
               String add4 = result.getString("ciclo");
               this.txtTelefono.setText(add4);
           }
           
       }catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + ex.getMessage());
            
        }
   }//Finaliza metodo para buscar
    
    
    
    
    
    //Metodo para limpiar cuadros de texto y establece en la poscicion 0 ComBobox
    public void limpiarTxt(){
        this.txtCarne.setText("");
        this.txtApellido.setText("");
        this.txtNombre.setText("");
        this.txtTelefono.setText("");
        this.jComboBox1.setSelectedIndex(0);
        
                 
   }
    
    
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
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
            java.util.logging.Logger.getLogger(RegistroEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCarne;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
