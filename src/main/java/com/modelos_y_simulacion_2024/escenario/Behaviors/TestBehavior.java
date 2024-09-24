package com.modelos_y_simulacion_2024.escenario.Behaviors;

import com.modelos_y_simulacion_2024.dominio.Behavior;

public class TestBehavior implements Behavior{

  private final int fixedClock;

  public TestBehavior(int fixedClock) {
    this.fixedClock = fixedClock;
  }

  @Override
  public int nextTime() {
    return this.fixedClock;
  }
  
}