package com.example.listview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainAdapter extends BaseAdapter implements Filterable {
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>() ;
    private ArrayList<ListViewItem> filteredItemList = listViewItemList ;

    Filter listFilter ;

    @Override
    public int getCount() {
        return filteredItemList.size() ;
    }
    //position에 위치한 데이터를 화면에 출력하는데 사용될 View 리턴
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        final Context context = parent.getContext();
    //item layout을 inflate 하여 convertview 참조
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
        }
    //화면에 표시될 View로부터 위젯에 대한 참조
        ImageView img = (ImageView) convertView.findViewById(R.id.item_img) ;
        TextView name = (TextView) convertView.findViewById(R.id.item_name) ;
        TextView dia = (TextView) convertView.findViewById(R.id.item_color) ;
        TextView gradia = (TextView) convertView.findViewById(R.id.item_dias) ;
        TextView desc = (TextView) convertView.findViewById(R.id.item_des) ;

        // Data Set(filteredItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItem listViewItem = filteredItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        img.setImageDrawable(listViewItem.getDrawable());
        name.setText(listViewItem.getName());
        dia.setText(listViewItem.getColor());
        gradia.setText(listViewItem.getDias());
        desc.setText(listViewItem.getDesc());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴
    @Override
    public Object getItem(int position) {
        return filteredItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수.
    public void addItem(Drawable icon, String name, String color, String dias, String desc) {
        ListViewItem item = new ListViewItem(icon, name, color,dias, desc);
        listViewItemList.add(item);
    }
//getFilter() overide
    @Override
    public Filter getFilter() {
        if (listFilter == null) {
            listFilter = new ListFilter() ;
        }

        return listFilter ;
    }

    private class ListFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults() ;

            if (constraint == null || constraint.length() == 0) {
                results.values = listViewItemList ;
                results.count = listViewItemList.size() ;
            } else {
                ArrayList<ListViewItem> itemList = new ArrayList<ListViewItem>() ;

                for (ListViewItem item : listViewItemList) {
                    if (item.getName().toUpperCase().contains(constraint.toString().toUpperCase()) ||
                            item.getDesc().toUpperCase().contains(constraint.toString().toUpperCase()) ||
                            item.getColor().toUpperCase().contains(constraint.toString().toUpperCase())||
                            item.getDias().toUpperCase().contains(constraint.toString().toUpperCase()))
                    {
                        itemList.add(item) ;
                    }
                }

                results.values = itemList ;
                results.count = itemList.size() ;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            // filter된 데이터 리스트로 리스트뷰 업데이트
            filteredItemList = (ArrayList<ListViewItem>) results.values ;

            if (results.count > 0) {
                notifyDataSetChanged() ;
            } else {
                notifyDataSetInvalidated() ;
            }
        }
    }
}