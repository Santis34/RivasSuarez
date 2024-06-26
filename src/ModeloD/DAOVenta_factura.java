    
package ModeloD;

import Modelo.conexion.ConexionBD;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class DAOVenta_factura {
     //crear una instancia de conexion
    //Hace llamado al metodo getInstance
    ConexionBD conectar=ConexionBD.getInstance();
  
public int Insertar( Venta_factura Ve) throws SQLException{
    try{ //Para manejar errores al realizar la conexion y transaccion BD
        
        //llama a proceo almacenado de SQLserver
        CallableStatement st=conectar.conectar().
               prepareCall("{CALL insertarVenta_factura(?,?)}");
          st.setInt(1, Ve.getIDCliente());
             st.setDate(2, Ve.getFecha());
            
       
        st.executeUpdate();
       
    }catch(SQLException e){
        System.out.println(e+"Error");
        conectar.cerrarConexion();
        return -1;
    }
        return 0;
}
public void productoStockBajo() throws JRException{
    conectar.conectar();
    
    String path = "C:\\Users\\Hp\\JaspersoftWorkspace\\MyReports\\StpckMinimo.jrxml";
            
            JasperReport jr;
    
    try{
        jr = JasperCompileManager.compileReport(path);
        JasperPrint mostrarReporte = JasperFillManager.fillReport
             (jr,null,conectar.conectar());
        
        JasperViewer.viewReport(mostrarReporte, false);
        
    }catch(JRException e){
        JOptionPane.showMessageDialog(null,e);
        System.out.println("Error"+e);
    }

}

 public int obtenerUltimoNumFactura() throws SQLException {
int numfac = 0;
ResultSet rs = null;
try {
//Llamada a procedimiento almacenado sin parámetros CallableStatement st conectar.conectar().
   CallableStatement st=conectar.conectar().
   prepareCall ( "{CALL obtenerUltimoIDFactura()}");
//Ejecución del procedimiento / obtención de datos
rs=st.executeQuery();
if (rs.next()) {
numfac=rs.getInt(1);

}
return numfac;
// conectar.cerrarConexion()
} catch (SQLException e) {
System.out.println("No se realizó la consulta:"+e.getMessage()); 
return 0;
}
 }
 public int actualizarStockProductos (Producto_metodos pro) throws SQLException {
try {
//Llamada a procedimiento almacenado con parámetros
CallableStatement st = conectar.conectar().
prepareCall ("{CALL actualizarStockProducto(?,?)}");
//Ejecución del procedimiento / obtención de datos
st.setInt(1,pro.getStock());
st.setInt(2, pro.getID_producto());
st.executeUpdate();
return 0;
//conectar.cerrarConexion();
} catch (SQLException e) {
System.out.println("No se realizó la consulta:"+e.getMessage());
return -1;
    }
}
 public int insertarDetalle(Venta_factura vent)throws SQLException{
        try{
            CallableStatement st =conectar.conectar().
                    prepareCall("{CALL insertarDetalleVenta(?,?,?,?)}");
            st.setInt(1, vent.getIDProducto());
            st.setInt(2, vent.getCantidad());
            st.setDouble(3, vent.getPrecioVenta());
            st.setInt(4, vent.getNumeroFactura());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e+"Error");
            conectar.cerrarConexion();
            return -1;
        }
       conectar.cerrarConexion();
       return 0;
    }

public void reporteFactura (int numFac) throws JRException{
//se debe pasar el número de factura como parámetro conectar.conectar();
String path="C:\\Users\\Hp\\JaspersoftWorkspace\\MyReports\\FActuraGrupo.jrxml";
JasperReport jr;
Map parametro=new HashMap(); //Mapea los parámetros
//Pasa el numero de factura al nombre de parámetro del reporte
//Parameterfumfact es el nombre del parámetro en el reporte
parametro.put("ParameterDistrib", numFac);
try {
jr=JasperCompileManager.compileReport(path); //se pasa el parámetro del reporte al mostrarlo
JasperPrint mostrarReporte=JasperFillManager.fillReport 
( jr,parametro,  conectar.conectar());
JasperViewer.viewReport ( mostrarReporte, false);
}catch (JRException e) {
JOptionPane.showMessageDialog
( null, e); 
System.out.println("Error "+e);
}

   }
   
   public void ProductosVendidos() throws JRException{
    conectar.conectar();
    
    String path = "C:\\Users\\Hp\\JaspersoftWorkspace\\MyReports\\UltimospructosVendios.jrxml";
            
            JasperReport jr;
    
    try{
        jr = JasperCompileManager.compileReport(path);
        JasperPrint mostrarReporte = JasperFillManager.fillReport
             (jr,null,conectar.conectar());
        
        JasperViewer.viewReport(mostrarReporte, false);
        
    }catch(JRException e){
        JOptionPane.showMessageDialog(null,e);
        System.out.println("Error"+e);
    }
}
    public void CantidadVendida() throws JRException{
    conectar.conectar();
    
    String path = "C:\\Users\\Hp\\JaspersoftWorkspace\\MyReports\\CantidadVendida.jrxml";
            
            JasperReport jr;
    
    try{
        jr = JasperCompileManager.compileReport(path);
        JasperPrint mostrarReporte = JasperFillManager.fillReport
             (jr,null,conectar.conectar());
        
        JasperViewer.viewReport(mostrarReporte, false);
        
    }catch(JRException e){
        JOptionPane.showMessageDialog(null,e);
        System.out.println("Error"+e);
    }
}
    public void IngresoTotal() throws JRException{
    conectar.conectar();
    
    String path = "C:\\Users\\Hp\\JaspersoftWorkspace\\MyReports\\IngresoTotal.jrxml"
            + "";
            
            JasperReport jr;
    
    try{
        jr = JasperCompileManager.compileReport(path);
        JasperPrint mostrarReporte = JasperFillManager.fillReport
             (jr,null,conectar.conectar());
        
        JasperViewer.viewReport(mostrarReporte, false);
        
    }catch(JRException e){
        JOptionPane.showMessageDialog(null,e);
        System.out.println("Error"+e);
    }
}
}



