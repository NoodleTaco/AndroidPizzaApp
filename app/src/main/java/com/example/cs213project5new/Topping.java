package com.example.cs213project5;

import java.util.ArrayList;

/**
 * Enum that represents the different pizza toppings
 * @author Donald Yubeaton, Michael Kassie
 */
public enum Topping {
    SAUSAGE("Sausage"),
    PEPPERONI("Pepperoni"),
    GREEN_PEPPER("Green Pepper"),
    ONION("Onion"),
    MUSHROOM("Mushroom"),
    HAM("Ham"),
    BLACK_OLIVE("Black Olive"),
    BEEF("Beef"),
    SHRIMP("Shrimp"),
    SQUID("Squid"),
    CRAB_MEAT("Crab Meat"),
    SNICKERS("Snickers"),
    RICE_CRACKERS("Rice Crackers");

    private final String displayName;

    /**
     * Adds the display name as a property to the topping
     * @param displayName The display name of the enum
     */
    Topping(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    /**
     * Takes in an arraylist of toppings and returns a String array populated with the display name of each topping
     * @param toppings The Arraylist of toppings
     * @return A String array with their display names
     */
    public static String[] getDisplayNames(ArrayList<Topping> toppings) {
        String[] displayNames = new String[toppings.size()];

        for (int i = 0; i < toppings.size(); i++) {
            displayNames[i] = toppings.get(i).getDisplayName();
        }

        return displayNames;
    }

    /**
     * Overloaded version to take in an array of toppings rather an arraylist.
     * @param toppings The array of toppings
     * @return A String array with their display names
     */
    public static String[] getDisplayNames(Topping[] toppings) {
        String[] displayNames = new String[toppings.length];

        for (int i = 0; i < toppings.length; i++) {
            displayNames[i] = toppings[i].getDisplayName();
        }

        return displayNames;
    }
}
