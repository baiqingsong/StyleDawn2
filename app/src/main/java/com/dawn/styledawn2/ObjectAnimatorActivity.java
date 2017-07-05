package com.dawn.styledawn2;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by 90449 on 2017/7/5.
 */

public class ObjectAnimatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
    }
    public void onScaleWidth(final View view) {
        // 获取屏幕宽度
        int maxWidth = getWindowManager().getDefaultDisplay().getWidth();
        // 将目标view进行包装
        ViewWrapper wrapper = new ViewWrapper(view, maxWidth);
        // 将xml转化为ObjectAnimator对象
        ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.object_animator);
        // 设置动画的目标对象为包装后的view
        objectAnimator.setTarget(wrapper);
        // 启动动画
        objectAnimator.start();
    }
    private static class ViewWrapper {
        private View target; //目标对象
        private int maxWidth; //最长宽度值

        public ViewWrapper(View target, int maxWidth) {
            this.target = target;
            this.maxWidth = maxWidth;
        }

        public int getWidth() {
            return target.getLayoutParams().width;
        }

        public void setWidth(int widthValue) {
            //widthValue的值从100到20变化
            target.getLayoutParams().width = maxWidth * widthValue / 100;
            target.requestLayout();
        }
    }
}
