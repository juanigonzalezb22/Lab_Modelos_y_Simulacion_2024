package com.modelos_y_simulacion_2024.policies;

import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Server;

public class PoliticaDeUnicoServidor implements SelectionPolicy<Server, Server>{

    @Override
    public Server select(int id, List<Server> options) {
        if ( !options.get(0).isBusy() ) {
            return options.get(0);
        }
        return null;
    }
    
}
