package com.modelos_y_simulacion_2024.policies;

import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Entidad;
import com.modelos_y_simulacion_2024.dominio.Server;

public class PoliticaDesencolarUnoAUno implements dequeSelectionPolicy<Server, Entidad>{

    @Override
    public Entidad select(int id, List<Server> options) {
        
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getId() == id ){
                return options.get(i).getQueue().nextEntity();
            }
        }
        return null;
    }
    
}
