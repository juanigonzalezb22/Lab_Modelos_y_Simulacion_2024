package com.modelos_y_simulacion_2024.dominio;

public interface Queue {

  public void enqueue(Entidad enditad);
  
  public Entidad nextEntity();

  public boolean isEmpty();

  public int size();

  public int getId();

}
