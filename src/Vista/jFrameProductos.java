
package Vista;

import Controlador._principal;
import ModeloD.Categoria;
import ModeloD.DAOCategoria;
import ModeloD.DAOProductos;
import ModeloD.Producto_metodos;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class jFrameProductos extends javax.swing.JFrame {
public jFrameProductos() throws SQLException {
        
        initComponents();
        llenarCombo();
        
        jTextidProducto.setEnabled(false);
           jTextidCategoria.setEnabled(false);
        
           obtenerDatos();
    }
    
    private void obtenerDatos() throws SQLException {
         try {
        //se crea una Producto_metodos lista que almacena
        //los datos obtenidos de la BD
        List< Producto_metodos > producto = new DAOProductos().
                ObtenerDatos();
        //Define un modelo para la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        //Arreglo con nombre de columna de las tablas
            String[] Columnas = {"ID_producto","Nombre","Stock",
            "PrecioCompra","PrecioVenta","ID_Categoria"};
             //Establece los nombres definidos de las columnas
                modelo.setColumnIdentifiers(Columnas);
                for (Producto_metodos au : producto){//Recorre cada elemento de la lista y los agrega
               //al modelo de la tabla
               
                 String[] renglon = {Integer.toString(au.getID_producto())
                   ,au.getNombre(),
                   Integer.toString(au.getStock())
                        ,Double.toString(au.getPrecioCompra())
                              ,Double.toString(au.getPrecioVenta())
                                 ,Integer.toString(au.getID_Categoria())};
                             modelo.addRow(renglon);
         }
    
     jTableProductos.setModel(modelo); //Ubica los datos del modelo en la tabla

    }catch (SQLException ex) {
            Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
    }
    
      public void actualizarProducto() throws SQLException {
int id=Integer.parseInt( this.jTextidProducto.getText());
String nomArt=this.jTextNombreArticulo.getText();
int Sto=Integer.parseInt(this.jTextStock.getText());
Double PreC=Double.parseDouble(this.jTextPrecioC.getText());
Double preV=Double.parseDouble(this.jTextPrecioV.getText());
int idCat=Integer.parseInt( this.jTextidCategoria.getText());


Producto_metodos pro=new Producto_metodos 
        (id, nomArt, Sto, PreC, preV, idCat);

DAOProductos dao=new DAOProductos();
int res = dao.Actualizar(pro);
if (res == 0) {
JOptionPane.showMessageDialog( rootPane, "¡Producto Actualizado!");
} else {
JOptionPane.showMessageDialog( rootPane,  "Ocurrió un ERROR!");

}
    }
             public void limpiarCampos() {
        jTextidProducto.setText("");
        jTextNombreArticulo.setText("");
       jTextStock.setText("");
        jTextPrecioC.setText("");
        jTextPrecioV.setText("");
     
             
}
             
             public void llenarCombo() throws SQLException{
                 List<Categoria>categori=new DAOCategoria().ObtenerDatos();
                 for(int i = 0; i < categori.size(); i++){
                 
          jCbBCategorias.addItem(new Categoria(categori.get(i).getId_Categoria(),
                  categori.get(i).getNombreCategoria()));
                 
                 }
            
}
     private void buscarProducto(String dato) throws SQLException {
        List<Producto_metodos> productos = new DAOProductos().busquedaProductos(dato);
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"ID_Producto", "Producto",
            "Precio", "Stock"};

        modelo.setColumnIdentifiers(columnas);
        for (Producto_metodos pro : productos) {
            String[] renglon = {Integer.toString(pro.getID_producto()),
                pro.getNombre(),
                Double.toString(pro.getPrecioVenta()),
                Double.toString(pro.getStock())};
            modelo.addRow(renglon);
        }
        jTableProductos.setModel(modelo);
    }
   
   

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        BotonAgregar = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();
        jEditar = new javax.swing.JButton();
        jBBuscarpro = new javax.swing.JButton();
        buscaPro = new javax.swing.JFormattedTextField();
        jActualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextPrecioV = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextStock = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextidCategoria = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jCbBCategorias = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextidProducto = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextNombreArticulo = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextPrecioC = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(75, 158, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableProductos.setBackground(new java.awt.Color(103, 172, 242));
        jTableProductos.setForeground(new java.awt.Color(0, 0, 153));
        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 940, 210));

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Producto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 38, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estar (1).png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 32, 69, -1));

        jPanel18.setBackground(new java.awt.Color(125, 185, 246));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transacciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft JhengHei Light", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N
        jPanel18.setForeground(new java.awt.Color(51, 153, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-usuario.png"))); // NOI18N
        BotonAgregar.setText("Agregar");
        BotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarActionPerformed(evt);
            }
        });
        jPanel18.add(BotonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 51, 223, 33));

        Borrar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        Borrar.setText("Eliminar");
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });
        jPanel18.add(Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        jEditar.setText("Editar");
        jEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarActionPerformed(evt);
            }
        });
        jPanel18.add(jEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 100, -1));

        jBBuscarpro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jBBuscarpro.setText("Buscar");
        jBBuscarpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarproActionPerformed(evt);
            }
        });
        jPanel18.add(jBBuscarpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 103, 25));

        buscaPro.setBackground(new java.awt.Color(204, 204, 204));
        buscaPro.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        buscaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaProActionPerformed(evt);
            }
        });
        jPanel18.add(buscaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 240, 25));

        jActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar-pagina.png"))); // NOI18N
        jActualizar.setText("Actualizar");
        jActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jActualizarActionPerformed(evt);
            }
        });
        jPanel18.add(jActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 231, 32));

        jPanel1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 140, 280, 300));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresa.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 70, 70));

        jPanel2.setBackground(new java.awt.Color(125, 185, 246));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextPrecioV.setBackground(new java.awt.Color(204, 204, 204));
        jTextPrecioV.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextPrecioV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPrecioVActionPerformed(evt);
            }
        });
        jPanel2.add(jTextPrecioV, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 150, 30));

        jLabel12.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("Precio venta");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, 30));

        jTextStock.setBackground(new java.awt.Color(204, 204, 204));
        jTextStock.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextStockActionPerformed(evt);
            }
        });
        jPanel2.add(jTextStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 80, 30));

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Stoke");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 50, 30));

        jTextidCategoria.setBackground(new java.awt.Color(204, 204, 204));
        jTextidCategoria.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextidCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextidCategoriaActionPerformed(evt);
            }
        });
        jPanel2.add(jTextidCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 80, 30));

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("IDCategoria");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 90, 30));

        jCbBCategorias.setBackground(new java.awt.Color(204, 204, 204));
        jCbBCategorias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jCbBCategorias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCbBCategoriasItemStateChanged(evt);
            }
        });
        jCbBCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbBCategoriasActionPerformed(evt);
            }
        });
        jPanel2.add(jCbBCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 250, 30));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("Categoria seleccionada");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 170, 30));

        jTextidProducto.setBackground(new java.awt.Color(204, 204, 204));
        jTextidProducto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextidProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextidProductoActionPerformed(evt);
            }
        });
        jPanel2.add(jTextidProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 40, 30));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("ID");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 17, 30));

        jTextNombreArticulo.setBackground(new java.awt.Color(204, 204, 204));
        jTextNombreArticulo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextNombreArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreArticuloActionPerformed(evt);
            }
        });
        jPanel2.add(jTextNombreArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 200, 30));

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText("NombreArticulo");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 120, 30));

        jTextPrecioC.setBackground(new java.awt.Color(204, 204, 204));
        jTextPrecioC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextPrecioC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPrecioCActionPerformed(evt);
            }
        });
        jPanel2.add(jTextPrecioC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 170, 30));

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Precio compra");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 100, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 630, 300));

        jPanel3.setBackground(new java.awt.Color(125, 185, 246));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 1030, 750));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo con tipografía con inicial para marca personal profesional initial letter typography negro.png"))); // NOI18N
        jLabel13.setText("jLabel1");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 0, 450, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo con tipografía con inicial para marca personal profesional initial letter typography negro.png"))); // NOI18N
        jLabel7.setText("jLabel1");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 470, 750));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextStockActionPerformed

    private void jTextidCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextidCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextidCategoriaActionPerformed

    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed
        //Captura datos de la caja de texto
        String nombPro = jTextNombreArticulo.getText();
        String Sto =  jTextStock.getText();
        String preC = jTextPrecioC.getText();
        String PreV = jTextPrecioV.getText();
        String idCat = jTextidCategoria.getText();

        // Agregar validacines a cajas de texto segun fromato y
        // caracteres validos a ingresar
        // comprueba que las cajas de texto no esten vacias
        if (nombPro.contentEquals("") ||
            Sto.contentEquals("") ||
            preC.contentEquals("")||
            PreV.contentEquals("")||
            idCat.contentEquals("")){

            JOptionPane.showMessageDialog(rootPane,
                "Todos los campos son obligatorios llenar");
        } else {
            try {

                int st = Integer.parseInt(Sto);
                double PreC = Double.parseDouble(preC);
                double precV = Double.parseDouble(PreV);
                int id = Integer.parseInt(idCat);

                Producto_metodos Prod = new Producto_metodos
                (nombPro, st, PreC, precV,id);

                DAOProductos dao = new DAOProductos();
                if (dao.Insertar(Prod) == 0) {
                    JOptionPane.showMessageDialog(rootPane,
                        "Registro agregado");
                }

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(rootPane,
                    "No se agrego el registro");
            }

        }
        try {
            obtenerDatos(); //Llama a este metodo para que se muestre el nuevo
        } catch (SQLException ex) {
            Logger.getLogger(jFrameCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //Registro en la tabla del formulario
        limpiarCampos();
        //Llama a este metodo para limpiar las cajas de texto
    }//GEN-LAST:event_BotonAgregarActionPerformed

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        int fila=this.jTableProductos.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(rootPane,
                "Seleccione un registro de la tabla");
            //JOptionPane.OK_CANCEL_OPTION();
        } else {
            JDialog.setDefaultLookAndFeelDecorated(true);
            int resp = JOptionPane.showConfirmDialog(null,

                "¿Esta seguro de eliminar?",  "Aceptar",

                JOptionPane. YES_NO_OPTION,

                JOptionPane.QUESTION_MESSAGE);

            if (resp == JOptionPane.NO_OPTION) {

                JOptionPane.showMessageDialog( rootPane,
                    "Registro no borrado");
            } else {

                if (resp == JOptionPane.YES_OPTION) {
                    try {
                        int id= Integer.parseInt((String) this.jTableProductos.
                            getValueAt ( fila, 0).toString());
                        DAOProductos dao=new DAOProductos();
                        dao. Eliminar (id);
                        obtenerDatos();

                    } catch (SQLException ex) {

                    }
                }
            }
            if (resp == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog( rootPane,
                    "Ninguna acción realizada");
            }
        }
    }//GEN-LAST:event_BorrarActionPerformed

    private void jEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditarActionPerformed
        int fila=this.jTableProductos.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(rootPane, "Seleccione un registro de la tabla");
        } else {
            try {

                int id = Integer.parseInt((String)this.jTableProductos.getValueAt(fila, 0).toString());
                String NomArt=(String)this.jTableProductos.getValueAt(fila,1).toString();
                int Stock= Integer.parseInt((String)this.jTableProductos.getValueAt(fila,2).toString());
                String PreC=(String)this.jTableProductos.getValueAt(fila,3).toString();
                String PreV=(String)this.jTableProductos.getValueAt(fila,4).toString();
                int idCat=Integer.parseInt((String)this.jTableProductos.getValueAt(fila,5).toString());

                jTextidProducto.setText("" + id);
                jTextNombreArticulo.setText(NomArt);
                jTextStock.setText(""+Stock);
                jTextPrecioC.setText(PreC);
                jTextPrecioV.setText(PreV);
                jTextidCategoria.setText(""+idCat);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane,
                    "¡Ocurrió un ERROR!"+e.getMessage());

            }
        }
    }//GEN-LAST:event_jEditarActionPerformed

    private void jBBuscarproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarproActionPerformed
        if (buscaPro.getText().contentEquals("")) {
            JOptionPane.showMessageDialog(rootPane,
                "Ingrese texto a buscar");
        } else {
            try {
                //Se captura el dato del jtext para hacer la búsqueda de productio
                String datoprod = buscaPro.getText(); //Llama al método para buscar el producto con el parametro
                buscarProducto(datoprod);
                buscaPro.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(jFrameVentaFactura.class.getName()).
                log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBBuscarproActionPerformed

    private void buscaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscaProActionPerformed

    private void jActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jActualizarActionPerformed
        try {
            actualizarProducto();
        } catch (SQLException ex) {
            Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null,ex);

        }
        try {
            obtenerDatos();
        } catch (SQLException ex) {
            Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null,ex);
        }
        limpiarCampos();
    }//GEN-LAST:event_jActualizarActionPerformed

    private void jTextNombreArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreArticuloActionPerformed

    private void jTextPrecioCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPrecioCActionPerformed

    }//GEN-LAST:event_jTextPrecioCActionPerformed

    private void jTextPrecioVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPrecioVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrecioVActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        _principal TK = null;
    try {
        TK = new _principal();
    } catch (SQLException ex) {
        Logger.getLogger(jFrameProductos.class.getName()).log(Level.SEVERE, null, ex);
    }
        TK.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jCbBCategoriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCbBCategoriasItemStateChanged
        int id=jCbBCategorias.getItemAt(jCbBCategorias.getSelectedIndex()).getId_Categoria();
        jTextidCategoria.setText(""+ id);
    }//GEN-LAST:event_jCbBCategoriasItemStateChanged

    private void jCbBCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbBCategoriasActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jCbBCategoriasActionPerformed

    private void jTextidProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextidProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextidProductoActionPerformed

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
            java.util.logging.Logger.getLogger(jFrameProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jFrameProductos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jFrameProductos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar;
    private javax.swing.JButton BotonAgregar;
    private javax.swing.JFormattedTextField buscaPro;
    private javax.swing.JButton jActualizar;
    private javax.swing.JButton jBBuscarpro;
    private javax.swing.JComboBox<Categoria> jCbBCategorias;
    private javax.swing.JButton jEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JFormattedTextField jTextNombreArticulo;
    private javax.swing.JFormattedTextField jTextPrecioC;
    private javax.swing.JFormattedTextField jTextPrecioV;
    private javax.swing.JFormattedTextField jTextStock;
    private javax.swing.JFormattedTextField jTextidCategoria;
    private javax.swing.JFormattedTextField jTextidProducto;
    // End of variables declaration//GEN-END:variables
}
