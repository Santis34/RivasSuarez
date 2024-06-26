
package ModeloD;

import java.util.Date;


public class Compra_factura {
     private int NumeroCompra;
     private int ID_Proveedores;
     private Date Fecha;
     int Cantidad;
     double PrecioCompra;
     int IDProducto;

    public int getNumeroCompra() {
        return NumeroCompra;
    }

    public void setNumeroCompra(int NumeroCompra) {
        this.NumeroCompra = NumeroCompra;
    }

    public int getID_Proveedores() {
        return ID_Proveedores;
    }

    public void setID_Proveedores(int ID_Proveedores) {
        this.ID_Proveedores = ID_Proveedores;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(float PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    public Compra_factura(int ID_Proveedores, Date Fecha, String UnidadMedida, int Cantidad, double PrecioCompra, int IDProducto) {
        this.ID_Proveedores = ID_Proveedores;
        this.Fecha = Fecha;
        this.Cantidad = Cantidad;
        this.PrecioCompra = PrecioCompra;
        this.IDProducto = IDProducto;
    }


    public Compra_factura(int ID_Proveedores, Date Fecha) {
        this.ID_Proveedores = ID_Proveedores;
        this.Fecha = Fecha;
    }

    public Compra_factura(int NumeroCompra, int Cantidad, double PrecioCompra, int IDProducto) {
        this.NumeroCompra = NumeroCompra;
        this.Cantidad = Cantidad;
        this.PrecioCompra = PrecioCompra;
        this.IDProducto = IDProducto;
    }

   
    }

  
    
