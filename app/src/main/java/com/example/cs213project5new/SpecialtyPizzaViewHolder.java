package com.example.cs213project5new;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SpecialtyPizzaViewHolder extends RecyclerView.ViewHolder{
    private ImageView imageView;
    private TextView pizzaNameTextView, sauceTextView;
    private RadioButton smallRadioButton, mediumRadioButton, largeRadioButton;
    private RadioButton tomatoRadioButton, alfredoRadioButton;
    private CheckBox extraSauceCheckBox, extraCheeseCheckBox;
    private ListView toppingsListView;
    private TextView priceTextView, quantityTextView;
    private Button increaseButton, decreaseButton, addToOrderButton;

    private GlobalStoreOrder globalStoreOrder;

    private Pizza pizza;

    private int numOrders;

    private Context context;

    public SpecialtyPizzaViewHolder(@NonNull View itemView, Context context) {
        super(itemView);

        globalStoreOrder = globalStoreOrder = GlobalStoreOrder.getInstance();
        initializeComponents();
        numOrders = 0;
        this.context = context;

    }

    private void initializeComponents(){
        pizzaNameTextView = itemView.findViewById(R.id.pizzaNameTextView);
        imageView = itemView.findViewById(R.id.recyclerImageView);
        quantityTextView = itemView.findViewById(R.id.quantityTextView);
        smallRadioButton = itemView.findViewById(R.id.smallRadioButton);
        mediumRadioButton = itemView.findViewById(R.id.mediumRadioButton);
        largeRadioButton = itemView.findViewById(R.id.largeRadioButton);
        tomatoRadioButton = itemView.findViewById(R.id.tomatoSelectionRadioButton);
        alfredoRadioButton = itemView.findViewById(R.id.alfredoSelectionRadioButton);
        extraSauceCheckBox = itemView.findViewById(R.id.extraSauceSelectionCheckBox);
        extraCheeseCheckBox = itemView.findViewById(R.id.extraCheeseSelectionCheckBox);
        toppingsListView = itemView.findViewById(R.id.recyclerToppingsListView);
        priceTextView = itemView.findViewById(R.id.recyclerPriceTextView);
        quantityTextView = itemView.findViewById(R.id.quantityTextView);
        increaseButton = itemView.findViewById(R.id.increaseQuantityButton);
        decreaseButton = itemView.findViewById(R.id.decreaseQuantityButton);
        addToOrderButton = itemView.findViewById(R.id.recyclerAddToOrderButton);
        sauceTextView = itemView.findViewById(R.id.sauceTextView);
    }

    public void bind(SpecialtyPizzaItem pizzaItem) {
        pizza = PizzaMaker.createPizza(pizzaItem.getPizzaType());
        imageView.setImageResource(pizzaItem.getImage());
        pizzaNameTextView.setText(pizzaItem.getPizzaType());
        // Set other views accordingly based on pizzaItem properties

        updateToppingsAndSauce();

        updateQuantity();

        pizzaOptionSelect();

        initializeInteraction();

    }

    private void updateToppingsAndSauce(){
        String[] toppingsList = Topping.getDisplayNames(pizza.getToppings());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(itemView.getContext(), android.R.layout.simple_list_item_1, toppingsList);

        toppingsListView.setAdapter(adapter);

        sauceTextView.setText("Sauce: " + pizza.getSauce().getName());
    }

    private void initializeInteraction(){
        smallRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> pizzaOptionSelect());
        mediumRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> pizzaOptionSelect());
        largeRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> pizzaOptionSelect());
        extraSauceCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> pizzaOptionSelect());
        extraCheeseCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> pizzaOptionSelect());
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOrders ++;
                updateQuantity();
            }
        });

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numOrders > 0){
                    numOrders --;
                    updateQuantity();
                }
            }
        });

        addToOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numOrders > 0){
                    for(int i = 0; i < numOrders; i++){
                        globalStoreOrder.getStoreOrder().getCurrentOrder().addPizzaToOrder(pizza);
                    }
                    showToast("Added To Order");
                    numOrders = 0;
                    updateQuantity();
                }
            }
        });

    }

    private void pizzaOptionSelect(){
        if (smallRadioButton.isChecked()) {
            pizza.setSize(Size.SMALL);
        }
        else if (mediumRadioButton.isChecked()) {
            pizza.setSize(Size.MEDIUM);
        }
        else if (largeRadioButton.isChecked()) {
            pizza.setSize(Size.LARGE);
        }

        pizza.setExtraSauce(extraSauceCheckBox.isChecked());
        pizza.setExtraCheese(extraCheeseCheckBox.isChecked());

        updatePriceTextView();
    }

    private void updatePriceTextView() {
        priceTextView.setText("Price: $" + String.format("%.2f", pizza.price()));
    }

    private void updateQuantity(){
        quantityTextView.setText("Quantity: " + numOrders);
    }

    private void showToast(String message) {

        if(context != null){
            Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);

            toast.show();
        }

    }



}
