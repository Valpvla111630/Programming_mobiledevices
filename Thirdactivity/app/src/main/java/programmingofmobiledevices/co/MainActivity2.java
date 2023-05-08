package programmingofmobiledevices.co;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView dato;
    TextView dato2;
    TextView dato3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dato = findViewById(R.id.Resultado);
        dato2 = findViewById(R.id.LadoUno);
        dato3 = findViewById(R.id.LadoDos);

        //Obtener dato recibido
        String Result = getIntent().getStringExtra("Resultado");
        String LadoUno = getIntent().getStringExtra("LadoUno");
        String LadoDos = getIntent().getStringExtra("LadoDos");
        publicarDatos(Result, LadoUno, LadoDos);
    }

    public void publicarDatos(String Result, String LadoUno, String LadoDos){
        dato.setText(Result);
        dato2.setText(LadoUno);
        dato3.setText(LadoDos);
    }
}