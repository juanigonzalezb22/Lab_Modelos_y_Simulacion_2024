package com.modelos_y_simulacion_2024.Utils.distribuciones;

public interface Distribution {
  public double probabilidad(double x);

  public double sample(double x);
}
