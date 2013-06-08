package com.pollas.helper.chistes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by rafaelgarrote on 08/06/13.
 */
public abstract  class ChisteListAdaptor extends BaseAdapter {
    private ArrayList<?> items;
    private int R_layout_IdView;
    private Context context;

    public ChisteListAdaptor(ArrayList<?> items, int r_layout_IdView, Context context) {
        super();
        this.items = items;
        this.R_layout_IdView = r_layout_IdView;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R_layout_IdView, null);
        }
        onItem(items.get(i), view);
        return view;
    }

    /** Devuelve cada una de las entradas con cada una de las vistas a la que debe de ser asociada
     * @param item El item que será la asociado a la view. El item es del tipo del paquete/handler
     * @param view View particular que contendrá los datos del paquete/handler
     */

    public abstract void onItem (Object item, View view);
}
