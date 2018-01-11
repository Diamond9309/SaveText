package savetxt.hxzdsb.bh.savetxt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/13.
 */

public class listadapter extends BaseAdapter {
    private  MainActivity activity;
    private  ArrayList<txtbean> list;
    private txtbean txtbean;
    public listadapter(MainActivity activity, ArrayList list) {
        this.activity=activity;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=View.inflate(activity,R.layout.list_item,null);
            viewHolder.tv_item= (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(viewHolder);

        }else {
            viewHolder= (ViewHolder) convertView.getTag();

        }
        viewHolder.tv_item.setText(txtbean.getBarcode());

        return convertView;
    }



    class ViewHolder {
        public TextView tv_item;

    }

}
