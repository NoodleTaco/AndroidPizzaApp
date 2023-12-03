package com.example.cs213project5new;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;

public class SpecialtyPizzaActivity extends AppCompatActivity {

    RecyclerView specialtyPizzaRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialty_pizza);

        specialtyPizzaRecyclerView = findViewById(R.id.specialtyPizzaRecyclerView);
        specialtyPizzaRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<SpecialtyPizzaItem> specialtyPizzaList = new ArrayList<SpecialtyPizzaItem>();

        specialtyPizzaList.add(new SpecialtyPizzaItem("Deluxe", R.drawable.build_your_own_activity_image));
        specialtyPizzaList.add(new SpecialtyPizzaItem("Supreme", R.drawable.build_your_own_activity_image));
        specialtyPizzaRecyclerView.setAdapter(new SpecialtyPizzaAdapter(getApplicationContext(), specialtyPizzaList));
    }
}