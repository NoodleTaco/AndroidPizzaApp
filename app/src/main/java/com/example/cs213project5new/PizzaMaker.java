package com.example.cs213project5new;

/**
 * Class that handles the creation of Pizzas
 * @author Donald Yubeaton, Michael Kassie
 */
public class PizzaMaker {

    /**
     * Factory method that builds the instances of Pizza
     * @param pizzaType String that represents what type of pizza will be created
     * @return The constructed Pizza object
     */
    public static Pizza createPizza(String pizzaType) {
        switch (pizzaType) {
            case "Deluxe":
                return new Deluxe();
            case "Supreme":
                return new Supreme();
            case "Meatzza":
                return new Meatzza();
            case "Seafood":
                return new Seafood();
            case "Pepperoni":
                return new Pepperoni();
            case "Veggie":
                return new Veggie();
            case "MushroomPepperoni":
                return new MushroomPepperoni();
            case "Sweet":
                return new Sweet();
            case "SurfAndTurf":
                return new SurfAndTurf();
            case "Disaster":
                return new Disaster();
            case "BuildYourOwn":
                return new BuildYourOwn();
            default:
                return null;
        }
    }
}
