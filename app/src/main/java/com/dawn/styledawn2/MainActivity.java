package com.dawn.styledawn2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void jumpToDrawable(View view){
        startActivity(new Intent(this, DrawableActivity.class));
    }
    public void jumpToDrawable2(View view){
        startActivity(new Intent(this, Drawable2Activity.class));
    }
    public void jumpToViewAnimation(View view){
        startActivity(new Intent(this, ViewAnimationActivity.class));
    }
    public void jumpToValueAnimator(View view){
        startActivity(new Intent(this, ValueAnimatorActivity.class));
    }
    public void jumpToObjectAnimator(View view){
        startActivity(new Intent(this, ObjectAnimatorActivity.class));
    }
    public void jumpToSetAnimator(View view){
        startActivity(new Intent(this, SetAnimatorActivity.class));
    }
    public void jumpToStyle(View view){
        startActivity(new Intent(this, StyleActivity.class));
    }
}
