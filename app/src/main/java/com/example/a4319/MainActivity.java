package com.example.a4319;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView textView;
    Button easy, medium, hard;
    final Random myRandom = new Random();
    List<Integer> data = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView = (TextView) findViewById(R.id.randomNumber);
        easy = (Button) findViewById(R.id.easyBtn);
        medium = (Button) findViewById(R.id.mediumBtn);
        hard = (Button) findViewById(R.id.difficultBtn);

        easy.setOnClickListener(this);
        medium.setOnClickListener(this);
        hard.setOnClickListener(this);

        final TextView randomNumber = findViewById(R.id.randomNumber);
    }

    @Override
    public void onClick(View v){
        int myNumber;
        switch (v.getId()){
            case R.id.easyBtn:
                // Generate a random number range [1, 10]
                myNumber = myRandom.nextInt(11 - 1) + 1;
                textView.setText(String.valueOf(myNumber));
                break;

            case R.id.mediumBtn:
                // Generate a random number range [11, 50]
                myNumber = myRandom.nextInt(51 - 11) + 11;
                textView.setText(String.valueOf(myNumber));
                break;

            case R.id.difficultBtn:
                // Generate a random number range [51, 100]
                myNumber = myRandom.nextInt(101 - 51) + 51;
                textView.setText(String.valueOf(myNumber));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

        // Store the possible small answers into data (If myNumber = 30, data = {1, 2, 3, 5})
        for (int i = 1; i < Math.sqrt(myNumber) + 1; i++){
            if (myNumber % i == 0){
                data.add(i);
            }
        }
    }

}
