package com.modelos_y_simulacion_2024.policies.dequeSelectionPolicy;

import java.util.List;
import com.modelos_y_simulacion_2024.dominio.Entity;
import com.modelos_y_simulacion_2024.dominio.Server;

public class PoliticaDequeueDeUnicaCola implements DequeSelectionPolicy<Server, Entity>{
    // ESTA POLITICA NO UTILZIA EL ID, SE TIENE QUE RESOLVER ESO?
    @Override
    public Entity select( int id, List<Server> options) {
        Entity entity = null;
        for (Server s : options) {
            if( id == s.getId() )
                entity = s.getQueue().nextEntity();
        }
        return entity;
    }
    
}
