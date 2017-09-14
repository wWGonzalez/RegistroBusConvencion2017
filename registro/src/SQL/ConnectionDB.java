/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

/**
 *
 * @author luis
 */
public class ConnectionDB {
    public static java.sql.Connection conn=null;
    public static java.sql.Connection Conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/convencion?"+"user=root&password=01234");
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, "Error en la conexion:\t" + e.getMessage());
        }
        return conn;
        
    }
}
