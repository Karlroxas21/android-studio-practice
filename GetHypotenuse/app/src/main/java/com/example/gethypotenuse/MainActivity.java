package com.example.gethypotenuse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText baseInput, perpendicularInput;
    TextView resultHere;
    Button enterButton;
    double ans;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseInput = findViewById(R.id.baseInput);
        perpendicularInput = findViewById(R.id.perpendicularInput);
        resultHere = findViewById(R.id.resultHere);
        enterButton = findViewById(R.id.enterButton);

        enterButton.setOnClickListener(this);
        baseInput.setOnClickListener(this);
        perpendicularInput.setOnClickListener(this);
        resultHere.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.enterButton:
                int base = Integer.parseInt(baseInput.getText().toString());
                int perpendicular = Integer.parseInt(perpendicularInput.getText().toString());

                double temp = Math.pow(base, 2) + Math.pow(perpendicular, 2);
                ans = Math.sqrt(temp);  
                String string = String.valueOf(ans);
                resultHere.setText(string);
                break;
            default:
                break;
        }
    }
}