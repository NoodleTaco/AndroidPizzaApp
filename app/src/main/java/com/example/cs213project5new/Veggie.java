package com.example.cs213project5new;

/**
 * Represents the Veggie Specialty Pizza option
 * @author Donald Yubeaton, Michael Kassie
 */
public class Veggie extends Pizza{
    static final double smallPrice = 12.99;

    /**
     * Default Constructor that initializes the toppings and sauce a Veggie pizza has
     */
    public Veggie(){
        super();
        toppings.add(Topping.ONION); toppings.add(Topping.GREEN_PEPPER); toppings.add(Topping.BLACK_OLIVE);
        toppings.add(Topping.MUSHROOM);
        sauce = Sauce.TOMATO;
    }

    /**
     * Gives the pizza's price based on the Veggie pizza's default price
     * @return the pizza's price
     */
    @Override
    public double price() {
        return smallPrice + extraPriceFromSizeAndExtras();
    }
}
