package com.modelos_y_simulacion_2024.escenario.Behaviors;

import com.modelos_y_simulacion_2024.dominio.Behavior;

public class TestBehavior implements Behavior{

  private final float fixedClock;

  public TestBehavior(float fixedClock) {
    this.fixedClock = fixedClock;
  }

  @Override
  public float nextTime() {
    return this.fixedClock;
  }
  
}