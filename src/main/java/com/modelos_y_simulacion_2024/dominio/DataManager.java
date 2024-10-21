package com.modelos_y_simulacion_2024.dominio;

public class DataManager {

    private double tiempoDeEsperaAcumulado = 0;
    private int cantServidos = 0;
    private double tiempoDeTrancito = 0;

    public double getTiempoDeEsperaAcumulado(){
        return this.tiempoDeEsperaAcumulado;
    }

    public int getCantServidos(){
        return this.cantServidos;
    }

    public double getTiempoDeTrancito(){
        return this.tiempoDeTrancito;
    }

    public void incCantServidos(){
        this.cantServidos++;
    }

    public void acumularTiempoEspera(double tiempoEsperado){
        this.tiempoDeEsperaAcumulado += tiempoEsperado;
    }

    public void acumularTiempoDeTrancito(double tiempoTrancito){
        this.tiempoDeTrancito += tiempoTrancito;
    }
}
