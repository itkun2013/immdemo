package com.example.shinelon.immdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.example.shinelon.immdemo.R;
import com.example.shinelon.immdemo.base.BaseFragment;
import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.OnKeyboardListener;

import butterknife.BindView;

/**
 * Created by geyifeng on 2017/5/12.
 */

public class CategoryOneFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_2)
    EditText editText;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImmersionBar.setTitleBar(getActivity(), toolbar);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_one_category;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.statusBarDarkFont(true, 0.2f)
                .navigationBarColor(R.color.btn3)
                .init();
    }

    @Override
    protected void setListener() {
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImmersionBar.setOnKeyboardListener(new OnKeyboardListener() {
                    @Override
                    public void onKeyboardChange(boolean isPopup, int keyboardHeight) {
                        if(isPopup){
                            onHideListener.hide(isPopup);
                        }
                    }
                });
            }
        });
    }


}
