package com.example.hengkicahyawijaya.iak_final.anime_view;

import android.support.design.widget.TabLayout;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.hengkicahyawijaya.iak_final.R;
import com.example.hengkicahyawijaya.iak_final.anime_view.Fragment.FragmentOne;
import com.example.hengkicahyawijaya.iak_final.anime_view.Fragment.FragmentTwo;
import com.example.hengkicahyawijaya.iak_final.anime_view.spring_2017.EromangaActivity;
import com.example.hengkicahyawijaya.iak_final.anime_view.spring_2017.SakuraQuestActivity;
import com.example.hengkicahyawijaya.iak_final.anime_view.winter_2017.GabrielActivity;
import com.example.hengkicahyawijaya.iak_final.anime_view.winter_2017.MasamuneActivity;

import java.util.ArrayList;
import java.util.List;

public class AnimeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher_round
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentOne(), "Spring 2017");
        adapter.addFrag(new FragmentTwo(), "Winter 2017");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public void onClickSakuraQuest(View view){
        Intent intent1 = new Intent (this, SakuraQuestActivity.class);
        startActivity(intent1);
    }

    public void onClickMasamune(View view){
        Intent intent1 = new Intent (this, MasamuneActivity.class);
        startActivity(intent1);
    }

    public void onClickEromanga(View view){
        Intent intent1 = new Intent (this, EromangaActivity.class);
        startActivity(intent1);
    }

    public void onClickGabriel(View view){
        Intent intent1 = new Intent (this, GabrielActivity.class);
        startActivity(intent1);
    }
}
