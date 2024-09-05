package com.modelos_y_simulacion_2024.dominio;

public class Server {
  private int id;
  private Entidad entity;
  private Queue queue;
  
  public Server( Queue queue, int id ){
    this.id = id;
    this.entity = null;
    this.queue = queue;
  }

  public int getId(){
    return this.id;
  }

  public boolean isBusy(){
    return this.entity != null;
  }

  public Queue getQueue(){
    return this.queue;
  }

  public void setEntity(Entidad entity){
    this.entity = entity;
  }

  public void enqueue(Entidad enditad){
    //ESTE METODO PUEDE DECIR COMO PONER EN COLA EN CASO DE QUE UN SERVIDOR TENGA MULTIPELS SERVIDORES.
    this.queue.enqueue( enditad );

  }
}
