package com.example.cs213project5new;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class holds a list of placed orders and a current order
 * @author Donald Yubeaton, Michael Kassie
 */
public class StoreOrder implements Serializable {
    static int nextOrderNumber;

    static final int startingOrderNumber = 0;
    private ArrayList<Order> orderList;

    private Order currentOrder;

    /**
     * Default Constructor that initializes the order list, the nextOrderNumber, and a current order with that number
     */
    public StoreOrder(){
        orderList = new ArrayList<>();
        nextOrderNumber = startingOrderNumber;
        currentOrder = new Order(nextOrderNumber);
    }

    /**
     * Increments the nextOrderNumber
     */
    public void incrementNextOrderNumber(){
        nextOrderNumber++;
    }

    /**
     * Adds the current order to the order list
     */
    public void addOrder(){
        orderList.add(currentOrder);
        incrementNextOrderNumber();
        currentOrder = new Order(nextOrderNumber);
    }


    /**
     * Returns the list of placed orders
     * @return the list of placed orders
     */
    public ArrayList<Order> getOrderList(){
        return orderList;
    }

    /**
     * Returns the current order
     * @return the current order
     */
    public Order getCurrentOrder(){
        return currentOrder;
    }

    /**
     * Uses a StringBuilder to construct a representation of the order placed
     * For each order, its number and each pizza is stated placed in a different line
     * @return the string representation of all order placed
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Store Orders: \n");
        for(Order order: orderList){
            stringBuilder.append("Order: ").append(order.toString()).append(" Total: $").append(String.format("%.2f",
                    order.getOrderTotal())).append("\n");
            for(Pizza pizza: order.getPizzaList()){
                stringBuilder.append(pizza.toString()).append("\n");
            }

        }
        return stringBuilder.toString();
    }

}
