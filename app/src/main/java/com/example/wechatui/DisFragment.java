package com.example.wechatui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.wechatui.acticity.PengyouquanActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisFragment extends Fragment {
    private LinearLayout pengyouquan;

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
        return v;
    }



}
