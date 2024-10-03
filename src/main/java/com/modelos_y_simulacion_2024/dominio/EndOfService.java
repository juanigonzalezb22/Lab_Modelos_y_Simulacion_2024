package com.modelos_y_simulacion_2024.dominio;

import java.util.List;

public class EndOfService implements Planificator {

  private Event e;

  @Override
  public void planificate(List<Server> servers, FEL fel, DataManager dataManager) {

    Server server = this.e.getEnditad().getServer();
    

    if( !server.getQueue().isEmpty() ){
      Entidad entity = server.getQueue().nextEntity();
      server.setEntity(entity);
      entity.setServer(server);

      entity.setFinEspera(this.e.getClock());

      EndOfService end_of_service = new EndOfService();
      Event evento = new Event( e.getClock() + e.getBehavior().nextTime(), e.getBehavior(), entity, end_of_service );
      end_of_service.setEvent(evento);
      fel.insertEvent(evento);
    } else {
      
      server.setEntity(null);
      this.e.getEnditad().setServer(null);

      server.incioTiempoOcio(this.e.getClock());
    }

    dataManager.acumularTiempoEspera(this.e.getEnditad().getFinEspera() - this.e.getEnditad().getClock_inicio_espera());
    dataManager.incCantServidos();
    dataManager.acumularTiempoDeTrancito(this.e.getClock() - this.e.getEnditad().getClockArrival());
  }

  @Override
  public void setEvent(Event e) {
    this.e = e;
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
