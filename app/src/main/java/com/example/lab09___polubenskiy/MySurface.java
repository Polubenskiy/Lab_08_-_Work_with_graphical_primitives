package com.example.lab09___polubenskiy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import math.arr;
import math.interp;

public class MySurface extends SurfaceView
{
    // Polubenskiy 393, lab 09

    Paint p; //a pen

    float xmin; //aabb
    float xmax;
    float ymin;
    float ymax;

    float[] x;  // x, y data points
    float[] y;

    int n;  // number of points

    public void update()
    {
        xmin = arr.min(x, n);
        xmax = arr.max(x, n);
        ymin = arr.min(y, n);
        ymax = arr.max(y, n);
    }

    public MySurface(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false);

        p = new Paint(); // a pen to draw some lines
        p.setColor(Color.RED);  // line color is red

        setWillNotDraw(false); // enable calling onDraw() on getting invalidate() event
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.WHITE);  // clear background with while color

        int w = canvas.getWidth(); // image dimensions
        int h = canvas.getHeight();

        float x0 = 0.0f, y0 = 0.0f; // last point (need 2 point)
        for (int i = 0; i < n; i++)
        {
            // transform xi, yi (in some units) from world space to screen space (in pixels)
            float x1 = interp.map(x[i], xmin, xmax, 0, w-1);
            float y1 = interp.map(y[i], ymin, ymax, h-1, 0);

            if (i > 0)canvas.drawLine(x0, y0, x1, y1, p); // can only draw after 1 iteration

            x0 = x1; // remember last point
            y0 = y1;
        }
        //super.onDraw(canvas);
    }
}
