
package ModeloD;

import Modelo.conexion.ConexionBD;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DAOClientes {
     ConexionBD conectar=ConexionBD.getInstance();
   
    //Método para seleccionar todos los registros de la tabla
    public List ObtenerDatos() throws SQLException {
//Nombre del procedimiento almacenado
String proced = "listarClientes()";
//Llama a método Listar de DataBase java, se le pasa el nombre del proc.
List<Map> registros = new DataBase () .Listar ( proced) ;
List<Cliente> cliente = new ArrayList (); //Arreglo de Autores
//Ciclo que recorre cada registro y los agrega al arreglo Clientes
for (Map registro : registros) {
 Cliente cli = new Cliente ((int) registro.get ("ID_Cliente"),
         (String) registro.get("Nombre"),
           (String) registro.get("Apellido"),
         (String) registro.get("Tipo_Cliente"));
   cliente.add(cli);
   

}  
      return cliente; //Retorna todos los Clientes ubicados en la tabla de BD
    }  
public int Insertar( Cliente cli) throws SQLException{
    try{ //Para manejar errores al realizar la conexion y transaccion BD
        
        //llama a proceo almacenado de SQLserver
        CallableStatement st=conectar.conectar().
               prepareCall("{CALL insertarClientes(?,?,?)}");
        st.setString(1, cli.getNombre());
        st.setString(2, cli.getApellido());
        st.setString(3, cli.getTipo_Cliente());
   
        st.executeUpdate();
       
    }catch(SQLException e){
        System.out.println(e+"Error");
        conectar.cerrarConexion();
        return -1;
    }


conectar.cerrarConexion();
  return 0;   
}
public int Actualizar (Cliente Cli) throws SQLException {
   try{ //Para manejar errores al realizar la conexión y transacción en BD

CallableStatement st=conectar.conectar().
prepareCall ( "{CALL actualizarClientes(?,?,?,?)}");
st.setInt(1, Cli.getIDCliente());
st.setString(2,Cli.getNombre());
st.setString(3,Cli.getApellido());
st.setString(4,Cli.getTipo_Cliente());
st.executeUpdate();

}catch (SQLException e) {
System.out.println(e+" Error ");
conectar.cerrarConexion();
return -1;
}
conectar.cerrarConexion();
return 0;
}

 public java.util.List buscarCliente(String parametrobusqueda)throws SQLException{
        ResultSet rs=null;
        java.util.List<Map> registros=null;
        java.util.List<Cliente> clientes=new ArrayList();
        java.util.List resultado= new ArrayList();
        try{
            CallableStatement st =conectar.conectar().
                    prepareCall("{CALL buscarClientes(?)}");
            st.setString(1, parametrobusqueda);
           rs=st.executeQuery();
            resultado=OrganizarDatos(rs);
           registros = resultado;
           
           for (Map registro : registros) {
               
               Cliente  cli=new Cliente((int)registro.get("ID_Cliente"),
               (String)registro.get("Nombre"),
                        (String)registro.get("Apellido"),
                        (String)registro.get("Tipo_Cliente"));                   
                       clientes.add(cli);            
           }
                   
            
        }catch(SQLException e){
            System.out.println("No se a realizado la consulta:"+e.getMessage());
        }
        return clientes;
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
    public int Eliminar (int id) throws SQLException {
try{ //Para manejar errores al realizar la conexión y transacción en BD
CallableStatement st=conectar.conectar().
prepareCall ( "{CALL eliminarClientes(?)}");
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
}


  
     


    


    

