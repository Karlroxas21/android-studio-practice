package com.example.jan31;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView spidey;

    Button upBtn, downBtn, rightBtn, leftBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upBtn = findViewById(R.id.upBtn);
        downBtn = findViewById(R.id.downBtn);
        rightBtn = findViewById(R.id.rightBtn);
        leftBtn = findViewById(R.id.leftBtn);
        spidey = findViewById(R.id.spidey);

        upBtn.setOnClickListener(this);
        downBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);
        leftBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.upBtn:
                ObjectAnimator animatorUp = ObjectAnimator.ofFloat(spidey, "y", -350f);
                animatorUp.setDuration(1000);
                AnimatorSet animatorSetUp = new AnimatorSet();

                animatorSetUp.playTogether(animatorUp);
                animatorSetUp.start();
                break;
            case R.id.downBtn:
                ObjectAnimator animatorDown = ObjectAnimator.ofFloat(spidey, "y", 270f);
                animatorDown.setDuration(1000);
                AnimatorSet animatorSetDown = new AnimatorSet();

                animatorSetDown.playTogether(animatorDown);
                animatorSetDown.start();
                break;
            case R.id.rightBtn:
                ObjectAnimator animatorRight = ObjectAnimator.ofFloat(spidey, "x", 550f);
                animatorRight.setDuration(1000);
                AnimatorSet animatorSetRight = new AnimatorSet();

                animatorSetRight.playTogether(animatorRight);
                animatorSetRight.start();
                break;
            case R.id.leftBtn:
                ObjectAnimator animatorLeft = ObjectAnimator.ofFloat(spidey, "x", -0f);
                animatorLeft.setDuration(1000);
                AnimatorSet animatorSetLeft = new AnimatorSet();

                animatorSetLeft.playTogether(animatorLeft);
                animatorSetLeft.start();
                break;
            default:
                break;
        }
    }
}