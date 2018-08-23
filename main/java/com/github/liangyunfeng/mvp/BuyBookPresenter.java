package com.github.liangyunfeng.mvp;

import java.util.List;

public class BuyBookPresenter extends BasePresenter implements IBuyBookPresenter {
    private IBuyBookView mView;
    private IBuyBookModel mModel;

    BuyBookPresenter(IBuyBookView iBuyBookView) {
        mView = iBuyBookView;
        mModel = new BuyBookModel();
    }

    @Override
    public List<OrderItemBean> getAdapterData() {
        return mModel.getAdapterData();
    }

    @Override
    void initData() {
        // 在这里弹出loading
        mModel.getTestData(new ValueCallBack<List<OrderItemBean>>() {
            @Override
            public void onSuccess(List<OrderItemBean> orderItemBeans) {
                // 在这里取消loading
                // 简单数据操作可以在presenter里完成
                mModel.getAdapterData().addAll(orderItemBeans);
                mView.refreshAdapter();
            }

            @Override
            public void onFail(String code) {
                //在这里取消loading
                mView.showToast(code);
                mView.onEmpty();
            }
        });
    }
}
