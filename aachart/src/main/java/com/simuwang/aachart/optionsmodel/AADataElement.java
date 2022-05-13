package com.simuwang.aachart.optionsmodel;

public class AADataElement {
  public String name;
  public Float x;
  public Float y;
  public Object color;
  public AADataLabels dataLabels;
  public AAMarker marker;
  public String description;

  public AADataElement name(String prop) {
    name = prop;
    return this;
  }

  public AADataElement x(Float prop) {
    x = prop;
    return this;
  }

  public AADataElement y(Float prop) {
    y = prop;
    return this;
  }

  public AADataElement color(Object prop) {
    color = prop;
    return this;
  }

  public AADataElement dataLabels(AADataLabels prop) {
    dataLabels = prop;
    return this;
  }

  public AADataElement marker(AAMarker prop) {
    marker = prop;
    return this;
  }

  public AADataElement description(String prop) {
    description = prop;
    return this;
  }
}
