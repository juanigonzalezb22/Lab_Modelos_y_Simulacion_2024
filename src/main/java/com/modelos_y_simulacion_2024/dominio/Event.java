package com.modelos_y_simulacion_2024.dominio;

public final class Event {
  private final int clock;
  private final Behavior behavior;
  private final Entidad enditad;
  private final Planificator planificator;

  public Event(int clock ,Behavior behavior, Entidad entidad, Planificator planificator ) {
    this.clock = clock;
    this.behavior = behavior;
    this.enditad = entidad;
    this.planificator = planificator;
  }

  public int getClock() {
    return clock;
  }

  public Behavior getBehavior() {
    return behavior;
  }

  public Entidad getEnditad() {
    return enditad;
  }

  public Planificator getPlanificator() {
    return planificator;
  }

  @Override
  public String toString() {
    return super.toString();
  }

}

