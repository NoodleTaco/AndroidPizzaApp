package com.example.cs213project5new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    private Button openSpecialtyPizzaButton, openBuildYourOwnButton, openCurrentOrderButton, openStoreOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openSpecialtyPizzaButton = findViewById(R.id.openSpecialtyPizzaButton);
        openBuildYourOwnButton = findViewById(R.id.openBuildYourOwnButton);
        openCurrentOrderButton = findViewById(R.id.openCurrentOrderButton);
        openStoreOrderButton = findViewById(R.id.openStoreOrderButton);

        openSpecialtyPizzaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTargetActivity(SpecialtyPizzaActivity.class);
            }
        });

        openBuildYourOwnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTargetActivity(BuildYourOwnActivity.class);
            }
        });

        openCurrentOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTargetActivity(CurrentOrderActivity.class);
            }
        });

        openStoreOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTargetActivity(StoreOrderActivity.class);
            }
        });
    }

    public void openTargetActivity(Class<?> targetActivityClass){
        Intent intent = new Intent(this, targetActivityClass);
        startActivity(intent);
    }

}