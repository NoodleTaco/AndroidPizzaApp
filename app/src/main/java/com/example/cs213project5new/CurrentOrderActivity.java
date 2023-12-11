package com.example.cs213project5new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The Activity class of the Current Order Screen
 * @author Donald Yubeaton, Michael Kassie
 */
public class CurrentOrderActivity extends AppCompatActivity {

    private TextView orderNumberTextView, subtotalTextView, salesTaxTextView, totalPriceTextView;

    private ListView pizzaListView;

    private Button placeOrderButton;

    private GlobalStoreOrder globalStoreOrder;



    /**
     * Initializes global variables and calls initialization methods for the rest of the components
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);

        globalStoreOrder = GlobalStoreOrder.getInstance();

        initializeComponents();

        updatePizzaListView();

        updateOrderNumber();

        updateSalesPrices();
    }

    /**
     * Initializes the component variables and assigns their methods
     */
    private void initializeComponents(){
        orderNumberTextView = findViewById(R.id.orderNumberTextView);
        subtotalTextView = findViewById(R.id.subtotalTextView);
        salesTaxTextView = findViewById(R.id.salesTaxTextView);
        totalPriceTextView = findViewById(R.id.totalPriceTextView);
        pizzaListView = findViewById(R.id.pizzaOrderListView);
        placeOrderButton = findViewById(R.id.placeOrderButton);

        /**
         * Sets the click listener for the list view to remove pizzas on click
         */
        pizzaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pizza selectedPizza = (Pizza) parent.getItemAtPosition(position);
                if(!globalStoreOrder.getStoreOrder().getCurrentOrder().removePizza(selectedPizza)){
                    showToast("Error: Pizza not in Order");
                    return;
                }
                showToast("Pizza Removed From Order");
                updatePizzaListView();
                updateSalesPrices();
            }
        });

        /**
         * Sets the on click listener for place order button
         */
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(globalStoreOrder.getStoreOrder().getCurrentOrder().getPizzaList().isEmpty()){
                    AlertDialogMaker.showAlertDialog(CurrentOrderActivity.this,"Current Order Error" ,"Error: No Pizzas in the Order");
                    return;
                }
                globalStoreOrder.getStoreOrder().addOrder();
                showToast("Order Placed");
                updatePizzaListView();
                updateSalesPrices();
                updateOrderNumber();
            }
        });
    }

    /**
     * Method to display a toast given a message
     * @param message The message to be displayed in the toast
     */
    private void showToast(String message) {
        // Create a Toast object
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);

        // Display the Toast
        toast.show();
    }

    /**
     * Updates the pizza list view with the current list of pizzas
     */
    private void updatePizzaListView(){
        ArrayAdapter<Pizza> adapter = new ArrayAdapter<Pizza>(this, android.R.layout.simple_list_item_1, globalStoreOrder.getStoreOrder().getCurrentOrder().getPizzaList());

        pizzaListView.setAdapter(adapter);
    }

    /**
     * Updates the order number display
     */
    private void updateOrderNumber(){
        orderNumberTextView.setText("Order Number: " + globalStoreOrder.getStoreOrder().getCurrentOrder().getOrderNumber());
    }

    /**
     * Updates the sales prices display
     */
    private void updateSalesPrices(){
        subtotalTextView.setText("Subtotal: " + String.format("%.2f", globalStoreOrder.getStoreOrder().getCurrentOrder().getSubTotal()));
        salesTaxTextView.setText("Sales Tax: " + String.format("%.2f", globalStoreOrder.getStoreOrder().getCurrentOrder().getSalesTax()));
        totalPriceTextView.setText("Order Total: " + String.format("%.2f", globalStoreOrder.getStoreOrder().getCurrentOrder().getOrderTotal()));
    }
}