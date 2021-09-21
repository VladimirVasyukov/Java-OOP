package com.epam.knight.view;

import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.Ammunition;

public class ConsoleView {
    public static final String FILE_NOT_FOUND_EXCEPTION =
        "'Knight' file not found!\nKnight without ammunition will be created";
    public static final String MAIN_MENU_ERROR = "Main menu option not found!";
    public static final String EQUIP_ERROR = "Ammunition type not found!";
    public static final String SORT_TYPE_ERROR = "Sort type not found!";
    public static final String SEARCH_FIELD_ERROR = "Search file not found!";
    public static final String SWORD = "sword";
    public static final String HELMET = "helmet";
    public static final String WEIGHT = "weight";
    public static final String COST = "cost";
    public static final String DAMAGE = "damage";
    public static final String PROTECTION = "protection";
    public static final String MINIMUM_VALUE = "minimum";
    public static final String MAXIMUM_VALUE = "maximum";
    public static final String BYE = "Bye!";
    private static final String MAIN_MENU = "Main menu";
    private static final String PRINT_KNIGHT_STATS = "1. Print knight stats";
    private static final String SHOW_AMMUNITION = "2. Show ammunition";
    private static final String EQUIP_AMMUNITION = "3. Equip ammunition";
    private static final String SORT_AMMUNITION = "4. Sort ammunition";
    private static final String SEARCH_AMMUNITION = "5. Search ammunition";
    private static final String EXIT = "6. Exit";
    private static final String CHOOSE_OPTION = "Choose option";
    private static final String AMMUNITION_COST = "Ammunition cost";
    private static final String AMMUNITION_WEIGHT = "Ammunition weight";
    private static final String AMMUNITION_DAMAGE = "Ammunition damage";
    private static final String AMMUNITION_PROTECTION = "Ammunition protection";
    private static final String SWORD_1 = "1. Sword";
    private static final String HELMET_2 = "2. Helmet";
    private static final String WHAT_KIND_OF_AMMUNITION_DO_YOU_WANT_TO_EQUIP =
        "What kind of ammunition do you want to equip?";
    private static final String INPUT = "Input";
    private static final String COST_1 = "1. Cost";
    private static final String WEIGHT_2 = "2. Weight";
    private static final String CHOOSE_SORT_TYPE = "Choose sort type";
    private static final String CHOOSE_SEARCH_FIELD = "Choose search field";

    public void printMainMenu() {
        System.out.printf("%s:%n%s%n%s%n%s%n%s%n%s%n%s%n%s:%n", MAIN_MENU, PRINT_KNIGHT_STATS, SHOW_AMMUNITION,
            EQUIP_AMMUNITION, SORT_AMMUNITION, SEARCH_AMMUNITION, EXIT, CHOOSE_OPTION);
    }

    public void printMessage(String message) {
        System.out.printf("%s%n", message);
    }

    public void printKnightStats(Knight knight) {
        System.out.printf("%s: %d%n%s: %d%n%s: %d%n%s: %d%n",
            AMMUNITION_COST, knight.calculateAmmunitionCost(),
            AMMUNITION_WEIGHT, knight.calculateAmmunitionWeight(),
            AMMUNITION_DAMAGE, knight.calculateAmmunitionDamage(),
            AMMUNITION_PROTECTION, knight.calculateAmmunitionProtection());
    }

    public void printAmmunition(Ammunition[] ammunition) {
        for (Ammunition element : ammunition) {
            printAmmunitionElement(element);
        }
    }

    public void printAmmunitionElement(Ammunition element) {
        System.out.println(element.toString());
    }

    public void printAmmunitionTypeRequest() {
        System.out.printf("%s%n%s%n%s%n%s:%n",
            WHAT_KIND_OF_AMMUNITION_DO_YOU_WANT_TO_EQUIP, SWORD_1, HELMET_2, CHOOSE_OPTION);
    }

    public void printInputRequest(String secondRequestWord, String thirdRequestWord) {
        System.out.printf("%s %s %s:%n", INPUT, secondRequestWord, thirdRequestWord);
    }

    public void printSortTypeRequest() {
        printSortOrSortRequest(CHOOSE_SORT_TYPE);
    }

    public void printSearchFieldRequest() {
        printSortOrSortRequest(CHOOSE_SEARCH_FIELD);
    }

    private void printSortOrSortRequest(String requestMessage) {
        System.out.printf("%s:%n%s%n%s%n%s:%n", requestMessage, COST_1, WEIGHT_2, CHOOSE_OPTION);
    }

}
