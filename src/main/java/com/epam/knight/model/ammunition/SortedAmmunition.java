package com.epam.knight.model.ammunition;

import com.epam.knight.model.ammunition.comparator.CostComparator;
import com.epam.knight.model.ammunition.comparator.WeightComparator;

import java.util.Arrays;
import java.util.Comparator;

public class SortedAmmunition {

    public Ammunition[] sortAmmunitionByCost(Ammunition[] originalAmmunitionArray) {
        return sortAmmunition(originalAmmunitionArray, new CostComparator());
    }

    public Ammunition[] sortAmmunitionByWeight(Ammunition[] originalAmmunitionArray) {
        return sortAmmunition(originalAmmunitionArray, new WeightComparator());
    }

    private Ammunition[] sortAmmunition(Ammunition[] originalAmmunitionArray, Comparator<Ammunition> comparator) {
        Ammunition[] sortedAmmunition = originalAmmunitionArray.clone();
        Arrays.sort(sortedAmmunition, comparator);
        return sortedAmmunition;
    }
}
