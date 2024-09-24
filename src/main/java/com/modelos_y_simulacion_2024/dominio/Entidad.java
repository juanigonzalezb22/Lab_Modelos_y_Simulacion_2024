package com.modelos_y_simulacion_2024.dominio;

public class Entidad {

  private Server server;
  private final int id;
  private final int clock_arribo;

  Entidad(int id, int clock){
    this.id = id;
    this.clock_arribo = clock;
  }

  // public void setArrivalClock(int clock){
  //   this.clock_arribo = clock;
  // }

  public void setServer(Server server){
    this.server = server;
  }

  public Server getServer(){
    return server;
  }

  public int getId(){
    return id;
  }

  public int getClockArrival(){
    return clock_arribo;
  }
}
