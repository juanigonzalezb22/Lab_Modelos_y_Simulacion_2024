package com.modelos_y_simulacion_2024.dominio;

public class Entidad {
  private Server server;
  private final int id;

  Entidad(int id){
    this.id = id;
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
}
