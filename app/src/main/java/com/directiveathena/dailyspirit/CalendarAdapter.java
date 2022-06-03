package com.directiveathena.dailyspirit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

//--------------------------------------------------------------------------------------------------
public class CalendarAdapter extends BaseAdapter {
    private final Context context;
    int[] items;

    CalendarAdapter(Context c, int[] arr) {
        this.context = c;
        items = arr;
    }


    @Override public int getCount()
    {
        return items.length;
    }

    @Override public Object getItem(int i)
    {
        return null;
    }

    @Override public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {

            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.fragment_calendar_item, viewGroup, false);

        }

        ImageView imageview = view.findViewById(R.id.ImageMood);
        imageview.setImageResource(items[i]);

        return view;
    }

}
