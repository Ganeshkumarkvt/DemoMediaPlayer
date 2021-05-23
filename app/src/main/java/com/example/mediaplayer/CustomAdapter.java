package com.example.mediaplayer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static androidx.core.content.res.ResourcesCompat.getColor;

public class CustomAdapter  extends ArrayAdapter<String> {

private String[] sngname;
private Activity context;
    public CustomAdapter(@NonNull Activity context, String[] sngname) {
        super(context, R.layout.model, sngname);
        this.context = context;
        this.sngname = sngname;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.model, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) r.getTag();
        }
        viewHolder.tv.setText(sngname[position]);
        int temp = position+1;
        viewHolder.No.setText(temp+".");

        return r;
    }
    static class ViewHolder{
        TextView tv, No;
        ViewHolder(View v){

            tv = v.findViewById(R.id.songname);
            No = v.findViewById(R.id.serial);
        }
    }
}
