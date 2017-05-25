package com.example.hengkicahyawijaya.iak_final;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.hengkicahyawijaya.iak_final.anime_view.AnimeActivity;
import com.example.hengkicahyawijaya.iak_final.event_view.EventActivity;
import com.example.hengkicahyawijaya.iak_final.shop_view.ShopActivity;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
                break;

            case R.id.exit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Anda Yakin mau keluar ?");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog quit = builder.create();
                quit.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStack();
        } else if (!doubleBackToExitPressedOnce){
            this.doubleBackToExitPressedOnce= true;
            Toast.makeText(this, "Please Click BACK again to exit apps", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable(){

                @Override
                public void run(){
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            super.onBackPressed();
            return;
        }
    }

    public void onClickAnime(View view){
        Intent intent1 = new Intent (this, AnimeActivity.class);
        startActivity(intent1);
    }

    public void onClickEvent(View view){
        Intent intent2 = new Intent (this, EventActivity.class);
        startActivity(intent2);
    }

    public void onClickShop(View view){
        Intent intent3 = new Intent (this, ShopActivity.class);
        startActivity(intent3);
    }
}
