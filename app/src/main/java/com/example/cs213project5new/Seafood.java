package com.example.cs213project5new;

/**
 * Represents the Seafood Specialty Pizza option
 * @author Donald Yubeaton, Michael Kassie
 */
public class Seafood extends Pizza{

    static final double smallPrice = 17.99;

    /**
     * Default Constructor that initializes the toppings and sauce a Seafood pizza has
     */
    public Seafood(){
        super();
        toppings.add(Topping.SHRIMP); toppings.add(Topping.SQUID); toppings.add(Topping.CRAB_MEAT);

        sauce = Sauce.ALFREDO;
    }

    /**
     * Gives the pizza's price based on the Seafood pizza's default price
     * @return the pizza's price
     */
    @Override
    public double price() {
        return smallPrice + extraPriceFromSizeAndExtras();
    }
}
