package com.example.listviewandspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);

        ArrayList<String> names = new ArrayList<>();
        names.add("Elizabeth");
        names.add("Karina");
        names.add("Ella");
        names.add("Beatrice");
        names.add("Don");

        ArrayList<String> universities = new ArrayList<>();
        universities.add("National University");
        universities.add("FEU");
        universities.add("UST");
        universities.add("DLSU");
        universities.add("UE");

        ArrayAdapter<String> namesAdopter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);

        ArrayAdapter<String> universitiesAdopter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, universities);


        listView.setAdapter(namesAdopter);

        spinner.setAdapter(universitiesAdopter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Hi " + names.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        }
    }
