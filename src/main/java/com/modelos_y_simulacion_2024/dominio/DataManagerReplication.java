package com.modelos_y_simulacion_2024.dominio;

import java.util.ArrayList;

import java.util.List;

public class DataManagerReplication {
    
    private List<Double> mediaDeMedias = new ArrayList<>();
    private List<Double> maximosDeEspera = new ArrayList<>();

    private double calcularMedia( List<Double> valores ){
        double media=0;
        for (Double valor : valores) {
            media+= valor;
        }
        return media / valores.size();
    }

    private double calcularVarianza( List<Double> valores , double media){
        double suma = 0;
        for (Double valor : valores) {
            suma+= (media - valor)*(media - valor);
        }
        return suma/(valores.size()-1);
    }

    public List<Double> getMediaDeMedias() {
        return this.mediaDeMedias;
    }

    public void setMediaDeMedias(double media) {
        this.mediaDeMedias.add(media);
    }

    public List<Double> getMaximosDeEspera() {
        return this.maximosDeEspera;
    }

    public void setMaximosDeEspera(double maximoEspera) {
        this.maximosDeEspera.add(maximoEspera);
    }

    private double halfWidth( double media, double z, double desviacion_estandar, int n, boolean suma ){
        if( suma ){
            return media + z*( desviacion_estandar / Math.sqrt(n) );
        } 
        return media - z*( desviacion_estandar / Math.sqrt(n) );
    }

    public void generateReport(){
        double media = this.calcularMedia(this.mediaDeMedias);
        double desviacion_estandar = Math.sqrt(this.calcularVarianza(this.mediaDeMedias, media));
        int n = this.mediaDeMedias.size();

        System.out.println("Media de Espera: ( "+this.halfWidth(media, 1.96, desviacion_estandar, n, false)+" , "+ this.halfWidth(media, 1.96, desviacion_estandar, n, true)+" )");
    }

}
