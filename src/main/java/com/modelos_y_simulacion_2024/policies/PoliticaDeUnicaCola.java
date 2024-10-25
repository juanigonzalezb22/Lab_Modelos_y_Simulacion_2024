package com.modelos_y_simulacion_2024.policies;

import java.util.Collection;

import com.modelos_y_simulacion_2024.dominio.Queue;

public class PoliticaDeUnicaCola implements SelectionPolicy<Queue, Queue> {

    @Override
    public Queue select(Collection<Queue> options) {
        Queue queue = null;
        for (Queue q : options) {
            queue = q;
        }
        return queue;
    }

    
}
