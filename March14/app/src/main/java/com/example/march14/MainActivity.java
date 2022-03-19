package com.example.march14;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText enterName, enterContactNum;
    Button insertButton, updateButton, deleteButton, viewButton;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterName = findViewById(R.id.enterName);
        enterContactNum = findViewById(R.id.enterContactNum);
        insertButton = findViewById(R.id.insertButton);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);
        viewButton = findViewById(R.id.viewButton);

        db = new Database(this);

        insertButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        viewButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = enterName.getText().toString();
        String contactNum = enterContactNum.getText().toString();
        switch (v.getId()){
            case(R.id.insertButton):
                Boolean checkInsertData = db.insertUserData(name, contactNum);

                if(checkInsertData){
                    Toast.makeText(MainActivity.this, "Entry Inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }
                break;

            case(R.id.updateButton):
                Boolean checkUpdateData = db.updateUserData(name, contactNum);

                if(!checkUpdateData){
                    Toast.makeText(MainActivity.this, "Enter Not Updated", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                }
                break;

            case(R.id.deleteButton):
                Boolean checkDeleteData = db.deleteUserData(name);

                if(!checkDeleteData){
                    Toast.makeText(MainActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                }
                break;

            case(R.id.viewButton):
                Cursor res = db.getData();

                if(res.getCount() == 0){
                    Toast.makeText(MainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("\n" + "Name: " + res.getString(0) + "\n");
                    buffer.append("Contact: " + res.getString(1) + "\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
                break;

            default:
                break;
        }
    }
}