package com.modelos_y_simulacion_2024.policies;

import java.util.Collection;

import com.modelos_y_simulacion_2024.dominio.Server;

public class PoliticaDeUnicoServidor implements SelectionPolicy<Server, Server>{

    @Override
    public Server select(Collection<Server> options) {
        Server serv = null;
        for (Server s : options) {
            serv = s;
        }
        return serv;
    }
    
}
