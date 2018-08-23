package com.github.liangyunfeng.mvp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter
{
    private List<OrderItemBean> mListData;
    private Context mContext;

    public MyAdapter(Context context, List<OrderItemBean> listData)
    {
        this.mContext = context;
        this.mListData = listData;
    }

    @Override
    public int getCount()
    {
        return mListData == null ? 0 : mListData.size();
    }

    @Override
    public OrderItemBean getItem(int position)
    {
        return mListData == null ? null : mListData.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup)
    {
        MyViewHolder viewHolder = null;
        if (convertView == null)
        {
            convertView = View.inflate(mContext, R.layout.list_item, null);
            viewHolder = new MyViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (MyViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(getItem(position).getName());
        viewHolder.number.setText("(" + mListData.get(position).getNumber() + "人)");
        viewHolder.time.setText(mListData.get(position).getTime());
        return convertView;
    }

    class MyViewHolder
    {
        TextView name;
        TextView number;
        TextView time;

        public MyViewHolder(View convertView)
        {
            name = (TextView) convertView.findViewById(R.id.name);
            number = (TextView) convertView.findViewById(R.id.number);
            time = (TextView) convertView.findViewById(R.id.time);
        }
    }
}

