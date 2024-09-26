package com.modelos_y_simulacion_2024.escenario.Behaviors;

import com.modelos_y_simulacion_2024.dominio.Behavior;
import com.modelos_y_simulacion_2024.dominio.Randomizer;

public class Tabla1 implements Behavior{
  private double numero; 
  private Randomizer randomizer;

  public Tabla1( Randomizer randomizer ) {
    this.randomizer = randomizer;
  }

  @Override
  public float nextTime() {

    numero = this.randomizer.nextRandom();

    if( numero <= 0.35 ) {
      return 10;
    } else if( numero <= 0.8 ) {
      return 15;
    } else {
      return 20;
    }
  }
  
}
