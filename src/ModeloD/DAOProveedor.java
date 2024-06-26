
package ModeloD;

import Modelo.conexion.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DAOProveedor {
    //crear una instancia de conexion
    //Hace llamado al metodo getInstance
    ConexionBD conectar=ConexionBD.getInstance();
   
    //Método para seleccionar todos los registros de la tabla
public List ObtenerDatos() throws SQLException {
//Nombre del procedimiento almacenado
String proced = "listarProveedores()";
//Llama a método Listar de DataBase java, se le pasa el nombre del proc.
List<Map> registros = new DataBase () .Listar ( proced) ;
List<Proveedor> proveedor = new ArrayList (); //Arreglo de Autores
//Ciclo que recorre cada registro y los agrega al arreglo autores
for (Map registro : registros) {
  Proveedor prov = new Proveedor ((int) registro.get("ID_Proveedores"),
           (String) registro.get("Nombre"),
           (String) registro.get("Correo"),
           (String) registro.get("Direccion"),
           (String) registro.get("Telefono"));
    proveedor.add( prov);
}
return proveedor; //Retorna todos los autores ubicados en la tabla de BD
  }  
//Método para eliminar un registro de la tabla en la BD
public int Eliminar (int id) throws SQLException {
try{ //Para manejar errores al realizar la conexión y transacción en BD
CallableStatement st=conectar.conectar().
prepareCall ( "{CALL eliminarProveedores(?)}");
st.setInt(1, id);
st.executeUpdate();

}catch (SQLException e) {
System.out.println(e+" Error");
conectar.cerrarConexion();
return -1;
}
conectar.cerrarConexion();
return 0;
}


public int Actualizar ( Proveedor prov) throws SQLException {
   try{ //Para manejar errores al realizar la conexión y transacción en BD

CallableStatement st=conectar.conectar().
prepareCall ( "{CALL actualizarProveedores(?,?,?,?,?)}");
st.setInt(1, prov.getId_proveedor());
st.setString(2,prov.getNombreProveedor());
st.setString(3,prov.getCorreo());
st.setString(4,prov.getDireccion());
st.setString(5,prov.getTelefono());

st.executeUpdate();

}catch (SQLException e) {
System.out.println(e+" Error ");
conectar.cerrarConexion();
return -1;
}
conectar.cerrarConexion();
return 0;
}
    
public int Insertar(Proveedor prov) throws SQLException{
    try{ //Para manejar errores al realizar la conexion y transaccion BD
        
        //llama a proceo almacenado de SQLserver
        CallableStatement st=conectar.conectar().
               prepareCall("{CALL insertarProveedor(?,?,?,?)}");
        
        st.setString(1, prov.getNombreProveedor());
         st.setString(2, prov.getTelefono());
        st.setString(3, prov.getCorreo());
        st.setString(4, prov.getDireccion());
       
    
        st.executeUpdate();
       
    }catch(SQLException e){
        System.out.println(e+"Error");
        conectar.cerrarConexion();
        return -1;
    }


conectar.cerrarConexion();
  return 0;   
}

public java.util.List buscarProveedor(String parametrobusqueda)throws SQLException{
        ResultSet rs=null;
        java.util.List<Map> registros=null;
        java.util.List<Proveedor> proveedor=new ArrayList();
        java.util.List resultado= new ArrayList();
        try{
            CallableStatement st =conectar.conectar().
                    prepareCall("{CALL buscarProveedores(?)}");
            st.setString(1, parametrobusqueda);
           rs=st.executeQuery();
            resultado=OrganizarDatos(rs);
           registros = resultado;
           
           for (Map registro : registros) {
               
               Proveedor pro=new Proveedor((int)registro.get("ID_Proveedores"),
                  (String)registro.get("Nombre"),
                        (String)registro.get("Correo"),
                        (String)registro.get("Direccion"), 
                         (String)registro.get("Telefono")); 
                       proveedor.add(pro);            
           }
                   
            
        }catch(SQLException e){
            System.out.println("No se a realizado la consulta:"+e.getMessage());
        }
        return proveedor;
    }
     
    private java.util.List OrganizarDatos(ResultSet rs){
        java.util.List filas=new ArrayList();
        try{
            int numcolumnas = rs.getMetaData().getColumnCount();
            while (rs.next()){
                Map<String , Object> renglon=new HashMap();
                for(int i=1; i<=numcolumnas; i++){
                   String nombreCampo=rs.getMetaData().getColumnName(i);
                   Object valor=rs.getObject(nombreCampo);
                   
                   renglon.put(nombreCampo,valor);
                }
                filas.add(renglon);
            }
        }catch(SQLException e){
            System.out.println(e+"Error");
        }
        return filas;
    }


}





     


    



  


     

