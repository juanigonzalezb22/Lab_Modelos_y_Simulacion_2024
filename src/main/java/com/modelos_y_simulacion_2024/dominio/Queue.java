package com.modelos_y_simulacion_2024.dominio;

public interface Queue {

  public void enqueue(Entity enditad);
  
  public Entity nextEntity();

  public boolean isEmpty();

  public int size();

  public int getId();

}
