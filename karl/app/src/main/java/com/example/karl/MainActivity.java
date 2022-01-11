package com.example.karl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTxtName;
    TextView txtHello;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSayKarl:
                Toast.makeText(this, "Karl yeah!", Toast.LENGTH_SHORT).show();
                txtHello.setText("Lupet mo " + editTxtName.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSay = findViewById(R.id.btnSayKarl);
        btnSay.setOnClickListener(this);

        editTxtName = findViewById(R.id.txtName);
        txtHello = findViewById(R.id.hello);

    }


}