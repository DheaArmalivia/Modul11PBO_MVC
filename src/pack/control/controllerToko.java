/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.control;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.List; 
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTableModel; 
import javax.swing.table.TableModel; 
import pack.dao.daoToko; 
import pack.dao.implementToko; 
import pack.model.m_toko; 
import pack.view.home; 
import pack.model.tableModelToko;

/**
 *
 * @author Smktelkom
 */
public class controllerToko {
    home hm;
    implementToko impToko;
    List<m_toko> lt;

    public controllerToko(home hm) {
        this.hm = hm;
        impToko = new daoToko();
        lt = impToko.getAll();
    }

    //mengkosongkan isian field     
    public void Reset() {
        hm.getTxtKode().setText("");
        hm.getTxtNama().setText("");
        hm.getTxtHarga().setText("");
        hm.getCbKategori().setSelectedItem(null);
        hm.getCbJenis().setSelectedItem(null);
    }      
    //menghapus data yang dipilih     
    public void Hapus() {
        if (hm.getTxtKode().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(hm, "Masukkan kode barang");
        } else {
            String kode = (hm.getTxtKode().getText());
            impToko.HapusData(kode);
            JOptionPane.showMessageDialog(hm, "Data berhasil dihapus");
        }

//        int baris = TableMod.getSelectedRow();
//        if (baris!= -1) {
//            String NIS = tableData.getValueAt(baris, 0).toString();
//            String SQL = "DELETE FROM t_siswa Where NIS ='"+NIS+"'";
//            int status = KoneksiDB.execute(SQL);
//            if (status == 1) {
//                JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(this, "Data Gagal Dihapus", "Gagal", JOptionPane.WARNING_MESSAGE);
//            }       
//        } else {
//            JOptionPane.showMessageDialog(this, "Pilih baris terlebih dahulu", "Error", JOptionPane.WARNING_MESSAGE);
//        } 

    }     
    //menyimpan data     
    public void SimpanData() {
        m_toko toko = new m_toko();
        toko.setkode(hm.getTxtKode().getText());
        toko.setnama(hm.getTxtNama().getText());
        toko.setharga(hm.getTxtHarga().getText());
        toko.setkategori(hm.getCbKategori().getSelectedItem().toString());
        toko.setjenis(hm.getCbJenis().getSelectedItem().toString());
        impToko.SimpanData(toko);
    }     
    //mengubah data     
    public void Ubah() {
        m_toko toko = new m_toko();
        toko.setkode(hm.getTxtKode().getText());
        toko.setnama(hm.getTxtNama().getText());
        toko.setkategori(hm.getCbKategori().getSelectedItem().toString());
        toko.setjenis(hm.getCbJenis().getSelectedItem().toString());
        toko.setharga(hm.getTxtHarga().getText());
        impToko.UbahData(toko);
    }
    public void isiTable() {
        lt = impToko.getAll();
        tableModelToko tmt = new tableModelToko(lt);
        hm.getTableData().setModel(tmt);
    }

    public void isiField(int row) {
        hm.getTxtKode().setText(lt.get(row).getkode());
        hm.getTxtNama().setText(lt.get(row).getnama());
        hm.getCbKategori().setSelectedItem(lt.get(row).getkategori());
        hm.getCbJenis().setSelectedItem(lt.get(row).getjenis());
        hm.getTxtHarga().setText(lt.get(row).getharga());
    }

    public void CariKategori() {
        if (!hm.getCbCariKategori().getSelectedItem().toString().isEmpty()) {
            isiTableCariKategori();
        } else {
            JOptionPane.showMessageDialog(hm, "Silahkan Pilih Kategori");
        }
    }

    private void isiTableCariKategori() {
        String item = hm.getCbCariKategori().getSelectedItem().toString();
        lt = impToko.getCariKategori(item);
        tableModelToko tmt = new tableModelToko(lt);
        hm.getTableData().setModel(tmt);
    }
}
