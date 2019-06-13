package com.example.wechatui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.wechatui.acticity.DituActivity;
import com.example.wechatui.utils.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private List<Fragment> fragmentList;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DrawerLayout drawer_layout;
    private ListView list_left_drawer;
    private ArrayList<Item> menuLists;
    private MyAdapter myAdapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=(TabLayout)findViewById(R.id.tablayout1);
        tabLayout.addTab(tabLayout.newTab().setText("微信").setIcon(R.drawable.menu_chat_selector));
        tabLayout.addTab(tabLayout.newTab().setText("通讯录").setIcon(R.drawable.menu_addressbook_selector));
        tabLayout.addTab(tabLayout.newTab().setText("发现").setIcon(R.drawable.menu_discovery_selector));
        tabLayout.addTab(tabLayout.newTab().setText("我").setIcon(R.drawable.menu_me_selector));

        fragmentList=new ArrayList<>();
        fragmentList.add(new ChatFragment());
        fragmentList.add(new AddFragment());
        fragmentList.add(new DisFragment());
        fragmentList.add(new MeFragment());

        MyVPFragmentAdapter myVPFragmentAdapter=new MyVPFragmentAdapter(getSupportFragmentManager());
        viewPager=(ViewPager)findViewById(R.id.vp);
        viewPager.setAdapter(myVPFragmentAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tabLayout.getTabAt(i).select();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for (int i=0;i<tabLayout.getTabCount();i++){
                    if (tab==tabLayout.getTabAt(i))
                        viewPager.setCurrentItem(i);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //侧滑
        drawer_layout=(DrawerLayout)findViewById(R.id.drawer_layout);
        list_left_drawer=(ListView)findViewById(R.id.list_left_drawer);
        menuLists=new ArrayList<Item>();
        menuLists.add(new Item(R.drawable.auj,"这是？"));
        myAdapter=new MyAdapter();
        list_left_drawer.setAdapter(myAdapter);
        list_left_drawer.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ContentFragment contentFragment=new ContentFragment();
        Bundle args=new Bundle();
        /*args.putString("text",menuLists.get(position).getIconName());*/
        contentFragment.setArguments(args);
        android.app.FragmentManager fm=getFragmentManager();
        fm.beginTransaction().replace(R.id.ly_content,contentFragment).commit();
        drawer_layout.closeDrawer(list_left_drawer);
        switch (position){
            case 0:
                Intent intent=new Intent(MainActivity.this,DituActivity.class);
                startActivity(intent);
                break;

        }
    }


    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return menuLists.size();
        }

        @Override
        public Object getItem(int position) {
            return menuLists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View converview, ViewGroup parent) {
            View view=LayoutInflater.from(MainActivity.this).inflate(R.layout.item_list,null);
            ImageView imageView=(ImageView)view.findViewById(R.id.img_icon);
            TextView textView=(TextView)view.findViewById(R.id.txt_content);
            imageView.setImageResource(menuLists.get(position).getIconId());
            textView.setText(menuLists.get(position).getIconName());
            return view;
        }
    }

    class MyVPFragmentAdapter extends FragmentPagerAdapter{
        public MyVPFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
