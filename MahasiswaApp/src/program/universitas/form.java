/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package program.universitas;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.sql.PreparedStatement; 
import java.sql.Connection; 

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author ryanp
 */
public class form extends javax.swing.JFrame {
    private DefaultTableModel Model;
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JasperPrint jasperPrint;
    Map<String, Object> param = new HashMap<String, Object>();
    

    /**
     * Creates new form form
     */
    public form() {
        initComponents();
        // membuat TableModel;
        Model = new DefaultTableModel();
        //menambahkan Table model ke table
        TabelMahasiswa.setModel(Model);
        
        Model.addColumn("Nim");
        Model.addColumn("Nama");
        Model.addColumn("Tanggal Lahir");
        Model.addColumn("Jurusan");
        Model.addColumn("Alamat");
        loadData();
    }
    
    public void loadData() {
        
        // menghapus seluruh data
        Model.getDataVector().removeAllElements();
        
        // memeberi tahu bahwa data telah kosong
        Model.fireTableDataChanged();
        
        try{
            Connection c = KoneksiDatabase.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "select * from mahasiswafix";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                //lakukan penelsuran baris
                Object[] o = new Object[5];
                o[0] = r.getString("nim");
                o[1] = r.getString("nama");
                o[2] = r.getString("jurusan");
                o[3] = r.getDate("Tanggal_lahir");
                o[4] = r.getString("alamat");
                Model.addRow(o);
            }
            r.close();
            s.close();
        } catch(SQLException e){
            System.out.println("Terjadi Error1");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        InputNim = new javax.swing.JTextField();
        InputNama = new javax.swing.JTextField();
        InputJurusan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InputAlamat = new javax.swing.JTextArea();
        InputTanggalLahir = new javax.swing.JFormattedTextField();
        Tambah = new javax.swing.JButton();
        Ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelMahasiswa = new javax.swing.JTable();
        Cetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NIM :");

        jLabel2.setText("NAMA:");

        jLabel3.setText("Tanggal Lahir:");

        jLabel4.setText("Jurusan:");

        jLabel5.setText("Alamat:");

        InputNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputNimActionPerformed(evt);
            }
        });

        jLabel6.setText("jLabel6");

        InputAlamat.setColumns(20);
        InputAlamat.setRows(5);
        jScrollPane2.setViewportView(InputAlamat);

        InputTanggalLahir.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/mm/yyyy"))));
        InputTanggalLahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputTanggalLahirActionPerformed(evt);
            }
        });

        Tambah.setText("Tambah");
        Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahActionPerformed(evt);
            }
        });

        Ubah.setText("Ubah");
        Ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbahActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        TabelMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelMahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMahasiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelMahasiswa);

        Cetak.setText("Cetak");
        Cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InputNim, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(Cetak)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Tambah)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Ubah)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(hapus))
                                .addComponent(InputTanggalLahir)
                                .addComponent(InputNama)
                                .addComponent(InputJurusan)
                                .addComponent(jScrollPane2)))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(InputNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(InputNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(InputTanggalLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(InputJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tambah)
                    .addComponent(Ubah)
                    .addComponent(hapus)
                    .addComponent(Cetak))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void InputNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputNimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputNimActionPerformed

    private void InputTanggalLahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputTanggalLahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputTanggalLahirActionPerformed

    private void TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahActionPerformed
        // TODO add your handling code here:
        String nim = InputNim.getText(); 
        String nama = InputNama.getText();
        java.util.Date tanggalLahir = (java.util.Date) InputTanggalLahir.getValue();
        String jurusan = InputJurusan.getText();
        String alamat = InputAlamat.getText(); 
        
        try{ 
            Connection c = KoneksiDatabase.getKoneksi(); 
            String sql = "insert into mahasiswafix (nim, nama, Tanggal_lahir, jurusan, alamat) value (?, ?, ?, ?, ?) "; 
            PreparedStatement p = c.prepareStatement(sql); 
            p.setString(1, nim); 
            p.setString(2, nama); 
            p.setDate(3, new java.sql.Date(tanggalLahir.getTime())); 
            p.setString(4, jurusan); 
            p.setString(5, alamat); 
            p.executeUpdate(); 
            p.close(); 
        } catch(SQLException e){ 
            System.out.println("Terjadi Error2"); 
        } finally{ 
            loadData(); 
        }

    }//GEN-LAST:event_TambahActionPerformed

    private void UbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbahActionPerformed
        // TODO add your handling code here:
        int i = TabelMahasiswa.getSelectedRow(); 
        if(i == -1){ 
        // tidak ada baris terseleksi 
            return; 
        } 
        // ambil nim yang terseleksi 
        String nim = (String) Model.getValueAt(i, 0); 
        String nama = InputNama.getText(); 
        java.util.Date tanggalLahir = (java.util.Date) InputTanggalLahir.getValue(); 
        String jurusan = InputJurusan.getText(); 
        String alamat = InputAlamat.getText();
        
        try{
            Connection c = KoneksiDatabase.getKoneksi();
            String sql = "update mahasiswafix set nama = ?, Tanggal_lahir = ?, jurusan = ?, alamat = ? where nim = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, nama);
            p.setDate(2, new java.sql.Date(tanggalLahir.getTime()));
            p.setString(3, jurusan);
            p.setString(4, alamat);
            p.setString(5, nim);
            
            p.executeUpdate(); 
            p.close();
      
        } catch(SQLException e) {
            System.out.println("Terjadi Error3");
            
        } finally {
            loadData();
        }
    }//GEN-LAST:event_UbahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        int i = TabelMahasiswa.getSelectedRow(); 
        if(i == -1) {
            // tidak ada baris terseleksi 
            return;
        }
    String nim =(String) Model.getValueAt(i, 0);
    try {
        Connection c = KoneksiDatabase.getKoneksi();
        String sql = "delete from mahasiswafix where nim = ?";
        PreparedStatement p = c.prepareStatement(sql);
        p.setString(1, nim); 
        p.executeUpdate();
        p.close();
        
    }catch(SQLException e){
        System.err.println("Terjadi Error4");
        
    } finally {
        loadData();
    }
        
    }//GEN-LAST:event_hapusActionPerformed

    private void TabelMahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMahasiswaMouseClicked
        // TODO add your handling code here:
        int i = TabelMahasiswa.getSelectedRow(); 
        if(i == -1) {
            // tak ada baris terseleksi
            return; 
        }
        String nim = (String) Model.getValueAt(i, 0);
        InputNim.setText(nim);
        String nama = (String) Model.getValueAt(i, 1);
        InputNama.setText(nama);
        
        java.util.Date tanggalLahir = (java.util.Date) Model.getValueAt(i, 2);
        InputTanggalLahir.setValue(tanggalLahir);
        
        String jurusan = (String) Model.getValueAt(i, 3);
        InputJurusan.setText(jurusan);
        String alamat = (String) Model.getValueAt(i, 4);
        InputAlamat.setText(alamat);
    }//GEN-LAST:event_TabelMahasiswaMouseClicked

    private void CetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakActionPerformed
        // TODO add your handling code here:
        try {
            var file = new File("src/program/universitas/report_mahasiswa.jrxml");
            jasperDesign = JRXmlLoader.load(file);
            param.clear();
            jasperReport = JasperCompileManager.compileReport(jasperDesign); 
            jasperPrint = JasperFillManager.fillReport(jasperReport, param,KoneksiDatabase.getKoneksi()); 
            JasperViewer.viewReport(jasperPrint, false); 
        } catch (Exception e) {
            e.printStackTrace(); 
            System.err.println("Terjadi Error5");
        }
        
    }//GEN-LAST:event_CetakActionPerformed

    
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
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cetak;
    private javax.swing.JTextArea InputAlamat;
    private javax.swing.JTextField InputJurusan;
    private javax.swing.JTextField InputNama;
    private javax.swing.JTextField InputNim;
    private javax.swing.JFormattedTextField InputTanggalLahir;
    private javax.swing.JTable TabelMahasiswa;
    private javax.swing.JButton Tambah;
    private javax.swing.JButton Ubah;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
