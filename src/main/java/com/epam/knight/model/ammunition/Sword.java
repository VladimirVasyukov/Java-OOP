package com.epam.knight.model.ammunition;

public class Sword extends AmmunitionParameters {

    private final int damage;

    public Sword(int damage, int weight, int cost) {
        this.damage = damage;
        this.weight = weight;
        this.cost = cost;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Sword{" +
                "damage=" + damage +
                ", weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
