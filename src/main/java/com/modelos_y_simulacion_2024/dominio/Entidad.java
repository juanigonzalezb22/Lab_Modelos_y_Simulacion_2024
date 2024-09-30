package com.modelos_y_simulacion_2024.dominio;

public class Entidad {

  private Server server;
  private final int id;
  private final float clock_arribo;
  
  private float clock_inicio_espera;
  private float clock_fin_espera;

  public float getClock_arribo() {
    return this.clock_arribo;
  }



  Entidad(int id, float clock_arribo){
    this.id = id;
    this.clock_arribo = clock_arribo;
    // supongo que entra al servicio cuando arriba, en caso
    // de que no sea asi, la dinamica del booststrapping debe encargarse
    // de volver a setear este valor; sino se rompe todo
    this.clock_inicio_espera = clock_arribo;
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

  public float getClockArrival(){
    return clock_arribo;
  }

  public float getClock_inicio_espera() {
    return clock_inicio_espera;
  }

  public void setClock_inicio_espera(float clock_inicio_espera) {
    this.clock_inicio_espera = clock_inicio_espera;
  }

  public void setFinEspera(float clock) {
    this.clock_fin_espera = clock;
  }



  public float getFinEspera() {
    return this.clock_fin_espera;
  }
}
