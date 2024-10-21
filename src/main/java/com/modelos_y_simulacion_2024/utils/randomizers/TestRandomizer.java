package com.modelos_y_simulacion_2024.utils;

import java.util.ArrayList;
import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Randomizer;

public class TestRandomizer implements Randomizer {
  private List<Double> randoms = new ArrayList<Double>(){
    {
      add(0.25d);
      add(0.64d);
      add(0.93d);
      add(0.11d);
      add(0.82d);
      add(0.62d);
      add(0.72d);
      add(0.33d);
      add(0.31d);
      add(0.06d);
      add(0.1d);
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
