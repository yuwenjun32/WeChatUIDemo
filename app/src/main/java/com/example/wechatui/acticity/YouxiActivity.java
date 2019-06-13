package com.example.wechatui.acticity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.wechatui.MainActivity;
import com.example.wechatui.R;

public class YouxiActivity extends AppCompatActivity {
    private ImageView youxi_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youxi);
        youxi_back=(ImageView)findViewById(R.id.youxi_back);
        youxi_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(YouxiActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
