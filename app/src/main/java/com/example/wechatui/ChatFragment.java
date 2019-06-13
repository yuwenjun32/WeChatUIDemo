package com.example.wechatui;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.wechatui.acticity.SaoyisaoActivity;
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
    private ImageView popobutton;
    private LinearLayout chat,friend,saoyisao,shoufukuan;

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
        map1.put("logo", R.drawable.touxiang1);
        map1.put("title", "马云");
        map1.put("content", "我不喜欢钱！");
        mylistList.add(map1);

        Map<String, Object> map2=new HashMap<String,Object>();
        map2.put("logo", R.drawable.touxiang2);
        map2.put("title", "王健林");
        map2.put("content", "要不先定个小目标？");
        mylistList.add(map2);

        Map<String, Object> map3=new HashMap<String,Object>();
        map3.put("logo", R.drawable.touxiang3);
        map3.put("title", "马化腾");
        map3.put("content", "够钟充钱了！");
        mylistList.add(map3);

        Map<String, Object> map4=new HashMap<String,Object>();
        map4.put("logo", R.drawable.touxiang4);
        map4.put("title", "游乐王子");
        map4.put("content", "雨女无瓜！");
        mylistList.add(map4);

        Map<String, Object> map5=new HashMap<String,Object>();
        map5.put("logo", R.drawable.touxiang5);
        map5.put("title", "蔡徐坤");
        map5.put("content", "下课打篮球？");
        mylistList.add(map5);

        Map<String, Object> map6=new HashMap<String,Object>();
        map6.put("logo", R.drawable.touxiang6);
        map6.put("title", "超级毒奶：黄旭东");
        map6.put("content", "你们实训拉闸零分了！");
        mylistList.add(map6);

        Map<String, Object> map7=new HashMap<String,Object>();
        map7.put("logo", R.drawable.touxiang7);
        map7.put("title", "卢本伟");
        map7.put("content", "你17张牌能秒我？");
        mylistList.add(map7);

        Map<String, Object> map8=new HashMap<String,Object>();
        map8.put("logo", R.drawable.touxiang);
        map8.put("title", "公主");
        map8.put("content", "你是哪位骑士？");
        mylistList.add(map8);


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
                }else if(arg2==1){
                    showDialog4();
                }else if (arg2==2){
                    showDialog4();
                }else if (arg2==3){
                    showDialog4();
                }
                else if (arg2==4){
                    showDialog4();
                }
                else if (arg2==5){
                    showDialog4();
                }
                else if (arg2==6){
                    showDialog4();
                }
                else if (arg2==7){
                    showDialog4();
                }
            }
        });

        popobutton=(ImageView)v.findViewById(R.id.popobutton);
        popobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View myview= LayoutInflater.from(getActivity()).inflate(R.layout.popowindow,null);
                final PopupWindow mypopwindow=new PopupWindow(myview, 500,ViewGroup.LayoutParams.WRAP_CONTENT,true);
                mypopwindow.setTouchable(true);
                mypopwindow.setOutsideTouchable(true);
                mypopwindow.showAsDropDown(v);
                chat=(LinearLayout)myview.findViewById(R.id.ll_chat);
                friend=(LinearLayout)myview.findViewById(R.id.ll_friend);
                saoyisao=(LinearLayout)myview.findViewById(R.id.ll_saoyisao);
                shoufukuan=(LinearLayout)myview.findViewById(R.id.ll_shoufukuan);
                chat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getActivity(),"点击了发起群聊",Toast.LENGTH_LONG).show();
                        mypopwindow.dismiss();
                        showDialog1();
                    }
                });
                friend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getActivity(),"点击了添加好友",Toast.LENGTH_LONG).show();
                        mypopwindow.dismiss();
                        showDialog2();
                    }
                });
                saoyisao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent3=new Intent(getActivity(),SaoyisaoActivity.class);
                        startActivity(intent3);
                    }
                });
                shoufukuan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mypopwindow.dismiss();
                        showDialog3();
                    }
                });
            }
        });
        return v;
    }

    private void showDialog4() {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.touxiang);
        builder.setTitle("温馨提示");
        builder.setMessage("对方已将你移除好友，你还不是对方好友！");
        builder.setPositiveButton("我知道了",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void showDialog3() {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.touxiang);
        builder.setTitle("温馨提示");
        builder.setMessage("您的当前余额为：￥0");
        builder.setPositiveButton("我知道了",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void showDialog2() {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.touxiang);
        builder.setTitle("温馨提示");
        builder.setMessage("对方拒绝与你成为好友！");
        builder.setPositiveButton("我知道了",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void showDialog1() {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.touxiang);
        builder.setTitle("温馨提示");
        builder.setMessage("对方拒绝与你发起群聊！");
        builder.setPositiveButton("我知道了",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
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
