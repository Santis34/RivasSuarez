
package ModeloD;

import Modelo.conexion.ConexionBD;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataBase {
    //crear una instancia de conexion
    //Hace llamado al metodo getIntance
    ConexionBD conectar=ConexionBD.getInstance();
    
    public List Listar(String procedimiento) throws SQLException{
        ResultSet rs=null;
        //Arreglo de elementos en el que se almacenan los datos obtenidos de BD
        List resultado=new ArrayList();
        try{
            //Llama a procedimiento almacenado sin parametros
            CallableStatement st=conectar.conectar().
                    prepareCall ("{CALL "+procedimiento+"}");
            //Ejecucion del procedimiento / Obtencion de datos en Resulset
            rs=st.executeQuery();
            resultado=OrganizarDatos (rs); //Llama al metodo que Organiza datos
            
            //Conectar.cerrar conexion();
        }catch(SQLException e){
            System.out.println("No se realizo la consulta: "+e.getMessage());
                   
           }
        return resultado;
        }

    private List OrganizarDatos(ResultSet rs){
        List filas=new ArrayList(); // Arreglo de elementos
        try{
            
            int numColumnas=rs.getMetaData().getColumnCount();
            while (rs.next()){ //Recorre cada reguistro de la tabla
                Map<String, Object> renglon=new HashMap();
                for (int i=1; i<=numColumnas; i++){
                    //Se obtiene nombre de cada campo en la BD
                    String nombreCampo=rs.getMetaData().getColumnName(i);
                    Object valor=rs.getObject(nombreCampo);
                    //Por cada campo se obtiene el nombre y el valor del mismo
                    renglon.put(nombreCampo, valor);
                }
            filas.add(renglon);//se agrega al arreglo cada registro
        }
           
        } catch (SQLException e) {
            System.out.println(e+"Error");
        }
        return filas;
    }
        
}
    
    
        
  
