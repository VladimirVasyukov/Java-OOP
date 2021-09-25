package com.epam.knight.model.ammunition;

public class Helmet extends AmmunitionParameters {

    private final int protection;

    public Helmet(int weight, int cost, int protection) {
        this.weight = weight;
        this.cost = cost;
        this.protection = protection;
    }

    public int getProtection() {
        return protection;
    }
}
