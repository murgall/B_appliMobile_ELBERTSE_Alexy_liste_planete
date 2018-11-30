package com.example.murga.b_appmob_elbertse_alexy_liste_planete;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AndroidAdapter extends ArrayAdapter<AndroidVersion> {

    private final ArrayList<AndroidVersion> AndroidVersionList;
    private final Context context;
    private final Resources res;
    private final int viewRes;

    public AndroidAdapter(Context context, int textViewResourceId, ArrayList<AndroidVersion> versions){
        super(context,textViewResourceId,versions);
        this.AndroidVersionList=versions;
        this.context=context;
        this.res=context.getResources();
        this.viewRes=textViewResourceId;
    }

    static class ViewHolder {
        TextView title;
        TextView description;
        ImageView imgpla;
    }

    @Override
    public View getView(int position, View ConvertView, ViewGroup parent) {
        View view = ConvertView;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
            holder = new ViewHolder();
            holder.title= (TextView) view.findViewById(R.id.nom_planete);
            holder.description = (TextView) view.findViewById(R.id.distance_planete);
            holder.imgpla = (ImageView) view.findViewById(R.id.img_planet);
            view.setTag(holder);
        } else {
            holder= (ViewHolder) view.getTag();
        }
        final AndroidVersion androidVersion = AndroidVersionList.get(position);
        if (androidVersion != null) {
            final String versionName = String.format("Nom planete : %s", androidVersion.getVersionName());
            holder.title.setText(versionName);
            final String versionNumber = String.format("distance : %s", androidVersion.getVersionNumber());
            holder.description.setText(versionNumber);

            switch (position){
                case 0 :
                    holder.imgpla.setBackgroundResource(R.drawable.jupiter);
                    break;
                case 1 :
                    holder.imgpla.setBackgroundResource(R.drawable.mars);
                    break;
                case 2 :
                    holder.imgpla.setBackgroundResource(R.drawable.mercure);
                    break;
                case 3 :
                    holder.imgpla.setBackgroundResource(R.drawable.neptune);
                    break;
                case 4 :
                    holder.imgpla.setBackgroundResource(R.drawable.saturn);
                    break;
                case 5 :
                    holder.imgpla.setBackgroundResource(R.drawable.uranus);
                    break;
                case 6 :
                    holder.imgpla.setBackgroundResource(R.drawable.venus);
                    break;

            }
        }
        return view;
    }
    //Nombre d’éléments de la liste
    public int getCount() {
        return AndroidVersionList.size();
    }
}

