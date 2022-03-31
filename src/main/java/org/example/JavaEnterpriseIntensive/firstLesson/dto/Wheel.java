package org.example.JavaEnterpriseIntensive.firstLesson.dto;

import org.example.JavaEnterpriseIntensive.firstLesson.api.AutoPart;

public class Wheel /*extends AutoPart*/ implements AutoPart  {
    private int radius;
    private int diameter;

    public Wheel(int radius, int diameter) {
        this.radius = radius;
        this.diameter = diameter;
    }

    public Wheel() {
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "wheel{" +
                "radius=" + radius +
                ", diameter=" + diameter +
                '}';
    }
}
