package com.modelos_y_simulacion_2024.policies;

import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Server;

public class PoliticaDeUnicoServidor2 implements dequeSelectionPolicy<Server, Server>{

    @Override
    public Server select( int id, List<Server> options) {
        if ( !options.get(id).isBusy() ) {
            return options.get(id);
        }
        return null;
    }
    
}
