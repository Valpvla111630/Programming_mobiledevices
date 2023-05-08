package programmingmyapplication.co;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String TAG = "Depuracion";
    EditText datoUno, datoDos;
    TextView datoTres;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"Estoy en OnCreate");
        datoUno = findViewById(R.id.datouno);
        datoDos = findViewById(R.id.datodos);
        datoTres = findViewById(R.id.datotres);
        boton = findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity2(view);
            }
        });
    }

    public void gotoActivity2(View view){
        Intent pasarDatos = new Intent(this,MainActivity2.class);
        pasarDatos.putExtra("datoUno",datoUno.getText().toString());
        pasarDatos.putExtra("datoDos",datoDos.getText().toString());
        pasarDatos.putExtra("datoTres",datoTres.getText().toString());
        startActivity(pasarDatos);
    }
}