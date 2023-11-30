package com.example.cs213project5;

/**
 * Represents the Supreme Specialty Pizza option
 * @author Donald Yubeaton, Michael Kassie
 */
public class Supreme extends Pizza{

    static final double smallPrice = 15.99;

    /**
     * Default Constructor that initializes the toppings and sauce a Supreme pizza has
     */
    public Supreme(){
        super();
        toppings.add(Topping.SAUSAGE); toppings.add(Topping.PEPPERONI); toppings.add(Topping.HAM);
        toppings.add(Topping.GREEN_PEPPER); toppings.add(Topping.ONION); toppings.add(Topping.BLACK_OLIVE);
        toppings.add(Topping.MUSHROOM);

        sauce = Sauce.TOMATO;
    }

    /**
     * Gives the pizza's price based on the Supreme pizza's default price
     * @return the pizza's price
     */
    @Override
    public double price() {
        return smallPrice + extraPriceFromSizeAndExtras();
    }
}
