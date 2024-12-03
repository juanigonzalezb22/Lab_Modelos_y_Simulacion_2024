package com.modelos_y_simulacion_2024.dominio;

import java.util.List;

import com.modelos_y_simulacion_2024.policies.dequeSelectionPolicy.DequeSelectionPolicy;

public class EndOfService implements Planificator {

  private Event e;

  private final DequeSelectionPolicy<Server, Server> serverSelectionPolicy;
  private final DequeSelectionPolicy<Server, Entity> dequeueSelectionPolicy;

  public EndOfService(DequeSelectionPolicy<Server, Server> serverSelectionPolicy, DequeSelectionPolicy<Server, Entity> dequeueSelectionPolicy){
    this.serverSelectionPolicy = serverSelectionPolicy;  
    this.dequeueSelectionPolicy = dequeueSelectionPolicy;
  }

  @Override
  public void planificate(List<Server> servers, FEL fel, DataManager dataManager) {

    // Server server = this.e.getEntidad().getServer();
    // server.setEntity(null);
    // this.e.getEntidad().setServer(null);
      
    // de todas las colas que veo, hay alguien esperando? si hay varios? cual pasa
    // a ser atendido? y donde?
    if (this.hayAlguienEsperando(servers)) {

      Server server = this.serverSelectionPolicy.select(0,servers);

      Entity entity = this.dequeueSelectionPolicy.select(server.getId(),servers);

      server.setEntity(entity);
      entity.setServer(server);
      
      entity.setFinEspera(this.e.getClock());
      
      EndOfService end_of_service = new EndOfService( this.serverSelectionPolicy, this.dequeueSelectionPolicy );
      Event evento = new Event(this.e.getClock() + this.e.getBehavior().nextTime(this.e.getClock()), this.e.getBehavior(), entity, end_of_service);
      end_of_service.setEvent(evento);
      fel.insertEvent(evento);

      dataManager.acumularTiempoEspera(this.e.getEntidad().getFinEspera() - this.e.getEntidad().getClock_inicio_espera());

    } else {

      Server server = this.e.getEntidad().getServer();
      server.setEntity(null);
      this.e.getEntidad().setServer(null);
      server.incioTiempoOcio(this.e.getClock());

    }
    
    dataManager.incCantServidos();
    dataManager.acumularTiempoDeTrancito(this.e.getClock() - this.e.getEntidad().getClockArrival());
  }

  private boolean hayAlguienEsperando(List<Server> servers) {
    for (Server s : servers) {
      if (!s.getQueue().isEmpty()) {
        return true;
      }
    }
    return false;
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
