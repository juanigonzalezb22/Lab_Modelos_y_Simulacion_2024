package com.modelos_y_simulacion_2024.dominio;

public class DataManager {

    private int tiempoDeEsperaAcumulado = 0;
    private int cantServidos = 0;
    private int tiempoDeTrancito = 0;

    public int getTiempoDeEsperaAcumulado(){
        return this.tiempoDeEsperaAcumulado;
    }

    public int getCantServidos(){
        return this.cantServidos;
    }

    public int getTiempoDeTrancito(){
        return this.tiempoDeTrancito;
    }

    public void incCantServidos(){
        this.cantServidos++;
    }

    public void acumularTiempoEspera(int tiempoEsperado){
        this.tiempoDeEsperaAcumulado += tiempoEsperado;
    }

    public void acumularTiempoDeTrancito(int tiempoTrancito){
        this.tiempoDeTrancito += tiempoTrancito;
    }
}