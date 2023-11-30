package com.example.cs213project5new;

/**
 * Enum that represents the different pizza sauces
 * @author Donald Yubeaton, Michael Kassie
 */
public enum Sauce {
    TOMATO("Tomato"),
    ALFREDO("Alfredo");

    private final String name;

    /**
     * Adds the display name as a property to the sauce
     * @param name The display name of the enum
     */
    Sauce(String name) {
        this.name = name;
    }

    /**
     * Getter method for the display name
     * @return The display name
     */
    public String getName() {
        return name;
    }
}