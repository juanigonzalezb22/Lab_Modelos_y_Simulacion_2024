package com.modelos_y_simulacion_2024.dominio;

@FunctionalInterface
public interface Behavior {
  double nextTime(double clock);
}
