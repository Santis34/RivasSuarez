
package Vista;

import Controlador._principal;
import ModeloD.Categoria;
import ModeloD.DAOCategoria;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class jFrameCategorias extends javax.swing.JFrame {
    
   
public jFrameCategorias() throws SQLException {
      initComponents();
        jidCategoria.setEnabled(false);
         obtenerDatos();
    }
    
    private void obtenerDatos() throws SQLException {
        //se crea una lista que almacena los datos obtenidos de la BD
        List<Categoria> cat = new DAOCategoria().ObtenerDatos();
        //Define un modelo para la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        //Arreglo con nombre de columna de las tablas
        String[] Columnas = {"ID_Categoria","NombreCategoria"};
        //Establece los nombres definidos de las columnas
        modelo.setColumnIdentifiers(Columnas);
      for (Categoria ca : cat){//Recorre cada elemento de la lista y los agrega
            //al modelo de la tabla
         String[] renglon = {Integer.toString(ca.getId_Categoria()) 
         , ca.getNombreCategoria().toString()};
                 
          modelo.addRow(renglon);
         }
      jTableCategoria.setModel(modelo); //Ubica los datos del modelo en la tabla
        }
  
      public void actualizarCategoria() throws SQLException {
int id=Integer.parseInt( this.jidCategoria.getText());
String nomC=this.jTextCategoria.getText();
Categoria Cat=new Categoria(id, nomC);
DAOCategoria dao=new DAOCategoria();
int res = dao.Actualizar(Cat);
if (res == 0) {
JOptionPane.showMessageDialog( rootPane, "¡Categoria Actualizada!");
} else {
JOptionPane.showMessageDialog( rootPane,  "Ocurrió un ERROR!");

}
   }
             public void limpiarCategoria() {
         jidCategoria.setText("");
         jTextCategoria.setText(null);
             }
             
             
      
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelRegresa = new javax.swing.JLabel();
        jTextFiltar = new javax.swing.JFormattedTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCategoria = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jAgregar = new javax.swing.JButton();
        jBorrar = new javax.swing.JButton();
        jEditar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextCategoria = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jidCategoria = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabelRegresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresa.png"))); // NOI18N
        jLabelRegresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegresaMouseClicked(evt);
            }
        });

        jTextFiltar.setBackground(new java.awt.Color(204, 204, 204));
        jTextFiltar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextFiltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFiltarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(75, 158, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableCategoria.setBackground(new java.awt.Color(103, 172, 242));
        jTableCategoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableCategoria);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, 918, 190));

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 55)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Categoria");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/categorias.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 144, 132));

        jPanel18.setBackground(new java.awt.Color(125, 185, 246));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transacciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft JhengHei Light", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N

        jAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-usuario.png"))); // NOI18N
        jAgregar.setText("Agregar");
        jAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgregarActionPerformed(evt);
            }
        });

        jBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        jBorrar.setText("Eliminar");
        jBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBorrarActionPerformed(evt);
            }
        });

        jEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        jEditar.setText("Editar");
        jEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarActionPerformed(evt);
            }
        });

        Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar-pagina.png"))); // NOI18N
        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEditar)
                    .addComponent(jBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, 280, 270));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresa.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 23, -1, 62));

        jPanel2.setBackground(new java.awt.Color(125, 185, 246));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Categoria", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 0, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextCategoria.setBackground(new java.awt.Color(204, 204, 204));
        jTextCategoria.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jTextCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCategoriaActionPerformed(evt);
            }
        });
        jPanel2.add(jTextCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 327, 35));

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText("Nombre Categoria");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 140, 35));

        jidCategoria.setBackground(new java.awt.Color(204, 204, 204));
        jidCategoria.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jidCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jidCategoriaActionPerformed(evt);
            }
        });
        jPanel2.add(jidCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 67, 32));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("ID");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 40, 32));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 620, 270));

        jPanel3.setBackground(new java.awt.Color(125, 185, 246));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 1040, 750));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo con tipografía con inicial para marca personal profesional initial letter typography negro.png"))); // NOI18N
        jLabel5.setText("jLabel1");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 470, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo con tipografía con inicial para marca personal profesional initial letter typography negro.png"))); // NOI18N
        jLabel6.setText("jLabel1");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 0, 470, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 1386, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jidCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jidCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jidCategoriaActionPerformed

    private void jAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgregarActionPerformed
     //Captura datos de la caja de texto
        String nombCat = jTextCategoria.getText();
       
        // Agregar validacines a cajas de texto segun fromato y
        // caracteres validos a ingresar
        // comprueba que las cajas de texto no esten vacias 
        if (nombCat.contentEquals("")) {
            JOptionPane.showMessageDialog(rootPane,
                    "Todos los campos son obligatorios llenar");
        } else {
            try {
              
               
                Categoria Cat = new Categoria ( nombCat );
                DAOCategoria dao = new DAOCategoria();
                if (dao.Insertar(Cat) == 0) {
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
        Logger.getLogger(jFrameCategorias.class.getName()).log(Level.SEVERE, null, ex);
    }
        //Registro en la tabla del formulario
        limpiarCategoria();   //Llama a este metodo para limpiar las cajas de texto
    }//GEN-LAST:event_jAgregarActionPerformed

    private void jBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBorrarActionPerformed
        int fila=this.jTableCategoria.getSelectedRow();

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
int id= Integer.parseInt((String) this.jTableCategoria.
getValueAt ( fila, 0).toString());
DAOCategoria dao=new DAOCategoria();
dao. Eliminar (id);
obtenerDatos();

} catch (SQLException ex) {
Logger.getLogger ( jFrameCategorias.class.getName()).
log ( Level.SEVERE, null,  ex);
}
  }
    }
if (resp == JOptionPane.CLOSED_OPTION) {
JOptionPane.showMessageDialog( rootPane,
"Ninguna acción realizada");
}
    }//GEN-LAST:event_jBorrarActionPerformed
    }
    private void jEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditarActionPerformed
        int fila=this.jTableCategoria.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(rootPane, "Seleccione un registro de la tabla");
        } else {
    try {
        
int id = Integer.parseInt((String)this.jTableCategoria.getValueAt(fila, 0).toString());
   String NomCat=(String)this.jTableCategoria.getValueAt(fila,1).toString();

   
                jidCategoria.setText("" + id);
                jTextCategoria.setText(NomCat);         
                 } catch (NumberFormatException e) {
                     JOptionPane.showMessageDialog(rootPane,
                             "¡Ocurrió un ERROR!"+e.getMessage()); 
                
                 }
                 
    }//GEN-LAST:event_jEditarActionPerformed
    }
    private void jTextFiltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFiltarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFiltarActionPerformed

    private void jLabelRegresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegresaMouseClicked
       
    }//GEN-LAST:event_jLabelRegresaMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
         _principal TK = null;
    try {
        TK = new _principal();
    } catch (SQLException ex) {
        Logger.getLogger(jFrameCategorias.class.getName()).log(Level.SEVERE, null, ex);
    }
        TK.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        try {
      actualizarCategoria();
} catch (SQLException ex) {
     Logger.getLogger(jFrameCategorias.class.getName()).log(Level.SEVERE, null,ex);
     
  }   
  try {
      obtenerDatos();
      } catch (SQLException ex) {
     Logger.getLogger(jFrameCategorias.class.getName()).log(Level.SEVERE, null,ex);
  }
     limpiarCategoria();

    }//GEN-LAST:event_ActualizarActionPerformed

    private void jTextCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(jFrameCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jFrameCategorias().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jFrameCategorias.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton jAgregar;
    private javax.swing.JButton jBorrar;
    private javax.swing.JButton jEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelRegresa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTableCategoria;
    private javax.swing.JFormattedTextField jTextCategoria;
    private javax.swing.JFormattedTextField jTextFiltar;
    private javax.swing.JFormattedTextField jidCategoria;
    // End of variables declaration//GEN-END:variables
}
