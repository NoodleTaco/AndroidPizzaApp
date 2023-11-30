package com.example.cs213project5;

/**
 * Represents the Meatzza Specialty Pizza option
 * @author Donald Yubeaton, Michael Kassie
 */
public class Meatzza extends Pizza{

    static final double smallPrice = 16.99;

    /**
     * Default Constructor that initializes the toppings and sauce a Meatzza pizza has
     */
    public Meatzza(){
        super();
        toppings.add(Topping.SAUSAGE); toppings.add(Topping.PEPPERONI); toppings.add(Topping.BEEF);
        toppings.add(Topping.HAM);

        sauce = Sauce.TOMATO;
    }

    /**
     * Gives the pizza's price based on the Meatzza pizza's default price
     * @return the pizza's price
     */
    @Override
    public double price() {
        return smallPrice + extraPriceFromSizeAndExtras();
    }
}
