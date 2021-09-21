package com.epam.knight.model.ammunition.comparator;

import com.epam.knight.model.ammunition.Ammunition;

import java.io.Serializable;
import java.util.Comparator;

public class CostComparator implements Comparator<Ammunition>, Serializable {
    private static final long serialVersionUID = 2L;

    @Override
    public int compare(Ammunition ammunitionOne, Ammunition ammunitionTwo) {
        return Integer.compare(ammunitionOne.getCost(), ammunitionTwo.getCost());
    }
}
