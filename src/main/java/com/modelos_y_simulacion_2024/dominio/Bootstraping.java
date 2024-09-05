package com.modelos_y_simulacion_2024.dominio;

import java.util.List;

public abstract class Bootstraping implements Engine {
  private float simulation_time;
  private FEL fel;
  private List<Server> servers;
  private Behavior arrivalBehavior;
  private Behavior eosBehavior;

  public Bootstraping(float simulation_time, Behavior arrivalBehavior, Behavior eosBehavior){
    this.simulation_time = simulation_time;
    this.fel = new FEL();
    this.arrivalBehavior = arrivalBehavior;
    this.eosBehavior = eosBehavior;


    Arrival a = new Arrival();
    Event e = new Event(0, null, new Entidad(0),a);
    a.setEvent(e);
    fel.insertEvent(e);
  }

  public void execute(){
    Event e;
    do{
      e = this.fel.imminent();

      e.getPlanificator().planificate( this.servers, this.fel );

    }while( e.getClock() <= this.simulation_time );
  }

  public void generate_report(){

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
