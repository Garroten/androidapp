package com.pollas.tab;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pollas.R;

/**
 * Created by rafaelgarrote on 07/06/13.
 */
public class FragmentTabComplementos extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_complementos, container, false);
    }
}
