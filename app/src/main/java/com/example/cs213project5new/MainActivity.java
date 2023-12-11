package com.example.cs213project5new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * The Activity class of the Main Menu
 * Activity displayed when the program is ran
 * @author Donald Yubeaton, Michael Kassie
 */
public class MainActivity extends AppCompatActivity {

    private Button openSpecialtyPizzaButton, openBuildYourOwnButton, openCurrentOrderButton, openStoreOrderButton;

    /**
     * Initializes global variables and calls initialization methods for the rest of the components
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openSpecialtyPizzaButton = findViewById(R.id.openSpecialtyPizzaButton);
        openBuildYourOwnButton = findViewById(R.id.openBuildYourOwnButton);
        openCurrentOrderButton = findViewById(R.id.openCurrentOrderButton);
        openStoreOrderButton = findViewById(R.id.openStoreOrderButton);
        /**
         * Sets the listener of the button to open the SpecialtyPizza Activity
         */
        openSpecialtyPizzaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTargetActivity(SpecialtyPizzaActivity.class);
            }
        });
        /**
         * Sets the listener of the button to open the BuildYourOwn Activity
         */
        openBuildYourOwnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTargetActivity(BuildYourOwnActivity.class);
            }
        });
        /**
         * Sets the listener of the button to open the CurrentOrder Activity
         */
        openCurrentOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTargetActivity(CurrentOrderActivity.class);
            }
        });
        /**
         * Sets the listener of the button to open the StoreOrder Activity
         */
        openStoreOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTargetActivity(StoreOrderActivity.class);
            }
        });

        GlobalStoreOrder globalStoreOrder = GlobalStoreOrder.getInstance();
        globalStoreOrder.setGlobalStoreOrder(new StoreOrder());
    }

    /**
     * Opens the target activity
     * @param targetActivityClass the activity class of the screen that will be opened
     */
    public void openTargetActivity(Class<?> targetActivityClass){
        Intent intent = new Intent(this, targetActivityClass);
        startActivity(intent);
    }

}