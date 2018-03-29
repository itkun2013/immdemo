package com.example.shinelon.immdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.shinelon.immdemo.base.BaseActivity;
import com.example.shinelon.immdemo.base.BaseFragment;
import com.example.shinelon.immdemo.fragment.CategoryOneFragment;
import com.example.shinelon.immdemo.fragment.MineOneFragment;
import com.example.shinelon.immdemo.fragment.ServiceOneFragment;
import com.gyf.barlibrary.OnKeyboardListener;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.ll_category)
    LinearLayout ll_category;
    @BindView(R.id.ll_service)
    LinearLayout ll_service;
    @BindView(R.id.ll_mine)
    LinearLayout ll_mine;
    @BindView(R.id.ll)
    LinearLayout ll;
    private ArrayList<Fragment> mFragments;
    private ServiceOneFragment serviceOneFragment;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void initData() {
        mFragments = new ArrayList<>();
        CategoryOneFragment categoryOneFragment = new CategoryOneFragment();
        serviceOneFragment = new ServiceOneFragment();
        MineOneFragment mineOneFragment = new MineOneFragment();
        mFragments.add(categoryOneFragment);
        mFragments.add(serviceOneFragment);
        mFragments.add(mineOneFragment);
    }
    @Override
    protected void initView() {
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(3);
        ll_category.setSelected(true);
    }

    @Override
    protected void setListener() {

        ll_category.setOnClickListener(this);
        ll_service.setOnClickListener(this);
        ll_mine.setOnClickListener(this);
        viewPager.addOnPageChangeListener(this);
        serviceOneFragment.setOnHideListener(new BaseFragment.OnKeyBoradListener() {
            @Override
            public void hide(boolean isPopup) {
                if(isPopup){
                    ll.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.ll_category:
                viewPager.setCurrentItem(1);
                tabSelected(ll_category);
                break;
            case R.id.ll_service:
                viewPager.setCurrentItem(2);
                tabSelected(ll_service);
                break;
            case R.id.ll_mine:
                viewPager.setCurrentItem(3);
                tabSelected(ll_mine);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                tabSelected(ll_category);
                break;
            case 1:
                tabSelected(ll_service);
                break;
            case 2:
                tabSelected(ll_mine);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    private void tabSelected(LinearLayout linearLayout) {
        ll_category.setSelected(false);
        ll_service.setSelected(false);
        ll_mine.setSelected(false);
        linearLayout.setSelected(true);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private class MyAdapter extends FragmentPagerAdapter {
        MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
