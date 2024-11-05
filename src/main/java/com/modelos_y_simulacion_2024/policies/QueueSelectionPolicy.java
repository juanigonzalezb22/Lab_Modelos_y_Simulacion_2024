package com.modelos_y_simulacion_2024.policies;

import java.util.Collection;
import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Queue;

public class QueueSelectionPolicy implements SelectionPolicy<Queue,Queue> {

    @Override
    public Queue select(int id, List<Queue> options) {
      //BUSCAR QUEUE MAS CORTA
        return null;
    }
}