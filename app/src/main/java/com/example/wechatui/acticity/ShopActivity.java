package com.example.wechatui.acticity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.wechatui.MainActivity;
import com.example.wechatui.R;
import com.example.wechatui.utils.ViewPagePoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopActivity extends AppCompatActivity {
    private List<ImageView> imgdata;
    private ViewPager viewPager;
    private ViewPagePoint viewPagePoint;
    private TextView tvcar,wenzi;
    private int[] imgs;
    private String[] carname;
    private ListView mylistview;
    private List<Map<String,Object>> mylistList;
    private SimpleAdapter mysimAdapter;
    private ImageView shop_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        shop_back=(ImageView)findViewById(R.id.shop_back);
        shop_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShopActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        imgs=new int[]{R.drawable.huodong1,R.drawable.huodong2,R.drawable.huodong3,R.drawable.huodong4,R.drawable.huodong5};
        carname=new String[]{"搭实惠&“火热家装季","12.12&0元购机","11.11降价到底","校园季","11月光棍购物狂欢"};
        imgdata=new ArrayList<ImageView>();
        for (int i=0;i<imgs.length;i++){
            ImageView img1=new ImageView(ShopActivity.this);
            img1.setImageResource(imgs[i]);
            imgdata.add(img1);
        }
        viewPagePoint=(ViewPagePoint)findViewById(R.id.vp_point);
        viewPagePoint.setPoint(imgs.length);
        viewPagePoint.setPagePoint(1);
        tvcar=(TextView)findViewById(R.id.tv_adname);
        tvcar.setText(carname[1]);
        viewPager=(ViewPager)findViewById(R.id.vp_ad);
        MyPageAdapter myPageAdapter=new MyPageAdapter();
        viewPager.setAdapter(myPageAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                viewPagePoint.setPagePoint(i%imgs.length);
                tvcar.setText(carname[i%imgs.length]);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        //商品展示
        mylistList=new ArrayList<Map<String,Object>>();
        Map<String, Object> map1=new HashMap<String,Object>();
        map1.put("tupian", R.drawable.shangpin1);
        map1.put("name", "喷水式熨斗");
        map1.put("jiage","$200");
        map1.put("tupian1",R.drawable.shangpin5);
        map1.put("name1","酸奶机");
        map1.put("jiage1","$230");
        mylistList.add(map1);

        Map<String, Object> map2=new HashMap<String,Object>();
        map2.put("tupian", R.drawable.shangpin7);
        map2.put("name", "碎肉机");
        map2.put("jiage","$250");
        map2.put("tupian1",R.drawable.shangpin12);
        map2.put("name1","碎肉机");
        map2.put("jiage1","$150");
        mylistList.add(map2);

        Map<String, Object> map3=new HashMap<String,Object>();
        map3.put("tupian", R.drawable.shangpin4);
        map3.put("name", "吸油烟机");
        map3.put("jiage","$1500");
        map3.put("tupian1",R.drawable.shangpin9);
        map3.put("name1","电磁炉");
        map3.put("jiage1","$200");
        mylistList.add(map3);

        Map<String, Object> map4=new HashMap<String,Object>();
        map4.put("tupian", R.drawable.shangpin11);
        map4.put("name", "扫机器人");
        map4.put("jiage","$600");
        map4.put("tupian1",R.drawable.shangpin3);
        map4.put("name1","吸尘器");
        map4.put("jiage1","$500");
        mylistList.add(map4);

        Map<String, Object> map5=new HashMap<String,Object>();
        map5.put("tupian", R.drawable.shangpin2);
        map5.put("name", "空气清新机");
        map5.put("jiage","$300");
        map5.put("tupian1", R.drawable.shangpin10);
        map5.put("name1", "大容量冰箱");
        map5.put("jiage1","$2000");
        mylistList.add(map5);

        Map<String, Object> map6=new HashMap<String,Object>();
        map6.put("tupian", R.drawable.shangpin6);
        map6.put("name", "惠普笔记本");
        map6.put("jiage","$5000");
        map6.put("tupian1", R.drawable.shangpin8);
        map6.put("name1", "吃鸡台式主机");
        map6.put("jiage1","$4500");
        mylistList.add(map6);

        mysimAdapter=new SimpleAdapter(ShopActivity.this, mylistList, R.layout.shangpingzhanshi,new String[]{"tupian","name","jiage","tupian1","name1","jiage1"},
                new int[]{R.id.iv_tupian,R.id.tv_name,R.id.jiage,R.id.iv_tupian1,R.id.tv_name1,R.id.jiage1});
        mylistview=(ListView)findViewById(R.id.lv1);
        mylistview.setAdapter(mysimAdapter);
        registerForContextMenu(mylistview);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub

            }
        });

        //文字移动
        wenzi= (TextView) findViewById(R.id.wenzi);
        Animation mAnnotation=AnimationUtils.loadAnimation(this,R.anim.wenziyidong);
        ((Animation) mAnnotation).setFillAfter(true);
        wenzi.startAnimation(mAnnotation);
    }
    private class MyPageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imgdata.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
            return arg0==arg1;
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public void destroyItem(@NonNull View container, int position, @NonNull Object object) {
            ((ViewPager)container).removeView((View)object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull View container, int position) {
            ((ViewPager)container).addView(imgdata.get(position));
            return imgdata.get(position);
        }
    }
}
