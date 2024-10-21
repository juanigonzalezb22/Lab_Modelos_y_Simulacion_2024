package com.modelos_y_simulacion_2024.utils.distribuciones;

import java.util.List;

import com.modelos_y_simulacion_2024.utils.Pair;

public class EmpiricalDiscrete<T,E> implements Distribution {

    private final List<Pair<T,E>> pairs;
    // dame en el constructor la lista de (prob, valor)
    // recomendacion usar MAP (hashmap)
    public EmpiricalDiscrete(List<Pair<T,E>> pairs){        
        this.pairs = new ArrayList<>
    }

    @Override
    public double probabilidad(double x) {
        
    }

    @Override
    public double sample(double x) {
        
    }
}
