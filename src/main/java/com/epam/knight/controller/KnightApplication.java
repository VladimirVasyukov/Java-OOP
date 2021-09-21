package com.epam.knight.controller;

import com.epam.knight.view.ConsoleView;

/**
 * 05_OOP - Vladimir Vasyukov
 * This Application creates a knight and allows you:
 * - Print knight stats;
 * - Show knight`s ammunition;
 * - Equip a knight with a sword or helmet;
 * - Sort the knight's ammunition;
 * - Search ammunition by parameters;
 */

public class KnightApplication {

    public static void main(String[] args) {
        KnightApplication application = new KnightApplication();
        application.start();
    }

    private void start() {
        KnightController knightController =
            new KnightController(KnightGenerator.generateKnight(), new ConsoleView());
        knightController.knightControllerMenu();
    }
}
