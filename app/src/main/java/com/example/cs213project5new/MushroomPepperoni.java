package com.example.cs213project5new;


/**
 * Represents the MushroomPepperoni Specialty Pizza option
 * @author Donald Yubeaton, Michael Kassie
 */
public class MushroomPepperoni extends Pizza{
    static final double smallPrice = 12.99;

    /**
     * Default Constructor that initializes the toppings and sauce a MushroomPepperoni pizza has
     */
    public MushroomPepperoni(){
        super();
        toppings.add(Topping.PEPPERONI); toppings.add(Topping.MUSHROOM);
        sauce = Sauce.TOMATO;
    }

    /**
     * Gives the pizza's price based on the MushroomPepperoni pizza's default price
     * @return the pizza's price
     */
    @Override
    public double price() {
        return smallPrice + extraPriceFromSizeAndExtras();
    }
}
