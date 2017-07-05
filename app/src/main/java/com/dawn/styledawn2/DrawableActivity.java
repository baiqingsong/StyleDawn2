package com.dawn.styledawn2;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by 90449 on 2017/7/5.
 */

public class DrawableActivity extends AppCompatActivity {
    boolean isTransitionToggle = true;
    int levelListNum = 25;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
        final ImageView ivTransitionToggle = (ImageView)findViewById(R.id.iv_transition_toggle);
        final TransitionDrawable transitionDrawable = (TransitionDrawable) ivTransitionToggle.getDrawable();
        ivTransitionToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTransitionToggle){
                    transitionDrawable.startTransition(500);
                }else{
                    transitionDrawable.reverseTransition(500);
                }
                isTransitionToggle = !isTransitionToggle;
            }
        });

        final ImageView ivLevelListWifi = (ImageView)findViewById(R.id.iv_level_list_wifi);
        ivLevelListWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelListNum += 25;
                if(levelListNum > 100)
                    levelListNum = 25;
                ivLevelListWifi.getDrawable().setLevel(levelListNum);
            }
        });
    }
}
