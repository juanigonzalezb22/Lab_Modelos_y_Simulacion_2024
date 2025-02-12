package com.modelos_y_simulacion_2024.policies;

import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Queue;

public class PoliticaDeUnicaCola implements SelectionPolicy<Queue, Queue> {

    @Override
    public Queue select(int id, List<Queue> options) {
        return options.get(0);   
    }
    
}
