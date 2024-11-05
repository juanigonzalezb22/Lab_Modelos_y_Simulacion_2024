package com.modelos_y_simulacion_2024.policies;

import java.util.Collection;
import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Queue;

public class PoliticaSegundaEtapaQueue implements SelectionPolicy<Queue, Queue> {

    @Override
    public Queue select(int id, List<Queue> options) {
        Queue queue = null;
        
        int long_minima = Integer.MAX_VALUE;
        for (Queue q : options) {
          if ( q.size() < long_minima ) {
            long_minima = q.size();
            queue = q;   // Seleccionamos la primer cola más corta
          }
        }

        return queue;
    }

    
}

