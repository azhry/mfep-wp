/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Data;
import Model.Kriteria;
import Model.Nilai_Faktor;
import java.util.ArrayList;
/**
 *
 * @author M.Hakim Amransyah
 */
public class MFEP {
    
    private ArrayList<Data> data_calon_penerima_bantuan;
    private ArrayList<Kriteria> kriteria;
    private ArrayList<Double> nbf;
    
    public MFEP(ArrayList<Data> dcpb, ArrayList<Kriteria> krtr){
        this.data_calon_penerima_bantuan = dcpb;
        this.kriteria = krtr;
        this.nbf = new ArrayList<Double>(this.kriteria.size());
    }
    
    public ArrayList<Data> doMFEP(){
        this.normalisasiBobotFactor();
        this.nilaiEvaluasiFaktor();
        this.rangkingHasil();    
        return this.data_calon_penerima_bantuan;
    }
    
    private void rangkingHasil(){
       Data temp; 
       for(int i=this.data_calon_penerima_bantuan.size()-2;i>=0;i--){
           for(int j=0;j<=i;j++){
               if(this.data_calon_penerima_bantuan.get(j).getTotal_bobot_evauasi() < this.data_calon_penerima_bantuan.get(j+1).getTotal_bobot_evauasi()){               
                  temp =   this.data_calon_penerima_bantuan.get(j);
                  this.data_calon_penerima_bantuan.set(j, this.data_calon_penerima_bantuan.get(j+1));
                  this.data_calon_penerima_bantuan.set(j+1, temp);
               }
           }
       }       
    }
    
    private void nilaiEvaluasiFaktor(){
        double sum,mult;
        String nilai_faktor,kriteria;
        for(Data data : this.data_calon_penerima_bantuan){
            sum = 0;
             for(int i=0;i<this.kriteria.size();i++){
                 nilai_faktor = data.getKriteria_pada_data().get(i);
                 kriteria = this.kriteria.get(i).getNama();
                    for(Nilai_Faktor value : this.kriteria.get(i).getFaktor()){
                        if(value.getNama().equalsIgnoreCase(nilai_faktor)){
//                            System.out.println(kriteria+" : "+value.getNilai());
                            mult = (value.getNilai()*this.nbf.get(i));
                            sum = sum + mult;
                            break;
                        }
                    }
                 }
//             System.out.println("sum : "+sum);
//             System.out.println("");
             data.setTotal_bobot_evauasi(sum);          
        }
    }
    
    private void normalisasiBobotFactor(){
        double sum = 0;
        for(Kriteria k : this.kriteria){
            sum = sum + k.getNilai();
        }
        for(Kriteria k : this.kriteria){
            this.nbf.add((k.getNilai()/sum));
        }
        
    }
    
}
