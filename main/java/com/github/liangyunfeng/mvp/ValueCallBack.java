package com.github.liangyunfeng.mvp;

public interface ValueCallBack<T> {
    void onSuccess(T t);

    void onFail(String code);
}
