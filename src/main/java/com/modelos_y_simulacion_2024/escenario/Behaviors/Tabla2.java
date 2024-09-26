package com.modelos_y_simulacion_2024.escenario.Behaviors;

import com.modelos_y_simulacion_2024.dominio.Behavior;
import com.modelos_y_simulacion_2024.dominio.Randomizer;

public class Tabla2 implements Behavior{
  private double numero; 
  private Randomizer randomizer;

  public Tabla2( Randomizer randomizer ) {
    this.randomizer = randomizer;
  }

  @Override
  public float nextTime() {

    numero = this.randomizer.nextRandom();

    if( numero <= 0.38 ) {
      return 8;
    } else if( numero <= 0.70 ) {
      return 10;
    } else if( numero <= 0.80 ) {
      return 13;
    } else {
      return 15;
    }
  }
  
}
