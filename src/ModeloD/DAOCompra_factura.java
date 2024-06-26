
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


public class DAOCompra_factura {
      ConexionBD conectar=ConexionBD.getInstance();
   
public int InsertarCompra( Compra_factura Ve) throws SQLException{
    try{ //Para manejar errores al realizar la conexion y transaccion BD
        
        //llama a proceo almacenado de SQLserver
        CallableStatement st=conectar.conectar().
               prepareCall("{CALL [insertarCompras](?,?)}");
             st.setInt(1, Ve.getID_Proveedores());
              st.setDate(2, (java.sql.Date) Ve.getFecha());
            
       
        st.executeUpdate();
       
    }catch(SQLException e){
        System.out.println(e+"Error");
        conectar.cerrarConexion();
        return -1;
    }
        return 0;
}

 public int insertarDetalle(Venta_factura vent)throws SQLException{
        try{
            CallableStatement st =conectar.conectar().
                    prepareCall("{CALL [insertarDetalleCompra](?,?,?,?)}");
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
 public int obtenerUltimoNumCompra() throws SQLException {
int numfac = 0;
ResultSet rs = null;
try {
//Llamada a procedimiento almacenado sin parámetros CallableStatement st conectar.conectar().
   CallableStatement st=conectar.conectar().
   prepareCall ( "{CALL obtenerUltimoIDCompra()}");
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
 public int insertarDetalleCompra(Compra_factura vent)throws SQLException{
        try{
            CallableStatement st =conectar.conectar(). 
                    prepareCall("{CALL insertarDetalleCompra(?,?,?,?)}");
            
             st.setInt(1, vent.getCantidad());
             st.setDouble(2, vent.getPrecioCompra());
             st.setInt(3, vent.getNumeroCompra());
             st.setInt(4, vent.getIDProducto());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e+"Error");
            conectar.cerrarConexion();
            return -1;
        }
       conectar.cerrarConexion();
       return 0;
    }
 public void reporteCompra (int numFac) throws JRException{
//se debe pasar el número de factura como parámetro conectar.conectar();
String path="C:\\Users\\Hp\\JaspersoftWorkspace\\MyReports\\VerCompraDistri.jrxml";
JasperReport jr;
Map parametro=new HashMap(); //Mapea los parámetros
//Pasa el numero de factura al nombre de parámetro del reporte
//Parameterfumfact es el nombre del parámetro en el reporte
parametro.put("VerCompra", numFac);
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
   }
    

