package com.example.wechatui.acticity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wechatui.ChatFragment;
import com.example.wechatui.ChatMessage;
import com.example.wechatui.MainActivity;
import com.example.wechatui.R;

import java.util.ArrayList;
import java.util.List;

public class mayunActivity extends AppCompatActivity {
    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private List<ChatMessage> messagesList;
    private mayunActivity.ChatListAdapter chatListAdapter;
    private ImageView back,paizhao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mayun);
        msgListView=(ListView)findViewById(R.id.lv_content_panding);
        inputText=(EditText)findViewById(R.id.et_content_panding);
        send=(Button)findViewById(R.id.bt_send_panding);
        messagesList=new ArrayList<ChatMessage>();
        messagesList.add(new ChatMessage("皮卡皮卡",ChatMessage.TYPE_RECEIVED));
        messagesList.add(new ChatMessage("皮卡丘",ChatMessage.TYPE_SEND));
        messagesList.add(new ChatMessage("皮卡皮卡皮卡",ChatMessage.TYPE_RECEIVED));
        messagesList.add(new ChatMessage("说人话可以吗？",ChatMessage.TYPE_SEND));
        messagesList=new ArrayList<ChatMessage>();
        chatListAdapter=new ChatListAdapter();
        msgListView.setAdapter(chatListAdapter);
        paizhao=(ImageView)findViewById(R.id.paizhao);
        paizhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(mayunActivity.this,PaizhaoActivity.class);
                startActivity(intent1);
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                String content=inputText.getText().toString().trim();
                if (!content.isEmpty()){
                    ChatMessage msg=new ChatMessage(content,ChatMessage.TYPE_SEND);
                    messagesList.add(msg);
                    chatListAdapter.notifyDataSetChanged();
                }
                Intent intent=new Intent(mayunActivity.this,ChatFragment.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(mayunActivity.this,0,intent,0);
                NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT>=26){
                    NotificationChannel channel=new NotificationChannel("channel_1","notificetion",NotificationManager.IMPORTANCE_LOW);
                    notificationManager.createNotificationChannel(channel);
                    Notification.Builder notifyBuilder=new Notification.Builder(mayunActivity.this,"channel_1");
                    notifyBuilder.setContentTitle("微信信息")
                            .setContentText("你有一条微信信息")
                            .setTicker("你有微信信息")
                            .setSmallIcon(R.drawable.touxiang)
                            .setWhen(System.currentTimeMillis());
                    notifyBuilder.setContentIntent(pendingIntent);
                    notificationManager.notify(0,notifyBuilder.build());
                }else {
                    Notification.Builder notifyBuilder=new Notification.Builder(mayunActivity.this);
                    notifyBuilder.setContentTitle("微信信息")
                            .setContentText("你有一条微信信息")
                            .setTicker("你微信有一条信息")
                            .setSmallIcon(R.drawable.touxiang)
                            .setWhen(System.currentTimeMillis());
                    notifyBuilder.setContentIntent(pendingIntent);
                    notificationManager.notify(1,notifyBuilder.build());
                }
            }
        });
        back=(ImageView)findViewById(R.id.fanhui1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(mayunActivity.this,MainActivity.class);
                startActivity(intent3);
            }
        });

    }
    class ChatListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return messagesList.size();
        }

        @Override
        public Object getItem(int i) {
            return messagesList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ChatMessage msg=messagesList.get(i);
            View myview;
            ViewHolder viewHolder;
            if (view==null){
                myview= LayoutInflater.from(mayunActivity.this).inflate(R.layout.chating_list_item,null);
                viewHolder= new ChatListAdapter.ViewHolder();
                viewHolder.leftLayout=(LinearLayout)myview.findViewById(R.id.left_layout);
                viewHolder.rightLayout=(LinearLayout)myview.findViewById(R.id.right_layout);
                viewHolder.leftMsg=(TextView)myview.findViewById(R.id.left_msg);
                viewHolder.rightMsg=(TextView)myview.findViewById(R.id.right_msg);
                viewHolder.head1=(ImageView)myview.findViewById(R.id.head_left);
                viewHolder.head2=(ImageView)myview.findViewById(R.id.head_right);
                myview.setTag(viewHolder);
            }else {
                myview=view;
                viewHolder=(mayunActivity.ChatListAdapter.ViewHolder)myview.getTag();
            }if (msg.getType()==ChatMessage.TYPE_RECEIVED){
                viewHolder.leftLayout.setVisibility(View.VISIBLE);
                viewHolder.head1.setVisibility(View.VISIBLE);
                viewHolder.leftMsg.setVisibility(View.VISIBLE);

                viewHolder.rightLayout.setVisibility(View.GONE);
                viewHolder.head2.setVisibility(View.GONE);
                viewHolder.leftMsg.setText(msg.getContent());
            }else if (msg.getType()==ChatMessage.TYPE_SEND){
                viewHolder.rightLayout.setVisibility(View.VISIBLE);
                viewHolder.head2.setVisibility(View.VISIBLE);
                viewHolder.rightMsg.setVisibility(View.VISIBLE);

                viewHolder.leftLayout.setVisibility(View.GONE);
                viewHolder.head1.setVisibility(View.GONE);
                viewHolder.rightMsg.setText(msg.getContent());
            }
            return myview;
        }
        class ViewHolder{
            LinearLayout leftLayout;
            LinearLayout rightLayout;
            TextView leftMsg;
            TextView rightMsg;
            ImageView head1;
            ImageView head2;
        }
    }
}
