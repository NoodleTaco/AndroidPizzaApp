package com.example.cs213project5new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

/**
 * The Activity class of the BuildYourOwn Screen
 * @author Donald Yubeaton, Michael Kassie
 */
public class BuildYourOwnActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    static final int MAX_NUMBER_OF_TOPPINGS = 7;

    static final int MIN_NUMBER_OF_TOPPINGS = 3;

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


    /**
     * Initializes global variables and calls initialization methods for the rest of the components
     */
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

    /**
     * Initializes the component variables and assigns their methods
     */
    private void initializeComponents(){
        priceTextView = findViewById(R.id.priceTextView);

        allToppingsListView = findViewById(R.id.allToppingsListView);
        selectedToppingsListView = findViewById(R.id.selectedToppingsListView);

        String[] toppingsList = Topping.getDisplayNames(Topping.values());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, toppingsList);

        allToppingsListView.setAdapter(adapter);

        /**
         * Click Listener to add toppings to the pizza
         */
        allToppingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String clickedTopping = (String) parent.getItemAtPosition(position);
                Topping toppingEnum = Topping.valueOf(clickedTopping.toUpperCase().replace(" ", "_"));
                BuildYourOwn buildYourOwn = (BuildYourOwn)pizza;
                if(!buildYourOwn.buildTopping(toppingEnum)){
                    Toast.makeText(BuildYourOwnActivity.this, "Error: Topping Already on on Pizza", Toast.LENGTH_SHORT).show();
                    return;
                }
                updateSelectedToppingsList();
                updateTotalPrice();
            }
        });

        /**
         * Click Listener to remove toppings from the pizza
         */
        selectedToppingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedTopping = (String) parent.getItemAtPosition(position);
                Topping toppingEnum = Topping.valueOf(clickedTopping.toUpperCase().replace(" ", "_"));
                BuildYourOwn buildYourOwn = (BuildYourOwn)pizza;
                if(!buildYourOwn.removeTopping(toppingEnum)){
                    //showToast("Error: Topping Not On Pizza");
                    Toast.makeText(BuildYourOwnActivity.this, "Error: Topping Not On on Pizza", Toast.LENGTH_SHORT).show();
                    return;
                }
                updateSelectedToppingsList();
                updateTotalPrice();
            }
        });

        addToOrderButton = findViewById(R.id.addToOrderButton);

        /**
         * Click listener that calls the addToOrder method
         */
        addToOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToOrder();
            }
        });

    }

    /**
     * Adds the BuildYourOwn Pizza to the current order
     */
    private void addToOrder() {
        if(pizza.toppings.size() > MAX_NUMBER_OF_TOPPINGS){
            AlertDialogMaker.showAlertDialog(this, "Build Your Own Error", "The Pizza cannot have over 7 toppings.");
            return;
        }

        if(pizza.toppings.size() < MIN_NUMBER_OF_TOPPINGS){
            AlertDialogMaker.showAlertDialog(this, "Build Your Own Error", "The Pizza cannot have less than 3 toppings.");
            return;
        }

        Toast.makeText(this, "Pizza Added to Order", Toast.LENGTH_SHORT).show();
        globalStoreOrder.getStoreOrder().getCurrentOrder().addPizzaToOrder(pizza);
        pizza = PizzaMaker.createPizza("BuildYourOwn");
        buildYourOwnOptions();
        updateSelectedToppingsList();
    }

    /**
     * Updates the toppings displayed in the listView
     */
    private void updateSelectedToppingsList() {
        String[] toppingsList = Topping.getDisplayNames(pizza.getToppings());
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, toppingsList);
        selectedToppingsListView.setAdapter(adapter);
    }

    /**
     * Handles the list view click to add a pizza topping
     * @param parent The AdapterView where the click happened.
     * @param view The view within the AdapterView that was clicked (this
     *            will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String clickedTopping = (String) parent.getItemAtPosition(position);
        Topping toppingEnum = Topping.valueOf(clickedTopping.toUpperCase().replace(" ", "_"));
        BuildYourOwn buildYourOwn = (BuildYourOwn)pizza;
        if(!buildYourOwn.buildTopping(toppingEnum)){
            //showToast("Error: Topping Already on Pizza");
            Toast.makeText(this, "Error: Topping Already on Pizza", Toast.LENGTH_SHORT).show();
            return;
        }
        updateSelectedToppingsList();
        updateTotalPrice();

    }


    /**
     * Initializes the button and check box components and assigns their listeners
     */
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

    /**
     * Updates the pizza based on the currently selected options
     */
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

    /**
     * Updates the price display
     */
    private void updateTotalPrice() {
        priceTextView.setText("Price: " + String.format("%.2f", pizza.price()));
    }



}