package com.example.jan27;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button pressmeBtn;
    Button pressmeagainBtn;
    Button pressmeBtnY;
    Button pressmeagainBtnY;
    ImageView spiderImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pressmeBtn = findViewById(R.id.pressmeBtn);
        spiderImage = findViewById(R.id.spiderImage);
        pressmeagainBtn = findViewById(R.id.pressmeagainBtn);

        pressmeagainBtnY = findViewById(R.id.pressmeagainBtnY);
        pressmeBtnY = findViewById(R.id.pressmeBtnY);

        pressmeBtn.setOnClickListener(this);
        pressmeagainBtn.setOnClickListener(this);

        pressmeagainBtnY.setOnClickListener(this);
        pressmeBtnY.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pressmeBtn:
                ObjectAnimator animatorX = ObjectAnimator.ofFloat(spiderImage, "x", 550f);
                animatorX.setDuration(1000);
                AnimatorSet animatorSet = new AnimatorSet();

                animatorSet.playTogether(animatorX);
                animatorSet.start();
                break;
            case R.id.pressmeagainBtn:
                ObjectAnimator animatorX2 = ObjectAnimator.ofFloat(spiderImage, "x", 0f);
                animatorX2.setDuration(1000);
                AnimatorSet animatorSetX2 = new AnimatorSet();

                animatorSetX2.playTogether(animatorX2);
                animatorSetX2.start();
                break;
            case R.id.pressmeagainBtnY:
                ObjectAnimator animatorY = ObjectAnimator.ofFloat(spiderImage, "y", 800f);
                animatorY.setDuration(1000);
                AnimatorSet animatorSetY = new AnimatorSet();

                animatorSetY.playTogether(animatorY);
                animatorSetY.start();
                break;
            case R.id.pressmeBtnY:
                ObjectAnimator animatorY2 = ObjectAnimator.ofFloat(spiderImage, "y", 0f);
                animatorY2.setDuration(1000);
                AnimatorSet animatorSetY2 = new AnimatorSet();

                animatorSetY2.playTogether(animatorY2);
                animatorSetY2.start();
                break;
            default:
                break;
        }
    }
}