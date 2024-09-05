package com.modelos_y_simulacion_2024.escenario;
import java.util.ArrayList;
import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Bootstraping;
import com.modelos_y_simulacion_2024.dominio.Server;


public final class Airport extends Bootstraping {
  
  public Airport( float simulation_time, Behavior arrivalBehavior, Behavior eosBehavior ){ {
    super(simulation_time,arrivalBehavior,eosBehavior);

    List<Server> servers = new ArrayList<Server>();

    servers.add(new Server( new CustomQueue(1), 1 ));
    servers.add(new Server( new CustomQueue(2), 2 ));
    servers.add(new Server( new CustomQueue(3), 3 ));

    this.setServers(servers);
  }

}
