package com.modelos_y_simulacion_2024.dominio;

import java.util.List;

public class Arrival implements Planificator {

  private Event e;
  private Behavior eosBehavior;

  public Arrival() {
  }


  @Override
  public void planificate(List<Server> servers, FEL fel) {

    Server server = servers.get(0);

    if (server.isBusy()) {
      server.enqueue(this.e.getEnditad());
    } else {
      server.setEntity(this.e.getEnditad());
      this.e.getEnditad().setServer(server);
      
      EndOfService end_of_server = new EndOfService();
      Event evento = new Event(this.e.getClock() + this.eosBehavior.nextTime(), this.eosBehavior, this.e.getEnditad(), end_of_server );
      end_of_server.setEvent(evento);
      fel.insertEvent(evento);
    }

    Entidad entidad = new Entidad(e.getEnditad().getId() + 1);

    Arrival a = new Arrival();
    Event new_event = new Event(this.e.getClock() + this.e.getBehavior().nextTime(), this.e.getBehavior(), entidad, a );
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
