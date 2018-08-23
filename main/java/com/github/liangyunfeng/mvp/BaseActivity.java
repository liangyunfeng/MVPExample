package com.github.liangyunfeng.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class BaseActivity<T extends BasePresenter> extends Activity {
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initViews();
        mPresenter = initPresenter();
        onPrepare();
    }

    abstract T initPresenter();

    abstract int getLayout();

    abstract void initViews();

    abstract void onPrepare();
}
