package com.example.shinelon.immdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.shinelon.immdemo.R;
import com.example.shinelon.immdemo.base.BaseFragment;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;

/**
 * Created by geyifeng on 2017/5/12.
 */

public class MineOneFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImmersionBar.setTitleBar(getActivity(), toolbar);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_one_mine;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(false)
                .navigationBarColor(R.color.btn1)
                .init();
    }
}
