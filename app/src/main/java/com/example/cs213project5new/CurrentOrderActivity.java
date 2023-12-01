package com.example.cs213project5new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CurrentOrderActivity extends AppCompatActivity {

    private TextView orderNumberTextView, subtotalTextView, salesTaxTextView, totalPriceTextView;

    private ListView pizzaListView;

    private Button removePizzaButton, placeOrderButton;

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
        pizzaListView = findViewById(R.id.pizzaListView);
        removePizzaButton = findViewById(R.id.removePizzaButton);
        placeOrderButton = findViewById(R.id.placeOrderButton);
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