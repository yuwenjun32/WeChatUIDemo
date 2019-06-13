package com.example.wechatui;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.wechatui.acticity.PengyouquanActivity;
import com.example.wechatui.acticity.SaoyisaoActivity;
import com.example.wechatui.acticity.ShopActivity;
import com.example.wechatui.acticity.YouxiActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisFragment extends Fragment {
    private LinearLayout pengyouquan,saoyisao,ditu,gouwu,youxi;

    public DisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_dis, container, false);
        pengyouquan=(LinearLayout)v.findViewById(R.id.pengyouquan);
        pengyouquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),PengyouquanActivity.class);
                startActivity(intent);
            }
        });

        saoyisao=(LinearLayout)v.findViewById(R.id.saoyisao);
        saoyisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(),SaoyisaoActivity.class);
                startActivity(intent1);
            }
        });

        ditu=(LinearLayout)v.findViewById(R.id.ditu);
        ditu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        gouwu=(LinearLayout)v.findViewById(R.id.gouwu);
        gouwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getActivity(),ShopActivity.class);
                startActivity(intent2);
            }
        });

        youxi=(LinearLayout)v.findViewById(R.id.youxi);
        youxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(getActivity(),YouxiActivity.class);
                startActivity(intent3);
            }
        });
        return v;
    }

    private void showDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.touxiang);
        builder.setTitle("温馨提示");
        builder.setMessage("未完待续");
        builder.setPositiveButton("我知道了",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }


}
