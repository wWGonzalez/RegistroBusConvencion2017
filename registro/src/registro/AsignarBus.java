/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro;

import SQL.ShareConnection;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author wz
 */
public class AsignarBus extends javax.swing.JFrame implements Printable {

    /**
     * Creates new form AsignarBus
     */
    
    java.sql.PreparedStatement statement = null;
        java.sql.ResultSet result = null;
        String sql = null;
        Integer busId = 0;//Guarda el id del ciclo
        String estudianteId;
        String date="";
        Integer contarAsientos=0;
         Integer contarAsientos2=0;
         
         Integer limite=45;
        
    
    public AsignarBus() {
        initComponents();
        setCombobox();
        tablaAsientos();
      
    }

   
    
    
    //Debuelve la cantidad de asientos para restaral en el reinicio
     public void contarAsientos(String idBus){
      try{
            this.sql="SELECT count(*) as cantidadAsientos FROM convencion.asientos where Bus_idBus="+idBus+"";
            statement = ShareConnection.connection.getConn().prepareStatement(sql);
            result = statement.executeQuery();
            
            while(result.next()){
                 contarAsientos= result.getInt("cantidadAsientos");
               // this.txtTelefono.setText(contarCiclo.toString()); //Muestra la cantidad obtenida de la base de datos
            }
            this.statement.close();
            result.close();
        }catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + ex.getMessage());
            }
    }
     
     
     //Devuelve la cantidad de asientos para establecer el limite de asientos
      public void contarAsientos2(){
      try{
            this.sql="SELECT count(*) as cantidadAsientos FROM convencion.asientos where Bus_idBus='"+this.busId+"' ";
            statement = ShareConnection.connection.getConn().prepareStatement(sql);
            result = statement.executeQuery();
            
            while(result.next()){
                 contarAsientos2= result.getInt("cantidadAsientos");
               // this.txtTelefono.setText(contarCiclo.toString()); //Muestra la cantidad obtenida de la base de datos
            }
            this.statement.close();
            result.close();
        }catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + ex.getMessage());
            }
    }
     
      
      
      //Reinicia desde 1 el conteo de Numros de asientos dependiendo del limite de asientos que se tenga
     public void reiniciarAsiento(){
        
    if(this.contarAsientos>limite){ //Si el numero de asientos es mayor a limite le resta el limite +1 para volver a iniciar el conteo desde 1
        this.contarAsientos=this.contarAsientos-(limite+1);
    }else{
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtCarne = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        labelIdBus = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelConteoDeAsientos1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        ImprimirAsiento = new javax.swing.JLabel();
        jPanelImprimir = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableImprimir = new javax.swing.JTable();

        jTable1.setAutoCreateRowSorter(true);
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Asignar Bus"));

        jLabel1.setText("Nombre");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Bus" }));
        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Carne");

        jLabel3.setText("No.Bus");

        jButton1.setText("Mostrar Asientos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Apellido");

        jButton2.setText("Asignar Asiento");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Mostar Asientos del Bus Seleccionado");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(42, 42, 42)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCarne, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCarne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(9, 9, 9))
        );

        labelIdBus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Caonteo Asientos: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Bus:");

        labelConteoDeAsientos1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton4.setText("Nuevo Bus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Imprimir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTableImprimir.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableImprimir);

        javax.swing.GroupLayout jPanelImprimirLayout = new javax.swing.GroupLayout(jPanelImprimir);
        jPanelImprimir.setLayout(jPanelImprimirLayout);
        jPanelImprimirLayout.setHorizontalGroup(
            jPanelImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImprimirLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanelImprimirLayout.setVerticalGroup(
            jPanelImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImprimirLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(ImprimirAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addComponent(jButton5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelConteoDeAsientos1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelIdBus, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(139, 139, 139))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelConteoDeAsientos1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelIdBus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(ImprimirAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jButton5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jPanelImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(277, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
         String tmp = (String)this.jComboBox2.getSelectedItem();
      this.sql= "SELECT * FROM convencion.bus where bus.idBus=?;";
             
        try{
            statement = ShareConnection.connection.getConn().prepareStatement(sql);
            statement.setString(1, tmp);
            result = statement.executeQuery();
            if(result.next()){
                this.busId=result.getInt("idBus");
           
                
            }
            statement.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
        
              this.contarAsientos(busId.toString());
              
              this.labelIdBus.setText(busId.toString());
              this.labelConteoDeAsientos1.setText(this.contarAsientos.toString());
        
        
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tablaAsientos();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         contarAsientos(this.busId.toString()); //Cuenta los asientos dependiendo del id del bus que este el jcombobox
         contarAsientos2(); //Cuenta los asientos en base al idBus para utilizarlo en el reinicio
         
         
         
         reiniciarAsiento();

        // TODO add your handling code here:
        if(this.contarAsientos2<45){
                                     if(this.busId==0){
                                            JOptionPane.showMessageDialog(rootPane, "Seleccione Bus");
                                    }else{
                                             this.asignarAsiento();
                                                       }
        }else{
             JOptionPane.showMessageDialog(rootPane, "Bus lleno seleccione otro bus");   
                }
    
             //this.imprimir();
        
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        tablaAsientos2();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        CrearBus bus = new CrearBus();
        bus.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setDatosImprimir();
        this.imprimir();
    }//GEN-LAST:event_jButton5ActionPerformed

    
    //Metodo Para Mostrar Tabla Asientos
    public void tablaAsientos(){
         this.sql = "SELECT Bus_idBus as No_Bus,NoAsiento,carne,nombre,apellido FROM convencion.asientos Inner Join estudiante\n" +
"on estudiante.idEstudiante = asientos.Estudiante_idEstudiante";
        
        try{
        statement = ShareConnection.connection.getConn().prepareStatement(sql);
        result = statement.executeQuery(sql);
        this.jTable1.setModel(DbUtils.resultSetToTableModel(result));
        
        
        }catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + ex.getMessage());
            }
    }//Finaliza metodo para mostrar tabla asietos
    
    
    
    //Metodo que Asigna asiento
    public void asignarAsiento(){
       sql = "Insert Into asientos(idAsiento,Bus_idBus,Estudiante_idEstudiante,NoAsiento) values(?,?,?,?)";
            try {
                statement = ShareConnection.connection.getConn().prepareStatement(sql);
                statement.setString(1, "0");
                statement.setInt(2, busId);
                statement.setString(3, this.estudianteId);
                
                    
                statement.setString(4, this.contarAsientos+1+"");
                
           
                
                statement.execute();
               
                statement.close();
                this.tablaAsientos();
                JOptionPane.showMessageDialog(rootPane, "Asiento Asignado Correctamente");
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + ex.getMessage());
            }
            this.contarAsientos2();
            this.labelConteoDeAsientos1.setText(this.contarAsientos2.toString());//Muestra la cantidad de asientos asignados
    }
    
    
    
    
    
    
    //Muestra asientos del bus 2
   public void tablaAsientos2(){
         this.sql = "SELECT Bus_idBus,idAsiento,carne,nombre,apellido FROM convencion.asientos Inner Join estudiante\n" +
"on estudiante.idEstudiante = asientos.Estudiante_idEstudiante where Bus_idBus="+this.busId+"";
        
        try{
        statement = ShareConnection.connection.getConn().prepareStatement(sql);
        result = statement.executeQuery(sql);
        this.jTable1.setModel(DbUtils.resultSetToTableModel(result));
        
        
        }catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + ex.getMessage());
            }
    }//Finaliza metodo para mostrar tabla asietos
   
    
   public void setDatosImprimir(){
         this.sql = "select carne,nombre,apellido,Bus_idBus as Bus,NoAsiento  from asientos inner join estudiante\n" +
"on estudiante.idEstudiante = asientos.Estudiante_idEstudiante where Estudiante_idEstudiante="+this.estudianteId+"";
        
        try{
        statement = ShareConnection.connection.getConn().prepareStatement(sql);
        result = statement.executeQuery(sql);
        this.jTableImprimir.setModel(DbUtils.resultSetToTableModel(result));
        
        
        }catch (SQLException ex) {
                Logger.getLogger(RegistroEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + ex.getMessage());
            }
    }//Finaliza metodo para mostrar tabla asietos
   
    public void setCombobox(){
          try{
            this.sql="select * from convencion.bus";
            statement = ShareConnection.connection.getConn().prepareStatement(sql);
            result = statement.executeQuery();
            
            while(result.next()){
                String ciclo = result.getString("idBus");
                this.jComboBox2.addItem(ciclo);
            }
            statement.close();
            result.close();
        }catch(Exception e){
            
        }
    }
    
    
    
   
    
       public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

            if (pageIndex > 0) { /* We have only one page, and 'page' is zero-based */
                 return NO_SUCH_PAGE;
                                }

                Graphics2D g2d = (Graphics2D)graphics;
                //g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                
                //Punto donde empezara a imprimir
                g2d.translate(  pageFormat.getImageableX()+100, 
                        pageFormat.getImageableY()+50);

                
                //Envia los datos a imprimir
               // jPanel1.printAll(graphics);
                this.jPanelImprimir.print(graphics);
                
                    
                

                return PAGE_EXISTS;

}
       
    public void imprimir(){
                        try {
                         PrinterJob job = PrinterJob.getPrinterJob();
                          job.setPrintable(this);
                          job.printDialog();
                         job.print();
                            } catch (PrinterException ex) {
                         Logger.getLogger(AsignarBus.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(AsignarBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignarBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignarBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignarBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignarBus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImprimirAsiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelImprimir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableImprimir;
    private javax.swing.JLabel labelConteoDeAsientos1;
    private javax.swing.JLabel labelIdBus;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtCarne;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    
}