package com.modelos_y_simulacion_2024.utils.distribuciones;

import java.util.ArrayList;
import java.util.List;

import com.modelos_y_simulacion_2024.utils.Pair;

public class EmpiricalDiscrete implements Distribution {

    private final List<Pair<Double,Double>> pairs;

    // dame en el constructor la lista de (prob, valor)
    // recomendacion usar MAP (hashmap)
    public EmpiricalDiscrete(List<Pair<Double, Double>> pairs){        
        this.pairs = pairs;
    }

    public EmpiricalDiscrete(Pair<Double,Double>... pairs){        
        this.pairs = new ArrayList<>();
        for (Pair<Double,Double> p : pairs)
            this.pairs.add(p);
    }

    @Override
    public double probabilidad(double x) {
        for (Pair<Double, Double> p : this.pairs) {
            if(p.e1() == x)
                return p.e2();  
        }
        return 0d;
    }

    @Override
    public double sample(double x) {
        double aux = 0d;
        for (Pair<Double, Double> p : this.pairs) {
            aux += p.e2();
            if( x <= aux)
                return p.e1();  
        }
        return this.pairs.get(this.pairs.size()-1).e1();
    }
}
