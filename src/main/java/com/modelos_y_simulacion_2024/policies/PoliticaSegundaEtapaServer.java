package com.modelos_y_simulacion_2024.policies;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.modelos_y_simulacion_2024.dominio.Server;

public class PoliticaSegundaEtapaServer implements SelectionPolicy<Server, Server>{

    @Override
    public Server select(Collection<Server> options) {
      
      Server serv = null;

      List<Server> emptyServers = options.stream()
                                        .filter(server -> !server.isBusy())
                                        .collect(Collectors.toList());

      if (!emptyServers.isEmpty()) {
        serv = emptyServers.get(ThreadLocalRandom.current().nextInt(emptyServers.size())); // TOMA CUALQUIERA DE LOS LIBRES
      }
      
      return serv;
    }
    
}
