package com.pollas;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.pollas.listener.tab.PollasTabListener;
import com.pollas.tab.FragmentTabComplementos;
import com.pollas.tab.FragmentTabPelucas;
import com.pollas.tab.FragmentTabPollas;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar abar = getActionBar();
        abar.setNavigationMode(
                ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tabPollas = abar.newTab().setText(R.string.tab_1);
        ActionBar.Tab tabComplementos = abar.newTab().setText(R.string.tab_2);
        ActionBar.Tab tabPelucas = abar.newTab().setText(R.string.tab_3);
        FragmentTabPollas fragnemtTabPollas = new FragmentTabPollas();
        FragmentTabComplementos fragmentTabComplementos = new FragmentTabComplementos();
        FragmentTabPelucas fragmentTabPelucas = new FragmentTabPelucas();
        tabPollas.setTabListener(new PollasTabListener(fragnemtTabPollas));
        tabComplementos.setTabListener(new PollasTabListener(fragmentTabComplementos));
        tabPelucas.setTabListener(new PollasTabListener(fragmentTabPelucas));
        abar.addTab(tabPollas);
        abar.addTab(tabComplementos);
        abar.addTab(tabPelucas);
        final ImageView imagenFondoView = (ImageView) findViewById(R.id.imageViewFondo);
        imagenFondoView.setImageResource(R.drawable.fondocaca_420x728);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_chistes:
                Intent intent = new Intent(this, ChistesActivity.class);
                this.startActivity(intent);
                return true;
            case R.id.action_ilustres:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
}
