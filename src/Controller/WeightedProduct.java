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
 * @author acer
 */
public class WeightedProduct {
    
    private ArrayList<Kriteria> criteria;
    private ArrayList<Data> data;
    private double vectorTotal;
    
    public WeightedProduct(ArrayList<Data> data, 
            ArrayList<Kriteria> criteria) {
        this.data = data;
        this.criteria = criteria;
        this.normalizeWeight();
    }
    
    public ArrayList<Data> doWP(){
        this.normalizeWeight();
        this.vectorizing();
        this.sortData();    
        return this.data;
    }
    
    private void sortData(){
       Data temp; 
       for(int i=this.data.size()-2;i>=0;i--){
           for(int j=0;j<=i;j++){
               if(this.data.get(j).getTotal_bobot_evaluasi_ternormalisasi()< 
                       this.data.get(j+1).getTotal_bobot_evaluasi_ternormalisasi()){               
                  temp =   this.data.get(j);
                  this.data.set(j, this.data.get(j+1));
                  this.data.set(j+1, temp);
               }
           }
       }

    }
    
    private void vectorizing() {
        String factor;
        this.vectorTotal = 0;
        this.data.stream().forEach(x -> {
            double mult = 1;
            for (int i = 0; i < this.criteria.size(); i++) {
                Kriteria k = this.criteria.get(i);
                String factorValue = x.getKriteria_pada_data().get(i);
                String criterion = k.getNama();
                for (Nilai_Faktor value : k.getFaktor()) {
                    if (value.getNama().equalsIgnoreCase(factorValue)) {
                        double bobot = k.getBobot();
                        if (k.getKondisi().equalsIgnoreCase("cost(-)")) {
                            bobot *= -1;
                        }
                        mult *= Math.pow(value.getNilai(), bobot);
                        break;
                    }
                }
            }
            x.setTotal_bobot_evauasi(mult);
            this.vectorTotal += mult;
        });

        this.normalizeVector();
    }
    
    private void normalizeVector() {
        this.data.stream().forEach(x -> {
           x.setTotal_bobot_evaluasi_ternormalisasi(x.getTotal_bobot_evauasi() / vectorTotal);
        });
    }
    
    private void normalizeWeight() {
        final double total = this.criteria.stream().map(Kriteria::getNilai)
                .mapToDouble(x -> x).sum();
        this.criteria.stream().forEach(c -> {
            c.setBobot(c.getNilai() / total);
        });
    }
}
