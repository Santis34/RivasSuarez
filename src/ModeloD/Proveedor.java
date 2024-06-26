
package ModeloD;



public class Proveedor {
    private int id_proveedor;
    private String nombreProveedor;
    private String Correo;
    private String direccion;
    private String telefono;

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Proveedor(int id_proveedor, String nombreProveedor, String Correo, String direccion, String telefono) {
        this.id_proveedor = id_proveedor;
        this.nombreProveedor = nombreProveedor;
        this.Correo = Correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Proveedor(String nombreProveedor, String Correo, String direccion, String telefono) {
        this.nombreProveedor = nombreProveedor;
        this.Correo = Correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

}