/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Data;
import Model.Kriteria;
import Model.Nilai_Faktor;
import View.Mainframe;
import View.Pengaturan;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author M.Hakim Amransyah
 */
public class Main {

    private ArrayList<Kriteria> daftar_kriteria;
    
    public Main(){
       daftar_kriteria = new ArrayList<Kriteria>();
       this.bentukDefaultPreferensiPengetahuan();
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        main.tampilkanFrameUtama();
    }
    
    private void tampilkanFrameUtama(){
        Mainframe mf = new Mainframe(this);
        mf.setVisible(true);
    }
    
    public void tampilkanFramePreferensi(){
        Pengaturan frame = new Pengaturan(this.daftar_kriteria);
        frame.setVisible(true);
    }
    
    public void mulai_SPK(ArrayList<Data> dcp){
        if(dcp.size()>0){
            
        }else{
             JOptionPane.showMessageDialog(null,"Data tidak ada","Ooops!",JOptionPane.ERROR_MESSAGE);
        }
//        Lakukan perhitungan metode MFEP dan WP
    }
    
    public ArrayList<Data> muatData(javax.swing.JPanel parent_panel) throws FileNotFoundException, IOException{
        ArrayList<Data> daftar_calon_penerima_bantuan = new ArrayList<Data>();
        String header[],data,temp[];
        JFileChooser file_chooser = new JFileChooser();
        file_chooser.setCurrentDirectory(new File("E:\\"));
        file_chooser.setFileFilter(new FileNameExtensionFilter("csv file", "csv"));
        if(file_chooser.showOpenDialog(parent_panel) == JFileChooser.APPROVE_OPTION)
        {
            File f = file_chooser.getSelectedFile();
            BufferedReader bf = new BufferedReader(new FileReader(f.getPath()));    
            header = bf.readLine().split(",");
            Data calon_penerima_bantuan;
            while((data = bf.readLine())!=null){
               calon_penerima_bantuan = new Data();
               calon_penerima_bantuan.setKriteria(this.daftar_kriteria);
               temp = data.split(",");
               calon_penerima_bantuan.setNama(temp[1]);
               for(int i=2;i<temp.length;i++){
                   calon_penerima_bantuan.tambahKriteriaPadaData(temp[i]);
               }
               daftar_calon_penerima_bantuan.add(calon_penerima_bantuan);
            }
        }
        return daftar_calon_penerima_bantuan;
            
    }
    
    private void bentukDefaultPreferensiPengetahuan(){
       
        Kriteria kriteria1 = new Kriteria("Pekerjaan",3,"Cost(-)");
        kriteria1.tambahFaktor(new Nilai_Faktor("Wirausaha",5));
        kriteria1.tambahFaktor(new Nilai_Faktor("Petani",3));
        kriteria1.tambahFaktor(new Nilai_Faktor("Buruh",1));
        daftar_kriteria.add(kriteria1);
        
        Kriteria kriteria2 = new Kriteria("Penghasilan",5,"Cost(-)");
        kriteria2.tambahFaktor(new Nilai_Faktor(">1500000",5));
        kriteria2.tambahFaktor(new Nilai_Faktor("1300001-1500000",4));
        kriteria2.tambahFaktor(new Nilai_Faktor("800001-1300000",3));
        kriteria2.tambahFaktor(new Nilai_Faktor("300000-800000",2));
        kriteria2.tambahFaktor(new Nilai_Faktor("<300000",1));
        daftar_kriteria.add(kriteria2);
        
        Kriteria kriteria3 = new Kriteria("Jumlah tanggungan",5,"Benefit(+)");
        kriteria3.tambahFaktor(new Nilai_Faktor(">8",5));
        kriteria3.tambahFaktor(new Nilai_Faktor("6-8",4));
        kriteria3.tambahFaktor(new Nilai_Faktor("3-5",3));
        kriteria3.tambahFaktor(new Nilai_Faktor("1-2",2));
        kriteria3.tambahFaktor(new Nilai_Faktor("Sendiri",1));
        daftar_kriteria.add(kriteria3);
        
        Kriteria kriteria4 = new Kriteria("Kondisi rumah",1,"Cost(-)");
        kriteria4.tambahFaktor(new Nilai_Faktor("Beton",5));
        kriteria4.tambahFaktor(new Nilai_Faktor("Papan",4));
        kriteria4.tambahFaktor(new Nilai_Faktor("Triplek",2));
        kriteria4.tambahFaktor(new Nilai_Faktor("Bambu",1));
        daftar_kriteria.add(kriteria4);
        
        Kriteria kriteria5 = new Kriteria("Kepemilikan rumah",3,"Cost(-)");
        kriteria5.tambahFaktor(new Nilai_Faktor("Milik sendiri",4));
        kriteria5.tambahFaktor(new Nilai_Faktor("Mengontrak",2));
        kriteria5.tambahFaktor(new Nilai_Faktor("Menumpang",1));
        daftar_kriteria.add(kriteria5);
        
        Kriteria kriteria6 = new Kriteria("Jaringan listrik",2,"Cost(-)");
        kriteria6.tambahFaktor(new Nilai_Faktor("Milik sendiri(subsidi)",5));
        kriteria6.tambahFaktor(new Nilai_Faktor("Menumpang(subsidi)",4));
        kriteria6.tambahFaktor(new Nilai_Faktor("Milik sendiri(tanpa subsidi)",3));
        kriteria6.tambahFaktor(new Nilai_Faktor("Menumpang(sanpa subsidi)",2));
        kriteria6.tambahFaktor(new Nilai_Faktor("Tidak ada",1));
        daftar_kriteria.add(kriteria6);

        Kriteria kriteria7 = new Kriteria("Jenis rumah",2,"Cost(-)");
        kriteria7.tambahFaktor(new Nilai_Faktor("Permanen",5));
        kriteria7.tambahFaktor(new Nilai_Faktor("Semi permanen",3));
        kriteria7.tambahFaktor(new Nilai_Faktor("Panggung",1));
        daftar_kriteria.add(kriteria7);
     
    }
    
    
    
}
