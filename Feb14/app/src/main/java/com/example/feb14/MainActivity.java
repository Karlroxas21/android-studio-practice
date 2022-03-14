package com.example.feb14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button clear, num1, num2, num3, num4, num5, num6, num7, num8 ,num9, num0, divide, multiply, minus, plus, point, equals;
    private TextView topOfInputTxt, inputTxt;





    String input = "";
    String ans = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clear = findViewById(R.id.clear);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);
        num0 = findViewById(R.id.num0);
        divide = findViewById(R.id.divide);
        multiply = findViewById(R.id.multiply);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        point = findViewById(R.id.point);
        equals = findViewById(R.id.equals);

        topOfInputTxt = findViewById(R.id.topOfInputTxt);
        inputTxt =findViewById(R.id.inputTxt);


    }
public void ButtonClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch(data){
            case "C":
                input = "";
                ans = "";
                inputTxt.setText(null);
                break;
            case "=":
                Solve();
               ans = input;

                break;
            case "*":
                Solve();
                input += "*";
                break;
            default:
                if(input == null){
                    input = "";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/")){
                    Solve();
                }
                input += data;
                break;
        }
        inputTxt.setText(input);

}
public void Solve() {
    if (input.split("\\*").length == 2) {
        String number[] = input.split("\\*");
        try {
            double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
            input = mul + "";
        } catch (Exception e) {
            System.out.println(e);
        }
    } else if (input.split("/").length == 2) {
        String number[] = input.split("/");
        try {
            double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
            input = div + "";
        } catch (Exception e) {
            System.out.println(e);
        }
    } else if (input.split("\\+").length == 2) {
        String number[] = input.split("\\+");
        try {
            double add = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
            input = add + "";
        } catch (Exception e) {
            System.out.println(e);
        }
    } else if (input.split("-").length == 2) {
        String number[] = input.split("-");
        try {
            double minus = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
            input = minus + "";
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    String n[] = input.split("\\.");
    if(n.length > 1){
        if(n[1].equals("0")) {
            input = n[0];
        }
    }


//    inputTxt.setText(ans);

}

}