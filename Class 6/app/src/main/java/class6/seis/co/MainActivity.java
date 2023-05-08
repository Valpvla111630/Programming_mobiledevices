package class6.seis.co;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etusuario;
    Button guardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etusuario = (EditText)findViewById(R.id.etusuario);
        guardar = findViewById(R.id.button);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar(view);
            }
        });


        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        etusuario.setText(preferences.getString("Usuarios", ""));
    }

    public void guardar(View view)
    {
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferencias.edit();
        Obj_editor.putString("Usuarios", etusuario.getText().toString());
        Obj_editor.commit();
        finish();
    }
}