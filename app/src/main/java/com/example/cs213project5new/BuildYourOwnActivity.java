package com.example.cs213project5new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;

public class BuildYourOwnActivity extends AppCompatActivity {

    private RadioButton smallSizeRadioButton, mediumSizeRadioButton, largeSizeRadioButton,
            tomatoRadioButton, alfredoRadioButton;
    private ImageView buildYourOwnImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_your_own);
    }
}