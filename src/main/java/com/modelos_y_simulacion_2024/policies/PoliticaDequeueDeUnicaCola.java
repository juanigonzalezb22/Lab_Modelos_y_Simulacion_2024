package com.modelos_y_simulacion_2024.policies;

import java.util.Collection;

import com.modelos_y_simulacion_2024.dominio.Entidad;
import com.modelos_y_simulacion_2024.dominio.Queue;

public class PoliticaDequeueDeUnicaCola implements SelectionPolicy<Queue, Entidad>{

    @Override
    public Entidad select(Collection<Queue> options) {
        Entidad entity = null;
        for (Queue q : options) {
            entity = q.nextEntity();
        }
        return entity;
    }
    
}
