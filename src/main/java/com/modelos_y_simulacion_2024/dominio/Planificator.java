package com.modelos_y_simulacion_2024.dominio;

import java.util.List;

public interface Planificator {
  
  /**
   * Este metodo esta re copado
   * @param servers la lista de servers del modelo
   * @param fel la lista de eventos futuros para el booststrapping
   */
  void planificate(List<Server> servers, FEL fel);

  int getTypeOrder();

  Event getEvent();

  void setEvent(Event e);
}
