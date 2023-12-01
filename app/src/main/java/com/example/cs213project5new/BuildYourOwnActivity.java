package com.example.cs213project5new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BuildYourOwnActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    static final int MAX_NUMBER_OF_TOPPINGS = 7;

    private RadioButton smallSizeRadioButton, mediumSizeRadioButton, largeSizeRadioButton,
            tomatoRadioButton, alfredoRadioButton;

    private RadioGroup sizeRadioGroup, sauceRadioGroup;

    private Button addToOrderButton;

    private CheckBox extraSauceCheckBox, extraCheeseCheckBox;
    private ImageView buildYourOwnImageView;

    private ListView allToppingsListView, selectedToppingsListView;

    private GlobalStoreOrder globalStoreOrder;

    private TextView priceTextView;

    private Pizza pizza;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_your_own);

        globalStoreOrder = GlobalStoreOrder.getInstance();

        pizza = PizzaMaker.createPizza("BuildYourOwn");

        initializeComponents();

        initializeOptions();

        buildYourOwnOptions();

    }

    private void initializeComponents(){
        priceTextView = findViewById(R.id.priceTextView);

        allToppingsListView = findViewById(R.id.allToppingsListView);
        selectedToppingsListView = findViewById(R.id.selectedToppingsListView);

        String[] toppingsList = Topping.getDisplayNames(Topping.values());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, toppingsList);

        allToppingsListView.setAdapter(adapter);

        allToppingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String clickedTopping = (String) parent.getItemAtPosition(position);
                Topping toppingEnum = Topping.valueOf(clickedTopping.toUpperCase().replace(" ", "_"));
                BuildYourOwn buildYourOwn = (BuildYourOwn)pizza;
                if(!buildYourOwn.buildTopping(toppingEnum)){
                    showToast("Error: Topping Already on Pizza");
                    return;
                }
                updateSelectedToppingsList();
                updateTotalPrice();
            }
        });

        selectedToppingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedTopping = (String) parent.getItemAtPosition(position);
                Topping toppingEnum = Topping.valueOf(clickedTopping.toUpperCase().replace(" ", "_"));
                BuildYourOwn buildYourOwn = (BuildYourOwn)pizza;
                if(!buildYourOwn.removeTopping(toppingEnum)){
                    showToast("Error: Topping Not On Pizza");
                    return;
                }
                updateSelectedToppingsList();
                updateTotalPrice();
            }
        });

        addToOrderButton = findViewById(R.id.addToOrderButton);

        addToOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToOrder();
            }
        });

    }

    private void addToOrder() {
        if(pizza.toppings.size() > MAX_NUMBER_OF_TOPPINGS){
            showToast("Error: More than 7 Toppings selected");
            return;
        }

        showToast("Pizza Added to Order");
        globalStoreOrder.getStoreOrder().getCurrentOrder().addPizzaToOrder(pizza);
        //resetOptions();
        pizza = PizzaMaker.createPizza("BuildYourOwn");
        buildYourOwnOptions();
        updateSelectedToppingsList();
    }

    private void resetOptions() {
        smallSizeRadioButton.setChecked(true);
        tomatoRadioButton.setChecked(true);
        extraSauceCheckBox.setChecked(false);
        extraCheeseCheckBox.setChecked(false);
        updateTotalPrice();
    }

    private void updateSelectedToppingsList() {
        String[] toppingsList = Topping.getDisplayNames(pizza.getToppings());
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, toppingsList);
        selectedToppingsListView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String clickedTopping = (String) parent.getItemAtPosition(position);
        Topping toppingEnum = Topping.valueOf(clickedTopping.toUpperCase().replace(" ", "_"));
        BuildYourOwn buildYourOwn = (BuildYourOwn)pizza;
        if(!buildYourOwn.buildTopping(toppingEnum)){
            showToast("Error: Topping Already on Pizza");
            return;
        }
        updateSelectedToppingsList();
        updateTotalPrice();

    }



    private void initializeOptions(){
        smallSizeRadioButton = findViewById(R.id.smallSizeRadioButton);
        mediumSizeRadioButton = findViewById(R.id.mediumSizeRadioButton);
        largeSizeRadioButton = findViewById(R.id.largeSizeRadioButton);
        tomatoRadioButton = findViewById(R.id.tomatoRadioButton);
        alfredoRadioButton = findViewById(R.id.alfredoRadioButton);

        smallSizeRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> buildYourOwnOptions());
        mediumSizeRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> buildYourOwnOptions());
        largeSizeRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> buildYourOwnOptions());
        tomatoRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> buildYourOwnOptions());
        alfredoRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> buildYourOwnOptions());

        extraSauceCheckBox = findViewById(R.id.extraSauceCheckBox);
        extraCheeseCheckBox = findViewById(R.id.extraCheeseCheckBox);

        extraSauceCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> buildYourOwnOptions());
        extraCheeseCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> buildYourOwnOptions());
    }

    private void buildYourOwnOptions(){
        BuildYourOwn buildYourOwn = (BuildYourOwn)pizza;
        if (smallSizeRadioButton.isChecked()) {
            pizza.setSize(Size.SMALL);
        }
        else if (mediumSizeRadioButton.isChecked()) {
            pizza.setSize(Size.MEDIUM);
        }
        else if (largeSizeRadioButton.isChecked()) {
            pizza.setSize(Size.LARGE);
        }
        if (tomatoRadioButton.isChecked()) {
            buildYourOwn.buildSauce(Sauce.TOMATO);
        }
        else if (alfredoRadioButton.isChecked()) {
            buildYourOwn.buildSauce(Sauce.ALFREDO);
        }

        pizza.setExtraSauce(extraSauceCheckBox.isChecked());
        pizza.setExtraCheese(extraCheeseCheckBox.isChecked());
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        priceTextView.setText("Price: " + String.format("%.2f", pizza.price()));
    }

    private void showToast(String message) {
        // Create a Toast object
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);

        // Display the Toast
        toast.show();
    }


}