package com.modelos_y_simulacion_2024.dominio;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.modelos_y_simulacion_2024.policies.SelectionPolicy;

public class EndOfService implements Planificator {

  private Event e;

  private SelectionPolicy<Queue, Entidad> dequeueSelectionPolicy;
  private SelectionPolicy<Server, Server> serverSelectionPolicy;

  @Override
  public void planificate(List<Server> servers, FEL fel, DataManager dataManager) {

    // Server server = this.e.getEntidad().getServer();
    Set<Queue> queueAux = new HashSet<>();
    for (Server s : servers)
      queueAux.add(s.getQueue());
    // de todas las colas que veo, hay alguien esperando? si hay varios? cual pasa
    // a ser atendido? y donde?
    if (this.hayAlguienEsperando(queueAux)) {
      
      Entidad entity = this.dequeueSelectionPolicy.select(queueAux);
      
      Server server = this.serverSelectionPolicy.select( servers );

      entity.setServer(server);

      entity.setFinEspera(this.e.getClock());

      EndOfService end_of_service = new EndOfService();
      Event evento = new Event(e.getClock() + e.getBehavior().nextTime(), e.getBehavior(), entity, end_of_service);
      end_of_service.setEvent(evento);
      fel.insertEvent(evento);
    } else {

      Server server = this.e.getEntidad().getServer();
      server.setEntity(null);
      this.e.getEntidad().setServer(null);
      server.incioTiempoOcio(this.e.getClock());

    }

    dataManager.acumularTiempoEspera(this.e.getEntidad().getFinEspera() - this.e.getEntidad().getClock_inicio_espera());
    dataManager.incCantServidos();
    dataManager.acumularTiempoDeTrancito(this.e.getClock() - this.e.getEntidad().getClockArrival());
  }

  private boolean hayAlguienEsperando(Collection<Queue> queues) {
    for (Queue queue : queues) {
      if (!queue.isEmpty())
        return true;
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
