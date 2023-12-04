package com.example.cs213project5new;

/**
 * Represents the Disaster Specialty Pizza option
 * @author Donald Yubeaton, Michael Kassie
 */
public class Disaster extends Pizza{
    static final double smallPrice = 20.99;

    /**
     * Default Constructor that initializes the toppings and sauce a Disaster pizza has
     * Adds every possible topping to the pizza
     */
    public Disaster(){
        super();
        for(Topping topping: Topping.values()){
            toppings.add(topping);
        }
        sauce = Sauce.ALFREDO;
    }

    /**
     * Gives the pizza's price based on the Disaster pizza's default price
     * @return the pizza's price
     */
    @Override
    public double price() {
        return smallPrice + extraPriceFromSizeAndExtras();
    }
}
