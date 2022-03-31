package org.example.JavaEnterpriseIntensive.firstLesson.dto;

import org.example.JavaEnterpriseIntensive.firstLesson.api.AutoPart;

public class Door /*extends AutoPart1*/ implements AutoPart {
    private int weight;
    private String color;

    public Door(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Door() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "door{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
