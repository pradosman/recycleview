package net.sgoliver.android.recyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recView;
    private Button btnInsertar;
    private Button btnEliminar;
    private Button btnMover;
    private TextView LblEtiqueta;

    private ArrayList<Titular> datos;
    private FloatingActionButton actionButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datos = new ArrayList<Titular>();
        datos.add(new Titular("Alex ", "Buenavida ", "2DAM ", R.mipmap.berni));
        datos.add(new Titular("Jaime ", "Fajardo ", "2DAM ", R.mipmap.jauma));
        datos.add(new Titular("Alberto ", "Plained ", "2DAM ", R.mipmap.alberto));
        datos.add(new Titular("David ", "Pradosman ", "2DAM ", R.mipmap.yo));

        for (int i = 0; i < 20; i++)
            datos.add(new Titular("Nombre ", "Apellidos ", "Curso ", R.mipmap.ic_launcher));

        recView = (RecyclerView) findViewById(R.id.RecView);
        recView.setHasFixedSize(true);

        final AdaptadorTitulares adaptador = new AdaptadorTitulares(datos);


        /*
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String opcionSeleccionada =
                        datos.get(recView.getChildPosition(v)).getTitulo();

                LblEtiqueta.setText("Opción seleccionada: " + opcionSeleccionada);
            }
        });
    */
        recView.setAdapter(adaptador);

        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //recView.setLayoutManager(new GridLayoutManager(this,3));

        recView.setItemAnimator(new DefaultItemAnimator());
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
