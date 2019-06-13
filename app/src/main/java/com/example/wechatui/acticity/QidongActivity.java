package com.example.wechatui.acticity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.wechatui.MainActivity;
import com.example.wechatui.R;

public class QidongActivity extends AppCompatActivity {
    private LinearLayout wenzi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qidong);
        wenzi=(LinearLayout)findViewById(R.id.wenzi);
        Animation mAnnotation=AnimationUtils.loadAnimation(this,R.anim.qidong_donghua);
        ((Animation) mAnnotation).setFillAfter(true);
        wenzi.startAnimation(mAnnotation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(QidongActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },6700);
    }
}