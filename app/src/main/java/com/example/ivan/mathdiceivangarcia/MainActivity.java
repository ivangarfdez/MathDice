package com.example.ivan.mathdiceivangarcia;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ahora creamos todos los datos que tiene que tener la Array de
        // la lista con los items
        String[] items = new String[]{"Perfil","Juego","Instrucciones","Informacion"};

        //El problema que viene ahora es que necesitamos una lista,
        //lo que tenemos que hacer es transformar la Array en una ArrayList
        ArrayList<String> listaItems = new ArrayList<String>(Arrays.asList(items));

        //Ahora, necesitamos un adaptador, para poder pasarle el "contexto"
        // y la lista de items "itemlist"
        //Utilizamos nuestro Adapter customizado
        MenuAdapter adapter = new MenuAdapter(this,listaItems);

        //INTERFAZ o la VISION
        //Ahora creamos el listView
        final ListView lv = (ListView) findViewById(R.id.lv);
        //Pasamos la listView al Adaptador
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
