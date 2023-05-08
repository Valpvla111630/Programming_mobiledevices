package programmingofmobiledevices.co;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String TAG = "Depuracion";
    EditText LadoUno, LadoDos;
    TextView Resultado;
    Button Calcular, AbrirGoogle, Llamada;
    String phoneNumber = "3102545281";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"Estoy en OnCreate");
        LadoUno = findViewById(R.id.LadoUno);
        LadoDos = findViewById(R.id.LadoDos);
        Resultado = findViewById(R.id.Resultado);
        Calcular = findViewById(R.id.Calcular);
        AbrirGoogle = findViewById(R.id.openGoogle);
        Llamada = findViewById(R.id.llamar);
        Llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamada(view);
            }
        });
        AbrirGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irActivity2(view);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Entre a OnStar");
        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity2(view);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Entre a OnRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Entre a OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Entre a OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Entre a OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Entre a OnDestroy");
    }

    //Crear una funcion,nombre gotoActivity: es publica y no espera nada de respuesta
    //view es el tipo de dato(en este caso, un objeto que es la vista)
    //view es el nombre de ese objeto que recibe la funcion
    public void gotoActivity2(View view){
        float ladoUno = Float.parseFloat(LadoUno.getText().toString());
        float ladoDos = Float.parseFloat(LadoDos.getText().toString());
        float Resultad = ladoUno*ladoDos;
        Resultado.setText(String.valueOf(Resultad));
        Intent pasarResultado = new Intent(this,MainActivity2.class);
        pasarResultado.putExtra("Resultado",String.valueOf(Resultad));
        pasarResultado.putExtra("LadoUno",LadoUno.getText().toString());
        pasarResultado.putExtra("LadoDos",LadoDos.getText().toString());
        startActivity(pasarResultado);
    }

    public void irActivity2(View view){
        Intent irAGoogle = new Intent(Intent.ACTION_VIEW);
        irAGoogle.setData(Uri.parse("https://www.google.com"));
        startActivity(irAGoogle);
    }

    public void llamada(View view){
        Intent llamar = new Intent(Intent.ACTION_DIAL);
        llamar.setData(Uri.parse("tel:" + phoneNumber));
        if(llamar.resolveActivity(getPackageManager())!=null){
            startActivity(llamar);
        }
    }
}