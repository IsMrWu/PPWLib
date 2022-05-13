package com.simuwang.aachart.optionsmodel;

public class AAHover {
  public String borderColor;
  public Float brightness;
  public String color;
  public AAHalo halo;
  public float lineWidth;
  public float lineWidthPlus;

  public AAHover borderColor(String prop) {
    borderColor = prop;
    return this;
  }

  public AAHover brightness(Float prop) {
    brightness = prop;
    return this;
  }

  public AAHover color(String prop) {
    color = prop;
    return this;
  }

  public AAHover halo(AAHalo prop) {
    halo = prop;
    return this;
  }

  public AAHover lineWidth(float prop) {
    lineWidth = prop;
    return this;
  }

  public AAHover lineWidthPlus(float prop) {
    lineWidthPlus = prop;
    return this;
  }
}
