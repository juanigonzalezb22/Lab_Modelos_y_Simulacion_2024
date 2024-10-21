package com.modelos_y_simulacion_2024.escenario.Behaviors;

import com.modelos_y_simulacion_2024.dominio.Behavior;

public class TestBehavior implements Behavior{

  private final double fixedClock;

  public TestBehavior(double fixedClock) {
    this.fixedClock = fixedClock;
  }

  @Override
  public double nextTime() {
    return this.fixedClock;
  }
  
}