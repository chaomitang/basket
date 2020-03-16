package com.chaomitang.app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TransitionDemoActivity extends AppCompatActivity {

    LinearLayout rl1;
    ViewGroup rl2;
    TextView tv1;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_demo);
        rl1 = findViewById(R.id.rl_1);
        rl2 = findViewById(R.id.rl_2);
        tv1 = findViewById(R.id.tv_1);

        ViewGroup fl = findViewById(R.id.fl);
        Handler h = new Handler();
        h.postDelayed(() -> {
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.setDuration(800);
            changeBounds.setInterpolator(new DecelerateInterpolator());
            changeBounds.setResizeClip(true);
            //开启延迟动画，在这里会记录当前视图树的状态
            TransitionManager.beginDelayedTransition(fl, changeBounds);
            //我们直接修改视图树中的View的属性
            tv1.setText("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh hhhhhhhhhhhhhhh hhhhhhhhhhhhhhhhhh hhhhhhhhhhhhhhh hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) rl1.getLayoutParams();
            layoutParams.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
            rl1.setLayoutParams(layoutParams);

        }, 3000);
    }
}
