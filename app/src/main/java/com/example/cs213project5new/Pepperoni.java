package com.example.cs213project5;

/**
 * Represents the Pepperoni Specialty Pizza option
 * @author Donald Yubeaton, Michael Kassie
 */
public class Pepperoni extends Pizza{

    static final double smallPrice = 10.99;

    /**
     * Default Constructor that initializes the toppings and sauce a Pepperoni pizza has
     */
    public Pepperoni(){
        super();
        toppings.add(Topping.PEPPERONI);

        sauce = Sauce.TOMATO;
    }

    /**
     * Gives the pizza's price based on the Pepperoni pizza's default price
     * @return the pizza's price
     */
    @Override
    public double price() {
        return smallPrice + extraPriceFromSizeAndExtras();
    }
}
