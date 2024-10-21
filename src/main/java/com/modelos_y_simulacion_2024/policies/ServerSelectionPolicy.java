package com.modelos_y_simulacion_2024.policies;

import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Server;

public interface ServerSelectionPolicy {

  public Server selectServer( List<Server> servers );

}
