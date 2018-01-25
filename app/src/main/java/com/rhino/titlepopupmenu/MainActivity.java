package com.rhino.titlepopupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rhino.titlepopupmenu.view.TitlePopupMenu;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TitlePopupMenu titlePopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titlePopup = new TitlePopupMenu(this, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        titlePopup.setItemOnClickListener(new TitlePopupMenu.OnItemOnClickListener() {

            @Override
            public void onItemClick(String desc) {
                showToast(desc);
            }
        });

        titlePopup.addItem(getResources().getDrawable(R.mipmap.ic_launcher),
                "发起群聊");
        titlePopup.addItem(null, "添加朋友");
        titlePopup.addItem(getResources().getDrawable(R.mipmap.ic_launcher),
                "扫一扫");
        titlePopup.addItem(null, "收付款");
        titlePopup.addItem(getResources().getDrawable(R.mipmap.ic_launcher),
                "帮助与反馈");

        findViewById(R.id.bottom_left).setOnClickListener(this);
        findViewById(R.id.bottom_center).setOnClickListener(this);
        findViewById(R.id.bottom_right).setOnClickListener(this);
        findViewById(R.id.top_left).setOnClickListener(this);
        findViewById(R.id.top_center).setOnClickListener(this);
        findViewById(R.id.top_right).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(R.id.bottom_left == id){
            titlePopup.show(v, TitlePopupMenu.STYLE_ALIGN_THIS_BOTTOM_WINDOW_LEFT);
        } else if(R.id.bottom_center == id){
            titlePopup.show(v, TitlePopupMenu.STYLE_ALIGN_THIS_BOTTOM_CENTER);
        } else if(R.id.bottom_right == id){
            titlePopup.show(v, TitlePopupMenu.STYLE_ALIGN_THIS_BOTTOM_WINDOW_RIGHT);
        } else if(R.id.top_left == id){
            titlePopup.show(v, TitlePopupMenu.STYLE_ALIGN_THIS_TOP_WINDOW_LEFT);
        } else if(R.id.top_center == id){
            titlePopup.show(v, TitlePopupMenu.STYLE_ALIGN_THIS_TOP_CENTER);
        } else if(R.id.top_right == id){
            titlePopup.show(v, TitlePopupMenu.STYLE_ALIGN_THIS_TOP_WINDOW_RIGHT);
        }
    }

    private void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }


}
