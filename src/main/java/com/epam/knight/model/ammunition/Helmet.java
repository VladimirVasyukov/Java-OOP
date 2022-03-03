package com.epam.knight.model.ammunition;

public class Helmet extends AmmunitionParameters {

    private final int protection;

    public Helmet(int protection, int weight, int cost) {
        this.protection = protection;
        this.weight = weight;
        this.cost = cost;
    }

    public int getProtection() {
        return protection;
    }

    @Override
    public String toString() {
        return "Helmet{" +
                "protection=" + protection +
                ", weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
