package com.modelos_y_simulacion_2024.dominio;

public class Server {
  private int id;
  private Entidad entity;
  private Queue queue;
  

  private double ocioTotal = 0;
  private double inicioTiempoOcio = 0;

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

  public void incioTiempoOcio(double clockInicioOcio){    
    this.inicioTiempoOcio = clockInicioOcio;
  }
  
  public void finalizaTiempoOcio(double clockFinalizaOcio){
      if(clockFinalizaOcio < this.inicioTiempoOcio)
        throw new RuntimeException("desfasage de clocks para calcular el ocio de servidor");
        
      this.ocioTotal += (clockFinalizaOcio - this.inicioTiempoOcio);
      this.inicioTiempoOcio = 0;
  }

  public double getOcioTotal(){
    return this.ocioTotal;
  }
}
