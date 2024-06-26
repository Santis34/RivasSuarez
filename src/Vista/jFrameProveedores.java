
package Vista;

import Controlador._principal;
import ModeloD.DAOProveedor;
import ModeloD.Proveedor;
import java.awt.HeadlessException;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class jFrameProveedores extends javax.swing.JFrame {

   
    public jFrameProveedores() throws SQLException {
        initComponents();
         jidProveedor.setEnabled(false);
         obtenerDatos();
    }

    private void obtenerDatos() throws SQLException {
        //se crea una lista que almacena los datos obtenidos de la BD
        List<Proveedor> prove = new DAOProveedor().ObtenerDatos();
        //Define un modelo para la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        //Arreglo con nombre de columna de las tablas
        String[] Columnas = {"ID_Proveedores","Nombre","Telefono","Correo"
            ,"Direccion"};
        //Establece los nombres definidos de las columnas
        modelo.setColumnIdentifiers(Columnas);
      for (Proveedor au : prove){//Recorre cada elemento de la lista y los agrega
            //al modelo de la tabla
         String[] renglon = {Integer.toString(au.getId_proveedor()), 
             au.getNombreProveedor(), au.getTelefono().toString(), au.getCorreo(),
             au.getDireccion()};
                 
          modelo.addRow(renglon);
         }
      jTableProveedor.setModel(modelo); //Ubica los datos del modelo en la tabla
        }

    private void limpiarCampos() {
        jTextNombrej.setText(null);
    jTextDireccion.setText(null);
    jTextTelefono.setText(null);
      Correok.setText(null);
        
}

    public void actualizarProveedor() throws SQLException {
        int id = Integer.parseInt(this.jidProveedor.getText());
        String nom = this.jTextNombrej.getText();
        String Corr = this.Correok.getText();
        String Dire = this.jTextDireccion.getText();
         String Tel = this.jTextTelefono.getText();

        Proveedor Prov = new Proveedor(id, nom, Corr, Dire, Tel);

        DAOProveedor dao = new DAOProveedor();
        int res = dao.Actualizar(Prov);
        if (res == 0) {
            JOptionPane.showMessageDialog(rootPane, "¡Proveedor Actualizado!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ocurrió un ERROR!");

        }
}
         private void buscarProveedor(String dato) throws SQLException {
        List<Proveedor> proveedor = new DAOProveedor().buscarProveedor(dato);
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {"ID_Proveedores", "Nombre",
            "Telefono", "Direccion","Correo"};

        modelo.setColumnIdentifiers(columnas);
        for (Proveedor prov : proveedor) {
            String[] renglon = {Integer.toString(prov.getId_proveedor()),
                prov.getNombreProveedor(),
                prov.getCorreo(),
                prov.getDireccion(),
                prov.getTelefono()};
            modelo.addRow(renglon);
        }
        jTableProveedor.setModel(modelo);
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabelRegresar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        Agregarj = new javax.swing.JButton();
        jEliminar = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jBuscarPro = new javax.swing.JButton();
        jTextBusca = new javax.swing.JFormattedTextField();
        jActualizar = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTableProveedor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Correok = new javax.swing.JFormattedTextField();
        jLabel68 = new javax.swing.JLabel();
        jTextNombrej = new javax.swing.JFormattedTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jidProveedor = new javax.swing.JFormattedTextField();
        jLabel61 = new javax.swing.JLabel();
        jTextDireccion = new javax.swing.JFormattedTextField();
        jLabel60 = new javax.swing.JLabel();
        jTextTelefono = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel58.setBackground(new java.awt.Color(75, 158, 241));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setFont(new java.awt.Font("Rockwell", 1, 48)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 0, 204));
        jLabel64.setText("Proveedores");
        jPanel58.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 46, -1, -1));

        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/convenio (1).png"))); // NOI18N
        jPanel58.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 39, 61, -1));

        jLabelRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresa.png"))); // NOI18N
        jLabelRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegresarMouseClicked(evt);
            }
        });
        jPanel58.add(jLabelRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 63, -1));

        jPanel2.setBackground(new java.awt.Color(125, 185, 246));

        jPanel59.setBackground(new java.awt.Color(125, 185, 246));
        jPanel59.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transacciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft JhengHei Light", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N
        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Agregarj.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Agregarj.setForeground(new java.awt.Color(0, 51, 153));
        Agregarj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-usuario.png"))); // NOI18N
        Agregarj.setText("Agregar");
        Agregarj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarjActionPerformed(evt);
            }
        });
        jPanel59.add(Agregarj, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 230, 33));

        jEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jEliminar.setForeground(new java.awt.Color(0, 51, 153));
        jEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        jEliminar.setText("Eliminar");
        jEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarActionPerformed(evt);
            }
        });
        jPanel59.add(jEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 120, -1));

        jButton24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton24.setForeground(new java.awt.Color(0, 51, 153));
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        jButton24.setText("Editar");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel59.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 100, -1));

        jBuscarPro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBuscarPro.setForeground(new java.awt.Color(0, 51, 153));
        jBuscarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jBuscarPro.setText("Buscar");
        jBuscarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarProActionPerformed(evt);
            }
        });
        jPanel59.add(jBuscarPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 103, 25));

        jTextBusca.setBackground(new java.awt.Color(204, 204, 204));
        jTextBusca.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBuscaActionPerformed(evt);
            }
        });
        jPanel59.add(jTextBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 229, 30));

        jActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jActualizar.setForeground(new java.awt.Color(0, 51, 153));
        jActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar-pagina.png"))); // NOI18N
        jActualizar.setText("Actualizar");
        jActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jActualizarActionPerformed(evt);
            }
        });
        jPanel59.add(jActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 230, 30));

        jTableProveedor.setBackground(new java.awt.Color(103, 172, 242));
        jTableProveedor.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTableProveedor.setForeground(new java.awt.Color(0, 0, 153));
        jTableProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableProveedor.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jScrollPane13.setViewportView(jTableProveedor);

        jPanel1.setBackground(new java.awt.Color(125, 185, 246));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 51, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Correok.setBackground(new java.awt.Color(204, 204, 204));
        Correok.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        Correok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorreokActionPerformed(evt);
            }
        });
        jPanel1.add(Correok, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 260, 30));

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 0, 204));
        jLabel68.setText("Correo");
        jPanel1.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 70, 30));

        jTextNombrej.setBackground(new java.awt.Color(204, 204, 204));
        jTextNombrej.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextNombrej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombrejActionPerformed(evt);
            }
        });
        jPanel1.add(jTextNombrej, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 260, 30));

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 0, 204));
        jLabel67.setText("Nombre proveedor");
        jPanel1.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, 30));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 0, 204));
        jLabel59.setText("ID");
        jPanel1.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, 30));

        jidProveedor.setBackground(new java.awt.Color(204, 204, 204));
        jidProveedor.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jidProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jidProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(jidProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 60, 30));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 0, 204));
        jLabel61.setText("Direccion");
        jPanel1.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 170, 80, 30));

        jTextDireccion.setBackground(new java.awt.Color(204, 204, 204));
        jTextDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(jTextDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 260, 30));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 0, 204));
        jLabel60.setText("Telefono");
        jPanel1.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 70, 30));

        jTextTelefono.setBackground(new java.awt.Color(204, 204, 204));
        jTextTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 260, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel58.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 1030, 710));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo con tipografía con inicial para marca personal profesional initial letter typography negro.png"))); // NOI18N
        jLabel2.setText("jLabel1");
        jPanel58.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, -40, 470, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo con tipografía con inicial para marca personal profesional initial letter typography negro.png"))); // NOI18N
        jLabel4.setText("jLabel1");
        jPanel58.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 0, 470, -1));

        getContentPane().add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDireccionActionPerformed

    private void jTextTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTelefonoActionPerformed

    private void jidProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jidProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jidProveedorActionPerformed

    private void AgregarjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarjActionPerformed
        try{
            //Captura datos de la caja de texto

            String nom = jTextNombrej.getText();
            String corr = Correok.getText();
            String di = jTextDireccion.getText();
            String te = jTextTelefono.getText();

            //Agregar validaciones a cajas de texto segun formato y
            //caracteres validos a ingresar
            //comprueba que las cajas de texto no esten vacias
            if (nom.contentEquals("") || corr.contentEquals("")
                || di.contentEquals("")
                || te.contentEquals("")) {
                JOptionPane.showMessageDialog(rootPane,
                    "Todos los campos son obligatorios");

            } else {
                try {

                    Proveedor prov = new Proveedor(nom, corr,di, te);
                    DAOProveedor dao = new DAOProveedor();
                    if (dao.Insertar(prov) == 0) {
                        JOptionPane.showMessageDialog(rootPane,
                            "Registro agregado");

                    }

                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(rootPane, "No se agredo el registro");
                }
            }
            obtenerDatos();//llama a este metodo para que se muestre el nuevo
            //registro en la tabla del formulario
            limpiarCampos();

      

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(jFrameProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AgregarjActionPerformed

    private void jEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarActionPerformed
        int fila=this.jTableProveedor.getSelectedRow();

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
                        int id= Integer.parseInt((String) this.jTableProveedor.
                            getValueAt ( fila, 0).toString());
                        DAOProveedor dao=new DAOProveedor();
                        dao. Eliminar (id);
                        obtenerDatos();

                   
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(jFrameProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }
            }
            if (resp == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog( rootPane,
                    "Ninguna acción realizada");
            }
        }
    }//GEN-LAST:event_jEliminarActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed

        int fila = this.jTableProveedor.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un registro de la tabla");
        } else {
            try {

                int id = Integer.parseInt((String) this.jTableProveedor.getValueAt(fila, 0).toString());
                String nom = (String) this.jTableProveedor.getValueAt(fila, 1).toString();
                String Corr = (String) this.jTableProveedor.getValueAt(fila, 2).toString();
                String Dire = (String) this.jTableProveedor.getValueAt(fila, 3).toString();
                String Tel = (String) this.jTableProveedor.getValueAt(fila, 4).toString();

                jidProveedor.setText("" + id);
                jTextNombrej.setText(nom);
                Correok.setText(Corr);
                jTextDireccion.setText(Dire);
                jTextTelefono.setText(Tel);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane,
                    "¡Ocurrió un ERROR!" + e.getMessage());

            }
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jBuscarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarProActionPerformed
        if (jTextBusca.getText().contentEquals("")) {
            JOptionPane.showMessageDialog(rootPane,
                "Ingrese texto a buscar");
        } else {
            try {
                //Se captura el dato del jtext para hacer la búsqueda de productio
                String datoprod = jTextBusca.getText(); //Llama al método para buscar el producto con el parametro
                buscarProveedor(datoprod);
                jTextBusca.setText("");
          
        }   catch (SQLException ex) {
                java.util.logging.Logger.getLogger(jFrameProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBuscarProActionPerformed

    private void jTextBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextBuscaActionPerformed

    private void jActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jActualizarActionPerformed
        try {
            actualizarProveedor();
}       catch (SQLException ex) {
            java.util.logging.Logger.getLogger(jFrameProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        try {
            obtenerDatos();
}       catch (SQLException ex) {
            java.util.logging.Logger.getLogger(jFrameProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        limpiarCampos();
    }//GEN-LAST:event_jActualizarActionPerformed

    private void jTextNombrejActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombrejActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombrejActionPerformed

    private void jLabelRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegresarMouseClicked
        _principal TK = null;
        try {
            TK = new _principal();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(jFrameProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        TK.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelRegresarMouseClicked

    private void CorreokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorreokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CorreokActionPerformed

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
            java.util.logging.Logger.getLogger(jFrameProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jFrameProveedores().setVisible(true);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(jFrameProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregarj;
    private javax.swing.JFormattedTextField Correok;
    private javax.swing.JButton jActualizar;
    private javax.swing.JButton jBuscarPro;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabelRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JTable jTableProveedor;
    private javax.swing.JFormattedTextField jTextBusca;
    private javax.swing.JFormattedTextField jTextDireccion;
    private javax.swing.JFormattedTextField jTextNombrej;
    private javax.swing.JFormattedTextField jTextTelefono;
    private javax.swing.JFormattedTextField jidProveedor;
    // End of variables declaration//GEN-END:variables
}
