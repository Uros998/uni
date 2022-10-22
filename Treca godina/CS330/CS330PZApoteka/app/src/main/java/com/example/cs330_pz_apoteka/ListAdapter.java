package com.example.cs330_pz_apoteka;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.cs330_pz_apoteka.entities.Lek;
import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Lek> lekList;

    public ListAdapter(Context context, int layout, ArrayList<Lek> lekList) {
        this.context = context;
        this.layout = layout;
        this.lekList = lekList;
    }

    @Override
    public int getCount() {
        return lekList.size();
    }

    @Override
    public Object getItem(int i) {
        return lekList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder{
        ImageView image;
        TextView txtIme, txtTip, txtOpis, txtCena;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if (row==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtIme = row.findViewById(R.id.txtIme);
            holder.txtTip= row.findViewById(R.id.txtTip);
            holder.txtOpis = row.findViewById(R.id.txtOpis);
            holder.txtCena = row.findViewById(R.id.txtCena);
            holder.image = row.findViewById(R.id.imgIcon);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder)row.getTag();
        }

        Lek lek= lekList.get(i);

        holder.txtIme.setText(lek.getIme());
        holder.txtTip.setText(lek.getTip());
        holder.txtOpis.setText(lek.getOpis());
        holder.txtCena.setText(String.valueOf(lek.getCena()));

        byte[] movieImg = lek.getImg();
        Bitmap bitmap = BitmapFactory.decodeByteArray(movieImg, 0, movieImg.length);
        holder.image.setImageBitmap(bitmap);

        return row;
    }
}
