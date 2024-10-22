package com.modelos_y_simulacion_2024.policies;

import java.util.Collection;

@FunctionalInterface
public interface SelectionPolicy<T> {

  T select(Collection<T> options );

}
