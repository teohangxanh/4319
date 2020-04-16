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
    final Random myRandom = new Random();

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
        switch (v.getId()){
            case R.id.easyBtn:
                // Generate a random number range [1, 10]
                textView.setText(String.valueOf(myRandom.nextInt(11 - 1) + 1));
                break;

            case R.id.mediumBtn:
                // Generate a random number range [11, 50]
                textView.setText(String.valueOf(myRandom.nextInt(51 - 11) + 11));
                break;

            case R.id.difficultBtn:
                // Generate a random number range [51, 100]
                textView.setText(String.valueOf(myRandom.nextInt(101 - 51) + 51));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}
