package com.example.wechatui.acticity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.wechatui.DisFragment;
import com.example.wechatui.MainActivity;
import com.example.wechatui.R;
import com.example.wechatui.pengyouquan.ExpandFoldTextAdapter;
import com.example.wechatui.pengyouquan.ExpandFoldTextBean;

import java.util.ArrayList;
import java.util.List;

public class PengyouquanActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    List<ExpandFoldTextBean> mList = new ArrayList<>();
    private ImageView pengyouquan_back,paizhao2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengyouquan);
        initData();
        ExpandFoldTextAdapter adapter = new ExpandFoldTextAdapter(mList, this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(adapter);
        pengyouquan_back=(ImageView)findViewById(R.id.pengyouquan_back);
        pengyouquan_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(PengyouquanActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });
        paizhao2=(ImageView)findViewById(R.id.paizhao2);
        paizhao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PengyouquanActivity.this,PaizhaoActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 初始化数据
     */
    private void initData() {
        String longContent = "程序猿是一种近几十年来出现的新物种，是信息革命的产物，在行为和物种归类上我们也可称为码字猴。程序猿是人类在科技研究上的一种新兴进化，拥有无与伦比的耐力、超越时代的智商、横穿社会的苦逼相和低于人类平均寿命的显著特点。\n" +
                "另，可以理解为”程序员“的无奈的自我称呼.节日平年的9月13日和闰年的9月12日（每年的第256天）是程序员节。之所以选择256，是因为8个位元可以有256种不同的排列合，256是2的幂中小于365的最大值。同样的逻辑，在24位RGB颜色空间里，最大值为十六进制0xFFFFFF，表示为白色，又称白色程序猿节。\n";
        String shortContent = "少年投身IT行，老来无伴又何妨。擦肩美女不屑看，三千码友在身旁。";
        for (int i = 0; i < 20; i++) {
            ExpandFoldTextBean bean = new ExpandFoldTextBean();
            if (i % 2 == 0) {
                bean.setContent(shortContent);
                bean.setId(i);
            } else {
                bean.setContent(longContent);
                bean.setId(i);
            }
            mList.add(bean);
        }
    }
}