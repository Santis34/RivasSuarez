package Vista;

import Controlador._principal;
import ModeloD.Categoria;
import ModeloD.Cliente;
import ModeloD.DAOCategoria;
import ModeloD.DAOClientes;
import ModeloD.DAOCompra_factura;
import ModeloD.DAOProductos;
import ModeloD.DAOProveedor;
import ModeloD.DAOVenta_factura;
import ModeloD.Producto_metodos;
import ModeloD.Venta_factura;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

public class jFrameVentaFactura extends javax.swing.JFrame {
 //static Calendar Hora = Calendar.getInstance();
   // static Calendar Fecha = Calendar.getInstance();

    private DefaultTableModel ModeloTableventa;
    private Object[] ObjectoventaTable = new Object[6];
    private Double total = 0.0;
    private int item = 0;
    private java.sql.Date fech;
    private int numFac = 0;
    private int Cantidad = 0;
    private int IDproducto;

    public jFrameVentaFactura() throws SQLException {
        initComponents();

        idCliente.setEnabled(true);

        fech = java.sql.Date.valueOf(LocalDate.now());
        jLabelFechas.setText(fech.toString());
         //        int dia, mes, año, hora, minutos, segundos;
        //dia = Fecha.get(Calendar.DATE);
       // hora = Fecha.get(Calendar.HOUR);
       // minutos = Fecha.get(Calendar.MINUTE);
        //segundos = Fecha.get(Calendar.SECOND);
       // FechaActual = año + "-" + (mes + 1) + "-" + dia;
       // HoraActual = hora + ":" + (minutos) + ":" + segundos;
     //   String fecha = (FechaActual + " - " + HoraActual);
      //  jLabelFechas.setText(fecha);
        

        jTextCantidad.setText("0");
        jTextIDProducto.setText("0");
        jDialogCliente.setLocationRelativeTo(null);
        jDialogProducto.setLocationRelativeTo(null);
        jTextIDCliente.setEnabled(false);
        jTextNombreClientes.setEnabled(false);

       

        ModeloTableventa = (DefaultTableModel) jTableVentaDetalle.getModel();
    }



    public void limpiarVenta() {
        jTextidVenta.setText("");
        idCliente.setText("");
        jTextCantidad.setText("0");

    

}
    

    private void BuscarClientes(String dato) throws SQLException {
        List<Cliente> clientes = new DAOClientes().buscarCliente(dato);
        DefaultTableModel modelo = new DefaultTableModel();

        String[] columnas = {"IDCliente", "Nombre", "Apellido",
            "TipoCliente"};

        modelo.setColumnIdentifiers(columnas);
        for (Cliente cli : clientes) {
            String[] renglon = {Integer.toString(cli.getIDCliente()),
                cli.getNombre(), cli.getApellido(), cli.getTipo_Cliente()};
            modelo.addRow(renglon);
        }
        jTaBuscaClientes.setModel(modelo);
    }

    private void buscarProducto(String dato) throws SQLException {
        List<Producto_metodos> productos = new DAOProductos().busquedaProductos(dato);
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"IDProducto", "Descripcion",
            "Precio", "Stock"};

        modelo.setColumnIdentifiers(columnas);
        for (Producto_metodos pro : productos) {
            String[] renglon = {Integer.toString(pro.getID_producto()),
                pro.getNombre(),
                Double.toString(pro.getPrecioVenta()),
                Integer.toString(pro.getStock())};

            modelo.addRow(renglon);
        }
        jTBuscaProducto.setModel(modelo);
    }

    private void limpiarCampos() {
        PrecioVenta.setText("0");
        jTextstock.setText("0");

    }


    public void guardarventa() throws SQLException {
        int IDcliente;

        if (jTextIDCliente.getText().contentEquals("")
                || jLabelFechas.getText().contentEquals("")){

            JOptionPane.showMessageDialog(rootPane,
                    "Se requieren datos del cliente y productos,"
                    + "fecha y forma de pago");

        } else {
            try{
                IDcliente = Integer.parseInt(jTextIDCliente.getText());
                Venta_factura vent = new Venta_factura( IDcliente, fech);

                DAOVenta_factura daoventa = new DAOVenta_factura();

                if (daoventa.Insertar(vent) == 0) {
                    JOptionPane.showMessageDialog(rootPane,
                            "Registro agregado en venta");

                    numFac = daoventa.obtenerUltimoNumFactura();

                } else {
                    JOptionPane.showMessageDialog(rootPane,
                            "Ha ocurrido un error, no se inserto en venta");
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(rootPane,
                        "No se agregaron los registros" + e);
            }
            JOptionPane.showMessageDialog(rootPane,
                    "Registro listo para agregar en factura " + numFac);

            guardarDetalleventa();

            actualizarStock();
            }
        }


    public void guardarDetalleventa() throws SQLException {

        double precio;

        if (numFac == 0 || jTableVentaDetalle.getRowCount() == 0) {
            JOptionPane.showMessageDialog(rootPane,
                    "No se ha obtenido numero de factura o "
                    + "no tiene productos añadidos para vender");
        } else {
            for (int i = 0; i < jTableVentaDetalle.getRowCount(); i++) {
                IDproducto = Integer.parseInt(jTableVentaDetalle.
                        getValueAt(i, 1).toString());
                Cantidad = Integer.parseInt(jTableVentaDetalle.
                        getValueAt(i, 3).toString());
                precio = Double.parseDouble(jTableVentaDetalle.
                        getValueAt(i, 4).toString());

                Venta_factura venta = new Venta_factura(IDproducto, Cantidad, numFac, precio);

                DAOVenta_factura dao = new DAOVenta_factura();

                if (dao.insertarDetalle(venta) == 0) {
                    JOptionPane.showMessageDialog(rootPane,
                            "Registro agregado en Detalle venta");
                } else {
                    JOptionPane.showMessageDialog(rootPane,
                            "Ha ocurrido un error, no se inserto Detalle venta");
                }
            }
        }
}

    public void actualizarStock() {
        int existenciActual;
        int nuevaExistencia;

        for (int i = 0; i < jTableVentaDetalle.getRowCount(); i++) {
            IDproducto = Integer.parseInt(jTableVentaDetalle.
                    getValueAt(i, 1).toString());
            Cantidad = Integer.parseInt(jTableVentaDetalle.
                    getValueAt(i, 3).toString());

            DAOProductos daopro = new DAOProductos();
            try {
                List<Producto_metodos> p = daopro.busquedaProductos(String.valueOf(IDproducto).toString());
                existenciActual = p.get(0).getStock();
                nuevaExistencia = existenciActual - Cantidad;
                Producto_metodos pro = new Producto_metodos(IDproducto, nuevaExistencia);
                DAOVenta_factura dAOventa = new DAOVenta_factura();

                if (dAOventa.actualizarStockProductos(pro) == 0) {
                    JOptionPane.showMessageDialog(rootPane,
                            "Stock actualizado");
                }
            } catch (SQLException ex) {
                Logger.getLogger(jFrameVentaFactura.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
}

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTableVenta2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListadoVenta1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextApellido5 = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextApellido2 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextApellido6 = new javax.swing.JFormattedTextField();
        jTextApellido4 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        Capturar = new javax.swing.JButton();
        jCalendar3 = new com.toedter.calendar.JCalendar();
        jTextApellido7 = new javax.swing.JFormattedTextField();
        jButton26 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        idCliente1 = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        capturar1 = new javax.swing.JLabel();
        jTextFechas1 = new javax.swing.JFormattedTextField();
        jTextApellido30 = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextidVenta1 = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextFechas = new javax.swing.JFormattedTextField();
        jEditar1 = new javax.swing.JButton();
        jTextApellido31 = new javax.swing.JFormattedTextField();
        jTextApellido32 = new javax.swing.JFormattedTextField();
        jTextApellido29 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListadoVenta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        capturar = new javax.swing.JLabel();
        idCliente = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextidVenta = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jAgregarVenta = new javax.swing.JButton();
        jEditar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTextApellido9 = new javax.swing.JFormattedTextField();
        jTextApellido35 = new javax.swing.JFormattedTextField();
        jButton28 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextApellido10 = new javax.swing.JFormattedTextField();
        jButton29 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jTextApellido11 = new javax.swing.JFormattedTextField();
        jTextApellido37 = new javax.swing.JFormattedTextField();
        jTextApellido38 = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextApellido12 = new javax.swing.JFormattedTextField();
        jLabel26 = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableVenta3 = new javax.swing.JTable();
        jTextApellido36 = new javax.swing.JFormattedTextField();
        jTextApellido3 = new javax.swing.JFormattedTextField();
        jTextApellido33 = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Stock = new javax.swing.JTextField();
        Cantidad1 = new javax.swing.JTextField();
        Cantidad2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jDialogCliente = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        buscarClientes = new javax.swing.JTextField();
        jBAñadirClientes = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTaBuscaClientes = new javax.swing.JTable();
        jDialogBuscarCliente = new javax.swing.JButton();
        jDialogProducto = new javax.swing.JDialog();
        jPanel12 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jBbuscarProducto = new javax.swing.JTextField();
        jBañadirProducto = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTBuscaProducto = new javax.swing.JTable();
        jDialogBuscarProducto = new javax.swing.JButton();
        jDialogBusClientes1 = new javax.swing.JButton();
        jDialogBusClientes = new javax.swing.JButton();
        CantidadPrd = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelFechas = new javax.swing.JLabel();
        jLFe = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jBAñadirDeta = new javax.swing.JButton();
        jBQuitarDeta = new javax.swing.JButton();
        PrecioVenta = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextstock = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextCantidad = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jTextBProducto = new javax.swing.JFormattedTextField();
        jTextIDProducto = new javax.swing.JFormattedTextField();
        jBBuscarProducto = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jTextNombreClientes = new javax.swing.JFormattedTextField();
        jTextIDCliente = new javax.swing.JFormattedTextField();
        jBBuscarCliente = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVentaDetalle = new javax.swing.JTable();
        jBGuardar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jModoPago = new javax.swing.JLabel();
        jTotal = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jTableVenta2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTableVenta2);

        ListadoVenta1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane3.setViewportView(ListadoVenta1);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 153, 255));
        jLabel13.setText("DetalleVenta");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setText("ListadoVenta");

        jTextApellido5.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido5ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Precio unitario");

        jTextApellido2.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Total");

        jTextApellido6.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido6ActionPerformed(evt);
            }
        });

        jTextApellido4.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido4ActionPerformed(evt);
            }
        });

        jLabel4.setText("Datos Venta");

        Capturar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CapturarMouseClicked(evt);
            }
        });
        Capturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapturarActionPerformed(evt);
            }
        });

        jTextApellido7.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido7ActionPerformed(evt);
            }
        });

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jButton26.setText("Buscar");

        jLabel17.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 204));
        jLabel17.setText("Datos venta");

        idCliente1.setBackground(new java.awt.Color(204, 204, 204));
        idCliente1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        idCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCliente1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 204));
        jLabel18.setText("Cliente ID");

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 204));
        jLabel15.setText("Fecha");

        capturar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        capturar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                capturar1MouseClicked(evt);
            }
        });

        jTextFechas1.setBackground(new java.awt.Color(204, 204, 204));
        jTextFechas1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextFechas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFechas1MouseClicked(evt);
            }
        });
        jTextFechas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFechas1ActionPerformed(evt);
            }
        });
        jTextFechas1.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jTextFechas1VetoableChange(evt);
            }
        });

        jTextApellido30.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido30.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido30ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 204));
        jLabel16.setText("Venta ID");

        jTextidVenta1.setBackground(new java.awt.Color(204, 204, 204));
        jTextidVenta1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextidVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextidVenta1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel18.setBackground(new java.awt.Color(143, 192, 240));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transacciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft JhengHei Light", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 204));
        jLabel20.setText("Datos venta");

        jLabel22.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 204));
        jLabel22.setText("Datos Cliente");

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 204));
        jLabel14.setText("Datos Cliente");

        jLabel23.setText("jLabel23");

        jTextFechas.setBackground(new java.awt.Color(204, 204, 204));
        jTextFechas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextFechas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFechasMouseClicked(evt);
            }
        });
        jTextFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFechasActionPerformed(evt);
            }
        });
        jTextFechas.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jTextFechasVetoableChange(evt);
            }
        });

        jEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        jEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditar1ActionPerformed(evt);
            }
        });

        jTextApellido31.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido31.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido31ActionPerformed(evt);
            }
        });

        jTextApellido32.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido32.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido32ActionPerformed(evt);
            }
        });

        jTextApellido29.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido29.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido29ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jButton1.setText("Realizar venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ListadoVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(ListadoVenta);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("ListadoVenta");

        capturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        capturar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                capturarMouseClicked(evt);
            }
        });

        idCliente.setBackground(new java.awt.Color(204, 204, 204));
        idCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        idCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idClienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Cliente ID");

        jTextidVenta.setBackground(new java.awt.Color(204, 204, 204));
        jTextidVenta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextidVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextidVentaActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 204));
        jLabel19.setText("Venta ID");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/procesamiento-de-datos.png"))); // NOI18N

        jButton7.setText("Actualizar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        jPanel2.setBackground(new java.awt.Color(135, 189, 243));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 255));
        jLabel7.setText("DetalleVenta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel7)
                .addContainerGap(901, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(279, 279, 279))
        );

        jPanel4.setBackground(new java.awt.Color(135, 189, 243));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transacciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jAgregarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-usuario.png"))); // NOI18N
        jAgregarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgregarVentaActionPerformed(evt);
            }
        });
        jPanel4.add(jAgregarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 200, 30));

        jEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        jEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarActionPerformed(evt);
            }
        });
        jPanel4.add(jEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 60, 30));

        jButton2.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jButton2.setText("Realizar venta");
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, 30));

        jPanel5.setBackground(new java.awt.Color(135, 189, 243));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextApellido9.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido9ActionPerformed(evt);
            }
        });

        jTextApellido35.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido35.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido35ActionPerformed(evt);
            }
        });

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jButton28.setText("Buscar");

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 204));
        jLabel24.setText(" ID");

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 204));
        jLabel25.setText(" ID");

        jTextApellido10.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido10ActionPerformed(evt);
            }
        });

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jButton29.setText("Buscar");

        jPanel6.setBackground(new java.awt.Color(135, 189, 243));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextApellido11.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido11ActionPerformed(evt);
            }
        });

        jTextApellido37.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido37.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido37ActionPerformed(evt);
            }
        });

        jTextApellido38.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido38.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido38ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 204));
        jLabel27.setText(" ID");

        jTextApellido12.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido12ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 204));
        jLabel26.setText(" ID");

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jButton31.setText("Buscar");

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jButton30.setText("Buscar");

        jTableVenta3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTableVenta3);

        jTextApellido36.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido36.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido36ActionPerformed(evt);
            }
        });

        jTextApellido3.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido3ActionPerformed(evt);
            }
        });

        jTextApellido33.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido33.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido33ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 204));
        jLabel21.setText(" ID");

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jButton25.setText("Buscar");

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText(" ID");

        Stock.setText("jTextField2");

        jLabel31.setText("jLabel31");

        jLabel32.setText("jLabel32");

        jDialogCliente.setSize(new java.awt.Dimension(705, 560));

        jPanel11.setBackground(new java.awt.Color(153, 204, 255));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(85, 186, 232));
        jLabel35.setText("Buscar Clientes");

        jBAñadirClientes.setText("Añadir");
        jBAñadirClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAñadirClientesActionPerformed(evt);
            }
        });

        jTaBuscaClientes.setBackground(new java.awt.Color(117, 184, 255));
        jTaBuscaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IDCliente", "Nombre", "Apellido", "TipoCliente"
            }
        ));
        jScrollPane6.setViewportView(jTaBuscaClientes);

        jDialogBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jDialogBuscarCliente.setText("Buscar");
        jDialogBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDialogBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(buscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jDialogBuscarCliente)
                        .addGap(35, 35, 35)
                        .addComponent(jBAñadirClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(690, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAñadirClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDialogBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogClienteLayout = new javax.swing.GroupLayout(jDialogCliente.getContentPane());
        jDialogCliente.getContentPane().setLayout(jDialogClienteLayout);
        jDialogClienteLayout.setHorizontalGroup(
            jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialogClienteLayout.setVerticalGroup(
            jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialogProducto.setSize(new java.awt.Dimension(705, 560));

        jPanel12.setBackground(new java.awt.Color(153, 204, 255));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(85, 186, 232));
        jLabel36.setText("Buscar Producto");

        jBañadirProducto.setText("Añadir");
        jBañadirProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBañadirProductoActionPerformed(evt);
            }
        });

        jTBuscaProducto.setBackground(new java.awt.Color(117, 184, 255));
        jTBuscaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IDProducto", "Descripcion", "Descripcion", "Stock"
            }
        ));
        jScrollPane7.setViewportView(jTBuscaProducto);

        jDialogBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jDialogBuscarProducto.setText("Buscar");
        jDialogBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDialogBuscarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel36)
                        .addGap(29, 29, 29)
                        .addComponent(jBbuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jDialogBuscarProducto)
                        .addGap(39, 39, 39)
                        .addComponent(jBañadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(666, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBbuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBañadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDialogBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogProductoLayout = new javax.swing.GroupLayout(jDialogProducto.getContentPane());
        jDialogProducto.getContentPane().setLayout(jDialogProductoLayout);
        jDialogProductoLayout.setHorizontalGroup(
            jDialogProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialogProductoLayout.setVerticalGroup(
            jDialogProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialogBusClientes1.setText("Buscar");
        jDialogBusClientes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDialogBusClientes1ActionPerformed(evt);
            }
        });

        jDialogBusClientes.setText("Buscar");
        jDialogBusClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDialogBusClientesActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 500));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Venta factura");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/punto-de-venta.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresa.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabelFechas.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabelFechas.setForeground(new java.awt.Color(0, 51, 255));
        jPanel1.add(jLabelFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 110, 220, 20));

        jLFe.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLFe.setForeground(new java.awt.Color(25, 91, 189));
        jLFe.setText("Fecha:");
        jPanel1.add(jLFe, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 110, 50, 20));

        jPanel7.setBackground(new java.awt.Color(108, 165, 228));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de producto", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(25, 91, 189))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBAñadirDeta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBAñadirDeta.setForeground(new java.awt.Color(51, 153, 255));
        jBAñadirDeta.setText("Añadir");
        jBAñadirDeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAñadirDetaActionPerformed(evt);
            }
        });
        jPanel7.add(jBAñadirDeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 340, 90, 30));

        jBQuitarDeta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBQuitarDeta.setForeground(new java.awt.Color(51, 153, 255));
        jBQuitarDeta.setText("Quitar");
        jBQuitarDeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitarDetaActionPerformed(evt);
            }
        });
        jPanel7.add(jBQuitarDeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 90, 30));

        PrecioVenta.setBackground(new java.awt.Color(166, 189, 210));
        jPanel7.add(PrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 180, 30));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(25, 91, 189));
        jLabel30.setText("Cantidad");
        jPanel7.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 60, 30));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(25, 91, 189));
        jLabel34.setText("PrecioVenta");
        jPanel7.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 90, 30));

        jTextstock.setBackground(new java.awt.Color(166, 189, 210));
        jPanel7.add(jTextstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 180, 30));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(25, 91, 189));
        jLabel33.setText("Stock");
        jPanel7.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 90, 30));

        jTextCantidad.setBackground(new java.awt.Color(166, 189, 210));
        jPanel7.add(jTextCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 180, 30));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 350, 510));

        jPanel10.setBackground(new java.awt.Color(108, 165, 228));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(108, 165, 228));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " producto", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(25, 91, 189))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextBProducto.setBackground(new java.awt.Color(166, 189, 210));
        jTextBProducto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 153, 255)));
        jTextBProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBProductoActionPerformed(evt);
            }
        });
        jPanel9.add(jTextBProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 270, 30));

        jTextIDProducto.setBackground(new java.awt.Color(166, 189, 210));
        jTextIDProducto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 139, 224)));
        jTextIDProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIDProductoActionPerformed(evt);
            }
        });
        jPanel9.add(jTextIDProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 50, 30));

        jBBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jBBuscarProducto.setText("Buscar");
        jBBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarProductoActionPerformed(evt);
            }
        });
        jPanel9.add(jBBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 110, -1));

        jLabel28.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(25, 91, 189));
        jLabel28.setText(" ID");
        jPanel9.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 20, -1));

        jPanel10.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 650, 80));

        jPanel8.setBackground(new java.awt.Color(108, 165, 228));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " cliente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(25, 91, 189))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextNombreClientes.setBackground(new java.awt.Color(166, 189, 210));
        jTextNombreClientes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 153, 255)));
        jTextNombreClientes.setForeground(new java.awt.Color(0, 0, 204));
        jTextNombreClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreClientesActionPerformed(evt);
            }
        });
        jPanel8.add(jTextNombreClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 270, 30));

        jTextIDCliente.setBackground(new java.awt.Color(166, 189, 210));
        jTextIDCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(53, 139, 224)));
        jTextIDCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIDClienteActionPerformed(evt);
            }
        });
        jPanel8.add(jTextIDCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 50, 28));

        jBBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jBBuscarCliente.setText("Buscar");
        jBBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarClienteActionPerformed(evt);
            }
        });
        jPanel8.add(jBBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 110, -1));

        jLabel29.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(25, 91, 189));
        jLabel29.setText(" ID");
        jPanel8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 20, -1));

        jPanel10.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 650, 80));

        jTableVentaDetalle.setAutoCreateRowSorter(true);
        jTableVentaDetalle.setBackground(new java.awt.Color(117, 184, 255));
        jTableVentaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "ID producto", "Producto ", "Cantidad", "Precio", "SubTotal"
            }
        ));
        jScrollPane2.setViewportView(jTableVentaDetalle);

        jPanel10.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 770, 180));

        jBGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBGuardar.setForeground(new java.awt.Color(51, 153, 255));
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPanel10.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 90, 30));

        jBCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBCancelar.setForeground(new java.awt.Color(51, 153, 255));
        jBCancelar.setText("Cancelar");
        jPanel10.add(jBCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, 90, 30));

        jModoPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jModoPago.setForeground(new java.awt.Color(0, 51, 255));
        jModoPago.setText("Total:");
        jPanel10.add(jModoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, -1, -1));

        jTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTotal.setForeground(new java.awt.Color(0, 102, 255));
        jPanel10.add(jTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, 90, 20));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 153, 255));
        jButton3.setText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 100, 30));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 830, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idClienteActionPerformed

    private void jTextidVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextidVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextidVentaActionPerformed

    private void jTextApellido3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido3ActionPerformed

    private void jAgregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgregarVentaActionPerformed
//Captu

        // Agregar validacines a cajas de texto segun fromato y

    }//GEN-LAST:event_jAgregarVentaActionPerformed

    private void jEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditarActionPerformed

    }//GEN-LAST:event_jEditarActionPerformed

    private void jTextApellido29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido29ActionPerformed

    private void jTextFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFechasActionPerformed
     
    }//GEN-LAST:event_jTextFechasActionPerformed

    private void jTextFechasVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jTextFechasVetoableChange

    }//GEN-LAST:event_jTextFechasVetoableChange

    private void jTextFechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFechasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFechasMouseClicked

    private void capturarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capturarMouseClicked


    }//GEN-LAST:event_capturarMouseClicked

    private void jTextFechas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFechas1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFechas1MouseClicked

    private void jTextFechas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFechas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFechas1ActionPerformed

    private void jTextFechas1VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jTextFechas1VetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFechas1VetoableChange

    private void jTextApellido30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido30ActionPerformed

    private void capturar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capturar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_capturar1MouseClicked

    private void idCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCliente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idCliente1ActionPerformed

    private void jTextidVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextidVenta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextidVenta1ActionPerformed

    private void jTextApellido31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido31ActionPerformed

    private void jTextApellido32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido32ActionPerformed

    private void jTextApellido33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido33ActionPerformed

    private void jTextBProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextBProductoActionPerformed

    private void jTextIDProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIDProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIDProductoActionPerformed

    private void jEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEditar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextApellido9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido9ActionPerformed

    private void jTextApellido35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido35ActionPerformed

    private void jTextApellido36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido36ActionPerformed

    private void jTextApellido10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido10ActionPerformed

    private void jTextApellido11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido11ActionPerformed

    private void jTextApellido12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido12ActionPerformed

    private void jTextApellido37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido37ActionPerformed

    private void jTextApellido38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido38ActionPerformed

    private void jTextNombreClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreClientesActionPerformed

    private void jTextIDClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIDClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIDClienteActionPerformed

    private void jDialogBusClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDialogBusClientesActionPerformed

    }//GEN-LAST:event_jDialogBusClientesActionPerformed

    private void jBAñadirClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAñadirClientesActionPerformed
        int fila = this.jTaBuscaClientes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Seleccione un registro de la tabla");
        } else {
            try {
                int id = Integer.parseInt((String) this.jTaBuscaClientes.
                        getValueAt(fila, 0).toString());
                String nom = (String) this.jTaBuscaClientes.getValueAt(fila, 1);
                String ape = (String) this.jTaBuscaClientes.getValueAt(fila, 2);
                String TipoCli = (String) this.jTaBuscaClientes.getValueAt(fila, 3);

                jTextIDCliente.setText("" + id);
                jTextNombreClientes.setText(nom + "" + ape);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane,
                        "Ocurrio un Error!" + e.getMessage());
            }
        }

    }//GEN-LAST:event_jBAñadirClientesActionPerformed

    private void jBBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarClienteActionPerformed
        jDialogCliente.setVisible(true);
    }//GEN-LAST:event_jBBuscarClienteActionPerformed

    private void jDialogBusClientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDialogBusClientes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDialogBusClientes1ActionPerformed

    private void jBañadirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBañadirProductoActionPerformed
        int fila = this.jTBuscaProducto.getSelectedRow();// obtiene la fila seleccionado
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Seleccione un registro de la tabia");
        } else {//Be toma cada campo de la tabla del registro seinccionado

            try {
                int id = Integer.parseInt((String) this.jTBuscaProducto.
                        getValueAt(fila, 0).toString());
                String nom = (String) this.jTBuscaProducto.getValueAt(fila, 1);
                double preV = Double.parseDouble((String) this.jTBuscaProducto.
                        getValueAt(fila, 2).toString());
                int stock = Integer.parseInt((String) this.jTBuscaProducto.
                        getValueAt(fila, 3).toString());
//Se ubican en las cajas de textos los datos capturados de la tabla productos
                jTextIDProducto.setText("" + id);
                jTextBProducto.setText(nom);
                PrecioVenta.setText("" + preV);
                jTextstock.setText("" + stock);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "Ocurrió un ERROR! " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jBañadirProductoActionPerformed

    private void jBBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarProductoActionPerformed
        jDialogProducto.setVisible(true);
    }//GEN-LAST:event_jBBuscarProductoActionPerformed

    private void jDialogBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDialogBuscarProductoActionPerformed
        if (jBbuscarProducto.getText().contentEquals("")) {
            JOptionPane.showMessageDialog(rootPane,
                    "Ingrese texto a buscar");
        } else {
            try {
                //Se captura el dato del jtext para hacer la búsqueda de productio
                String datoprod = jBbuscarProducto.getText(); //Llama al método para buscar el producto con el parametro
                buscarProducto(datoprod);
                jBbuscarProducto.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(jFrameVentaFactura.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jDialogBuscarProductoActionPerformed

    private void jDialogBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDialogBuscarClienteActionPerformed
        if (buscarClientes.getText().contentEquals("")) {
            JOptionPane.showMessageDialog(rootPane,
                    "Ingrese texto a buscar");
        } else {
            try {
                //Se obtiene el dato de la caja de texto, para realizar posqueda
                String dato = buscarClientes.getText();
                //Llamada al método para buscar cliente
                BuscarClientes(dato);
                buscarClientes.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(jFrameVentaFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jDialogBuscarClienteActionPerformed

    private void jTextApellido7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido7ActionPerformed

    private void jTextApellido6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido6ActionPerformed

    private void jTextApellido4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido4ActionPerformed

    private void jTextApellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido2ActionPerformed

    private void jTextApellido5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido5ActionPerformed

    private void CapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapturarActionPerformed

    }//GEN-LAST:event_CapturarActionPerformed

    private void CapturarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CapturarMouseClicked

    }//GEN-LAST:event_CapturarMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        _principal TK = null;
        try {
            TK = new _principal();
        } catch (SQLException ex) {
            Logger.getLogger(jFrameVentaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        TK.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jBAñadirDetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAñadirDetaActionPerformed

        if (jTextCantidad.getText().equals("0")) {
            JOptionPane.showMessageDialog(rootPane,
                    "Debe de llenar los campos");

        } else {
            if (Integer.parseInt(jTextCantidad.getText().strip())
                    > Integer.parseInt(jTextstock.getText())) {
                JOptionPane.showMessageDialog(rootPane,
                        "La cantidad indicada supera la existencia actual"
                        + "del producto");
            } else {
                item += 1;

                ObjectoventaTable[0] = item;

                ObjectoventaTable[1] = jTextIDProducto.getText().trim();
                ObjectoventaTable[2] = jTextBProducto.getText().trim();
                ObjectoventaTable[3] = jTextCantidad.getText().trim();
                ObjectoventaTable[4] = PrecioVenta.getText().trim();

                Double subtotal = Double.parseDouble(jTextCantidad.getText().trim())
                        * Double.parseDouble(PrecioVenta.getText().trim());

                ObjectoventaTable[5] = subtotal;
                total += subtotal;

                jTotal.setText(total.toString());

                ModeloTableventa.addRow(ObjectoventaTable);

                limpiarVenta();

            }
            limpiarCampos();
        }
    }//GEN-LAST:event_jBAñadirDetaActionPerformed

    private void jBQuitarDetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitarDetaActionPerformed
        int fila = this.jTableVentaDetalle.getSelectedRow(); //Seobtiene #fila seleccionado 
        if (fila == 1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Seleccione una fila a quitar de la tabla");
        } else {
            //JOptionPane.OK_CANCEL_OPTION
            JDialog.setDefaultLookAndFeelDecorated(true);
            int resp = JOptionPane.showConfirmDialog(null,
                    "Esta seguro de quitar el producto de la lista?", "Aceptar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(rootPane,
                        "No se ha retirado ningun producto");
            } else {

                if (resp == JOptionPane.YES_OPTION) {
                    DefaultTableModel temp = (DefaultTableModel) jTableVentaDetalle.getModel();
                    temp.removeRow(fila);
                    for (int i = 0; i < jTableVentaDetalle.getRowCount(); i++) {
                        total = 0.0;
                        total += Double.parseDouble(jTableVentaDetalle.
                                getValueAt(i, 5).toString());

                    }
                    jTotal.setText(total.toString());
                }
            }
            if (resp == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(rootPane,
                        "Ninguna acción realizada");
            }

        }
    }//GEN-LAST:event_jBQuitarDetaActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        try {
            guardarventa();
        } catch (SQLException ex) {
            Logger.getLogger(jFrameVentaFactura.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      // objeto de la clase DAOVenta
DAOVenta_factura daoventa=new DAOVenta_factura();
//se evalúa que el numero de factura sea diferente de cero
if (numFac!=0){
try {
//llama al método que carga el reporte con el último numero de facts
//que se quardo
daoventa.reporteFactura ( numFac);
} catch (JRException ex) {  
Logger.getLogger( jFrameVentaFactura.class.getName()).
log ( Level.SEVERE,null,ex);
}
}else{
//Si el numfac-0 significa que no ha guardado la venta
JOptionPane.showMessageDialog( rootPane,
 "No tiene productos, no se puede mostrar la factura");
}
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jFrameVentaFactura().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jFrameVentaFactura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cantidad1;
    private javax.swing.JTextField Cantidad2;
    private javax.swing.JTextField CantidadPrd;
    private javax.swing.JButton Capturar;
    private javax.swing.JTable ListadoVenta;
    private javax.swing.JTable ListadoVenta1;
    private javax.swing.JTextField PrecioVenta;
    private javax.swing.JTextField Stock;
    private javax.swing.JTextField buscarClientes;
    private javax.swing.JLabel capturar;
    private javax.swing.JLabel capturar1;
    private javax.swing.JFormattedTextField idCliente;
    private javax.swing.JFormattedTextField idCliente1;
    private javax.swing.JButton jAgregarVenta;
    private javax.swing.JButton jBAñadirClientes;
    private javax.swing.JButton jBAñadirDeta;
    private javax.swing.JButton jBBuscarCliente;
    private javax.swing.JButton jBBuscarProducto;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBQuitarDeta;
    private javax.swing.JButton jBañadirProducto;
    private javax.swing.JTextField jBbuscarProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private com.toedter.calendar.JCalendar jCalendar3;
    private javax.swing.JButton jDialogBusClientes;
    private javax.swing.JButton jDialogBusClientes1;
    private javax.swing.JButton jDialogBuscarCliente;
    private javax.swing.JButton jDialogBuscarProducto;
    private javax.swing.JDialog jDialogCliente;
    private javax.swing.JDialog jDialogProducto;
    private javax.swing.JButton jEditar;
    private javax.swing.JButton jEditar1;
    private javax.swing.JLabel jLFe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFechas;
    private javax.swing.JLabel jModoPago;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTBuscaProducto;
    private javax.swing.JTable jTaBuscaClientes;
    private javax.swing.JTable jTableVenta2;
    private javax.swing.JTable jTableVenta3;
    private javax.swing.JTable jTableVentaDetalle;
    private javax.swing.JFormattedTextField jTextApellido10;
    private javax.swing.JFormattedTextField jTextApellido11;
    private javax.swing.JFormattedTextField jTextApellido12;
    private javax.swing.JFormattedTextField jTextApellido2;
    private javax.swing.JFormattedTextField jTextApellido29;
    private javax.swing.JFormattedTextField jTextApellido3;
    private javax.swing.JFormattedTextField jTextApellido30;
    private javax.swing.JFormattedTextField jTextApellido31;
    private javax.swing.JFormattedTextField jTextApellido32;
    private javax.swing.JFormattedTextField jTextApellido33;
    private javax.swing.JFormattedTextField jTextApellido35;
    private javax.swing.JFormattedTextField jTextApellido36;
    private javax.swing.JFormattedTextField jTextApellido37;
    private javax.swing.JFormattedTextField jTextApellido38;
    private javax.swing.JFormattedTextField jTextApellido4;
    private javax.swing.JFormattedTextField jTextApellido5;
    private javax.swing.JFormattedTextField jTextApellido6;
    private javax.swing.JFormattedTextField jTextApellido7;
    private javax.swing.JFormattedTextField jTextApellido9;
    private javax.swing.JFormattedTextField jTextBProducto;
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JFormattedTextField jTextFechas;
    private javax.swing.JFormattedTextField jTextFechas1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JFormattedTextField jTextIDCliente;
    private javax.swing.JFormattedTextField jTextIDProducto;
    private javax.swing.JFormattedTextField jTextNombreClientes;
    private javax.swing.JFormattedTextField jTextidVenta;
    private javax.swing.JFormattedTextField jTextidVenta1;
    private javax.swing.JTextField jTextstock;
    private javax.swing.JLabel jTotal;
    // End of variables declaration//GEN-END:variables

}
