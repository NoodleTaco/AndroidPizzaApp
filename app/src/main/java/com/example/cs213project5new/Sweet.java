package com.example.cs213project5new;

/**
 * Represents the Sweet Specialty Pizza option
 * @author Donald Yubeaton, Michael Kassie
 */
public class Sweet extends Pizza{
    static final double smallPrice = 13.99;

    /**
     * Default Constructor that initializes the toppings and sauce a Sweet pizza has
     */
    public Sweet(){
        super();
        toppings.add(Topping.RICE_CRACKERS); toppings.add(Topping.SNICKERS);
        sauce = Sauce.TOMATO;
    }

    /**
     * Gives the pizza's price based on the Sweet pizza's default price
     * @return the pizza's price
     */
    @Override
    public double price() {
        return smallPrice + extraPriceFromSizeAndExtras();
    }
}
