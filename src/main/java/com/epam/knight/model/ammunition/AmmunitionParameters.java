package com.epam.knight.model.ammunition;

public class AmmunitionParameters implements Ammunition {

    protected int weight;

    protected int cost;

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
