package com.example.cs213project5new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class SpecialtyPizzaAdapter extends RecyclerView.Adapter<SpecialtyPizzaViewHolder>{

    private List<SpecialtyPizzaItem> pizzaItemList;
    private Context context;

    public SpecialtyPizzaAdapter(Context context, List<SpecialtyPizzaItem> pizzaItemList) {
        this.context = context;
        this.pizzaItemList = pizzaItemList;
    }

    @NonNull
    @Override
    public SpecialtyPizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);
        return new SpecialtyPizzaViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialtyPizzaViewHolder holder, int position) {
        SpecialtyPizzaItem pizzaItem = pizzaItemList.get(position);
        holder.bind(pizzaItem);
    }

    @Override
    public int getItemCount() {
        return pizzaItemList.size();
    }
}
