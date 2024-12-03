package com.modelos_y_simulacion_2024.utils.distribuciones;

import java.util.Random;

public class Normal {
  
  private Random random = new Random(System.currentTimeMillis());

  private double mediaY;
  private double varianzaY;

  //porque voy a usar una uniforme entre 0 y 1
  private final double varianzaX = 1d/12d;
  private final double mediaX = 0.5d;
  
  private final double mediaZ;
  private final double varianzaZ;
  private final double desviacionZ;

  private int n;

  public Normal(double mediaY, double varianzaY){
    this.n = 48;
    this.mediaY = mediaY;
    this.varianzaY = varianzaY;
    
    this.mediaZ = this.n*this.mediaX;
    this.varianzaZ = this.n*this.varianzaX;
    this.desviacionZ = Math.sqrt(this.varianzaZ);
  }

  public Normal(double mediaY, double varianzaY, int n){
    this.n = n;
    this.mediaY = mediaY;
    this.varianzaY = varianzaY;
    
    this.mediaZ = this.n*this.mediaX;
    this.varianzaZ = this.n*this.varianzaX;
    this.desviacionZ = Math.sqrt(this.varianzaZ);
  }

  public double probabilidad(double x, double media, double varianza){
    
    double desviacion_estandar = Math.sqrt(varianza);
    double z = (x - media) / desviacion_estandar;

    double distribucion_normal = (1 / ( desviacion_estandar * Math.sqrt(2 * Math.PI) ) ) * Math.exp( -0.5 * Math.pow(z, 2) );

    return distribucion_normal;
  }

  public double generarVariableNormal() {
    
    //PASO 1
    double normalAproximada = 0;
    for (int i=0; i < this.n; i++) {
      normalAproximada += this.random.nextDouble();
    }
    //PASO 2
    double normalEstandar = ( normalAproximada - this.mediaZ ) / this.desviacionZ;
    //PASO 3
    double Y = normalEstandar * Math.sqrt( varianzaY ) + mediaY;

    return Y;
  }
}
