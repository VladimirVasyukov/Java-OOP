package com.epam.knight.model.ammunition.comparator;

import com.epam.knight.model.ammunition.Ammunition;

import java.io.Serializable;
import java.util.Comparator;

public class WeightComparator implements Comparator<Ammunition>, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public int compare(Ammunition ammunitionOne, Ammunition ammunitionTwo) {
        return Integer.compare(ammunitionOne.getWeight(), ammunitionTwo.getWeight());
    }
}
