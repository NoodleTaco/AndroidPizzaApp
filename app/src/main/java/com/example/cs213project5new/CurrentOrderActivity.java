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

public class CurrentOrderActivity extends AppCompatActivity {

    private TextView orderNumberTextView, subtotalTextView, salesTaxTextView, totalPriceTextView;

    private ListView pizzaListView;

    private Button placeOrderButton;

    private GlobalStoreOrder globalStoreOrder;



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

    private void initializeComponents(){
        orderNumberTextView = findViewById(R.id.orderNumberTextView);
        subtotalTextView = findViewById(R.id.subtotalTextView);
        salesTaxTextView = findViewById(R.id.salesTaxTextView);
        totalPriceTextView = findViewById(R.id.totalPriceTextView);
        pizzaListView = findViewById(R.id.pizzaOrderListView);
        placeOrderButton = findViewById(R.id.placeOrderButton);

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

        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(globalStoreOrder.getStoreOrder().getCurrentOrder().getPizzaList().isEmpty()){
                    showToast("Error: No Pizzas in the Order");
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

    private void showToast(String message) {
        // Create a Toast object
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);

        // Display the Toast
        toast.show();
    }

    private void updatePizzaListView(){
        ArrayAdapter<Pizza> adapter = new ArrayAdapter<Pizza>(this, android.R.layout.simple_list_item_1, globalStoreOrder.getStoreOrder().getCurrentOrder().getPizzaList());

        pizzaListView.setAdapter(adapter);
    }

    private void updateOrderNumber(){
        orderNumberTextView.setText("Order Number: " + globalStoreOrder.getStoreOrder().getCurrentOrder().getOrderNumber());
    }

    private void updateSalesPrices(){
        subtotalTextView.setText("Subtotal: " + String.format("%.2f", globalStoreOrder.getStoreOrder().getCurrentOrder().getSubTotal()));
        salesTaxTextView.setText("Sales Tax: " + String.format("%.2f", globalStoreOrder.getStoreOrder().getCurrentOrder().getSalesTax()));
        totalPriceTextView.setText("Order Total: " + String.format("%.2f", globalStoreOrder.getStoreOrder().getCurrentOrder().getOrderTotal()));
    }
}