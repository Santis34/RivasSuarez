
package ModeloD;

import Modelo.conexion.ConexionBD;
import ModeloD.Categoria;
import com.sun.jdi.connect.spi.Connection;
import java.sql.Statement;
import java.sql. ResultSet ;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DAOCategoria {
  //crear una instancia de conexion
   //Hace llamado al metodo getInstance
    ConexionBD conectar=ConexionBD.getInstance();

    //Método para seleccionar todos los registros de la tabla   
                
    //Método para seleccionar todos los registros de la tabla
public List ObtenerDatos() throws SQLException {
//Nombre del procedimiento almacenado
String proced = "listarCategoria()";
//Llama a método Listar de DataBase java, se le pasa el nombre del proc.
List<Map> registros = new DataBase () .Listar ( proced) ;
List<Categoria> categoria = new ArrayList (); //Arreglo de Autores
//Ciclo que recorre cada registro y los agrega al arreglo autores
for (Map registro : registros) {
 Categoria Cat = new Categoria((int) registro.get("ID_Categoria"),
           (String) registro.get("NombreCategoria"));
           
    categoria.add ( Cat) ;
}
return categoria; //Retorna todos los autores ubicados en la tabla de BD
  }  

public int Insertar(Categoria ca) throws SQLException{
    try{ //Para manejar errores al realizar la conexion y transaccion BD
        
        //llama a proceo almacenado de SQLserver
        CallableStatement st=conectar.conectar().
               prepareCall("{CALL insertarCategoria(?)}");
        st.setString(1, ca.getNombreCategoria());
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
prepareCall ( "{CALL eliminarCategoria(?)}");
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

public int Actualizar (Categoria Cat) throws SQLException {
   try{ //Para manejar errores al realizar la conexión y transacción en BD

CallableStatement st=conectar.conectar().
prepareCall ( "{CALL actualizarCategoria(?,?)}");
st.setInt(1, Cat.getId_Categoria());
st.setString(2,Cat.getNombreCategoria());

st.executeUpdate();

}catch (SQLException e) {
System.out.println(e+" Error ");
conectar.cerrarConexion();
return -1;
}
conectar.cerrarConexion();
return 0;
}
}




