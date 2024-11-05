
package com.modelos_y_simulacion_2024.dominio;

import java.util.List;

import com.modelos_y_simulacion_2024.policies.SelectionPolicy;

public abstract class Bootstraping implements Engine {
  private final double simulation_length;
  private final FEL fel;

  private final Behavior arrivalBehavior;
  private final Behavior eosBehavior;
  private final DataManager dataManager;
  
  private final SelectionPolicy<Server,Server> arrivalServerSelectionPolicy;
  private final SelectionPolicy<Queue,Queue> enqueueSelectionPolicy;
  private final SelectionPolicy<Server, Server> eosServerSelectionPolicy;
  private final SelectionPolicy<Server, Entidad> dequeueSelectionPolicy;

  private List<Server> servers;
  private double currentClock;
  
  
  public Bootstraping(double init_time, 
                      double simulation_length, 
                      Behavior arrivalBehavior, 
                      Behavior eosBehavior, 
                      SelectionPolicy<Server,Server> arrivalServerSelectionPolicy, 
                      SelectionPolicy<Queue,Queue> enqueueSelectionPolicy,
                      SelectionPolicy<Server, Server> eosServerSelectionPolicy,
                      SelectionPolicy<Server, Entidad> dequeueSelectionPolicy,
                      DataManager dataManager
                      ){
    this.simulation_length = simulation_length;
    this.currentClock = init_time;
    this.fel = new FEL();
    this.arrivalBehavior = arrivalBehavior;
    this.eosBehavior = eosBehavior;
    this.dataManager = dataManager;

    this.arrivalServerSelectionPolicy = arrivalServerSelectionPolicy;
    this.enqueueSelectionPolicy = enqueueSelectionPolicy;
    this.eosServerSelectionPolicy = eosServerSelectionPolicy;
    this.dequeueSelectionPolicy = dequeueSelectionPolicy;
  
    Arrival a = new Arrival(this.arrivalServerSelectionPolicy, this.enqueueSelectionPolicy, this.eosServerSelectionPolicy, this.dequeueSelectionPolicy);
    Event e = new Event(init_time, this.arrivalBehavior, new Entidad(0, init_time),a);
    a.setEvent(e);
    a.setEndOfServiceBehavior(this.eosBehavior);
    fel.insertEvent(e);
    System.out.println(this.fel.toString());
  }

  public void execute(){

    Event e;
    e = fel.imminent();
    this.currentClock = e.getClock();
    
    while (this.currentClock <= this.simulation_length) {
      e.getPlanificator().planificate(this.servers, this.fel, this.dataManager);
      //System.out.println(this.fel.toString());

      e = fel.imminent();
      this.currentClock = e.getClock();
    }
    
    this.dataManager.setDatosDataManagerPadre();

  }

  // public void generate_report(){
  //   System.out.println("Tiempo de espera acumulado: " + this.dataManager.getTiempoDeEsperaAcumulado());
  //   System.out.println("Cantidad de entidades servidas: " + this.dataManager.getCantServidos());
  //   System.out.println("Tiempo de trancito acumulado: " + this.dataManager.getTiempoDeTrancito());
    
  //   for(Server s : this.servers){
  //     System.out.println("Tiempo de ocio para el server "+s.getId()+" : "+ s.getOcioTotal());
  //   }
  // }

  public void generate_report(){
    double mediaEspera = this.dataManager.getTiempoDeEsperaAcumulado() / this.dataManager.getCantServidos();
    //System.out.println("Media de Espera: "+mediaEspera);
  }

  public void setServers(List<Server> servers){
    this.servers = servers;
  }

  private void mostrarPorPantalla(){

  }

}
