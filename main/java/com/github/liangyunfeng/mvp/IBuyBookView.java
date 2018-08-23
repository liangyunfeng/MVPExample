package com.github.liangyunfeng.mvp;

public interface IBuyBookView {
    /**
     * 提示toast
     */
    void showToast(String msg);

    /**
     * 刷新adapter
     */
    void refreshAdapter();

    void onEmpty();
}
