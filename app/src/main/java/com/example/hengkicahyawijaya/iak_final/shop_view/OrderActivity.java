package com.example.hengkicahyawijaya.iak_final.shop_view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hengkicahyawijaya.iak_final.R;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    EditText mTextNama;
    TextView mTextHarga, mTextQty;
    Button mButtonOrder, mButtonPlus, mButtonMin;
    // spinner
    Spinner mSpinnerMenu;
    RadioGroup mRadioGroup;
    RadioButton mRadioButton;
    List<String> mListMenu = new ArrayList<>();
    int harga = 0;
    int qty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTextNama = (EditText) findViewById(R.id.mTextNama);
        mTextHarga = (TextView) findViewById(R.id.mTextHarga);
        mButtonOrder = (Button) findViewById(R.id.mButtonOrder);
        mTextQty = (TextView) findViewById(R.id.mTextQty);
        mButtonPlus = (Button) findViewById(R.id.mButtonPlus);
        mButtonMin = (Button) findViewById(R.id.mButtonMin);
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_ukuran);

        mSpinnerMenu = (Spinner) findViewById(R.id.mSpinerMenu);
        mListMenu.add("-------");
        mListMenu.add("Baju Naruto");
        mListMenu.add("Baju One Piece");
        ArrayAdapter<String> dataAdpter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mListMenu);
        dataAdpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerMenu.setAdapter(dataAdpter);
    }

    public void onClickOrder(View view){
        int id = mRadioGroup.getCheckedRadioButtonId();
        mRadioButton = (RadioButton) findViewById(id);
        String to  = "hengki.cahya.w@gmail.com";
        String subject = mTextNama.getText().toString();
        String message = "Saya Pesan "
                +mSpinnerMenu.getSelectedItem()
                +" Sebanyak "
                +mTextQty.getText()
                +" pcs ukuran "
                +mRadioButton.getText()
                +", Seharga "
                +mTextHarga.getText();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto"));
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(emailIntent, "Kirim email dengan"));
    }

    public void onClickPlus (View view){
        harga = harga + 120000;
        qty = qty + 1;
        mTextQty.setText(qty+"");
        mTextHarga.setText("Rp. "+harga);
    }

    public void onClickMin(View view){
        if(harga != 0){
            harga = harga - 120000;
            qty = qty - 1;
            mTextQty.setText(qty+"");
            mTextHarga.setText("Rp. "+harga);
        }
        else {
            harga = 0;
            qty = 0;
            mTextQty.setText(qty+"");
            mTextHarga.setText("Rp. "+harga);
        }
    }

    public void onClickReset(View view){
        harga = 0;
        qty = 0;
        mTextNama.setText("");
        mTextQty.setText(qty+"");
        mTextHarga.setText("Rp. "+harga);
        mSpinnerMenu.setSelection(0);
    }
}
