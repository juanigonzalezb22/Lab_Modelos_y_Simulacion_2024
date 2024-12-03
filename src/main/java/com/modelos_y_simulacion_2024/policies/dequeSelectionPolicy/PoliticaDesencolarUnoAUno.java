package com.modelos_y_simulacion_2024.policies.dequeSelectionPolicy;

import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Entity;
import com.modelos_y_simulacion_2024.dominio.Server;

public class PoliticaDesencolarUnoAUno implements DequeSelectionPolicy<Server, Entity>{

    @Override
    public Entity select(int id, List<Server> options) { 
        return options.get(id).getQueue().nextEntity();
    }

}
