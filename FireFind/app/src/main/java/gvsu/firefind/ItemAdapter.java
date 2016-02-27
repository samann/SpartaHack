package gvsu.firefind;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by droidowl on 2/27/16.
 */

public class ItemAdapter extends ArrayAdapter<FireFindItem> {
    Context context;
    int id;
    List<FireFindItem> items;

    public ItemAdapter(Context context, int resource, List<FireFindItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.id = resource;
        this.items = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ItemHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(id, parent, false);
            holder = new ItemHolder();
            holder.nameText = (TextView)row.findViewById(R.id.textViewName);
            holder.descText = (TextView)row.findViewById(R.id.textViewDesc);

            row.setTag(holder);
        } else {
            holder = (ItemHolder)row.getTag();
        }
        FireFindItem item = items.get(position);
        holder.descText.setText(item.getDesc());
        holder.nameText.setText(item.getName());

        return row;
    }

    static class ItemHolder {
        TextView nameText;
        TextView descText;
    }
}
