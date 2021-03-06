package com.dev.nguyenvantung.fg_app.ui.main;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.dev.nguyenvantung.fg_app.R;
import com.dev.nguyenvantung.fg_app.ui.lcdoan.LCDoanFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    @BindView(R.id.main_drawlayout)
    public DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;
    @BindView(R.id.main_navigation_view)
    public NavigationView mainNavigationView;
    @BindView(R.id.main_img_menu)
    public ImageView img_menu;
    @BindView(R.id.main_framelayout)
    public FrameLayout frameLayout;
    private FragmentManager mFragmentManager;

    private Fragment mActive;
    private Fragment hoatDongFragment = HoatDongFragment.getInstance(),
            lcdoanFragment = LCDoanFragment.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().add(frameLayout.getId(), hoatDongFragment)
                .add(frameLayout.getId(), lcdoanFragment).hide(lcdoanFragment).commit();
        mActive = HoatDongFragment.getInstance();

        initDrawerLayout();
        img_menu.setOnClickListener(this);
    }

    private void initDrawerLayout(){
        mToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        mainNavigationView.setNavigationItemSelectedListener(this);
    }

    private void nextFragment(Fragment fragment){
        mFragmentManager.beginTransaction().hide(mActive).show(fragment).commit();
        mActive = fragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_img_menu:
                drawerLayout.openDrawer(Gravity.START);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.mnu_hoatdong:
                nextFragment(hoatDongFragment);
                break;
            case R.id.mnu_lcdoan:
                nextFragment(lcdoanFragment);
                break;
        }
        drawerLayout.closeDrawer(Gravity.START);
        return false;
    }
}
