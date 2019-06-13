package com.example.wechatui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.wechatui.acticity.mayunActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {
    private ListView mylistview;
    private List<Map<String,Object>> mylistList;
    private SimpleAdapter mysimAdapter;

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  v=inflater.inflate(R.layout.fragment_chat, container, false);
        mylistList=new ArrayList<Map<String,Object>>();
        Map<String, Object> map1=new HashMap<String,Object>();
        map1.put("logo", R.drawable.touxiang);
        map1.put("title", "马云");
        map1.put("content", "我不喜欢钱！");
        mylistList.add(map1);

        Map<String, Object> map2=new HashMap<String,Object>();
        map2.put("logo", R.drawable.touxiang);
        map2.put("title", "王健林");
        map2.put("content", "要不先定个小目标？");
        mylistList.add(map2);

        Map<String, Object> map3=new HashMap<String,Object>();
        map3.put("logo", R.drawable.touxiang);
        map3.put("title", "马化腾");
        map3.put("content", "够钟充钱了！");
        mylistList.add(map3);

        Map<String, Object> map4=new HashMap<String,Object>();
        map4.put("logo", R.drawable.touxiang);
        map4.put("title", "游乐王子");
        map4.put("content", "雨女无瓜！");
        mylistList.add(map4);

        Map<String, Object> map5=new HashMap<String,Object>();
        map5.put("logo", R.drawable.touxiang);
        map5.put("title", "蔡徐坤");
        map5.put("content", "下课打篮球？");
        mylistList.add(map5);

        Map<String, Object> map6=new HashMap<String,Object>();
        map6.put("logo", R.drawable.touxiang);
        map6.put("title", "老师");
        map6.put("content", "好好上课，别看微信了！");
        mylistList.add(map6);


        mysimAdapter=new SimpleAdapter(getActivity(), mylistList, R.layout.chatlist_item,new String[]{"logo","content","title"},
                new int[]{R.id.img_logo,R.id.tv_content,R.id.tv_title});
        mylistview=(ListView)v.findViewById(R.id.lv_chat);
        mylistview.setAdapter(mysimAdapter);
        registerForContextMenu(mylistview);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                if (arg2==0){
                    Intent intent=new Intent(getActivity(),mayunActivity.class);
                    startActivity(intent);
                }
            }
        });
        return v;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v==mylistview){
            int i=((AdapterView.AdapterContextMenuInfo)menuInfo).position;
            menu.setHeaderTitle(mylistList.get(i).get("title").toString()+"信息");
            menu.setHeaderIcon(R.drawable.touxiang);
            menu.add(0,0,0,"详情");
            menu.add(0,1,1,"删除");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        AdapterView.AdapterContextMenuInfo menuInfo=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int i=menuInfo.position;
        switch (item.getItemId()){
            case 0:
                Toast.makeText(getActivity(),"信息："+mylistList.get(i).get("title").toString(), Toast.LENGTH_LONG).show();
                break;
            case 1:
                Toast.makeText(getActivity(),"删除信息："+mylistList.get(i).get("title").toString(),Toast.LENGTH_LONG).show();
                mylistList.remove(mylistList.get(i));
                mysimAdapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
        return true;
    }
}
