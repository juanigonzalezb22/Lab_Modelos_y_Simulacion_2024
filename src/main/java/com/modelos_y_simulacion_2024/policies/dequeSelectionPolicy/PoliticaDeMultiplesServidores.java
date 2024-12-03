package com.modelos_y_simulacion_2024.policies.dequeSelectionPolicy;

import java.util.List;
import java.util.stream.Collectors;

import com.modelos_y_simulacion_2024.dominio.Server;

public class PoliticaDeMultiplesServidores implements DequeSelectionPolicy<Server, Server>{

    @Override
    public Server select( int id, List<Server> options) {
      
      Server serv = null;

      List<Server> busyServers = options.stream()
                                        .filter(server -> server.isBusy())
                                        .collect(Collectors.toList());

      if (!busyServers.isEmpty()) {
 
        serv = busyServers.get(0);
        
      }

      return serv;
    }
    
}
