package com.example.cs213project5new;

public class SpecialtyPizzaItem {
    private String pizzaType;
    private int image;

    public SpecialtyPizzaItem(String pizzaType, int image) {
        this.pizzaType = pizzaType;
        this.image = image;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public int getImage() {
        return image;
    }
}
