
package ModeloD;

import java.sql.Date;


public class Venta_factura {
    int ID_Detalle;
    int IDCliente;
    int IDProducto;
    int Cantidad;
    int NumeroFactura;
    Date Fecha;
    Double precioVenta;
    Double subtotal; 
    Double total ;
    int Stock;
 

    public int getID_Detalle() {
        return ID_Detalle;
    }

    public void setID_Detalle(int ID_Detalle) {
        this.ID_Detalle = ID_Detalle;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

  

    public int getNumeroFactura() {
        return NumeroFactura;
    }

    public void setNumeroFactura(int NumeroFactura) {
        this.NumeroFactura = NumeroFactura;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

  

    public Venta_factura(int IDCliente, Date Fecha) {
        this.IDCliente = IDCliente;
        this.Fecha = Fecha;
    
    }

    public Venta_factura( int ID_Detalle, int IDCliente, Date Fecha, Double precioVenta, 
                Double subtotal, Double total, int Stock, int NumeroFactura, int IDProducto) {
     
        this.ID_Detalle = ID_Detalle;
        this.IDCliente = IDCliente;
        this.Fecha = Fecha;
        this.precioVenta = precioVenta;
        this.subtotal = subtotal;
        this.total = total;
        this.Stock = Stock;
        
        this.NumeroFactura = NumeroFactura;
        this.IDProducto = IDProducto;
        this.Cantidad = Cantidad;
    }

    public Venta_factura(int IDProducto, int Cantidad, int NumeroFactura, Double precioVenta) {
        this.IDProducto = IDProducto;
        this.Cantidad = Cantidad;
        this.NumeroFactura = NumeroFactura;
        this.precioVenta = precioVenta;
    } 
       }

  
    

    
    
     

