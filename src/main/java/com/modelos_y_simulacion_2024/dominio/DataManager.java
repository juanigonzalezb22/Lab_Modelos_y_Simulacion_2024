package com.modelos_y_simulacion_2024.dominio;

import java.util.List;

public class DataManager {

    private int cantServidos = 0;

    private double tiempoDeTrancito = 0;
    private double maxTiempoDeTrancito = 0;
    private double minTiempoDeTrancito = Double.MAX_VALUE;
    private double medTiempoDeTrancito = 0;

    private double tiempoDeEsperaAcumulado = 0;
    private double maxTiempoDeEspera = 0;
    private double minTiempoDeEspera = Double.MAX_VALUE;
    private double medTiempoDeEspera = 0;

    private double tiempoDeOcioAcumulado = 0;
    private double maxtiempoDeOcio = 0;
    private double mintiempoDeOcio = Double.MAX_VALUE;
    private double medtiempoDeOcio = 0;

    private int maxColaDeEspera = 0;
    private int minColaDeEspera = Integer.MAX_VALUE;

    private DataManagerReplication dataManagerPadre;

    public DataManager(DataManagerReplication dataManagerPadre) {
        this.dataManagerPadre = dataManagerPadre;
    }

    public double getTiempoDeOcioAcumulado(){
        return tiempoDeOcioAcumulado;
    }

    public double getMaxtiempoDeOcio(){
        return maxtiempoDeOcio;
    }

    public double getMintiempoDeOcio(){
        return mintiempoDeOcio;
    }


    public int getMaximaColaDeEspera(){
        return this.maxColaDeEspera;
    }

    public int getMinimaColaDeEspera(){
        if ( this.minColaDeEspera == Integer.MAX_VALUE ) {
            return -1;
        }
        return this.minColaDeEspera;
    }

    public double getMaxTiempoDeEspera(){
        return this.maxTiempoDeEspera;
    }

    public double getMinTiempoDeEspera(){
        return this.minTiempoDeEspera;
    }

    public double getTiempoDeEsperaAcumulado(){
        return this.tiempoDeEsperaAcumulado;
    }

    public int getCantServidos(){
        return this.cantServidos;
    }

    public void incCantServidos(){
        this.cantServidos++;
    }

    public double getTiempoDeTrancito(){
        return this.tiempoDeTrancito;
    }

    public double getMaxTiempoDeTrancito(){
        return this.maxTiempoDeTrancito;
    }

    public double getMinTiempoDeTrancito(){
        return this.minTiempoDeTrancito;
    }


    public void acumularTiempoEspera(double tiempoEsperado){
        this.tiempoDeEsperaAcumulado += tiempoEsperado;
        if( tiempoEsperado > this.maxTiempoDeEspera ){
            this.maxTiempoDeEspera  = tiempoEsperado;
        }
        if( tiempoEsperado < minTiempoDeEspera ){
            this.minTiempoDeEspera  = tiempoEsperado;
        }
    }

    public void acumularTiempoDeTrancito(double tiempoTrancito){
        this.tiempoDeTrancito += tiempoTrancito;
        if ( tiempoTrancito > this.maxTiempoDeTrancito ) {
            this.maxTiempoDeTrancito = tiempoTrancito;
        }
        if ( tiempoTrancito < this.minTiempoDeTrancito ) {
            this.minTiempoDeTrancito = tiempoTrancito;
        }
    }

    public void setDatosDataManagerPadre(){
        this.dataManagerPadre.setMediaDeMedias(this.tiempoDeEsperaAcumulado/this.cantServidos);
        this.dataManagerPadre.setMaximosDeEspera(this.maxTiempoDeEspera);
    }

    //***************************************************************//

    public void acumularTiempoDeOcio( double t_ocio ){
        tiempoDeOcioAcumulado += t_ocio;
        if ( t_ocio > this.maxtiempoDeOcio ) {
            this.maxtiempoDeOcio = t_ocio;
        }
        if ( t_ocio < this.mintiempoDeOcio ) {
            this.mintiempoDeOcio = t_ocio;
        }
    }

    public void tamañoColaDeEsperaMaxYMin( int tamañoCola ) {
        if( tamañoCola > this.maxColaDeEspera ){
            this.maxColaDeEspera = tamañoCola;
        }
        if( tamañoCola < this.minColaDeEspera  ) {
            this.minColaDeEspera = tamañoCola;
        }
    }

}
