package com.bryan.domain;

public class Animal {

    private Integer id;
    private Integer legs;
    private double weight;
    private String color;

    public Integer getLegs() {
        return legs;
    }

    public void setLegs(Integer legs) {
        this.legs = legs;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", legs=" + legs +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
