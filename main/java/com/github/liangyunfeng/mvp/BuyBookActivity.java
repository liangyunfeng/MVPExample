package com.github.liangyunfeng.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class BuyBookActivity extends BaseActivity<BuyBookPresenter> implements IBuyBookView{
    private ListView mListView;
    private MyAdapter mAdapter;

    @Override
    BuyBookPresenter initPresenter() {
        return new BuyBookPresenter(this);
    }

    @Override
    int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    void initViews() {
        mListView = (ListView) findViewById(R.id.listview);
    }

    @Override
    void onPrepare() {
        mAdapter = new MyAdapter(this, mPresenter.getAdapterData());
        mListView.setAdapter(mAdapter);
        mPresenter.initData();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void refreshAdapter() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onEmpty() {
        mListView.setEmptyView(null);
    }
}
