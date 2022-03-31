package org.example.JavaEnterpriseIntensive.firstLesson.dto;

import org.example.JavaEnterpriseIntensive.firstLesson.api.AutoPart;

public class Engine /*extends AutoPart*/ implements AutoPart {
    private String name;
    private int  capacity;

    public Engine(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Engine() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
