package com.modelos_y_simulacion_2024.dominio;

public class DataManager {

    private float tiempoDeEsperaAcumulado = 0;
    private int cantServidos = 0;
    private float tiempoDeTrancito = 0;

    public float getTiempoDeEsperaAcumulado(){
        return this.tiempoDeEsperaAcumulado;
    }

    public int getCantServidos(){
        return this.cantServidos;
    }

    public float getTiempoDeTrancito(){
        return this.tiempoDeTrancito;
    }

    public void incCantServidos(){
        this.cantServidos++;
    }

    public void acumularTiempoEspera(float tiempoEsperado){
        this.tiempoDeEsperaAcumulado += tiempoEsperado;
    }

    public void acumularTiempoDeTrancito(float tiempoTrancito){
        this.tiempoDeTrancito += tiempoTrancito;
    }

}