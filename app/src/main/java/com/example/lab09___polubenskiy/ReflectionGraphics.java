package com.example.lab09___polubenskiy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

import math.interp;

public class ReflectionGraphics extends AppCompatActivity
{
    // Polubenskiy 393 - Lab 08 - Work with Primitive

    MySurface surface;
    int functionNumber = -1;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflection_graphics);

        surface = findViewById(R.id.mySurface);

        intent  = getIntent();


        surface.n = intent.getIntExtra("transmittedPoint", 100); // default => 100
        surface.xmin = (float)intent.getIntExtra("transmittedXin", 0);
        surface.xmax = (float)intent.getIntExtra("transmittedXmax", 10);
        functionNumber = intent.getIntExtra("transmittedFunction", 1);

        BuildGraph();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 999)
        {
            if (data != null)
            {
                surface.n = data.getIntExtra("transmittedPoint", 10); // default => 100
                surface.xmin = (float)data.getIntExtra("transmittedXin", 1);
                surface.xmax = (float)data.getIntExtra("transmittedXmax", 10);
                functionNumber = data.getIntExtra("functionID", 1);
            }
        }
        BuildGraph();
    }

    public void BuildGraph()
    {
        surface.x= new float[surface.n]; //allocate samples
        surface.y = new float[surface.n];

        switch (functionNumber)
        {
            case 1:
                for (int i = 0 ; i < surface.n; i ++) //generate samples
                {
                    //while i ranges from 0 to s.n -1 ==> x ranges from 0 to 4 * pi
                    surface.x[i] = interp.map(i,(float)0,surface.n-1,surface.xmin, surface.xmax);
                    // y ==> cos(x)
                    surface.y[i] = (float) Math.cos(surface.x[i]);
                }
                break;
            case 2:
                for (int i = 0 ; i < surface.n; i ++) //generate samples
                {
                    //while i ranges from 0 to s.n -1 ==> x ranges from 0 to 4 * pi
                    surface.x[i] = interp.map(i,(float)0,surface.n-1,surface.xmin, surface.xmax);
                    // y ==> tan(x)
                    surface.y[i] = (float) Math.tan(surface.x[i]);
                }
                break;
            case 3:
                for (int i = 0 ; i < surface.n; i ++) //generate samples
                {
                    //while i ranges from 0 to s.n -1 ==> x ranges from 0 to 4 * pi
                    surface.x[i] = interp.map(i,(float)0,surface.n-1,surface.xmin, surface.xmax);
                    // y ==> asin(x)
                    surface.y[i] = (float) Math.asin(surface.x[i]);
                }
                break;
            case 4:
                for (int i = 0 ; i < surface.n; i ++) //generate samples
                {
                    //while i ranges from 0 to s.n -1 ==> x ranges from 0 to 4 * pi
                    surface.x[i] = interp.map(i,(float)0,surface.n-1,surface.xmin, surface.xmax);
                    // y ==> acos(x)
                    surface.y[i] = (float) Math.acos(surface.x[i]);
                }
                break;
            case 5:
                for (int i = 0 ; i < surface.n; i ++) //generate samples
                {
                    //while i ranges from 0 to s.n -1 ==> x ranges from 0 to 4 * pi
                    surface.x[i] = interp.map(i,(float)0,surface.n-1,surface.xmin, surface.xmax);
                    // y ==> pow(x)
                    surface.y[i] = (float) Math.pow(surface.x[i],2);
                }
                break;
            case 6:
                for (int i = 0 ; i < surface.n; i ++) //generate samples
                {
                    //while i ranges from 0 to s.n -1 ==> x ranges from 0 to 4 * pi
                    surface.x[i] = interp.map(i,(float)0,surface.n-1,surface.xmin, surface.xmax);
                    // y ==> sqrt(x)
                    surface.y[i] = (float) Math.sqrt(surface.x[i]);
                }
                break;
            default: return;
        }

        surface.update(); //compute min, max values
        surface.invalidate(); //invoke onDraw()
    }

    public void OnGraphCompression(View v) //ReDraw Function With Changed Scale
    {
        surface.xmin /= 2;
        surface.xmax /= 2;
        surface.n /= 2;
        BuildGraph();
    }

    public void OnIncreasingTheGraph(View v) //ReDraw Function With Changed Scale
    {
        surface.xmin *=2;
        surface.xmax *=2;
        surface.n*=2;
        BuildGraph();
    }
}