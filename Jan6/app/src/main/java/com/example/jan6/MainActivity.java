package com.example.jan6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTxt, editText2, editTxt3;
    Button btnCopy;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCopy = findViewById(R.id.btnCopy);
        btnCopy.setOnClickListener(this);

        txtView = findViewById(R.id.txtView);
        editTxt = findViewById(R.id.editTxt);
        editText2 = findViewById(R.id.editTxt2);
        editTxt3 = findViewById(R.id.editTxt3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCopy:
                txtView.setText("Hi my name is " + editTxt.getText().toString() + ", I am " + editText2.getText().toString() + " years old " + "and I am taking " + editTxt3.getText().toString());
                break;
            default:
                break;
        }
    }
}