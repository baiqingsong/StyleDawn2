package com.dawn.styledawn2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 90449 on 2017/7/5.
 */

public class ViewAnimationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        final ImageView ivAlphaArrow = (ImageView) findViewById(R.id.iv_alpha_arrow);
        TextView tvAlphaArrow = (TextView) findViewById(R.id.tv_alpha_arrow);
        tvAlphaArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivAlphaArrow.startAnimation(AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.alpha_arrow));
            }
        });

        final ImageView ivScaleArrow = (ImageView) findViewById(R.id.iv_scale_arrow);
        TextView tvScaleArrow = (TextView) findViewById(R.id.tv_scale_arrow);
        tvScaleArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivScaleArrow.startAnimation(AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.scale_arrow));
            }
        });

        final ImageView ivTranslateArrow = (ImageView) findViewById(R.id.iv_translate_arrow);
        TextView tvTranslateArrow = (TextView) findViewById(R.id.tv_translate_arrow);
        tvTranslateArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivTranslateArrow.startAnimation(AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.translate_arrow));
            }
        });

        final ImageView ivRotateArrow = (ImageView) findViewById(R.id.iv_rotate_arrow);
        TextView tvRotateArrow = (TextView) findViewById(R.id.tv_rotate_arrow);
        tvRotateArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivRotateArrow.startAnimation(AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.rotate_arrow));
            }
        });

        final ImageView ivSetArrow = (ImageView) findViewById(R.id.iv_set_arrow);
        TextView tvSetArrow = (TextView) findViewById(R.id.tv_set_arrow);
        tvSetArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivSetArrow.startAnimation(AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.set_arrow));
            }
        });
    }
}
