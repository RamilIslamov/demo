package com.example.demo.models;
import jakarta.persistence.*;

@Entity
@Table(name = "autos")
public class Auto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column (name = "model")
  private String model;

  //можно не указывать Column name, если оно совпадает с названием столбца в таблице
  private String color;


  public Auto() {
  }

  public Auto(String model, String color) {
    this.model = model;
    this.color = color;
  }

  public int getId() {
    return id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }


  @Override
  public String toString() {
    return color + " " + model;
  }
}
