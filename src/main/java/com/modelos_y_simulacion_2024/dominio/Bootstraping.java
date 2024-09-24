package com.modelos_y_simulacion_2024.dominio;

import java.util.List;

public abstract class Bootstraping implements Engine {
  private float simulation_time;
  private FEL fel;
  private List<Server> servers;
  private Behavior arrivalBehavior;
  private Behavior eosBehavior;
  private DataManager dataManager;

  public Bootstraping(float simulation_time, Behavior arrivalBehavior, Behavior eosBehavior, DataManager dataManager){
    this.simulation_time = simulation_time;
    this.fel = new FEL();
    this.arrivalBehavior = arrivalBehavior;
    this.eosBehavior = eosBehavior;
    this.dataManager = dataManager;

    Arrival a = new Arrival();
    Event e = new Event(0, arrivalBehavior, new Entidad(0, 0),a);
    a.setEvent(e);
    a.setEndOfServiceBehavior(eosBehavior);
    fel.insertEvent(e);
  }

  public void execute(){
    Event e;
    do{
      System.out.println( this.fel.toString() );
      
      e = this.fel.imminent();
      
      e.getPlanificator().planificate(this.servers, this.fel, this.dataManager);

    }while( e.getClock() <= this.simulation_time );
  }

  public void generate_report(){
    System.out.println("Tiempo de espera acumulado: " + this.dataManager.getTiempoDeEsperaAcumulado());
    System.out.println("Cantidad de entidades servidas: " + this.dataManager.getCantServidos());
    System.out.println("Tiempo de trancito acumulado: " + this.dataManager.getTiempoDeTrancito());
    
    for(Server s : this.servers){
      System.out.println("Tiempo de ocio para el server "+s.getId()+" : "+ s.getOcioTotal());
    }
    
  }

  public void setServers(List<Server> servers){
    this.servers = servers;
  }

  public void setArrivalBehavior(Behavior arrivalBehavior){
    this.arrivalBehavior = arrivalBehavior;
  }

  public void seteosBehavior(Behavior eosBehavior){
    this.eosBehavior = eosBehavior;
  }

}
