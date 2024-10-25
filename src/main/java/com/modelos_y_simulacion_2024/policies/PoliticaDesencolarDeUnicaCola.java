package com.modelos_y_simulacion_2024.policies;

import java.util.Collection;


import com.modelos_y_simulacion_2024.dominio.Entidad;
import com.modelos_y_simulacion_2024.dominio.Queue;

public class PoliticaDesencolarDeUnicaCola implements SelectionPolicy<Queue, Entidad>{

    @Override
    public Entidad select(Collection<Queue> options) {
        Queue queue = null;
        for (Queue q : options) {
            queue = q;
        }
        return queue.nextEntity();
    }
    

}
