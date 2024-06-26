
package ModeloD;


public class Cliente {

    private int IDCliente;
    private String Nombre;
    private String Apellido;
    private String Tipo_Cliente;

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTipo_Cliente() {
        return Tipo_Cliente;
    }

    public void setTipo_Cliente(String TipoCliente) {
        this.Tipo_Cliente = TipoCliente;
    }

    public Cliente(String Nombre, String Apellido, String Tipo_Cliente) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Tipo_Cliente = Tipo_Cliente;
    }

    public Cliente(int IDCliente, String Nombre, String Apellido, String Tipo_Cliente) {
        this.IDCliente = IDCliente;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Tipo_Cliente = Tipo_Cliente;
    }

}