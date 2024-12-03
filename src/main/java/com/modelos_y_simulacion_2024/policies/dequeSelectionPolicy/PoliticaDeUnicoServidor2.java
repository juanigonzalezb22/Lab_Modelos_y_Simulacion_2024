package com.modelos_y_simulacion_2024.policies.dequeSelectionPolicy;

import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Server;

public class PoliticaDeUnicoServidor2 implements DequeSelectionPolicy<Server, Server>{

    @Override
    public Server select( int id, List<Server> options) {
        for (int i = 0; i < options.size(); i++) {
            if( !options.get(i).getQueue().isEmpty() ){
                return options.get(i);
            }
        }
        return null;
    }
    
}
