package com.dawn.styledawn2;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by 90449 on 2017/7/5.
 */

public class SetAnimatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_animator);
    }
    public void onScaleWidth(View view) {
        // 获取屏幕宽度
        int maxWidth = getWindowManager().getDefaultDisplay().getWidth();
        // 将目标view进行包装
        ViewWrapper wrapper = new ViewWrapper(view, maxWidth);
        // 将xml转化为ObjectAnimator对象
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.set_animator);
        // 设置动画的目标对象为包装后的view
        animatorSet.setTarget(wrapper);
        // 启动动画
        animatorSet.start();
    }
    private static class ViewWrapper {
        private View target;
        private int maxWidth;

        public ViewWrapper(View target, int maxWidth) {
            this.target = target;
            this.maxWidth = maxWidth;
        }

        public int getWidth() {
            return target.getLayoutParams().width;
        }

        public void setWidth(int widthValue) {
            target.getLayoutParams().width = maxWidth * widthValue / 100;
            target.requestLayout();
        }

        public void setMarginTop(int margin) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) target.getLayoutParams();
            layoutParams.setMargins(0, margin, 0, 0);
            target.setLayoutParams(layoutParams);
        }
    }
}
