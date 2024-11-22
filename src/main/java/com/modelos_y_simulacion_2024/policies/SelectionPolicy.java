package com.modelos_y_simulacion_2024.policies;

import java.util.List;

@FunctionalInterface
public interface SelectionPolicy<T1, T2> {

  /**
   * 
   * @param options 
   * @return 
   */
  T2 select( List<T1> options );

}
