package Vista;

import Controlador._principal;
import ModeloD.Categoria;
import ModeloD.Cliente;
import ModeloD.DAOCategoria;
import ModeloD.DAOClientes;
import ModeloD.DAOProveedor;
import ModeloD.Proveedor;
import java.awt.HeadlessException;
import java.lang.System.Logger.Level;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class jFrameClientes extends javax.swing.JFrame {

    public jFrameClientes() throws SQLException {
        initComponents();
        jTextidCliente.setEnabled(false);
        obtenerDatos();
       
    }

    private void obtenerDatos() throws SQLException {
        try {

//se crea una lista que almacena los datos obtenidos de la BD
            List<Cliente> cliente = new DAOClientes().ObtenerDatos();
            //Define un modelo para la tabla
            DefaultTableModel modelo = new DefaultTableModel();
            //Arreglo con nombre de columna de las tablas
            String[] Columnas = {"ID_Cliente",
                 "Nombre", "Apellido", "Tipo_Cliente"};
            //Establece los nombres definidos de las columnas
            modelo.setColumnIdentifiers(Columnas);
            for (Cliente vi : cliente) {//Recorre cada elemento de la lista y los agrega
                //al modelo de la tabla
                String[] renglon = {Integer.toString(vi.getIDCliente()),
                    vi.getNombre(),
                    vi.getApellido(),
                    vi.getTipo_Cliente()};

                modelo.addRow(renglon);
            }
            jTableCli.setModel(modelo); //Ubica los datos del modelo en la tabla
        } catch (SQLException ex) {
            Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void actualizarCliente() throws SQLException {
        int id = Integer.parseInt(this.jTextidCliente.getText());
        String nom = this.jTextNombre.getText();
        String ape = this.jTextApellido.getText();
        String tip = this.jTipoCliente.getText();

        Cliente Clien = new Cliente(id, nom, ape, tip);

        DAOClientes dao = new DAOClientes();
        int res = dao.Actualizar(Clien);
        if (res == 0) {
            JOptionPane.showMessageDialog(rootPane, "¡Cliente Actualizado!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ocurrió un ERROR!");

        }
    }

    public void limpiarCampos() {
        jTextidCliente.setText("");
        jTextNombre.setText("");
        jTextApellido.setText("");
      

    }
     private void BuscarClientes(String dato) throws SQLException {
        List<Cliente> clientes = new DAOClientes().buscarCliente(dato);
        DefaultTableModel modelo = new DefaultTableModel();

        String[] columnas = {"ID_Cliente", "Nombre", "Apellido",
            "TipoCliente"};

        modelo.setColumnIdentifiers(columnas);
        for (Cliente cli : clientes) {
            String[] renglon = {Integer.toString(cli.getIDCliente()),
                cli.getNombre(), cli.getApellido(), cli.getTipo_Cliente()};
            modelo.addRow(renglon);
        }
        jTableCli.setModel(modelo);
    }
       
             

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTextApellido3 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextApellido1 = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        scrollPane1 = new java.awt.ScrollPane();
        jBactualizar2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextidCliente = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jTextApellido = new javax.swing.JFormattedTextField();
        jTipoCliente = new javax.swing.JTextField();
        jLabelAp = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jagregar = new javax.swing.JButton();
        jEliminar = new javax.swing.JButton();
        jEditar = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();
        buscarCliente = new javax.swing.JFormattedTextField();
        jBActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCli = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Descripcion");

        jTextApellido3.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Total");

        jTextApellido1.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellido1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Clientes");

        jBactualizar2.setBackground(new java.awt.Color(204, 255, 255));
        jBactualizar2.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jBactualizar2.setForeground(new java.awt.Color(0, 0, 153));
        jBactualizar2.setText("Actualizar");
        jBactualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBactualizar2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(75, 158, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Clientes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compras.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 69, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresa.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 70, 70));

        jPanel2.setBackground(new java.awt.Color(125, 185, 246));

        jPanel3.setBackground(new java.awt.Color(125, 185, 246));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextidCliente.setBackground(new java.awt.Color(204, 204, 204));
        jTextidCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextidCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextidClienteActionPerformed(evt);
            }
        });
        jPanel3.add(jTextidCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 49, 25));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("ID");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 17, -1));

        jTextNombre.setBackground(new java.awt.Color(204, 204, 204));
        jTextNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreActionPerformed(evt);
            }
        });
        jPanel3.add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 240, 30));

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Nombre");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 110, 30));

        jLabel.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel.setForeground(new java.awt.Color(0, 0, 204));
        jLabel.setText("Apellido");
        jPanel3.add(jLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 70, 30));

        jTextApellido.setBackground(new java.awt.Color(204, 204, 204));
        jTextApellido.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellidoActionPerformed(evt);
            }
        });
        jPanel3.add(jTextApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 240, 30));

        jTipoCliente.setBackground(new java.awt.Color(204, 204, 204));
        jTipoCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)));
        jPanel3.add(jTipoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 240, 30));

        jLabelAp.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabelAp.setForeground(new java.awt.Color(0, 0, 204));
        jLabelAp.setText("TipoCliente");
        jPanel3.add(jLabelAp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 90, 30));

        jPanel18.setBackground(new java.awt.Color(125, 185, 246));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transacciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft JhengHei Light", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N

        jagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-usuario.png"))); // NOI18N
        jagregar.setText("Agregar");
        jagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jagregarActionPerformed(evt);
            }
        });

        jEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        jEliminar.setText("Eliminar");
        jEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarActionPerformed(evt);
            }
        });

        jEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        jEditar.setText("Editar");
        jEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarActionPerformed(evt);
            }
        });

        jBBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        buscarCliente.setBackground(new java.awt.Color(204, 204, 204));
        buscarCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteActionPerformed(evt);
            }
        });

        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jBActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(74, 74, 74))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEliminar)
                    .addComponent(jEditar))
                .addGap(18, 18, 18)
                .addComponent(jBActualizar)
                .addGap(37, 37, 37)
                .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTableCli.setBackground(new java.awt.Color(103, 172, 242));
        jTableCli.setForeground(new java.awt.Color(0, 0, 153));
        jTableCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableCli);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(99, 99, 99))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 1020, 750));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo con tipografía con inicial para marca personal profesional initial letter typography negro.png"))); // NOI18N
        jLabel6.setText("jLabel1");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 0, 440, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo con tipografía con inicial para marca personal profesional initial letter typography negro.png"))); // NOI18N
        jLabel11.setText("jLabel1");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 440, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido1ActionPerformed

    private void jTextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreActionPerformed

    private void jTextidClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextidClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextidClienteActionPerformed

    private void jTextApellido3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellido3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellido3ActionPerformed

    private void jagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jagregarActionPerformed
        try {
            //Captura datos de la caja de texto

            String nomb = jTextNombre.getText();
            String apell = jTextApellido.getText();
            String tip = jTipoCliente.getText();

            //Agregar validaciones a cajas de texto segun formato y
            //caracteres validos a ingresar
            //comprueba que las cajas de texto no esten vacias
            if (nomb.contentEquals("") || apell.contentEquals("")
                    || tip.contentEquals("")) {
                JOptionPane.showMessageDialog(rootPane,
                        "Todos los campos son obligatorios");

            } else {
                try {

                    Cliente Cli = new Cliente( nomb, apell, tip);
                    DAOClientes dao = new DAOClientes();
                    if (dao.Insertar(Cli) == 0) {
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
            Logger.getLogger(jFrameClientes.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_jagregarActionPerformed

    private void jEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarActionPerformed
  
        int fila=this.jTableCli.getSelectedRow();

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
                        int id= Integer.parseInt((String) this.jTableCli.
                            getValueAt ( fila, 0).toString());
                        DAOClientes dao=new DAOClientes();
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
   
    }//GEN-LAST:event_jEliminarActionPerformed
        
    private void jEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditarActionPerformed

        
        int fila = this.jTableCli.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un registro de la tabla");
        } else {
            try {

                int id = Integer.parseInt((String) this.jTableCli.getValueAt(fila, 0).toString());
                String nom = (String) this.jTableCli.getValueAt(fila, 1).toString();
                String ape = (String) this.jTableCli.getValueAt(fila, 2).toString();
                String Tip = (String) this.jTableCli.getValueAt(fila, 3).toString();
                

                jTextidCliente.setText("" + id);
                jTextNombre.setText(nom);
                jTextApellido.setText(ape);
                jTipoCliente.setText(Tip);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane,
                        "¡Ocurrió un ERROR!" + e.getMessage());

            }
        }

    }//GEN-LAST:event_jEditarActionPerformed

    private void buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarClienteActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        _principal TK = null;
        try {
            TK = new _principal();
        } catch (SQLException ex) {
            Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        TK.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jTextApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellidoActionPerformed

    private void jBactualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBactualizar2ActionPerformed
      
    }//GEN-LAST:event_jBactualizar2ActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
try {
      actualizarCliente();
} catch (SQLException ex) {
     Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null,ex);
     
  }   
  try {
      obtenerDatos();
      } catch (SQLException ex) {
     Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null,ex);
  }
     limpiarCampos();      
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
if (buscarCliente.getText().contentEquals("")) {
            JOptionPane.showMessageDialog(rootPane,
                    "Ingrese texto a buscar");
        } else {
            try {
                //Se obtiene el dato de la caja de texto, para realizar busqueda
                String dato = buscarCliente.getText();
                //Llamada al método para buscar cliente
                BuscarClientes(dato);
                buscarCliente.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(jFrameVentaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }        
    }//GEN-LAST:event_jBBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jFrameClientes().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jFrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField buscarCliente;
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBactualizar2;
    private javax.swing.JButton jEditar;
    private javax.swing.JButton jEliminar;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCli;
    private javax.swing.JFormattedTextField jTextApellido;
    private javax.swing.JFormattedTextField jTextApellido1;
    private javax.swing.JFormattedTextField jTextApellido3;
    private javax.swing.JFormattedTextField jTextNombre;
    private javax.swing.JFormattedTextField jTextidCliente;
    private javax.swing.JTextField jTipoCliente;
    private javax.swing.JButton jagregar;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables
}
