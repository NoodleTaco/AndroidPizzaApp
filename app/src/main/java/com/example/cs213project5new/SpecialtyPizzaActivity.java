package com.example.cs213project5new;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;

/**
 * The Activity class of the Specialty Pizza Screen
 * @author Donald Yubeaton, Michael Kassie
 */
public class SpecialtyPizzaActivity extends AppCompatActivity {

    RecyclerView specialtyPizzaRecyclerView;


    /**
     * Initializes the recycler view that represents all the Specialty Pizzas
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialty_pizza);

        specialtyPizzaRecyclerView = findViewById(R.id.specialtyPizzaRecyclerView);
        specialtyPizzaRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<SpecialtyPizzaItem> specialtyPizzaList = new ArrayList<SpecialtyPizzaItem>();

        specialtyPizzaList.add(new SpecialtyPizzaItem("Deluxe", R.drawable.deluxe_image));
        specialtyPizzaList.add(new SpecialtyPizzaItem("Supreme", R.drawable.supreme_image));
        specialtyPizzaList.add(new SpecialtyPizzaItem("Meatzza", R.drawable.meatzza_image));
        specialtyPizzaList.add(new SpecialtyPizzaItem("Seafood", R.drawable.seafood_image));
        specialtyPizzaList.add(new SpecialtyPizzaItem("Pepperoni", R.drawable.pepperoni_image));
        specialtyPizzaList.add(new SpecialtyPizzaItem("Veggie", R.drawable.veggie_image));
        specialtyPizzaList.add(new SpecialtyPizzaItem("MushroomPepperoni", R.drawable.mushroom_pepperoni_image));
        specialtyPizzaList.add(new SpecialtyPizzaItem("SurfAndTurf", R.drawable.surf_and_turf_image));
        specialtyPizzaList.add(new SpecialtyPizzaItem("Sweet", R.drawable.sweet_image));
        specialtyPizzaList.add(new SpecialtyPizzaItem("Disaster", R.drawable.disaster_image));
        specialtyPizzaRecyclerView.setAdapter(new SpecialtyPizzaAdapter(getApplicationContext(), specialtyPizzaList));
    }
}