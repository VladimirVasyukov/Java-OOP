package com.epam.knight.model.ammunition;

public class Sword extends AmmunitionParameters {

    private final int damage;

    public Sword(int weight, int cost, int damage) {
        this.weight = weight;
        this.cost = cost;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
