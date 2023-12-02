
package com.example.cs213project5new;

import java.io.Serializable;
import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 * Abstract class that represents a Pizza
 * @author Donald Yubeaton, Michael Kassie
 */
public abstract class Pizza implements Serializable {
    protected ArrayList<Topping> toppings; //Topping is a enum class
    protected Size size; //Size is an enum class
    protected Sauce sauce; //Sauce is an enum class
    protected boolean extraSauce;
    protected boolean extraCheese;

    static final int mediumExtraPrice = 2;
    static final int largeExtraPrice = 4;

    /**
     * Default connstructor that initializes the toppings array list
     */
    public Pizza(){
        toppings = new ArrayList<>();
    }

    /**
     * Abstract price method that is implemented in the subclasses
     * @return The price of the pizza
     */
    public abstract double price();

    /**
     * Returns the additional price incurred from sizes other than small
     * @return 0 for small, 2 for medium, 4 for large
     */
    protected int extraPriceFromSizeAndExtras(){
        int extra = 0;
        if(size == null){
            return -1;
        }
        if(this.size.equals(Size.MEDIUM)){
            extra += mediumExtraPrice;
        }
        else if(this.size.equals(Size.LARGE)){
            extra += largeExtraPrice;
        }
        if(this.extraCheese){
            extra ++;
        }
        if(this.extraSauce){
            extra++;
        }
        return extra;
    }

    /**
     * Returns if the pizza has extra sauce
     * @return if the pizza has extra sauce
     */
    public boolean hasExtraSauce() {
        return extraSauce;
    }

    /**
     * Sets the extra sauce property
     * @param extraSauce Whether the pizza has extra sauce
     */
    public void setExtraSauce(boolean extraSauce) {
        this.extraSauce = extraSauce;
    }

    /**
     * Returns if the pizza has extra cheese
     * @return if the pizza has extra cheese
     */
    public boolean hasExtraCheese() {
        return extraCheese;
    }

    /**
     * Sets the extra cheese property
     * @param extraCheese Whether the pizza has extra cheese
     */
    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    /**
     * Returns the pizza's size
     * @return the pizza's size
     */
    public Size getSize() {
        return size;
    }

    /**
     * Sets the pizza's size
     * @param size the pizza's new size
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Returns the pizza's type of sauce
     * @return the pizza's type of sauce
     */
    public Sauce getSauce() {
        return sauce;
    }

    /**
     * Returns the pizza's list of toppings
     * @return the pizza's list of toppings
     */
    public ArrayList<Topping> getToppings(){
        return toppings;
    }

    /**
     * Overridden toString method that returns a string representation of the pizza
     * Includes the pizza's type, sauce, toppings, and price
     * @return
     */
    @Override
    public String toString(){
        String string = "";

        if(this.getClass() == Deluxe.class){
            string += "Deluxe: ";
        }
        else if(this.getClass() == Supreme.class){
            string += "Supreme: ";
        }
        else if(this.getClass() == Meatzza.class){
            string += "Meatzza: ";
        }
        else if(this.getClass() == Seafood.class){
            string += "Seafood: ";
        }
        else if(this.getClass() == Pepperoni.class){
            string += "Pepperoni: ";
        }
        else if(this.getClass() == BuildYourOwn.class){
            string += "Build Your Own: ";
        }

        for(String topping: Topping.getDisplayNames(this.getToppings())){
            string += topping + ",";
        }
        if(this.extraSauce){
            string += "extra sauce,";
        }
        if(this.extraCheese){
            string += "extra cheese,";
        }

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        string += " $" + decimalFormat.format(price());
        return string;

    }

}
