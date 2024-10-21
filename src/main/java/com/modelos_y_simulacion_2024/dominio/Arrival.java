package com.modelos_y_simulacion_2024.dominio;

import java.util.List;
import com.modelos_y_simulacion_2024.policies.ServerSelectionPolicy;

public class Arrival implements Planificator {
  
  private Event e;
  private Behavior eosBehavior;
  private ServerSelectionPolicy policy;

  @Override
  public void planificate(List<Server> servers, FEL fel, DataManager dataManager) {

      double nextArrivalClock = this.e.getClock() + this.e.getBehavior().nextTime();
      
      Server server =  this.policy.selectServer(servers);

      if (server.isBusy()) {
          server.enqueue(this.e.getEntidad());
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
