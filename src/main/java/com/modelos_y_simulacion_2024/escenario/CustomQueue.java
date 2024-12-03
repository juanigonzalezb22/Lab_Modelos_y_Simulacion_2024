package com.modelos_y_simulacion_2024.escenario;

import java.util.ArrayList;
import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Entity;
import com.modelos_y_simulacion_2024.dominio.Queue;

public class CustomQueue implements Queue{
  private int id;
  private List<Entity> q;

  public CustomQueue(int id) {
    this.id = id;
    this.q = new ArrayList<Entity>();
  }

  @Override
  public void enqueue(Entity enditad) {
    this.q.add(enditad);
  }

  @Override
  public Entity nextEntity() {
    return this.q.remove(0);
  }

  @Override
  public boolean isEmpty() {
    return this.q.isEmpty();
  }

  @Override
  public int size() {
    return this.q.size();
  }
 
  @Override
  public int getId(){
    return this.id;
  } 

}
