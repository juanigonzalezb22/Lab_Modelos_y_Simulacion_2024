package com.modelos_y_simulacion_2024.policies;

import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.ThreadLocalRandom;

import com.modelos_y_simulacion_2024.dominio.Server;

public class Random_Policy implements ServerSelectionPolicy {

  @Override
  public Server selectServer(List<Server> servers) {
    // Filtrar servidores no ocupados usando streams
    List<Server> emptyServers = servers.stream()
                                        .filter(server -> !server.isBusy())
                                        .collect(Collectors.toList());

    // Selección aleatoria de servidor
    if (emptyServers.isEmpty()) {
      return servers.get(ThreadLocalRandom.current().nextInt(servers.size()));
    } else {
      return emptyServers.get(ThreadLocalRandom.current().nextInt(emptyServers.size()));
    }
  }
}
