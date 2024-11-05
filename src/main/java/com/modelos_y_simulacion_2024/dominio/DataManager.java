package com.modelos_y_simulacion_2024.dominio;

public class DataManager {

    private double tiempoDeEsperaAcumulado = 0;
    private int cantServidos = 0;
    private double tiempoDeTrancito = 0;
    private double maximoDeEspera = 0;
    private DataManagerReplication dataManagerPadre;


    public DataManager(DataManagerReplication dataManagerPadre) {
        this.dataManagerPadre = dataManagerPadre;
    }

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
        if( tiempoEsperado > this.maximoDeEspera ){
            this.maximoDeEspera  = tiempoEsperado;
        }
    }

    public void acumularTiempoDeTrancito(double tiempoTrancito){
        this.tiempoDeTrancito += tiempoTrancito;
    }

    public void setDatosDataManagerPadre(){
        this.dataManagerPadre.setMediaDeMedias(this.tiempoDeEsperaAcumulado/this.cantServidos);
        this.dataManagerPadre.setMaximosDeEspera(this.maximoDeEspera);
    }

}
