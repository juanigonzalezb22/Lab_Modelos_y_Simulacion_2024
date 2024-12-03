package com.modelos_y_simulacion_2024.policies.dequeSelectionPolicy;

import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Entity;
import com.modelos_y_simulacion_2024.dominio.Server;
import com.modelos_y_simulacion_2024.policies.selectionPolicy.SelectionPolicy;

public class PoliticaDesencolarUnicoServer implements SelectionPolicy<Server, Entity>{

    @Override
    public Entity select( List<Server> options) {
        
        return options.get(0).getQueue().nextEntity();

    }
    

}
