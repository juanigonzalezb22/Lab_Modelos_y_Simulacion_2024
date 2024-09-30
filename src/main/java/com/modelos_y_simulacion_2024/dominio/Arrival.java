package com.modelos_y_simulacion_2024.dominio;

import java.util.List;

public class Arrival implements Planificator {
  
  private Event e;
  private Behavior eosBehavior;

  @Override
  public void planificate(List<Server> servers, FEL fel, DataManager dataManager) {
    float next_clock = this.e.getClock() + this.e.getBehavior().nextTime();
    Server server = servers.get(0);

    if (server.isBusy()) {

      server.enqueue(this.e.getEnditad());
      this.e.getEnditad().setClock_inicio_espera(this.e.getClock());

    } else {
      server.setEntity(this.e.getEnditad());
      this.e.getEnditad().setServer(server);
      
      server.finalizaTiempoOcio(this.e.getClock());
      
      EndOfService end_of_service = new EndOfService();
      Event evento = new Event(this.e.getClock() + this.eosBehavior.nextTime(), this.eosBehavior, this.e.getEnditad(), end_of_service );
      end_of_service.setEvent(evento);
      fel.insertEvent(evento);
    }
    
    Arrival a = new Arrival();
    Entidad entidad = new Entidad(e.getEnditad().getId() + 1, next_clock);
    Event new_event = new Event(next_clock,this.e.getBehavior(), entidad, a );
    a.setEvent(new_event);
    a.setEndOfServiceBehavior(eosBehavior);
    fel.insertEvent(new_event);
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
