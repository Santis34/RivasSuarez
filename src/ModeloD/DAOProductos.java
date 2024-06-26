
package ModeloD;

import Modelo.conexion.ConexionBD;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAOProductos {
    //crear una instancia de conexion
    //Hace llamado al metodo getInstance
    ConexionBD conectar=ConexionBD.getInstance();
   
    //Método para seleccionar todos los registros de la tabla
public List ObtenerDatos() throws SQLException {
//Nombre del procedimiento almacenado
String proced = "listarProducto()";
//Llama a método Listar de DataBase java, se le pasa el nombre del proc.
List<Map> registros = new DataBase().Listar ( proced) ;
List<Producto_metodos> producto = new ArrayList (); //Arreglo de Autores
//Ciclo que recorre cada registro y los agrega al arreglo autores
for (Map registro : registros) {
 Producto_metodos pro = new Producto_metodos((int) registro.get ("ID_Producto"),
           (String) registro.get("Nombre"),
           (int) registro.get("Stock"),
           (Double) registro.get("PrecioCompra"),
           (Double) registro.get("PrecioVenta"),
 (int) registro.get ("ID_Categoria"));
    producto.add ( pro) ;
}
return producto; //Retorna todos los autores ubicados en la tabla de BD
  }  
public int Actualizar (Producto_metodos pro) throws SQLException {
   try{ //Para manejar errores al realizar la conexión y transacción en BD

CallableStatement st=conectar.conectar().
prepareCall ( "{CALL actualizarProducto(?,?,?,?,?,?)}");
st.setInt(1, pro.getID_producto());
st.setString(2,pro.getNombre());
st.setInt(3,pro.getStock());
st.setDouble(4,pro.getPrecioCompra());
st.setDouble(5,pro.getPrecioVenta());
st.setInt(6,pro.getID_Categoria());
st.executeUpdate();

}catch (SQLException e) {
System.out.println(e+" Error ");
conectar.cerrarConexion();
return -1;
}
conectar.cerrarConexion();
return 0;
}
    
public int Insertar(Producto_metodos pro) throws SQLException{
    try{ //Para manejar errores al realizar la conexion y transaccion BD
        
        //llama a proceo almacenado de SQLserver
        CallableStatement st=conectar.conectar().
               prepareCall("{CALL insertarProducto(?,?,?,?,?)}");
        st.setString(1, pro.getNombre());
        st.setInt(2, pro.getStock());
        st.setDouble(3, pro.getPrecioCompra());
        st.setDouble(4, pro.getPrecioVenta());
        st.setInt(5,pro.getID_Categoria());
        st.executeUpdate();
       
    }catch(SQLException e){
        System.out.println(e+"Error");
        conectar.cerrarConexion();
        return -1;
    }


conectar.cerrarConexion();
  return 0;   
}


//Método para eliminar un registro de la tabla en la BD
public int Eliminar (int id) throws SQLException {
try{ //Para manejar errores al realizar la conexión y transacción en BD
CallableStatement st=conectar.conectar().
prepareCall ( "{CALL eliminarProducto(?)}");
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
 public List busquedaProductos(String parametrobusqueda)throws  SQLException{
        ResultSet rs=null;
        List<Map> registros=null;
        List<Producto_metodos> productos =new ArrayList();
        List resultado=new ArrayList();
        
        try{
            CallableStatement st=conectar.conectar().
                    prepareCall("{CALL buscarProducto(?)}");
            
            st.setString(1, parametrobusqueda);
            rs=st.executeQuery();
            resultado=OrganizarDatos(rs);
            registros=resultado;
            
           for(Map registro : registros){
                Producto_metodos prod = new Producto_metodos((int)registro.get("ID_Producto"),   
                (String)registro.get("Nombre"),
                (int)registro.get("Stock"),
                (Double)registro.get("PrecioCompra"),
                (Double)registro.get("PrecioVenta"),
                (int)registro.get("ID_Categoria"));
              
                productos.add(prod);
            }
        }catch(SQLException e){
            System.out.println("No se a realizado la consulta:"+e.getMessage());
        }
        return productos;
    }
    private List OrganizarDatos(ResultSet rs){
        List filas=new ArrayList();
        try{
            int numcolumnas = rs.getMetaData().getColumnCount();
            while(rs.next()){
                Map<String,Object> renglon =new HashMap();
                for(int i=1; i<=numcolumnas; i++){
                    String nombrecampos=rs.getMetaData().getColumnName(i);
                    Object valor=rs.getObject(nombrecampos);
                    
                    renglon.put(nombrecampos, valor);
                            }
                filas.add(renglon);
            }
        }catch(SQLException e){
            System.out.println(e+"Error");
        }
        return filas;
    }
}









     


    

 

