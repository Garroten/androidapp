package com.pollas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pollas.helper.chistes.ChisteListAdaptor;
import com.pollas.helper.chistes.ChisteListItem;

import java.util.ArrayList;

/**
 * Created by rafaelgarrote on 08/06/13.
 */

public class ChistesActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chistes);
        ArrayList<ChisteListItem> chistes = this.getChistes();
        ListView lista =(ListView) findViewById(R.id.ListView_chistes);
        lista.setAdapter(new ChisteListAdaptor(chistes, R.layout.chiste_list_element, this) {
            @Override
            public void onItem(Object chiste, View view) {
                if(chiste !=null) {
                    TextView textoTituloChiste =(TextView) view.findViewById(R.id.textView_superior);
                    if(textoTituloChiste !=null)
                        textoTituloChiste.setText(((ChisteListItem) chiste).getTitle());
                    TextView textoContenidoChiste = (TextView) view.findViewById(R.id.textView_inferior);
                    if(textoContenidoChiste !=null)
                        textoContenidoChiste.setText(((ChisteListItem) chiste).getText());
                    ImageView imagenChiste =(ImageView) view.findViewById(R.id.imageView_imagen);
                    if(imagenChiste !=null)
                        imagenChiste.setImageResource(((ChisteListItem) chiste).getIdImage());
                }
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente,View view,int posicion,long id) {
                ChisteListItem elegido =(ChisteListItem) pariente.getItemAtPosition(posicion);
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, elegido.getText());
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, elegido.getTitle());
                startActivity(Intent.createChooser(sharingIntent, "Comparte con"));
            }
        });
    }

    private ArrayList<ChisteListItem> getChistes() {
        ArrayList<ChisteListItem> chistes = new ArrayList<ChisteListItem>();
        for(int i = 0; i != 10; i ++){
            ChisteListItem chiste = new ChisteListItem(R.drawable.ico_chistes,"Titulo Chiste", "Hay ampollas. Yes you are!");
            chistes.add(chiste);
        }
        return chistes;
    }

}
