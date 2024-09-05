package com.modelos_y_simulacion_2024.dominio;

import java.util.List;

public class Arrival implements Planificator{
  
  private Event e;

  public Arrival(){};

  public Arrival( Event e ) {
    this.e = e;
  }

  @Override
  public void planificate(List<Server> servers, FEL fel) {
    
    Server server = servers.get(0);

    if( server.isBusy() ){
      server.enqueue( this.e.getEnditad() );
    } else {
      server.setEntity( this.e.getEnditad() );
      this.e.getEnditad().setServer(server);
    }
    Entidad entidad = new Entidad( e.getEnditad().getId() + 1 );
    fel.insertEvent( new Event( this.e.getClock() + this.e.getBehavior().nextTime(),this.e.getBehavior(), entidad, this ) );

  }

  public void setEvent( Event e ){
    this.e = e;
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
