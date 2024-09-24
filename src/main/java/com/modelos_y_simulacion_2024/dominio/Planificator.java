package com.modelos_y_simulacion_2024.dominio;

import java.util.List;

public interface Planificator {
  
  void planificate(List<Server> servers, FEL fel, DataManager dataManager);

  int getTypeOrder();

  Event getEvent();

  void setEvent(Event e);

}
