package com.modelos_y_simulacion_2024.policies;

import java.util.List;
import java.util.stream.Collectors;

import com.modelos_y_simulacion_2024.dominio.Server;

public class PoliticaSegundaEtapaServer implements SelectionPolicy<Server, Server>{

    @Override
    public Server select( List<Server> options) {
      
      Server serv = null;

      List<Server> emptyServers = options.stream()
                                        .filter(server -> !server.isBusy())
                                        .collect(Collectors.toList());

      if (!emptyServers.isEmpty()) {
 
        serv = emptyServers.get(0);
        
      }

      return serv;
    }
    
}
