package com.epam.knight.model.ammunition;

public class Helmet implements Ammunition {

    private final int weight;
    private final int cost;
    private final int protection;

    public Helmet(int weight, int cost, int protection) {
        this.weight = weight;
        this.cost = cost;
        this.protection = protection;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getCost() {
        return cost;
    }

    public int getProtection() {
        return protection;
    }
}
