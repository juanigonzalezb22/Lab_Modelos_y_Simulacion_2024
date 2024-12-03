package com.modelos_y_simulacion_2024.policies.selectionPolicy;

import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Queue;

public class PoliticaDeUnicaCola implements SelectionPolicy<Queue, Queue> {

    @Override
    public Queue select( List<Queue> options) {
        return options.get(0);   
    }
    
}
