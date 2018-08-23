package com.github.liangyunfeng.mvp;

import java.util.List;

public interface IBuyBookModel {
    /**
     * 获取模拟数据
     */
    void getTestData(ValueCallBack<List<OrderItemBean>> callBack);


    /**
     * 返回本地adapter数据
     * @return
     */
    List<OrderItemBean> getAdapterData();
}
