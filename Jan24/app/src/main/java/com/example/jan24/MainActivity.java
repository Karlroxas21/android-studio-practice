package com.example.jan24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button send;

    TextView outputName, outputAge, outputNum, outputEmail, outputCourse, outputCity;

    EditText inputName, inputAge, inputNum, inputEmail, inputCourse, inputCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = findViewById(R.id.send);
        send.setOnClickListener(this);

        outputName = findViewById(R.id.outputName);
        outputAge = findViewById(R.id.outputAge);
        outputNum = findViewById(R.id.outputNum);
        outputEmail = findViewById(R.id.outputEmail);
        outputCourse = findViewById(R.id.outputCourse);
        outputCity = findViewById(R.id.outputCity);

        inputName = findViewById(R.id.inputName);
        inputAge = findViewById(R.id.inputAge);
        inputNum = findViewById(R.id.inputNum);
        inputEmail = findViewById(R.id.inputEmail);
        inputCourse = findViewById(R.id.inputCourse);
        inputCity = findViewById(R.id.inputCity);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send:
                outputName.setText(inputName.getText());
                outputAge.setText(inputAge.getText());
                outputNum.setText(inputNum.getText());
                outputEmail.setText(inputEmail.getText());
                outputCourse.setText(inputCourse.getText());
                outputCity.setText(inputCity.getText());
                break;
            default:
                break;
        }
    }
}