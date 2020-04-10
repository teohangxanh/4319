package com.example.a4319;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView textView;
    Button easy, medium, hard;
    Random myRandom;

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
        final Random myRandom = new Random();
        final TextView randomNumber = findViewById(R.id.randomNumber);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.easyBtn:
                // Generate a random number range [10, 99]
                textView.setText(String.valueOf(myRandom.nextInt(99 - 10) + 10 + 1));
                break;

            case R.id.mediumBtn:
                // Generate a random number range [100, 999]
                textView.setText(String.valueOf(myRandom.nextInt(999 - 100) + 100 + 1));
                break;

            case R.id.difficultBtn:
                // Generate a random number range [1000, 9999]
                textView.setText(String.valueOf(myRandom.nextInt(9999 - 1000) + 1000 + 1));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}
