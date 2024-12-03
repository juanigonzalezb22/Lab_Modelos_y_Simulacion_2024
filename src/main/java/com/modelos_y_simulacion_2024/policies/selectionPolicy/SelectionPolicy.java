package com.modelos_y_simulacion_2024.policies.selectionPolicy;

import java.util.List;

@FunctionalInterface
public interface SelectionPolicy<T1, T2> {

  T2 select( List<T1> options );

}
