package com.example.feb3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText firstNum, secondNum;
    private TextView result;
    private Button addButton, subtractButton, multiplyButton, divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNum = findViewById(R.id.firstNum);
        secondNum = findViewById(R.id.secondNum);
        result = findViewById(R.id.result);
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);

        addButton.setOnClickListener(this);
        subtractButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addButton:
                int first = Integer.parseInt(String.valueOf(firstNum.getText()));
                int second = Integer.parseInt(String.valueOf(secondNum.getText()));

                int sum = first + second;

                result.setText(String.valueOf(sum));
                break;
            case R.id.subtractButton:
                int firstSubs = Integer.parseInt(String.valueOf(firstNum.getText()));
                int secondSubs = Integer.parseInt(String.valueOf(secondNum.getText()));

                int sumSubs = firstSubs - secondSubs;

                result.setText(String.valueOf(sumSubs));
                break;
            case R.id.multiplyButton:
                int firstMults = Integer.parseInt(String.valueOf(firstNum.getText()));
                int secondMults = Integer.parseInt(String.valueOf(secondNum.getText()));

                int sumMults = firstMults * secondMults;

                result.setText(String.valueOf(sumMults));
                break;
            case R.id.divideButton:
                int firstDivs = Integer.parseInt(String.valueOf(firstNum.getText()));
                int secondDivs = Integer.parseInt(String.valueOf(secondNum.getText()));

                int sumDivs = firstDivs / secondDivs;

                result.setText(String.valueOf(sumDivs));
                break;
            default:
                break;
        }

    }
}