package com.example.cs213project5new;

/**
 * Represents the SurfAndTurf Specialty Pizza option
 * @author Donald Yubeaton, Michael Kassie
 */
public class SurfAndTurf extends Pizza{
    static final double smallPrice = 17.99;

    /**
     * Default Constructor that initializes the toppings and sauce a SurfAndTurf pizza has
     */
    public SurfAndTurf(){
        super();
        toppings.add(Topping.HAM); toppings.add(Topping.SAUSAGE); toppings.add(Topping.BEEF);
        toppings.add(Topping.SHRIMP);toppings.add(Topping.CRAB_MEAT); toppings.add(Topping.SQUID);
        sauce  = Sauce.ALFREDO;
    }

    /**
     * Gives the pizza's price based on the SurfAndTurf pizza's default price
     * @return the pizza's price
     */
    @Override
    public double price() {
        return smallPrice + extraPriceFromSizeAndExtras();
    }
}
