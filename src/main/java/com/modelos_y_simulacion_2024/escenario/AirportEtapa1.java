package com.modelos_y_simulacion_2024.escenario;

import java.util.ArrayList;
import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Behavior;
import com.modelos_y_simulacion_2024.dominio.Bootstraping;
import com.modelos_y_simulacion_2024.dominio.DataManager;
import com.modelos_y_simulacion_2024.dominio.Server;
import com.modelos_y_simulacion_2024.policies.PoliticaDeUnicoServidor;
import com.modelos_y_simulacion_2024.policies.PoliticaDeUnicoServidor2;
import com.modelos_y_simulacion_2024.policies.PoliticaDeUnicaCola;
import com.modelos_y_simulacion_2024.policies.PoliticaDesencolarUnoAUno;

public final class AirportEtapa1 extends Bootstraping {
    
    public AirportEtapa1(
        double init_time, 
        double simulation_length, 
        Behavior arrivalBehavior,
        Behavior eosBehavior,
        DataManager dataManager
    ){
        super(init_time,simulation_length,arrivalBehavior,eosBehavior, new PoliticaDeUnicoServidor(), new PoliticaDeUnicaCola(), new PoliticaDeUnicoServidor2(), new PoliticaDesencolarUnoAUno(), dataManager);

        List<Server> servers = new ArrayList<Server>();
        for (int i = 0; i < 1; i++) {
            servers.add(new Server( new CustomQueue(i),i)); 
        }

        this.setServers(servers);
    }

}