package com.bichpormak;

public enum Season {

    WINTER(-20),
    SPRING(10),
    SUMMER(30),
    FALL(5);

    private final int temperature;

    Season(int temperature) {
        this.temperature = temperature;
    }


    @Override
    public String toString() {
        return "Season: " + name() + ", Avg Temp: " + temperature;
    }

}
