
package Model;

import java.sql.*;


    
public class Conexion {
    //Direcciòn de la base de datos
    private static final String UbicacionBD = "ProyectosConstruccion.db";
    String url = "jdbc:sqlite:" + UbicacionBD;
    Connection conn = null;
    
    public Conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión realizada");
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
    //Mostrar los registros de la base de datos
    public ResultSet consultarRegistros(String url){
        try {
            PreparedStatement pstm = conn.prepareStatement(url);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    
    }
    
}
