package com.modelos_y_simulacion_2024.escenario;
import java.util.ArrayList;
import java.util.List;
import com.modelos_y_simulacion_2024.dominio.Behavior;
import com.modelos_y_simulacion_2024.dominio.Bootstraping;
import com.modelos_y_simulacion_2024.dominio.Server;
import com.modelos_y_simulacion_2024.dominio.DataManager;


public final class Airport extends Bootstraping {
  
  public Airport(float init_time, float simulation_length, Behavior arrivalBehavior, Behavior eosBehavior, DataManager dataManager ){
    super(init_time,simulation_length,arrivalBehavior,eosBehavior, dataManager);

    List<Server> servers = new ArrayList<Server>();

    servers.add(new Server( new CustomQueue(1), 1 ));
    // servers.add(new Server( new CustomQueue(2), 2 ));
    // servers.add(new Server( new CustomQueue(3), 3 ));

    this.setServers(servers);
  }
}
