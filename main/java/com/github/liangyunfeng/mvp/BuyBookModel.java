package com.github.liangyunfeng.mvp;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuyBookModel implements IBuyBookModel{
    private List<OrderItemBean> listData;

    public BuyBookModel() {
        listData = new ArrayList<>();
    }

    @Override
    public void getTestData(final ValueCallBack<List<OrderItemBean>> callBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<OrderItemBean> list = new ArrayList<>();
                list.add(new OrderItemBean("赵云", 1, "09-27 09:11"));
                list.add(new OrderItemBean("赵云、隔壁老王、小王、典韦、貂蝉、林芳、曹操、刘备、关羽、黄忠、张飞、诸葛孔明", 10, "09-27 09:11"));
                list.add(new OrderItemBean("黄忠、孙权、大乔", 50, "09-27 09:11"));
                list.add(new OrderItemBean("大乔、小乔、貂蝉、孙尚香", 300, "09-27 09:11"));

                Random rd = new Random();
                int N = rd.nextInt(10);
                if (N > 5) {
                    callBack.onSuccess(list);
                } else {
                    callBack.onFail("拒绝请求");
                }
            }
        }, 1000);
    }

    @Override
    public List<OrderItemBean> getAdapterData() {
        return listData;
    }
}
