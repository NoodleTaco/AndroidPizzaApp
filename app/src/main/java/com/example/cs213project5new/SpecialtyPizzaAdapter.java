package com.example.cs213project5new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * Adapter used to fill the Specialty Pizza View Holder
 * @author Donald Yubeaton, Michael Kassie
 */
public class SpecialtyPizzaAdapter extends RecyclerView.Adapter<SpecialtyPizzaViewHolder>{

    private List<SpecialtyPizzaItem> pizzaItemList;
    private Context context;

    /**
     * Constructor
     * @param context
     * @param pizzaItemList
     */
    public SpecialtyPizzaAdapter(Context context, List<SpecialtyPizzaItem> pizzaItemList) {
        this.context = context;
        this.pizzaItemList = pizzaItemList;
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */
    @NonNull
    @Override
    public SpecialtyPizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);
        return new SpecialtyPizzaViewHolder(view, parent.getContext());
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull SpecialtyPizzaViewHolder holder, int position) {
        SpecialtyPizzaItem pizzaItem = pizzaItemList.get(position);
        holder.bind(pizzaItem);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     * @return the total number of items in the data set held by the adapter.
     */
    @Override
    public int getItemCount() {
        return pizzaItemList.size();
    }
}
