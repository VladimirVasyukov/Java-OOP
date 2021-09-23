package com.epam.knight.controller;

import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.Helmet;
import com.epam.knight.model.ammunition.Sword;
import com.epam.knight.view.ConsoleView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class KnightGenerator {
    private static final String SWORD = "Sword";
    private static final String HELMET = "Helmet";
    private static final String FILE_KNIGHT = "src/main/java/com/epam/knight/model/Knight.txt";
    private static final String SCANNER_CHARSET = "UTF-8";
    private static final String TEXT_FILE_DELIMITER = "[-\r\n]";

    private KnightGenerator() {
    }
    /**
     * Use it to quickly generate knight
     * @return knight
     */
    public static Knight generateKnight() {
        Knight knight;
        try (Scanner knightScanner = new Scanner(
            new File(FILE_KNIGHT), SCANNER_CHARSET)) {
            knightScanner.useDelimiter(TEXT_FILE_DELIMITER);
            knight = new Knight();
            while (knightScanner.hasNextLine()) {
                String wordInFirstColumn = knightScanner.next();
                if (wordInFirstColumn.equals(SWORD)) {
                    int weight = knightScanner.nextInt();
                    int cost = knightScanner.nextInt();
                    int damage = knightScanner.nextInt();
                    knight.equip(new Sword(weight, cost, damage));
                }
                if (wordInFirstColumn.equals(HELMET)) {
                    int weight = knightScanner.nextInt();
                    int cost = knightScanner.nextInt();
                    int protection = knightScanner.nextInt();
                    knight.equip(new Helmet(weight, cost, protection));
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            new ConsoleView().printMessage(ConsoleView.FILE_NOT_FOUND_EXCEPTION);
            knight = new Knight();
        }
        return knight;
    }

}
