package com.dawn.styledawn2;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by 90449 on 2017/7/5.
 */

public class Drawable2Activity extends AppCompatActivity {
    boolean isAnimationListWifi = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable2);
        ImageView ivAnimationListWifi = (ImageView) findViewById(R.id.iv_animation_list_wifi);
        final AnimationDrawable animationDrawable = (AnimationDrawable) ivAnimationListWifi.getDrawable();
        ivAnimationListWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isAnimationListWifi){
                    animationDrawable.start();
                }else{
                    animationDrawable.stop();
                }
                isAnimationListWifi = !isAnimationListWifi;
            }
        });
    }
}
