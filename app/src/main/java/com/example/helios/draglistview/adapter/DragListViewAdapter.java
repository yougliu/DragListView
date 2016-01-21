package com.example.helios.draglistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helios.draglistview.R;

/**
 * Created by Bonus Liu on 1/21/16- 3:50 PM
 * email : wumumawl@163.com
 * introduce :DragView 适配器,使用泛型
 */
public class DragListViewAdapter<T> extends ArrayAdapter<T> {

    private final String TAG = DragListViewAdapter.class.getSimpleName();
    private Context mContext;
    private LayoutInflater mInflater;
    private int mResource;

    public DragListViewAdapter(Context context, int resource) {
        super(context, resource);
        this.mResource = resource;
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    /**
     * 此处使用泛型，需要用户根据自己的实际需求进行扩展，
     * layout,bean都需要自己定义
     * 也可以使用viewholder进行优化
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        T bean = getItem(position);
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(mResource,null);
            holder.dragView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //在这里进行数据适配
        holder.textView.setText(bean.toString());

        return convertView;
    }

    public class ViewHolder{
        ImageView dragView;
        TextView textView;
    }
}
