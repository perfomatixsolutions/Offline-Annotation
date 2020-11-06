package com.android.offlineannotation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.videoannotation.DrawableView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DrawableView mDrawableView;
    Button mButton;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawableView = findViewById(R.id.draw_view);
        mButton = findViewById(R.id.button);

        imageView1 = (ImageView)findViewById(R.id.img_first_width);
        imageView2 = (ImageView)findViewById(R.id.img_second_width);
        imageView3 = (ImageView)findViewById(R.id.img_third_width);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);

        mDrawableView.setDrawEnable(true);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawableView.clearDrawLocal();

            }
        });

    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.img_first_width:
            mDrawableView.setupPaint(5, Color.BLUE);
            break;
        case R.id.img_second_width:
            mDrawableView.setupPaint(15,Color.RED);
            break;
        case R.id.img_third_width:
            mDrawableView.setupPaint(25,Color.BLACK);
            break;
    }
    }
}