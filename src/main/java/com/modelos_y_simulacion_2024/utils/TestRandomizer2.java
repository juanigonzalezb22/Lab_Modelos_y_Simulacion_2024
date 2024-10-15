package com.modelos_y_simulacion_2024.utils;

import java.util.ArrayList;
import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Randomizer;

public class TestRandomizer2 implements Randomizer {
  private List<Double> randoms = new ArrayList<Double>(){
    {
      add(0.82d);
      add(0.99d);
      add(0.10d);
      add(0.60d);
      add(0.82d);
      add(0.103d);
      add(0.502d);
      add(0.33444444444d);
      add(0.311111d);
      add(0.782d);
      add(0.99d);
      add(0.2d);
      add(0.3d);
      add(0.4d);
      add(0.5d);
      add(0.6d);
      add(0.7d);
      add(0.8d);
      add(0.9d);
      add(0.99d);
    }
  };

  @Override
  public double nextRandom() {
    return randoms.remove(0);
  }
}
