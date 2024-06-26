
package Controlador;

import ModeloD.DAOProveedor;
import ModeloD.DAOVenta_factura;
import ModeloD.Proveedor;

import Vista.jFrameCategorias;
import Vista.jFrameClientes;
import Vista.jFrameCompra_factura;
import Vista.jFrameProductos;
import Vista.jFrameProveedores;
import Vista.jFrameVentaFactura;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
public class _principal extends javax.swing.JFrame {
    
  
 public _principal() throws SQLException {
        initComponents();
    jDialogReporte.setLocationRelativeTo(null);
 }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jLabelProveedores24 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jLabelProveedores23 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabelProveedores21 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabelProveedores18 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabelProveedores17 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabelProveedores8 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        jLabelProveedores48 = new javax.swing.JLabel();
        jLabelProveedores1 = new javax.swing.JLabel();
        jLabelProveedores16 = new javax.swing.JLabel();
        jLabelProveedores32 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jLabelProveedores45 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabelProveedores20 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabelProveedores3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelProveedores19 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabelProveedores27 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabelProveedores44 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabelProveedores43 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabelProveedores42 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabelProveedores31 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabelProveedores30 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabelProveedores29 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jLabelProveedores40 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jLabelProveedores39 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabelProveedores38 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jLabelProveedores37 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabelProveedores41 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabelProveedores2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabelProveedores5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabelProveedores6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabelProveedores7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabelProveedores9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabelProveedores10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabelProveedores11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabelProveedores12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabelProveedores13 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabelProveedores14 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabelProveedores15 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabelProveedores34 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabelProveedores35 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabelProveedores33 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jDialogReporte = new javax.swing.JDialog();
        jPanel28 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        IngresoTotal = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabelReportes = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabeCompras = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabelVentas = new javax.swing.JLabel();
        jSalir = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jLabelProductos = new javax.swing.JLabel();
        jLabelClientes = new javax.swing.JLabel();
        jLabelCategorias = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelProveedores36 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel57.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores24.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores24.setText("Proveedor");
        jLabelProveedores24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores24MouseClicked(evt);
            }
        });

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores24)
                .addGap(26, 26, 26))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel56.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores23.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores23.setText("Proveedor");
        jLabelProveedores23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores23MouseClicked(evt);
            }
        });

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores23)
                .addGap(26, 26, 26))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel38.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores21.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores21.setText("Proveedor");
        jLabelProveedores21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores21MouseClicked(evt);
            }
        });

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores21)
                .addGap(26, 26, 26))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel36.setBackground(new java.awt.Color(48, 149, 242));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addGap(125, 125, 125))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel34.setBackground(new java.awt.Color(48, 149, 242));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addGap(125, 125, 125))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel33.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores18.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores18.setText("Proveedor");
        jLabelProveedores18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores18MouseClicked(evt);
            }
        });

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores18)
                .addGap(26, 26, 26))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel32.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores17.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores17.setText("Proveedor");
        jLabelProveedores17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores17MouseClicked(evt);
            }
        });

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores17)
                .addGap(26, 26, 26))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel31.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores8.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores8.setText("Proveedor");
        jLabelProveedores8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores8MouseClicked(evt);
            }
        });

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores8)
                .addGap(26, 26, 26))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel30.setBackground(new java.awt.Color(48, 149, 242));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(125, 125, 125))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel29.setBackground(new java.awt.Color(48, 149, 242));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(125, 125, 125))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(48, 149, 242));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(125, 125, 125))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(48, 149, 242));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(125, 125, 125))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel66.setBackground(new java.awt.Color(48, 149, 242));

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLabelProveedores48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores48.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores48.setText("Proveedor");
        jLabelProveedores48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores48MouseClicked(evt);
            }
        });

        jLabelProveedores1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores1.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores1.setText("Proveedor");
        jLabelProveedores1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores1MouseClicked(evt);
            }
        });

        jLabelProveedores16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores16.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores16.setText("Proveedor");
        jLabelProveedores16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores16MouseClicked(evt);
            }
        });

        jLabelProveedores32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores32.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores32.setText("Proveedor");
        jLabelProveedores32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores32MouseClicked(evt);
            }
        });

        jPanel62.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores45.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores45.setText("Proveedor");
        jLabelProveedores45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores45MouseClicked(evt);
            }
        });

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores45)
                .addGap(182, 182, 182))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProveedores45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel62Layout.createSequentialGroup()
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))))
        );

        jPanel63.setBackground(new java.awt.Color(48, 149, 242));

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jLabelProveedores20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores20.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores20.setText("Proveedor");
        jLabelProveedores20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jLabel63)
                .addGap(125, 125, 125))
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProveedores20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel65.setBackground(new java.awt.Color(48, 149, 242));

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel65Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel65)
                .addGap(125, 125, 125))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabelProveedores3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores3.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores3.setText("Proveedor");
        jLabelProveedores3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores3MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jLabelProveedores19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores19.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores19.setText("Proveedor");
        jLabelProveedores19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores19MouseClicked(evt);
            }
        });

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jLabelProveedores27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores27.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores27.setText("Proveedor");
        jLabelProveedores27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores27MouseClicked(evt);
            }
        });

        jPanel54.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores44.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores44.setText("Proveedor");
        jLabelProveedores44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores44MouseClicked(evt);
            }
        });

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores44)
                .addGap(26, 26, 26))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel53.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores43.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores43.setText("Proveedor");
        jLabelProveedores43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores43MouseClicked(evt);
            }
        });

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores43)
                .addGap(26, 26, 26))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel52.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores42.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores42.setText("Proveedor");
        jLabelProveedores42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores42MouseClicked(evt);
            }
        });

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores42)
                .addGap(26, 26, 26))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jLabelProveedores31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores31.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores31.setText("Proveedor");
        jLabelProveedores31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores31MouseClicked(evt);
            }
        });

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jLabelProveedores30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores30.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores30.setText("Proveedor");
        jLabelProveedores30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores30MouseClicked(evt);
            }
        });

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jLabelProveedores29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores29.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores29.setText("Proveedor");
        jLabelProveedores29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores29MouseClicked(evt);
            }
        });

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel50.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores40.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores40.setText("Proveedor");
        jLabelProveedores40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores40MouseClicked(evt);
            }
        });

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores40)
                .addGap(26, 26, 26))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel49.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores39.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores39.setText("Proveedor");
        jLabelProveedores39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores39MouseClicked(evt);
            }
        });

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores39)
                .addGap(26, 26, 26))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel48.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores38.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores38.setText("Proveedor");
        jLabelProveedores38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores38MouseClicked(evt);
            }
        });

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores38)
                .addGap(26, 26, 26))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel47.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores37.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores37.setText("Proveedor");
        jLabelProveedores37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores37MouseClicked(evt);
            }
        });

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores37)
                .addGap(26, 26, 26))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel51.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores41.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores41.setText("Proveedor");
        jLabelProveedores41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores41MouseClicked(evt);
            }
        });

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores41)
                .addGap(26, 26, 26))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(48, 149, 242));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores2.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores2.setText("Proveedor");
        jLabelProveedores2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores2MouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel7.setBackground(new java.awt.Color(48, 149, 242));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel8.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores5.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores5.setText("Proveedor");
        jLabelProveedores5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores5MouseClicked(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel9.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores6.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores6.setText("Proveedor");
        jLabelProveedores6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores6MouseClicked(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel10.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores7.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores7.setText("Proveedor");
        jLabelProveedores7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores7MouseClicked(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores7)
                .addGap(26, 26, 26))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores6)
                .addGap(26, 26, 26))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores5)
                .addGap(26, 26, 26))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel11.setBackground(new java.awt.Color(48, 149, 242));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel12.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores9.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores9.setText("Proveedor");
        jLabelProveedores9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores9MouseClicked(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel15.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores10.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores10.setText("Proveedor");
        jLabelProveedores10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores10MouseClicked(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel16.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores11.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores11.setText("Proveedor");
        jLabelProveedores11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores11MouseClicked(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores11)
                .addGap(26, 26, 26))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores12.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores12.setText("Proveedor");
        jLabelProveedores12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores12MouseClicked(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel18.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores13.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores13.setText("Proveedor");
        jLabelProveedores13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores13MouseClicked(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel19.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores14.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores14.setText("Proveedor");
        jLabelProveedores14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores14MouseClicked(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel20.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores15.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores15.setText("Proveedor");
        jLabelProveedores15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores15MouseClicked(evt);
            }
        });

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores15)
                .addGap(26, 26, 26))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores14)
                .addGap(26, 26, 26))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores13)
                .addGap(26, 26, 26))
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores12)
                .addGap(26, 26, 26))
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores10)
                .addGap(26, 26, 26))
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores9)
                .addGap(26, 26, 26))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel21.setBackground(new java.awt.Color(48, 149, 242));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel42.setBackground(new java.awt.Color(48, 149, 242));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel43.setBackground(new java.awt.Color(48, 149, 242));

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel44.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores34.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores34.setText("Proveedor");
        jLabelProveedores34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores34MouseClicked(evt);
            }
        });

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        jPanel45.setBackground(new java.awt.Color(48, 149, 242));

        jLabelProveedores35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores35.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores35.setText("Proveedor");
        jLabelProveedores35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores35MouseClicked(evt);
            }
        });

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores35)
                .addGap(26, 26, 26))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores34)
                .addGap(26, 26, 26))
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel44Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel44Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel43)
                .addGap(125, 125, 125))
            .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel43Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel43Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addGap(125, 125, 125))
            .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel42Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel42Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(125, 125, 125))
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(125, 125, 125))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(125, 125, 125))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores2)
                .addGap(26, 26, 26))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProveedores2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(125, 125, 125))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLabelProveedores33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelProveedores33.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores33.setText("Proveedor");
        jLabelProveedores33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores33MouseClicked(evt);
            }
        });

        jPanel46.setBackground(new java.awt.Color(48, 149, 242));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel46)
                .addGap(125, 125, 125))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(48, 149, 242));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(48, 149, 242));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        jPanel55.setBackground(new java.awt.Color(110, 172, 222));

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jDialogReporte.setBackground(new java.awt.Color(51, 153, 255));
        jDialogReporte.setSize(new java.awt.Dimension(900, 600));
        jDialogReporte.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel28.setBackground(new java.awt.Color(125, 185, 246));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel58.setBackground(new java.awt.Color(92, 169, 246));
        jPanel58.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 255), new java.awt.Color(51, 204, 255)));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/deposito.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("ProductosVendidos");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 51, 255));
        jLabel59.setText("StockMinimo");

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 153, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cantidad-de-ventas.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 51, 255));
        jLabel60.setText("CantidadVendida");

        IngresoTotal.setBackground(new java.awt.Color(51, 153, 255));
        IngresoTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ganador.png"))); // NOI18N
        IngresoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresoTotalActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 51, 255));
        jLabel64.setText("IngresoTotal");

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addGap(18, 18, 18)
                        .addComponent(IngresoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(503, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(37, 37, 37)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IngresoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jPanel28.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 118, 750, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Reportes");
        jPanel28.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 230, 66));

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/analisis-de-los-datos.png"))); // NOI18N
        jPanel28.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 100));

        jDialogReporte.getContentPane().add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -3, 890, 590));

        jLabel61.setText("jLabel61");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(125, 185, 246));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(48, 149, 242));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 255), null, null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel37.setBackground(new java.awt.Color(48, 149, 242));
        jPanel37.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 255)));

        jLabelReportes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelReportes.setForeground(new java.awt.Color(153, 255, 255));
        jLabelReportes.setText("ReporteVenta");
        jLabelReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelReportesMouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/analisis-de-los-datos (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelReportes)
                .addGap(20, 20, 20))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(jLabelReportes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 200, 50));

        jPanel41.setBackground(new java.awt.Color(48, 149, 242));
        jPanel41.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 255)));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proyecto-de-ley (1).png"))); // NOI18N

        jLabeCompras.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabeCompras.setForeground(new java.awt.Color(153, 255, 255));
        jLabeCompras.setText("CompraFactura");
        jLabeCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabeComprasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabeCompras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(jLabeCompras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 200, 50));

        jPanel40.setBackground(new java.awt.Color(48, 149, 242));
        jPanel40.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 255)));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/punto-de-venta (1).png"))); // NOI18N

        jLabelVentas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelVentas.setForeground(new java.awt.Color(153, 255, 255));
        jLabelVentas.setText("VentaFactura");
        jLabelVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVentasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelVentas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(jLabelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 200, 50));

        jSalir.setBackground(new java.awt.Color(204, 204, 204));
        jSalir.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jSalir.setForeground(new java.awt.Color(51, 51, 255));
        jSalir.setText("Salir");
        jSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSalirMouseClicked(evt);
            }
        });
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });
        jPanel2.add(jSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 100, 30));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 220, 570));

        jPanel39.setBackground(new java.awt.Color(48, 149, 242));
        jPanel39.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 204), null, null));

        jLabelProductos.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabelProductos.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProductos.setText("Producto");
        jLabelProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProductosMouseClicked(evt);
            }
        });

        jLabelClientes.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabelClientes.setForeground(new java.awt.Color(153, 255, 255));
        jLabelClientes.setText("Clientes");
        jLabelClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelClientesMouseClicked(evt);
            }
        });

        jLabelCategorias.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabelCategorias.setForeground(new java.awt.Color(153, 255, 255));
        jLabelCategorias.setText("Categoria");
        jLabelCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCategoriasMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estar.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categoria.png"))); // NOI18N

        jLabelProveedores36.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabelProveedores36.setForeground(new java.awt.Color(153, 255, 255));
        jLabelProveedores36.setText("Proveedor");
        jLabelProveedores36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProveedores36MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/convenio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCategorias)
                .addGap(63, 63, 63)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProductos)
                .addGap(69, 69, 69)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProveedores36)
                .addGap(58, 58, 58)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelClientes)
                .addContainerGap(306, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProveedores36, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 50));

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Distribuidora (1).png"))); // NOI18N
        jLabel58.setText("jLabel58");
        jPanel4.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 850, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelClientesMouseClicked
        try{
        dispose();
          jFrameClientes na=new jFrameClientes();
           na.setVisible(true);
       }catch (SQLException ex){
           java.util.logging.Logger.getLogger(_principal.class.getName()).
                log(java.util.logging.Level.SEVERE,null,ex);
       }
    }//GEN-LAST:event_jLabelClientesMouseClicked

    private void jLabelReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReportesMouseClicked
        jDialogReporte.setVisible(true);
    }//GEN-LAST:event_jLabelReportesMouseClicked

    private void jLabeComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabeComprasMouseClicked
      try{
        dispose();
         jFrameCompra_factura na=new jFrameCompra_factura();
           na.setVisible(true);
       }catch (SQLException ex){
           java.util.logging.Logger.getLogger(_principal.class.getName()).
                log(java.util.logging.Level.SEVERE,null,ex);
       }
    }//GEN-LAST:event_jLabeComprasMouseClicked

    private void jLabelVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVentasMouseClicked
       try{
           dispose();
         jFrameVentaFactura  na=new jFrameVentaFactura();
           na.setVisible(true);
       }catch (SQLException ex){
           java.util.logging.Logger.getLogger(_principal.class.getName()).
                log(java.util.logging.Level.SEVERE,null,ex);
       }
    }//GEN-LAST:event_jLabelVentasMouseClicked

    private void jLabelCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCategoriasMouseClicked
       try{
        dispose();
          jFrameCategorias na=new jFrameCategorias();
           na.setVisible(true);
       }catch (SQLException ex){
           java.util.logging.Logger.getLogger(_principal.class.getName()).
                log(java.util.logging.Level.SEVERE,null,ex);
       }
    }//GEN-LAST:event_jLabelCategoriasMouseClicked

    private void jLabelProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProductosMouseClicked
        try{
          dispose();
            jFrameProductos na=new jFrameProductos();
            na.setVisible(true);
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(_principal.class.getName()).
            log(java.util.logging.Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_jLabelProductosMouseClicked

    private void jLabelProveedores1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores1MouseClicked

    private void jLabelProveedores3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores3MouseClicked

    private void jLabelProveedores16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores16MouseClicked

    private void jLabelProveedores19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores19MouseClicked

    private void jLabelProveedores27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores27MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores27MouseClicked

    private void jLabelProveedores29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores29MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores29MouseClicked

    private void jLabelProveedores30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores30MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores30MouseClicked

    private void jLabelProveedores31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores31MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores31MouseClicked

    private void jLabelProveedores32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores32MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores32MouseClicked

    private void jLabelProveedores33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores33MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores33MouseClicked

    private void jLabelProveedores34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores34MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores34MouseClicked

    private void jLabelProveedores35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores35MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores35MouseClicked

    private void jLabelProveedores36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores36MouseClicked
       
try{
        dispose();
          jFrameProveedores na=new jFrameProveedores();
           na.setVisible(true);
       }catch (SQLException ex){
           java.util.logging.Logger.getLogger(_principal.class.getName()).
                log(java.util.logging.Level.SEVERE,null,ex);
       }



    }//GEN-LAST:event_jLabelProveedores36MouseClicked

    private void jLabelProveedores37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores37MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores37MouseClicked

    private void jLabelProveedores38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores38MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores38MouseClicked

    private void jLabelProveedores39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores39MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores39MouseClicked

    private void jLabelProveedores40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores40MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores40MouseClicked

    private void jLabelProveedores41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores41MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores41MouseClicked

    private void jLabelProveedores42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores42MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores42MouseClicked

    private void jLabelProveedores43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores43MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores43MouseClicked

    private void jLabelProveedores44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores44MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores44MouseClicked

    private void jLabelProveedores2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores2MouseClicked

    private void jLabelProveedores7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores7MouseClicked

    private void jLabelProveedores6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores6MouseClicked

    private void jLabelProveedores5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores5MouseClicked

    private void jLabelProveedores15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores15MouseClicked

    private void jLabelProveedores14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores14MouseClicked

    private void jLabelProveedores13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores13MouseClicked

    private void jLabelProveedores12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores12MouseClicked

    private void jLabelProveedores11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores11MouseClicked

    private void jLabelProveedores10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores10MouseClicked

    private void jLabelProveedores9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores9MouseClicked

    private void jLabelProveedores8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores8MouseClicked

    private void jLabelProveedores17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores17MouseClicked

    private void jLabelProveedores18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores18MouseClicked

    private void jLabelProveedores20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores20MouseClicked
       
    }//GEN-LAST:event_jLabelProveedores20MouseClicked

    private void jLabelProveedores21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores21MouseClicked

    }//GEN-LAST:event_jLabelProveedores21MouseClicked

    private void jLabelProveedores23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores23MouseClicked
     
    }//GEN-LAST:event_jLabelProveedores23MouseClicked

    private void jLabelProveedores24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores24MouseClicked
      
    }//GEN-LAST:event_jLabelProveedores24MouseClicked

    private void jLabelProveedores45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores45MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores45MouseClicked

    private void jLabelProveedores48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProveedores48MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProveedores48MouseClicked

    private void jSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalirMouseClicked
JDialog.setDefaultLookAndFeelDecorated(true); 
int resp = JOptionPane.showConfirmDialog(null,
"¿ Desea salir del sistema ?",  

"Advertencia",

 JOptionPane. YES_NO_OPTION,

 JOptionPane.QUESTION_MESSAGE);

 setVisible(false);
 
  if (resp != JOptionPane.NO_OPTION) {
        } else {
    setVisible(true);
        }       
    }//GEN-LAST:event_jSalirMouseClicked

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
DAOVenta_factura Vent=new DAOVenta_factura();
try{
    Vent.productoStockBajo();
}    catch (JRException ex) {
         java.util.logging.Logger.getLogger(_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }finally{
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
DAOVenta_factura Vent=new DAOVenta_factura();
try{
    Vent.ProductosVendidos();
}    catch (JRException ex) {
         java.util.logging.Logger.getLogger(_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }finally{
}         // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
DAOVenta_factura can=new DAOVenta_factura();
        try{
    can.CantidadVendida();
}    catch (JRException ex) {
         java.util.logging.Logger.getLogger(_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }finally{
}         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void IngresoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresoTotalActionPerformed
       DAOVenta_factura can=new DAOVenta_factura();
        try{
    can.IngresoTotal();
}    catch (JRException ex) {
         java.util.logging.Logger.getLogger(_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }finally{
}  // TODO add your handling code here:
    }//GEN-LAST:event_IngresoTotalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new _principal().setVisible(true);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                
            } 
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IngresoTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialogReporte;
    private javax.swing.JLabel jLabeCompras;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCategorias;
    private javax.swing.JLabel jLabelClientes;
    private javax.swing.JLabel jLabelProductos;
    private javax.swing.JLabel jLabelProveedores1;
    private javax.swing.JLabel jLabelProveedores10;
    private javax.swing.JLabel jLabelProveedores11;
    private javax.swing.JLabel jLabelProveedores12;
    private javax.swing.JLabel jLabelProveedores13;
    private javax.swing.JLabel jLabelProveedores14;
    private javax.swing.JLabel jLabelProveedores15;
    private javax.swing.JLabel jLabelProveedores16;
    private javax.swing.JLabel jLabelProveedores17;
    private javax.swing.JLabel jLabelProveedores18;
    private javax.swing.JLabel jLabelProveedores19;
    private javax.swing.JLabel jLabelProveedores2;
    private javax.swing.JLabel jLabelProveedores20;
    private javax.swing.JLabel jLabelProveedores21;
    private javax.swing.JLabel jLabelProveedores23;
    private javax.swing.JLabel jLabelProveedores24;
    private javax.swing.JLabel jLabelProveedores27;
    private javax.swing.JLabel jLabelProveedores29;
    private javax.swing.JLabel jLabelProveedores3;
    private javax.swing.JLabel jLabelProveedores30;
    private javax.swing.JLabel jLabelProveedores31;
    private javax.swing.JLabel jLabelProveedores32;
    private javax.swing.JLabel jLabelProveedores33;
    private javax.swing.JLabel jLabelProveedores34;
    private javax.swing.JLabel jLabelProveedores35;
    private javax.swing.JLabel jLabelProveedores36;
    private javax.swing.JLabel jLabelProveedores37;
    private javax.swing.JLabel jLabelProveedores38;
    private javax.swing.JLabel jLabelProveedores39;
    private javax.swing.JLabel jLabelProveedores40;
    private javax.swing.JLabel jLabelProveedores41;
    private javax.swing.JLabel jLabelProveedores42;
    private javax.swing.JLabel jLabelProveedores43;
    private javax.swing.JLabel jLabelProveedores44;
    private javax.swing.JLabel jLabelProveedores45;
    private javax.swing.JLabel jLabelProveedores48;
    private javax.swing.JLabel jLabelProveedores5;
    private javax.swing.JLabel jLabelProveedores6;
    private javax.swing.JLabel jLabelProveedores7;
    private javax.swing.JLabel jLabelProveedores8;
    private javax.swing.JLabel jLabelProveedores9;
    private javax.swing.JLabel jLabelReportes;
    private javax.swing.JLabel jLabelVentas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jSalir;
    // End of variables declaration//GEN-END:variables

}
