package com.modelos_y_simulacion_2024.policies;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.ThreadLocalRandom;

import com.modelos_y_simulacion_2024.dominio.Server;

public class Random_Policy implements SelectionPolicy<Server> {

  @Override
  public Server select(Collection<Server> servers) {
    // Filtrar servidores no ocupados usando streams
    List<Server> emptyServers = servers.stream()
                                        .filter(server -> !server.isBusy())
                                        .collect(Collectors.toList());

    // Selección aleatoria de servidor
    if (!emptyServers.isEmpty()) {

      int i = 0;
      int rand = ThreadLocalRandom.current().nextInt(emptyServers.size());
      for (Server s : emptyServers) {
        if (i==rand)
          return s;
        i ++;  
      }
    }

    return null;
  }
}
