

package Vista;

import Controlador._principal;
import ModeloD.Compra_factura;
import ModeloD.DAOCompra_factura;
import ModeloD.DAOProductos;
import ModeloD.DAOProveedor;
import ModeloD.DAOVenta_factura;
import ModeloD.Producto_metodos;
import ModeloD.Proveedor;
import ModeloD.Venta_factura;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;


public class jFrameCompra_factura extends javax.swing.JFrame {
      private java.sql.Date fech;
      private DefaultTableModel ModeloTableventa;
    private Object[] ObjectoventaTable = new Object[6];
    private Double total = 0.0;
    private int item = 0;
    private int numComp = 0;
    private int Cantidad = 0;
    private int IDproducto;
    
public jFrameCompra_factura() throws SQLException {
        initComponents();
      fech = java.sql.Date.valueOf(LocalDate.now());
        jLabelFechaCom.setText(fech.toString());
        
      jDialogProducto.setLocationRelativeTo(null);
        jDialogProveedor.setLocationRelativeTo(null);
ModeloTableventa = (DefaultTableModel) jTableCompra.getModel();
   
    jPrecioCompra.setEnabled(false);
    }

     private void buscarProducto(String dato) throws SQLException {
        List<Producto_metodos> productos = new DAOProductos().busquedaProductos(dato);
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"ID_Producto", "Producto",
            "PrecioCompra", "Stock"};

        modelo.setColumnIdentifiers(columnas);
        for (Producto_metodos pro : productos) {
            String[] renglon = {Integer.toString(pro.getID_producto()),
                pro.getNombre(),
                Double.toString(pro.getPrecioCompra()),
                Integer.toString(pro.getStock())};

            modelo.addRow(renglon);
        }
        jTBuscaProductos.setModel(modelo);
    }
      private void buscarProveedores(String dato) throws SQLException {
        List<Proveedor> proveedor = new DAOProveedor().buscarProveedor(dato);
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"IDProducto", "Nombre",
            "Telefono", "Correo","Direccion"};

        modelo.setColumnIdentifiers(columnas);
        for (Proveedor pro : proveedor) {
            String[] renglon = {Integer.toString(pro.getId_proveedor()),
                pro.getNombreProveedor(),
                pro.getTelefono(),
                pro.getCorreo(),
                pro.getDireccion()};

            modelo.addRow(renglon);
        }
        jTBuscaProveedor.setModel(modelo);
    }
   
    public void limpiarCompra() {
        jidProducto.setText("0");
        jTextCantidad.setText("0");
    }
     public void guardarCompra() throws SQLException {
        int IDProveedor;
        if (jTExtIDProveedor.getText().contentEquals("")
                || jLabelFechaCom.getText().contentEquals("")){

            JOptionPane.showMessageDialog(rootPane,
                    "Se requieren datos del Proveedor y productos,"
                    + "fecha");

        } else {
            try{
                IDProveedor = Integer.parseInt(jTExtIDProveedor.getText());
                Compra_factura vent = new Compra_factura( IDProveedor, fech);

                DAOCompra_factura daoventa = new DAOCompra_factura();

                if (daoventa.InsertarCompra(vent) == 0){
                    JOptionPane.showMessageDialog(rootPane,
                            "Registro agregado en Compra");

                    numComp = daoventa.obtenerUltimoNumCompra();

                } else {
                    JOptionPane.showMessageDialog(rootPane,
                            "Ha ocurrido un error, no se inserto en Compra");
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(rootPane,
                        "No se agregaron los registros" + e);
            }
            JOptionPane.showMessageDialog(rootPane,
                    "Registro listo para agregar en Compra " + numComp);

            guardarDetalleventa();

            actualizarStock();
            }
        }

    public void guardarDetalleventa() throws SQLException {

        double PrecioCom;

        if (numComp == 0 || jTableCompra.getRowCount() == 0) {
            JOptionPane.showMessageDialog(rootPane,
                    "No se ha obtenido numero de Compra o "
                    + "no tiene productos añadidos para Comprar");
        } else {
            for (int i = 0; i < jTableCompra.getRowCount(); i++) {
                IDproducto = Integer.parseInt(jTableCompra.
                        getValueAt(i, 1).toString());
                Cantidad = Integer.parseInt(jTableCompra.
                        getValueAt(i, 3).toString());
                PrecioCom = Double.parseDouble(jTableCompra.
                        getValueAt(i, 4).toString());
               

                Compra_factura Comp = new Compra_factura(numComp,Cantidad,PrecioCom,IDproducto);
                    
                DAOCompra_factura dao = new DAOCompra_factura();

                if (dao.insertarDetalleCompra(Comp) == 0) {
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

        for (int i = 0; i < jTableCompra.getRowCount(); i++) {
            IDproducto = Integer.parseInt(jTableCompra.
                    getValueAt(i, 1).toString());
            Cantidad = Integer.parseInt(jTableCompra.
                    getValueAt(i, 3).toString());

            DAOProductos daopro = new DAOProductos();
            try {
                List<Producto_metodos> p = daopro.busquedaProductos(String.valueOf(IDproducto).toString());
                existenciActual = p.get(0).getStock();
                nuevaExistencia = existenciActual + Cantidad;
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

        jeliminar = new javax.swing.JButton();
        jDialogProveedor = new javax.swing.JDialog();
        jPanel13 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jBbuscarProvee = new javax.swing.JTextField();
        jBañadirProducto1 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTBuscaProveedor = new javax.swing.JTable();
        jDialogBuscarProveedor = new javax.swing.JButton();
        jDialogProducto = new javax.swing.JDialog();
        jPanel12 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jBbuscarProducto = new javax.swing.JTextField();
        jBañadirProducto = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTBuscaProductos = new javax.swing.JTable();
        jDialogBuscarProducto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelFechaCom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCompra = new javax.swing.JTable();
        jButton25 = new javax.swing.JButton();
        jidProducto = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextNombreProvee = new javax.swing.JFormattedTextField();
        jTExtIDProveedor = new javax.swing.JFormattedTextField();
        jButton26 = new javax.swing.JButton();
        jTextApellido3 = new javax.swing.JFormattedTextField();
        jTexBProducto = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonGuardar = new javax.swing.JButton();
        Imprimir = new javax.swing.JButton();
        jlTotal = new javax.swing.JLabel();
        Cancelar1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextStock = new javax.swing.JFormattedTextField();
        jTextCantidad = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonAgregar = new javax.swing.JButton();
        jPrecioCompra = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();

        jeliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        jeliminar.setText("Eliminar");
        jeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jeliminarActionPerformed(evt);
            }
        });

        jDialogProveedor.setSize(new java.awt.Dimension(705, 560));
        jDialogProveedor.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(153, 204, 255));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(85, 186, 232));
        jLabel37.setText("Buscar Proveedor");

        jBañadirProducto1.setText("Añadir");
        jBañadirProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBañadirProducto1ActionPerformed(evt);
            }
        });

        jTBuscaProveedor.setBackground(new java.awt.Color(117, 184, 255));
        jTBuscaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "IDProveedor", "Nombre", "Telefono", "Correo", "Direccion"
            }
        ));
        jScrollPane8.setViewportView(jTBuscaProveedor);

        jDialogBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jDialogBuscarProveedor.setText("Buscar");
        jDialogBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDialogBuscarProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel37)
                        .addGap(29, 29, 29)
                        .addComponent(jBbuscarProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jDialogBuscarProveedor)
                        .addGap(39, 39, 39)
                        .addComponent(jBañadirProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(666, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBbuscarProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBañadirProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDialogBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jDialogProveedor.getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        jTBuscaProductos.setBackground(new java.awt.Color(117, 184, 255));
        jTBuscaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTBuscaProductos);

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
                .addContainerGap(654, Short.MAX_VALUE))
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
                .addContainerGap(101, Short.MAX_VALUE))
        );

        jDialogProducto.getContentPane().add(jPanel12, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFechaCom.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabelFechaCom.setForeground(new java.awt.Color(0, 0, 204));
        jLabelFechaCom.setText("Fecha");
        jPanel1.add(jLabelFechaCom, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 150, 110, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Compra");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/factura.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 69, 100));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresa.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, 74));

        jPanel2.setBackground(new java.awt.Color(108, 165, 228));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "IDProducto", "Producto", "Cantidad", "PrecioCompra", "SubTotal"
            }
        ));
        jScrollPane1.setViewportView(jTableCompra);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 680, 183));

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jButton25.setText("Buscar");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 103, 30));

        jidProducto.setBackground(new java.awt.Color(204, 204, 204));
        jidProducto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jidProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jidProductoActionPerformed(evt);
            }
        });
        jPanel2.add(jidProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 70, 25));

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Producto");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 80, 23));

        jTextNombreProvee.setBackground(new java.awt.Color(204, 204, 204));
        jTextNombreProvee.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextNombreProvee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreProveeActionPerformed(evt);
            }
        });
        jPanel2.add(jTextNombreProvee, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 220, 25));

        jTExtIDProveedor.setBackground(new java.awt.Color(204, 204, 204));
        jTExtIDProveedor.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTExtIDProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTExtIDProveedorActionPerformed(evt);
            }
        });
        jPanel2.add(jTExtIDProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 70, 25));

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jButton26.setText("Buscar");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 35, 103, 30));

        jTextApellido3.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido3ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextApellido3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 220, 25));

        jTexBProducto.setBackground(new java.awt.Color(204, 204, 204));
        jTexBProducto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTexBProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTexBProductoActionPerformed(evt);
            }
        });
        jPanel2.add(jTexBProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 220, 25));

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Proveedor");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 80, 23));

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, 90, 30));

        Imprimir.setText("Imprimir");
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(Imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 80, 30));

        jlTotal.setText("Total");
        jPanel2.add(jlTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 70, -1));

        Cancelar1.setText("Cancelar");
        jPanel2.add(Cancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 80, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 750, 480));

        jPanel3.setBackground(new java.awt.Color(108, 165, 228));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de compra", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 102, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextStock.setBackground(new java.awt.Color(204, 204, 204));
        jTextStock.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextStockActionPerformed(evt);
            }
        });
        jPanel3.add(jTextStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 150, 25));

        jTextCantidad.setBackground(new java.awt.Color(204, 204, 204));
        jTextCantidad.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCantidadActionPerformed(evt);
            }
        });
        jPanel3.add(jTextCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 150, 25));

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Cantidad");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 70, 23));

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText("Stock");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 50, 23));

        jButton1.setText("Quitar");
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 90, 30));

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 90, 30));

        jPrecioCompra.setBackground(new java.awt.Color(204, 204, 204));
        jPrecioCompra.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jPrecioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrecioCompraActionPerformed(evt);
            }
        });
        jPanel3.add(jPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 150, 25));

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 204));
        jLabel13.setText("PrecioCompra");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, 23));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 320, 490));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1430, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextStockActionPerformed

    private void jidProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jidProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jidProductoActionPerformed

    private void jeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jeliminarActionPerformed
       
    }//GEN-LAST:event_jeliminarActionPerformed
    
    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
          _principal TK = null;
    try {
        TK = new _principal();
    } catch (SQLException ex) {
        Logger.getLogger(jFrameCompra_factura.class.getName()).log(Level.SEVERE, null, ex);
    }
        TK.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
jDialogProducto.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jTextNombreProveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreProveeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreProveeActionPerformed

    private void jTExtIDProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTExtIDProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTExtIDProveedorActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
jDialogProveedor.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jTextApellido3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido3ActionPerformed

    private void jTexBProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTexBProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTexBProductoActionPerformed

    private void jTextCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCantidadActionPerformed

    private void jBañadirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBañadirProductoActionPerformed
        int fila = this.jTBuscaProductos.getSelectedRow();// obtiene la fila seleccionado
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane,
                "Seleccione un registro de la tabia");
        } else {//Be toma cada campo de la tabla del registro seinccionado

            try {
                int id = Integer.parseInt((String) this.jTBuscaProductos.
                    getValueAt(fila, 0).toString());
                String nom = (String) this.jTBuscaProductos.getValueAt(fila, 1);
                double preC = Double.parseDouble((String) this.jTBuscaProductos.
                    getValueAt(fila, 2).toString());
                int stock = Integer.parseInt((String) this.jTBuscaProductos.
                    getValueAt(fila, 3).toString());
                //Se ubican en las cajas de textos los datos capturados de la tabla productos
                jidProducto.setText("" + id);
                jTexBProducto.setText(nom);
                jPrecioCompra.setText("" + preC);
                jTextStock.setText("" + stock);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "Ocurrió un ERROR! " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jBañadirProductoActionPerformed

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

    private void jBañadirProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBañadirProducto1ActionPerformed
int fila = this.jTBuscaProveedor.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane,
                    "Seleccione un registro de la tabla");
        } else {
            try {
                int id = Integer.parseInt((String) this.jTBuscaProveedor.
                        getValueAt(fila, 0).toString());
                String nom = (String) this.jTBuscaProveedor.getValueAt(fila, 1);
                String tel = (String) this.jTBuscaProveedor.getValueAt(fila, 2);
                String corr = (String) this.jTBuscaProveedor.getValueAt(fila, 3);
                String dire = (String) this.jTBuscaProveedor.getValueAt(fila, 4);

                jTExtIDProveedor.setText("" + id);
                jTextNombreProvee.setText(nom);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane,
                        "Ocurrio un Error!" + e.getMessage());
            }
        }
        
    }//GEN-LAST:event_jBañadirProducto1ActionPerformed

    private void jDialogBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDialogBuscarProveedorActionPerformed
        if (jBbuscarProvee.getText().contentEquals("")) {
            JOptionPane.showMessageDialog(rootPane,
                "Ingrese texto a buscar");
        } else {
            try {
                //Se captura el dato del jtext para hacer la búsqueda de productio
                String datoprod = jBbuscarProvee.getText(); //Llama al método para buscar el producto con el parametro
                buscarProveedores(datoprod);
                jBbuscarProvee.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(jFrameVentaFactura.class.getName()).
                log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jDialogBuscarProveedorActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
 if (jTextCantidad.getText().equals("0")) {
            JOptionPane.showMessageDialog(rootPane,
                    "Debe de llenar los campos");

      
            } else {
                item += 1;

                ObjectoventaTable[0] = item;
                
                ObjectoventaTable[1] = jidProducto.getText().trim();
                ObjectoventaTable[2] = jTexBProducto.getText().trim();
                ObjectoventaTable[3] = jTextCantidad.getText().trim();
                ObjectoventaTable[4] = jPrecioCompra.getText().trim();

                Double subtotal = Double.parseDouble(jTextCantidad.getText().trim())
                        * Double.parseDouble(jPrecioCompra.getText().trim());

                ObjectoventaTable[5] = subtotal;
                total += subtotal;

                jlTotal.setText(total.toString());

                ModeloTableventa.addRow(ObjectoventaTable);

                limpiarCompra();

            }
       
            
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jPrecioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrecioCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPrecioCompraActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
  try {
            guardarCompra();
        } catch (SQLException ex) {
            Logger.getLogger(jFrameVentaFactura.class.getName()).
                    log(Level.SEVERE, null, ex);
        }      
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirActionPerformed
DAOCompra_factura daoventa=new DAOCompra_factura();
//se evalúa que el numero de factura sea diferente de cero
if (numComp!=0){
try {
//llama al método que carga el reporte con el último numero de facts
//que se quardo
daoventa.reporteCompra ( numComp);
} catch (JRException ex) {  
Logger.getLogger( jFrameVentaFactura.class.getName()).
log ( Level.SEVERE,null,ex);
}
}else{
//Si el numfac-0 significa que no ha guardado la venta
JOptionPane.showMessageDialog( rootPane,
 "No tiene productos, no se puede mostrar la factura");
}        // TODO add your handling code here:
    }//GEN-LAST:event_ImprimirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jFrameCompra_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameCompra_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameCompra_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameCompra_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jFrameCompra_factura().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jFrameCompra_factura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar1;
    private javax.swing.JButton Imprimir;
    private javax.swing.JButton jBañadirProducto;
    private javax.swing.JButton jBañadirProducto1;
    private javax.swing.JTextField jBbuscarProducto;
    private javax.swing.JTextField jBbuscarProvee;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jDialogBuscarProducto;
    private javax.swing.JButton jDialogBuscarProveedor;
    private javax.swing.JDialog jDialogProducto;
    private javax.swing.JDialog jDialogProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFechaCom;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JFormattedTextField jPrecioCompra;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTBuscaProductos;
    private javax.swing.JTable jTBuscaProveedor;
    private javax.swing.JFormattedTextField jTExtIDProveedor;
    private javax.swing.JTable jTableCompra;
    private javax.swing.JFormattedTextField jTexBProducto;
    private javax.swing.JFormattedTextField jTextApellido3;
    private javax.swing.JFormattedTextField jTextCantidad;
    private javax.swing.JFormattedTextField jTextNombreProvee;
    private javax.swing.JFormattedTextField jTextStock;
    private javax.swing.JButton jeliminar;
    private javax.swing.JFormattedTextField jidProducto;
    private javax.swing.JLabel jlTotal;
    // End of variables declaration//GEN-END:variables
}
