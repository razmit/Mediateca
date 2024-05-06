package com.mediateca.views;

import com.mediateca.utils.dbmodels.ModelBooks;
import com.mediateca.utils.dbmodels.ModelCDs;
import com.mediateca.utils.dbmodels.ModelDVDs;
import com.mediateca.utils.dbmodels.ModelMagazines;
import com.mediateca.utils.services.ServiceBooks;
import com.mediateca.utils.services.ServiceCDS;
import com.mediateca.utils.services.ServiceDVDS;
import com.mediateca.utils.services.ServiceMagazines;
import com.mediateca.utils.tablemodels.BooksTablemodel;
import com.mediateca.utils.tablemodels.CDsTablemodel;
import com.mediateca.utils.tablemodels.DVDsTablemodel;
import com.mediateca.utils.tablemodels.MagazinesTablemodel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 10kai
 */
public class Busqueda extends javax.swing.JFrame {

    /**
     * Creates new form Busqueda
     *
     * @param tipo_media
     */
    private String tipo_media;

    public Busqueda(String tipo_media) {
        initComponents();
        this.tipo_media = tipo_media;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_buscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        result_table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });

        result_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(result_table);

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit(3).png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete(1).png"))); // NOI18N
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btn_buscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Búsqueda");
        jLabel1.setToolTipText("");

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-hacia-atras (1).png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(298, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(295, 295, 295)
                        .addComponent(btnRegresar)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(342, 342, 342))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(277, 277, 277)
                                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 188, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_buscar)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton2))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //  editar
//        edicion edic = new edicion();
//        edic.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        int i = JOptionPane.showConfirmDialog(null,"Está seguro que desea borrar este dato?");
        if (i ==0 ){
        }else if(i ==1){}
        else{}

    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.setLocationRelativeTo(null);
            menuPrincipal.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        
        String searchTerm;
        // Buscar
        try {
            switch (tipo_media) {
                case "CD":

                    ServiceCDS serviceCDs = new ServiceCDS();

                    searchTerm = txt_buscar.getText();
                    try {

                        List<ModelCDs> listCDs = serviceCDs.searchAllCDs(searchTerm);

                        String[] columnNames = {"ID CD", "Codigo", "Titulo", "# Disponibles", "Artista", "Genero", "Duracion", "# Canciones", "Tipo de material"};
                        CDsTablemodel tableModel = new CDsTablemodel(columnNames, listCDs);

                        result_table.setModel(tableModel);
                    } catch (Exception e) {
                        System.out.println("Exception en Búsqueda: " + e.getLocalizedMessage());
                    }
                break;
                case "DVD":
                    ServiceDVDS serviceDVDs = new ServiceDVDS();

                    searchTerm = txt_buscar.getText();
                    try {

                        List<ModelDVDs> listDVDs = serviceDVDs.searchAllDVDs(searchTerm);

                        String[] columnNames = {"ID Libro", "Codigo", "Titulo", "# Disponibles", "Autor", "# Páginas", "Editorial", "ISBN", "Año publicación", "Tipo de material"};
                        DVDsTablemodel tableModel = new DVDsTablemodel(columnNames, listDVDs);

                        result_table.setModel(tableModel);
                    } catch (Exception e) {
                        System.out.println("Exception en Búsqueda: " + e.getLocalizedMessage());
                    }
                break;
                case "Book":
                    
                    ServiceBooks serviceBooks = new ServiceBooks();

                    searchTerm = txt_buscar.getText();
                    try {

                        List<ModelBooks> listBooks = serviceBooks.searchAllBooks(searchTerm);

                        String[] columnNames = {"ID Libro", "Codigo", "Titulo", "# Disponibles", "Autor", "# Páginas", "Editorial", "ISBN", "Año publicación", "Tipo de material"};
                        BooksTablemodel tableModel = new BooksTablemodel(columnNames, listBooks);

                        result_table.setModel(tableModel);
                    } catch (Exception e) {
                        System.out.println("Exception en Búsqueda: " + e.getLocalizedMessage());
                    }
                break;
                case "Magazine":
                    ServiceMagazines serviceMags = new ServiceMagazines();

                    searchTerm = txt_buscar.getText();
                    try {

                        List<ModelMagazines> listMags = serviceMags.searchAllMagazines(searchTerm);

                        String[] columnNames = {"ID Revista", "Codigo", "Titulo", "# Disponibles", "Editorial", "Periodicidad", "Fecha publicación", "Tipo de material"};
                        MagazinesTablemodel tableModel = new MagazinesTablemodel(columnNames, listMags);

                        result_table.setModel(tableModel);
                    } catch (Exception e) {
                        System.out.println("Exception en Búsqueda: " + e.getLocalizedMessage());
                    }
                break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable result_table;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
