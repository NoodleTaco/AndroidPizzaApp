package com.example.cs213project5;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents an Order that has a list of Pizzas and a unique order numberr
 * @author Donald Yubeaton, Michael Kassie
 */
public class Order implements Serializable {

    static final double NJ_SALES_TAX = 0.0625;
    private int orderNumber;
    private ArrayList<Pizza> pizzaList;

    /**
     * Default Constructor that initializes the pizza list
     */
    public Order(){
        pizzaList = new ArrayList<>();
    }

    /**
     * Parameterized constructor that sets the order's number
     * @param orderNumber The order's numberr
     */
    public Order(int orderNumber){
        this.orderNumber = orderNumber;
        pizzaList = new ArrayList<>();
    }

    /**
     * Adds a pizza to the order
     * @param pizza The pizza to be added
     */
    public void addPizzaToOrder(Pizza pizza){
        pizzaList.add(pizza);
    }

    /**
     * Returns a reference to the pizza list
     * @return a reference to the pizza list
     */
    public ArrayList<Pizza> getPizzaList(){
        return pizzaList;
    }

    /**
     * Returns the order number
     * @return the order number
     */
    public int getOrderNumber(){
        return orderNumber;
    }

    /**
     * Calculates the Subtotal of the order
     * @return the Subtotal of the order
     */
    public double getSubTotal(){
        double subtotal = 0;
        for(Pizza pizza: pizzaList){
            subtotal += pizza.price();
        }
        return subtotal;
    }

    /**
     * Calculates the Sales Tax of the order
     * @return the Sales Tax of the order
     */
    public double getSalesTax(){
        return getSubTotal() * NJ_SALES_TAX;
    }

    /**
     * Calculates the Total Price of the order
     * @return the Total Price of the order
     */
    public double getOrderTotal(){
        return getSubTotal() + getSalesTax();
    }

    /**
     * Removes a pizza from the pizza list
     * @param pizza The pizza to be removed
     * @return true if the pizza was removed, false if the list didn't contain the pizza
     */
    public boolean removePizza(Pizza pizza){
        if(!pizzaList.contains(pizza)){
            return false;
        }
        pizzaList.remove(pizza);
        return true;
    }

    /**
     * Overridden toString that returns the order number
     * @return the order number as a string
     */
    @Override
    public String toString(){
        return "" + this.orderNumber;
    }
}
