package com.modelos_y_simulacion_2024.dominio;

public class Entidad {

  private Server server;
  private final int id;
  private final double clock_arribo;
  
  private double clock_inicio_espera = 0;
  private double clock_fin_espera = 0;

  public double getClock_arribo() {
    return this.clock_arribo;
  }



  Entidad(int id, double clock_arribo){
    this.id = id;
    this.clock_arribo = clock_arribo;
    // supongo que entra al servicio cuando arriba, en caso
    // de que no sea asi, la dinamica del booststrapping debe encargarse
    // de volver a setear este valor; sino se rompe todo
  }

  public void setServer(Server server){
    this.server = server;
  }

  public Server getServer(){
    return server;
  }

  public int getId(){
    return id;
  }

  public double getClockArrival(){
    return clock_arribo;
  }

  public double getClock_inicio_espera() {
    return clock_inicio_espera;
  }

  public void setClock_inicio_espera(double clock_inicio_espera) {
    this.clock_inicio_espera = clock_inicio_espera;
  }

  public void setFinEspera(double clock) {
    this.clock_fin_espera = clock;
  }



  public double getFinEspera() {
    return this.clock_fin_espera;
  }
}
