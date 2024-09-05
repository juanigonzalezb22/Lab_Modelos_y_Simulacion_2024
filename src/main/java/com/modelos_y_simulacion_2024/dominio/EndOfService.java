package com.modelos_y_simulacion_2024.dominio;

import java.util.List;

public class EndOfService implements Planificator {

  private Event e;

  @Override
  public void planificate(List<Server> servers, FEL fel) {

    Server server = this.e.getEnditad().getServer();

    if( !server.getQueue().isEmpty() ){
      Entidad entity = server.getQueue().nextEntity();
      server.setEntity(entity);
      entity.setServer(server);
      fel.insertEvent(new Event(e.getClock() + e.getBehavior().nextTime(), e.getBehavior(), entity, this));
    } else {
      server.setEntity(null);
      this.e.getEnditad().setServer(null);
    }
  }

  @Override
  public int getTypeOrder() {
    return 0;
  }

  @Override
  public Event getEvent() {
    return e;
  }

}
