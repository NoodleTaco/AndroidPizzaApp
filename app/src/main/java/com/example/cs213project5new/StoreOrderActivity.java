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
import android.widget.Spinner;


import java.lang.reflect.Array;
import java.util.List;

public class StoreOrderActivity extends AppCompatActivity {


    private ListView pizzaOrderListView;

    private Spinner orderSpinner;
    private GlobalStoreOrder globalStoreOrder;

    private Button cancelOrderButton;

    private Order selectedOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order);

        globalStoreOrder = GlobalStoreOrder.getInstance();

        initializeComponents();

        updateOrderSpinner();

        if (orderSpinner.getSelectedItem() != null) {
            selectedOrder = (Order) orderSpinner.getSelectedItem();
            updatePizzaOrderListView();
        }


    }

    private void initializeComponents() {
        pizzaOrderListView = findViewById(R.id.pizzaOrderListView);
        orderSpinner = findViewById(R.id.orderSpinner);
        cancelOrderButton = findViewById(R.id.cancelOrderButton);

        orderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedOrder = (Order) parentView.getItemAtPosition(position);
                updatePizzaOrderListView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });

        cancelOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedOrder == null){
                    showToast("Error: No Order Selected");
                    return;
                }
                globalStoreOrder.getStoreOrder().getOrderList().remove(selectedOrder);
                showToast("Order Cancelled");

                updateOrderSpinner();

                if (orderSpinner.getSelectedItem() != null) {
                    selectedOrder = (Order) orderSpinner.getSelectedItem();
                }
                else{
                    selectedOrder = null;
                }
                updatePizzaOrderListView();
            }
        });

    }

    private void updateOrderSpinner(){
        List<Order> orderList = globalStoreOrder.getStoreOrder().getOrderList();
        ArrayAdapter<Order> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, orderList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orderSpinner.setAdapter(adapter);
    }

    private void updatePizzaOrderListView(){
        if(selectedOrder != null){
            ArrayAdapter<Pizza> adapter = new ArrayAdapter<Pizza>(this, android.R.layout.simple_list_item_1, selectedOrder.getPizzaList());

            pizzaOrderListView.setAdapter(adapter);
        }
        else{
            showToast("Making List Empty");
            ArrayAdapter<Pizza> emptyAdapter = new ArrayAdapter<Pizza>(this, android.R.layout.simple_list_item_1);
            pizzaOrderListView.setAdapter(emptyAdapter);
        }

    }

    private void showToast(String message) {
        // Create a Toast object
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);

        // Display the Toast
        toast.show();
    }


}