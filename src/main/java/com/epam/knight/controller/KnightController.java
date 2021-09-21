package com.epam.knight.controller;

import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.Helmet;
import com.epam.knight.model.ammunition.SortAmmunition;
import com.epam.knight.model.ammunition.Sword;
import com.epam.knight.view.ConsoleView;

import java.util.Scanner;

public class KnightController {
    private static final int PRINT_KNIGHT_STATS_OPTION = 1;
    private static final int SHOW_AMMUNITION_OPTION = 2;
    private static final int EQUIP_AMMUNITION_OPTION = 3;
    private static final int SORT_AMMUNITION_OPTION = 4;
    private static final int SEARCH_AMMUNITION_OPTION = 5;
    private static final int EXIT_MENU_OPTION = 6;
    private static final int EQUIP_SWORD = 1;
    private static final int EQUIP_HELMET = 2;
    private static final int SORT_BY_COST = 1;
    private static final int SORT_BY_WEIGHT = 2;
    private static final int SEARCH_BY_COST = 1;
    private static final int SEARCH_BY_WEIGHT = 2;
    private final Knight knight;
    private final ConsoleView consoleView;
    private final Scanner controllerScanner = new Scanner(System.in, "UTF-8");
    private boolean exitIsCalled;

    KnightController(Knight knight, ConsoleView consoleView) {
        this.knight = knight;
        this.consoleView = consoleView;
    }
    // This method contains the logic of the main menu of the program.

    public void knightControllerMenu() {
        do {
            consoleView.printMainMenu();
            int mainMenuOption = Integer.parseInt(controllerScanner.nextLine());
            switch (mainMenuOption) {
                case PRINT_KNIGHT_STATS_OPTION:
                    consoleView.printKnightStats(knight);
                    break;
                case SHOW_AMMUNITION_OPTION:
                    consoleView.printAmmunition(knight.getAmmunition());
                    break;
                case EQUIP_AMMUNITION_OPTION:
                    equipNewAmmunition();
                    break;
                case SORT_AMMUNITION_OPTION:
                    sortAmmunition(knight.getAmmunition());
                    break;
                case SEARCH_AMMUNITION_OPTION:
                    searchAmmunition(knight.getAmmunition());
                    break;
                case EXIT_MENU_OPTION:
                    exitIsCalled = true;
                    consoleView.printMessage(ConsoleView.BYE);
                    break;
                default:
                    consoleView.printMessage(ConsoleView.MAIN_MENU_ERROR);
            }
        } while (!exitIsCalled);
    }


    // This method allows to equip a knight with a sword or helmet.

    public void equipNewAmmunition() {
        consoleView.printAmmunitionTypeRequest();
        int chosenAmmunitionType = Integer.parseInt(controllerScanner.nextLine());

        String ammunitionType;
        switch (chosenAmmunitionType) {
            case EQUIP_SWORD:
                ammunitionType = ConsoleView.SWORD;
                break;
            case EQUIP_HELMET:
                ammunitionType = ConsoleView.HELMET;
                break;
            default:
                consoleView.printMessage(ConsoleView.EQUIP_ERROR);
                return;
        }

        int weight = scanInputInt(ammunitionType, ConsoleView.WEIGHT);
        int cost = scanInputInt(ammunitionType, ConsoleView.COST);

        if (ammunitionType.equals(ConsoleView.SWORD)) {
            int damage = scanInputInt(ammunitionType, ConsoleView.DAMAGE);
            knight.equip(new Sword(weight, cost, damage));
        } else {
            int protection = scanInputInt(ammunitionType, ConsoleView.PROTECTION);
            knight.equip(new Helmet(weight, cost, protection));
        }
    }


    // This method allows to sort the knight's ammunition by cost or by weight.

    public void sortAmmunition(Ammunition[] ammunition) {
        consoleView.printSortTypeRequest();
        int chosenSortType = Integer.parseInt(controllerScanner.nextLine());
        SortAmmunition sortAmmunition = new SortAmmunition();
        switch (chosenSortType) {
            case SORT_BY_COST:
                consoleView.printAmmunition(sortAmmunition.sortAmmunitionByCost(ammunition));
                break;
            case SORT_BY_WEIGHT:
                consoleView.printAmmunition(sortAmmunition.sortAmmunitionByWeight(ammunition));
                break;
            default:
                consoleView.printMessage(ConsoleView.SORT_TYPE_ERROR);
        }
    }


    // This method allows search ammunition corresponding to a given cost or weight range.

    public void searchAmmunition(Ammunition[] ammunition) {
        consoleView.printSearchFieldRequest();
        int chosenSearchedField = Integer.parseInt(controllerScanner.nextLine());

        String searchField;
        switch (chosenSearchedField) {
            case SEARCH_BY_COST:
                searchField = ConsoleView.COST;
                break;
            case SEARCH_BY_WEIGHT:
                searchField = ConsoleView.WEIGHT;
                break;
            default:
                consoleView.printMessage(ConsoleView.SEARCH_FIELD_ERROR);
                return;
        }

        int minSearchValue = scanInputInt(ConsoleView.MINIMUM_VALUE, searchField);
        int maxSearchValue = scanInputInt(ConsoleView.MAXIMUM_VALUE, searchField);

        int foundValue;
        for (Ammunition element : ammunition) {
            if (searchField.equals(ConsoleView.COST)) {
                foundValue = element.getCost();
            } else {
                foundValue = element.getWeight();
            }
            if (minSearchValue <= foundValue && foundValue <= maxSearchValue) {
                consoleView.printAmmunitionElement(element);
            }
        }
    }

    private int scanInputInt(String secondRequestWord, String thirdRequestWord) {
        consoleView.printInputRequest(secondRequestWord, thirdRequestWord);
        return Integer.parseInt(controllerScanner.nextLine());
    }

}
