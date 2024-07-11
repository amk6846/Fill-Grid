package com.example.paperq2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.gridLayout);

        // Generate random numbers and fill the grid
        fillGridWithRandomNumbers();
    }

    private void fillGridWithRandomNumbers() {
        Random random = new Random();

        // Array to keep track of the last generated numbers for each column
        int[] lastColumnNumbers = new int[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                TextView textView = new TextView(this);
                textView.setText(String.valueOf(random.nextInt(10))); // Generate a random number (0-9)

                // Add some padding to the text for better visualization
                textView.setPadding(20, 20, 20, 20);

                // Set gravity to center the text in the cell
                textView.setGravity(Gravity.CENTER);

                // Set text color to black
                textView.setTextColor(Color.BLACK);

                // Add the TextView to the GridLayout
                GridLayout.Spec rowSpec = GridLayout.spec(i, 1, 1f);
                GridLayout.Spec colSpec = GridLayout.spec(j, 1, 1f);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, colSpec);
                textView.setLayoutParams(params);
                gridLayout.addView(textView);

                // Check if the number is the same as the number in the last column
                if (j > 0 && Integer.parseInt(textView.getText().toString()) == lastColumnNumbers[j - 1]) {
                    textView.setBackgroundColor(Color.YELLOW); // Change background color
                }

                // Store the current number as the last number for the column
                lastColumnNumbers[j] = Integer.parseInt(textView.getText().toString());
            }
        }
    }
}