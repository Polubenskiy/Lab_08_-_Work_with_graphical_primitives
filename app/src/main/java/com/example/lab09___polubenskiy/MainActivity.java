package com.example.lab09___polubenskiy;

import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.File;
import java.util.ArrayList;

import math.interp;

public class MainActivity extends AppCompatActivity {

    // Polubenskiy Lab_09 - Plotting
    Intent intent;

    int selectedFunction = 1;

    EditText editTextPoints, editTextXmax, editTextXmin;
    Spinner function_list;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPoints = findViewById(R.id.editTextCountPoint);
        editTextXmin = findViewById(R.id.editTextXmin);
        editTextXmax = findViewById(R.id.editTextXmax);
        function_list = findViewById(R.id.spinner);
        intent = getIntent();

        function_list.setSelection(0);
    }

    public void onOpenActivity(View v)
    {
        int point = Integer.parseInt(editTextPoints.getText().toString()); // get text from MainActivity
        int xMin = Integer.parseInt(editTextXmin.getText().toString()); // get text from MainActivity
        int xMax = Integer.parseInt(editTextXmax.getText().toString()); // get text from MainActivity
        int selectedFunction = function_list.getSelectedItemPosition() + 1;

        intent = new Intent(this, ReflectionGraphics.class);

        intent.putExtra("transmittedPoint", point);
        intent.putExtra("transmittedXmin", xMin);
        intent.putExtra("transmittedXmax", xMax);
        intent.putExtra("transmittedFunction", selectedFunction);

        startActivity(intent);
        //startActivityForResult(intent, 999); // transmitting data to ReflectionGraphics and wait code
    }
}