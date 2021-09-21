package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.Helmet;
import com.epam.knight.model.ammunition.Sword;

import java.util.Arrays;

public class Knight {

    private Ammunition[] ammunition = new Ammunition[0];

    public Ammunition[] getAmmunition() {
        return ammunition.clone();
    }

    /**
     * Add new ammunition element to knight
     * @param element that should be equipped to the knight
     */
    public void equip(Ammunition element) {
        int ammunitionArrayLength = ammunition.length;
        Ammunition[] addAmmunition = Arrays.copyOf(ammunition, ammunitionArrayLength + 1);
        addAmmunition[ammunitionArrayLength] = element;
        this.ammunition = addAmmunition;
    }

    public int calculateAmmunitionWeight() {
        int ammunitionWeight = 0;
        for (Ammunition element : ammunition) {
            ammunitionWeight += element.getWeight();
        }
        return ammunitionWeight;
    }

    public int calculateAmmunitionCost() {
        int ammunitionCost = 0;
        for (Ammunition element : ammunition) {
            ammunitionCost += element.getCost();
        }
        return ammunitionCost;
    }

    public int calculateAmmunitionDamage() {
        int ammunitionDamage = 0;
        for (Ammunition element : ammunition) {
            if (element instanceof Sword) {
                ammunitionDamage += ((Sword) element).getDamage();
            }
        }
        return ammunitionDamage;
    }

    public int calculateAmmunitionProtection() {
        int ammunitionProtection = 0;
        for (Ammunition element : ammunition) {
            if (element instanceof Helmet) {
                ammunitionProtection += ((Helmet) element).getProtection();
            }
        }
        return ammunitionProtection;
    }
}
