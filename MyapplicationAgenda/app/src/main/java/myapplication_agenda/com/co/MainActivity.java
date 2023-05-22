package myapplication_agenda.com.co;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import myapplication_agenda.com.co.Adaptadores.ListaContactosAdapter;
import myapplication_agenda.com.co.DB.DbContactos;
import myapplication_agenda.com.co.DB.DbHelper;
import myapplication_agenda.com.co.entidades.Contactos;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaContactos;
    ArrayList<Contactos>listaArrayContactos;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaContactos = findViewById(R.id.listaContactos);
        listaContactos.setLayoutManager(new LinearLayoutManager(this));

        DbContactos dbContactos = new DbContactos(MainActivity.this);

        listaArrayContactos = new ArrayList<>();

        ListaContactosAdapter adapter = new ListaContactosAdapter(dbContactos.mostrarContactos());
        listaContactos.setAdapter(adapter);
        
        /*
        botoncrear.setOnClickListener(view -> {
            DbHelper dbHelper = new DbHelper(MainActivity.this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            if (db != null){
                Toast.makeText(MainActivity.this,"BASE DE DATOS CREADA",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MainActivity.this,"ERROR AL CREAR BASE DE DATOS",Toast.LENGTH_LONG).show();
            }
        });*/
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_nuevo:
                nuevoRegistro();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void nuevoRegistro(){
        Intent intent = new Intent(this, NuevoActivity.class);
        startActivity(intent);
    }
}