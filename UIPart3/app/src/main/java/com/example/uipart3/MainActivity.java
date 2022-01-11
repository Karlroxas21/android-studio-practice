package com.example.uipart3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkboxSwan, checkboxCrane, checkboxSun;
    RadioGroup rgMarital;

    ProgressBar pbExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkboxCrane = findViewById(R.id.checkboxCrane);
        checkboxSwan = findViewById(R.id.checkboxSwan);
        checkboxSun = findViewById(R.id.checkboxSun);

        rgMarital = findViewById(R.id.rgMarital);

        pbExample =  findViewById(R.id.pbExample);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i <100; i++){
                    pbExample.incrementProgressBy(1);
                    SystemClock.sleep(1000);
                }
            }
        });

        thread.start();

        rgMarital.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbMarried:
                        Toast.makeText(MainActivity.this, "You are married", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbSingle:
                        Toast.makeText(MainActivity.this, "You are Single", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbNeutral:
                        Toast.makeText(MainActivity.this, "You are Neutral", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;


                }
            }
        });

        checkboxSwan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "You checked swan", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "You didn't checked swan", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}