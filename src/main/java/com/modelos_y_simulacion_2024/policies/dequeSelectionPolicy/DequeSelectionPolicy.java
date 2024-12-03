package com.modelos_y_simulacion_2024.policies.dequeSelectionPolicy;

import java.util.List;

@FunctionalInterface
public interface DequeSelectionPolicy<T1, T2> {

  T2 select(int t1_id, List<T1> options );

}