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
import javax.swing.JOptionPane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.List;

/**
 *
 * @author 10kai
 */
public class Listar extends javax.swing.JFrame {

    /**
     * Creates new form Listar
     */
    
    private static final Logger log = LogManager.getLogger(Listar.class);
    public Listar() {
        initComponents();
        
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
        jScrollPane2 = new javax.swing.JScrollPane();
        cd_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_edit_cd = new javax.swing.JButton();
        btn_elim_CD = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        dvd_table = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        book_table = new javax.swing.JTable();
        btn_edit_dvd = new javax.swing.JButton();
        btn_elim_dvd = new javax.swing.JButton();
        btn_edit_book = new javax.swing.JButton();
        btn_elim_book = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        mag_table = new javax.swing.JTable();
        btn_edit_mag = new javax.swing.JButton();
        btn_elim_mag = new javax.swing.JButton();
        label1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        cd_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        cd_table.setName(""); // NOI18N
        jScrollPane2.setViewportView(cd_table);
        if (cd_table.getColumnModel().getColumnCount() > 0) {
            cd_table.getColumnModel().getColumn(9).setHeaderValue("Titulo material");
        }
        cd_table.getAccessibleContext().setAccessibleName("");

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CD");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DVDs");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Libros");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Revistas");

        btn_edit_cd.setBackground(new java.awt.Color(255, 250, 0));
        btn_edit_cd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit(3).png"))); // NOI18N
        btn_edit_cd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        btn_edit_cd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_cdActionPerformed(evt);
            }
        });

        btn_elim_CD.setBackground(new java.awt.Color(255, 0, 0));
        btn_elim_CD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete(1).png"))); // NOI18N
        btn_elim_CD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        btn_elim_CD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elim_CDActionPerformed(evt);
            }
        });

        dvd_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        dvd_table.setName(""); // NOI18N
        jScrollPane4.setViewportView(dvd_table);
        if (dvd_table.getColumnModel().getColumnCount() > 0) {
            dvd_table.getColumnModel().getColumn(9).setHeaderValue("Titulo material");
        }

        book_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        book_table.setName(""); // NOI18N
        jScrollPane5.setViewportView(book_table);
        if (book_table.getColumnModel().getColumnCount() > 0) {
            book_table.getColumnModel().getColumn(9).setHeaderValue("Titulo material");
        }

        btn_edit_dvd.setBackground(new java.awt.Color(255, 250, 0));
        btn_edit_dvd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit(3).png"))); // NOI18N
        btn_edit_dvd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        btn_edit_dvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_dvdActionPerformed(evt);
            }
        });

        btn_elim_dvd.setBackground(new java.awt.Color(255, 0, 0));
        btn_elim_dvd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete(1).png"))); // NOI18N
        btn_elim_dvd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        btn_elim_dvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elim_dvdActionPerformed(evt);
            }
        });

        btn_edit_book.setBackground(new java.awt.Color(255, 250, 0));
        btn_edit_book.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit(3).png"))); // NOI18N
        btn_edit_book.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        btn_edit_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_bookActionPerformed(evt);
            }
        });

        btn_elim_book.setBackground(new java.awt.Color(255, 0, 0));
        btn_elim_book.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete(1).png"))); // NOI18N
        btn_elim_book.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        btn_elim_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elim_bookActionPerformed(evt);
            }
        });

        mag_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        mag_table.setName(""); // NOI18N
        jScrollPane6.setViewportView(mag_table);
        if (mag_table.getColumnModel().getColumnCount() > 0) {
            mag_table.getColumnModel().getColumn(9).setHeaderValue("Titulo material");
        }

        btn_edit_mag.setBackground(new java.awt.Color(255, 250, 0));
        btn_edit_mag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit(3).png"))); // NOI18N
        btn_edit_mag.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        btn_edit_mag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_magActionPerformed(evt);
            }
        });

        btn_elim_mag.setBackground(new java.awt.Color(255, 0, 0));
        btn_elim_mag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete(1).png"))); // NOI18N
        btn_elim_mag.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        btn_elim_mag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elim_magActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_edit_cd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_elim_CD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_edit_book, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_elim_book, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_edit_mag, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_elim_mag, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_edit_dvd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_elim_dvd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_elim_CD)
                            .addComponent(btn_edit_cd))))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_elim_dvd)
                            .addComponent(btn_edit_dvd))
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_elim_book)
                            .addComponent(btn_edit_book))))
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_elim_mag)
                            .addComponent(btn_edit_mag))))
                .addGap(141, 141, 141))
        );

        label1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        label1.setText("Listado de productos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_edit_cdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_cdActionPerformed

        Edicion edic = new Edicion();
        edic.setVisible(true);
    }//GEN-LAST:event_btn_edit_cdActionPerformed

    private void btn_elim_CDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elim_CDActionPerformed
       
      int i = JOptionPane.showConfirmDialog(null, "Está seguro que desea borrar este CD?");
    if (i == 0) {      
        int selectedRow = cd_table.getSelectedRow();
        if (selectedRow != -1) { // Si se ha seleccionado una fila
            Object datoid = cd_table.getValueAt(selectedRow, 0);
            if (datoid instanceof Integer) {
                int id = (int) datoid;
                try {
                    ServiceCDS serviceCDS = new ServiceCDS(); 
                    serviceCDS.deleteCD(id); 
                } catch (Exception ex) {
                    log.info("Yay");
                }
            } else if (datoid instanceof String) {
                int id = Integer.parseInt((String) datoid);
                try {
                    ServiceCDS serviceCDS = new ServiceCDS(); 
                    serviceCDS.deleteCD(id); 
                } catch (Exception ex) {
                    log.debug("Pito");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.");
        }
    }
      
    }//GEN-LAST:event_btn_elim_CDActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
//        Servicio para cargar los CDs
        ServiceCDS loadCDS = new ServiceCDS();
        try {
            
            List<ModelCDs> listCDs = loadCDS.getAllCDs();
            
            String[] columnNames = {"ID CD", "Codigo", "Titulo", "# Disponibles", "Artista", "Genero", "Duracion", "# Canciones", "Tipo de material"};
        CDsTablemodel tableModel = new CDsTablemodel(columnNames, listCDs);
            
        cd_table.setModel(tableModel);
        } catch (Exception e) {
            System.out.println("Exception en Listar: "+e.getLocalizedMessage());
        }
                
//        Servicio para cargar los DVDs

        ServiceDVDS loadDVDs = new ServiceDVDS();
        try {
            
            List<ModelDVDs> listDVDs = loadDVDs.getAllDVDs();
            
            String[] columnNames = {"ID DVD", "Codigo", "Titulo", "# Disponibles", "Director", "Genero", "Duracion", "Tipo de material"};
            DVDsTablemodel tableModel = new DVDsTablemodel(columnNames, listDVDs);
            
        dvd_table.setModel(tableModel);
        } catch (Exception e) {
            System.out.println("Exception en Listar: "+e.getLocalizedMessage());
        }
                
//        Servicio para cargar los libros
    
        ServiceBooks loadBooks = new ServiceBooks();
        try {
            
            List<ModelBooks> listBooks = loadBooks.getAllBooks();
            
            String[] columnNames = {"ID Libro", "Codigo", "Titulo", "# Disponibles", "Autor", "# Páginas", "Editorial", "ISBN", "Año publicación", "Tipo de material"};
        BooksTablemodel tableModel = new BooksTablemodel(columnNames, listBooks);
            
        book_table.setModel(tableModel);
        } catch (Exception e) {
            System.out.println("Exception en Listar: "+e.getLocalizedMessage());
        }
                
//        Servicio para cargar las revistas

        ServiceMagazines loadMags = new ServiceMagazines();
        try {
            
            List<ModelMagazines> listMags = loadMags.getAllDVDs();
            
            String[] columnNames = {"ID Revista", "Codigo", "Titulo", "# Disponibles", "Editorial", "Periodicidad", "Fecha publicación", "Tipo de material"};
            MagazinesTablemodel tableModel = new MagazinesTablemodel(columnNames, listMags);
            
        book_table.setModel(tableModel);
        } catch (Exception e) {
            System.out.println("Exception en Listar: "+e.getLocalizedMessage());
        }
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowOpened

    private void btn_edit_dvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_dvdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit_dvdActionPerformed

    private void btn_elim_dvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elim_dvdActionPerformed
        
        int i = JOptionPane.showConfirmDialog(null, "Está seguro que desea borrar este DVD?");
    if (i == 0) {      
        int selectedRow = dvd_table.getSelectedRow();
        if (selectedRow != -1) { // Si se ha seleccionado una fila
            Object datoid = dvd_table.getValueAt(selectedRow, 0);
            if (datoid instanceof Integer) {
                int id = (int) datoid;
                try {
                    ServiceDVDS serviceDVDs = new ServiceDVDS(); 
                    serviceDVDs.deleteDVD(id); 
                } catch (Exception ex) {
                    log.info("Yay");
                }
            } else if (datoid instanceof String) {
                int id = Integer.parseInt((String) datoid);
                try {
                    ServiceDVDS serviceDVDs = new ServiceDVDS(); 
                    serviceDVDs.deleteDVD(id); 
                } catch (Exception ex) {
                    log.debug("Pito");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.");
        }
    }
    }//GEN-LAST:event_btn_elim_dvdActionPerformed

    private void btn_edit_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_bookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit_bookActionPerformed

    private void btn_elim_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elim_bookActionPerformed
        
        int i = JOptionPane.showConfirmDialog(null, "Está seguro que desea borrar este libro?");
    if (i == 0) {      
        int selectedRow = book_table.getSelectedRow();
        if (selectedRow != -1) { // Si se ha seleccionado una fila
            Object datoid = book_table.getValueAt(selectedRow, 0);
            if (datoid instanceof Integer) {
                int id = (int) datoid;
                try {
                    ServiceBooks serviceBooks = new ServiceBooks(); 
                    serviceBooks.deleteBook(id); 
                } catch (Exception ex) {
                    log.info("Yay");
                }
            } else if (datoid instanceof String) {
                int id = Integer.parseInt((String) datoid);
                try {
                    ServiceBooks serviceBooks = new ServiceBooks(); 
                    serviceBooks.deleteBook(id); 
                } catch (Exception ex) {
                    log.debug("Pito");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.");
        }
    }
    }//GEN-LAST:event_btn_elim_bookActionPerformed

    private void btn_edit_magActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_magActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit_magActionPerformed

    private void btn_elim_magActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elim_magActionPerformed
        
        int i = JOptionPane.showConfirmDialog(null, "Está seguro que desea borrar esta revista?");
    if (i == 0) {      
        int selectedRow = mag_table.getSelectedRow();
        if (selectedRow != -1) { // Si se ha seleccionado una fila
            Object datoid = mag_table.getValueAt(selectedRow, 0);
            if (datoid instanceof Integer) {
                int id = (int) datoid;
                try {
                    ServiceMagazines serviceMags = new ServiceMagazines(); 
                    serviceMags.deleteMag(id); 
                } catch (Exception ex) {
                    log.info("Yay");
                }
            } else if (datoid instanceof String) {
                int id = Integer.parseInt((String) datoid);
                try {
                    ServiceMagazines serviceMags = new ServiceMagazines(); 
                    serviceMags.deleteMag(id); 
                } catch (Exception ex) {
                    log.debug("Pito");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.");
        }
    }
    }//GEN-LAST:event_btn_elim_magActionPerformed

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
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable book_table;
    private javax.swing.JButton btn_edit_book;
    private javax.swing.JButton btn_edit_cd;
    private javax.swing.JButton btn_edit_dvd;
    private javax.swing.JButton btn_edit_mag;
    private javax.swing.JButton btn_elim_CD;
    private javax.swing.JButton btn_elim_book;
    private javax.swing.JButton btn_elim_dvd;
    private javax.swing.JButton btn_elim_mag;
    private javax.swing.JTable cd_table;
    private javax.swing.JTable dvd_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private java.awt.Label label1;
    private javax.swing.JTable mag_table;
    // End of variables declaration//GEN-END:variables
}
