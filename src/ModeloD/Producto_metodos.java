
package ModeloD;


public class Producto_metodos {
    private int ID_producto;
    private String Nombre;
    private int Stock;
    private double PrecioCompra;
    private double precioVenta;
    private int ID_Categoria;

    public Producto_metodos(int ID_producto, int Stock) {
        this.ID_producto = ID_producto;
        this.Stock = Stock;
    }
    public int getID_producto() {
        return ID_producto;
    }

    public void setID_producto(int ID_producto) {
        this.ID_producto = ID_producto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public double getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(double PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getID_Categoria() {
        return ID_Categoria;
    }

    public void setID_Categoria(int ID_Categoria) {
        this.ID_Categoria = ID_Categoria;
    }

    public Producto_metodos(String Nombre, int Stock, double PrecioCompra, double precioVenta, int ID_Categoria) {
        this.Nombre = Nombre;
        this.Stock = Stock;
        this.PrecioCompra = PrecioCompra;
        this.precioVenta = precioVenta;
        this.ID_Categoria = ID_Categoria;
    }

    public Producto_metodos(int ID_producto, String Nombre, int Stock, double PrecioCompra, double precioVenta, int ID_Categoria) {
        this.ID_producto = ID_producto;
        this.Nombre = Nombre;
        this.Stock = Stock;
        this.PrecioCompra = PrecioCompra;
        this.precioVenta = precioVenta;
        this.ID_Categoria = ID_Categoria;
    }

}