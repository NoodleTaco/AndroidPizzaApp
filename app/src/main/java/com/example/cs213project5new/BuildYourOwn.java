package com.example.cs213project5new;

/**
 * Subclass of Pizza that is customizable through the BuildYourOwnController
 * @author Donald Yubeaton, Michael Kassie
 */
public class BuildYourOwn extends Pizza {

    static final double smallPrice = 8.99;

    static final double extraToppingPrice = 1.49;

    static final int numToppingsBeforeExtraPrice = 3;

    /**
     * Default Constructor
     */
    public BuildYourOwn(){
        super();
    }

    /**
     * Adds a topping to the pizza.
     * @param topping The topping to be added.
     * @return true if the topping was added, false if the pizza already has the topping
     */
    public boolean buildTopping(Topping topping){
        if(toppings.contains(topping)){
            return false;
        }
        toppings.add(topping);
        return true;
    }

    /**
     * Removes a topping from the pizza.
     *
     * @param topping The topping to be removed.
     * @return true if the topping was removed, false if the topping isin't on the pizza.
     */
    public boolean removeTopping(Topping topping){
        if(!toppings.contains(topping)){
            return false;
        }
        toppings.remove(topping);
        return true;
    }

    /**
     * Sets the sauce for the pizza.
     * @param sauce The sauce to be added
     */
    public void buildSauce(Sauce sauce){
        this.sauce = sauce;
    }


    /**
     * Calculates the pizza's price factoring in the number of toppings it contains
     * @return the pizza's price
     */
    @Override
    public double price() {
        double extraPriceFromToppings = 0.0;
        if(toppings.size() > numToppingsBeforeExtraPrice){
            extraPriceFromToppings += (toppings.size() - numToppingsBeforeExtraPrice) * extraPriceFromToppings;
        }
        return smallPrice + extraPriceFromSizeAndExtras() + extraPriceFromToppings;
    }

}
