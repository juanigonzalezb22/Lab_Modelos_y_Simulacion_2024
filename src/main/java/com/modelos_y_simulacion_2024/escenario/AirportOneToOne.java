package com.modelos_y_simulacion_2024.escenario;
import java.util.ArrayList;
import java.util.List;
import com.modelos_y_simulacion_2024.dominio.Behavior;
import com.modelos_y_simulacion_2024.dominio.Bootstraping;
import com.modelos_y_simulacion_2024.dominio.Server;
import com.modelos_y_simulacion_2024.policies.PoliticaDequeueDeUnicaCola;
import com.modelos_y_simulacion_2024.policies.SelectionPolicy;
import com.modelos_y_simulacion_2024.dominio.DataManager;
import com.modelos_y_simulacion_2024.dominio.Entidad;
import com.modelos_y_simulacion_2024.dominio.Queue;


public final class AirportOneToOne extends Bootstraping {
  
  public AirportOneToOne(double init_time, 
                  double simulation_length, 
                  int serverQuantity, 
                  Behavior arrivalBehavior,
                  Behavior eosBehavior,
                  SelectionPolicy<Server,Server> arrivalServerSelectionPolicy,
                  SelectionPolicy<Queue, Queue> enqueueSelectionPolicy,
                  SelectionPolicy<Server, Server> eosServerSelectionPolicy,
                  SelectionPolicy<Server, Entidad> dequeueSelectionPolicy,
                  DataManager dataManager
                  ){
    super(init_time,simulation_length,arrivalBehavior,eosBehavior, arrivalServerSelectionPolicy, enqueueSelectionPolicy, eosServerSelectionPolicy, dequeueSelectionPolicy, dataManager);

    List<Server> servers = new ArrayList<Server>();
    for (int i = 0; i < serverQuantity; i++) {
      servers.add(new Server( new CustomQueue(i),i)); 
    }

    this.setServers(servers);
  }
}
