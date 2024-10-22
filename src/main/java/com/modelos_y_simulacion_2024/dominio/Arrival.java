package com.modelos_y_simulacion_2024.dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.modelos_y_simulacion_2024.policies.SelectionPolicy;

public class Arrival implements Planificator {
  
  private Event e;
  private Behavior eosBehavior;
  private SelectionPolicy<Server> serverSelectionPolicy;
  private SelectionPolicy<Queue> queueSelectionPolicy;

  @Override
  public void planificate(List<Server> servers, FEL fel, DataManager dataManager) {

      double nextArrivalClock = this.e.getClock() + this.e.getBehavior().nextTime();
      
      Server server = this.serverSelectionPolicy.select(servers);

      if (server == null) { // todos ocupados? si... entonces elegir la cola a donde va a esperar
          
          //server.enqueue(this.e.getEntidad());
          Set<Queue> queueAux = new HashSet<>();
          for (Server s : servers)
            queueAux.add(s.getQueue());
          }
          
          Queue q = this.queueSelectionPolicy.select(queueAux);
          q.enqueue(this.e.getEntidad());
          
          this.e.getEntidad().setClock_inicio_espera(this.e.getClock());
      } else {
          server.setEntity(this.e.getEntidad());
          this.e.getEntidad().setServer(server);
          server.finalizaTiempoOcio(this.e.getClock());
          planificarFinDeServicio(fel, server, this.e);
      }
      planificarNuevaLlegada(fel, nextArrivalClock, this.e);
  }

  private void planificarFinDeServicio(FEL fel, Server server, Event event) {
      EndOfService endOfService = new EndOfService();
      Event endEvent = new Event(
          event.getClock() + this.eosBehavior.nextTime(),
          this.eosBehavior,
          event.getEntidad(),
          endOfService
      );
      endOfService.setEvent(endEvent);
      fel.insertEvent(endEvent);
  }

  private void planificarNuevaLlegada(FEL fel, double nextArrivalClock, Event event) {
      Arrival arrival = new Arrival();
      Entidad entidad = new Entidad(event.getEntidad().getId() + 1, nextArrivalClock);
      Event newEvent = new Event(nextArrivalClock, event.getBehavior(), entidad, arrival);
      arrival.setEvent(newEvent);
      arrival.setEndOfServiceBehavior(this.eosBehavior);
      fel.insertEvent(newEvent);
  }

  @Override
  public void setEvent(Event e) {
    this.e = e;
  }

  public void setEndOfServiceBehavior(Behavior eosBehavior){
    this.eosBehavior = eosBehavior;
  }

  @Override
  public int getTypeOrder() {
    return 10;
  }

  @Override
  public Event getEvent() {
    return e;
  }

}
