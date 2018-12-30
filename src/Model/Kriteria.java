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
public class Kriteria {
     
    private String nama;
    private double nilai;
    private String kondisi;
    private ArrayList<Nilai_Faktor> faktor;
    private String kriteria_pada_data;
    private double bobot;
    
    public Kriteria(String nama, double nilai, String kondisi){
        this.faktor = new ArrayList<Nilai_Faktor>();
        this.nama = nama;
        this.nilai = nilai;
        this.kondisi = kondisi;
    }
    
    public void tambahFaktor(Nilai_Faktor faktor){
        this.faktor.add(faktor);
    }

    public ArrayList<Nilai_Faktor> getFaktor() {
        return faktor;
    }

    public void setFaktor(ArrayList<Nilai_Faktor> faktor) {
        this.faktor = faktor;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }
    
    public void setBobot(double bobot) {
        this.bobot = bobot;
    }
    
    public double getBobot() {
        return this.bobot;
    }
}
