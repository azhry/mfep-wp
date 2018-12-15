/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author M.Hakim Amransyah
 */
public class Data {
    
    private int nomor;
    private String nama;
    private ArrayList<Kriteria> kriteria;
    private ArrayList<String> kriteria_pada_data;
    
    public Data(){
        this.kriteria = new ArrayList<Kriteria>();
        this.kriteria_pada_data = new ArrayList<String>();
    }
     
    public ArrayList<String> getKriteria_pada_data() {
        return kriteria_pada_data;
    }

    public void setKriteria_pada_data(ArrayList<String> kriteria_pada_data) {
        this.kriteria_pada_data = kriteria_pada_data;
    }
    
    public void tambahKriteriaPadaData(String data){
       this.kriteria_pada_data.add(data);
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<Kriteria> getKriteria() {
        return kriteria;
    }

    public void setKriteria(ArrayList<Kriteria> kriteria) {
        this.kriteria = kriteria;
    }
      
}
