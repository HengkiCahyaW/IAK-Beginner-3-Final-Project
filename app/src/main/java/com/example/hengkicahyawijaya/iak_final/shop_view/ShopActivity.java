package com.example.hengkicahyawijaya.iak_final.shop_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.hengkicahyawijaya.iak_final.R;
import com.example.hengkicahyawijaya.iak_final.shop_view.detail.Baju1Activity;
import com.example.hengkicahyawijaya.iak_final.shop_view.detail.Baju2Activity;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onClickOrder(View view){
        Intent intent1 = new Intent (this, OrderActivity.class);
        startActivity(intent1);
    }

    public void onClickBaju1(View view){
        Intent intent1 = new Intent (this, Baju1Activity.class);
        startActivity(intent1);
    }

    public void onClickBaju2(View view){
        Intent intent1 = new Intent (this, Baju2Activity.class);
        startActivity(intent1);
    }
}