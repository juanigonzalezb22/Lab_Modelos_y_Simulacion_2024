package com.modelos_y_simulacion_2024.utils.randomizers;

import java.util.Random;

import com.modelos_y_simulacion_2024.dominio.Randomizer;

public class MyRandomizer implements Randomizer {
  private Random randomizer;

  public MyRandomizer(){
    this.randomizer = new Random(System.currentTimeMillis());
  }

  @Override
  public double nextRandom() {
    return randomizer.nextDouble();
  }
  
}
