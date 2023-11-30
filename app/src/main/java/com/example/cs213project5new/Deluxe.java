package com.example.cs213project5;

/**
 * Represents the Deluxe Specialty Pizza option
 * @author Donald Yubeaton, Michael Kassie
 */
public class Deluxe extends Pizza{

    static final double smallPrice = 14.99;

    /**
     * Default Constructor that initializes the toppings and sauce a Deluxe pizza has
     */
    public Deluxe(){
        super();
        toppings.add(Topping.SAUSAGE); toppings.add(Topping.PEPPERONI); toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION); toppings.add(Topping.MUSHROOM);

        sauce = Sauce.TOMATO;
    }

    /**
     * Gives the pizza's price based on the Deluxe pizza's default price
     * @return the pizza's price
     */
    @Override
    public double price() {
        return smallPrice + extraPriceFromSizeAndExtras();
    }
}
