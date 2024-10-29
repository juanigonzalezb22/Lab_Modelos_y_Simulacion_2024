
package com.modelos_y_simulacion_2024.dominio;

import java.util.List;

public abstract class Bootstraping implements Engine {
  private double simulation_length;
  private double currentClock;
  private FEL fel;
  private List<Server> servers;
  private Behavior arrivalBehavior;
  private Behavior eosBehavior;
  private DataManager dataManager;

  public Bootstraping(double init_time, double simulation_length, Behavior arrivalBehavior, Behavior eosBehavior, DataManager dataManager){
    this.simulation_length = simulation_length;
    this.currentClock = init_time;
    this.fel = new FEL();
    this.arrivalBehavior = arrivalBehavior;
    this.eosBehavior = eosBehavior;
    this.dataManager = dataManager;

    Arrival a = new Arrival();
    Event e = new Event(init_time, arrivalBehavior, new Entidad(0, init_time),a);
    a.setEvent(e);
    a.setEndOfServiceBehavior(eosBehavior);
    fel.insertEvent(e);
    System.out.println(this.fel.toString());
  }

  public void execute(){

    Event e;
    e = fel.imminent();
    this.currentClock = e.getClock();
    
    while (this.currentClock <= this.simulation_length) {
      e.getPlanificator().planificate(this.servers, this.fel, this.dataManager);
      System.out.println(this.fel.toString());

      e = fel.imminent();
      this.currentClock = e.getClock();
    }
    
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
