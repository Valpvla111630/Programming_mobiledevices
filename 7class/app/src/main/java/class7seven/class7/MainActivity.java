package class7seven.class7;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etC, etN, etT;

    Button registrar, consultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrar = findViewById(R.id.button);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar(view);
            }
        });
        consultar = findViewById(R.id.button2);
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultar(view);
            }
        });

        etC = (EditText) findViewById(R.id.etC);
        etN = (EditText) findViewById(R.id.etN);
        etT = (EditText) findViewById(R.id.etT);
    }

    public void registrar(View view){
        AdminBD admin = new AdminBD(this, "BD", null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase(); //Abrir la base de datos para que sea de escritura
        String cedula = etC.getText().toString();
        String nombre = etN.getText().toString();
        String telefono = etT.getText().toString();
        if(!cedula.isEmpty() && !nombre.isEmpty() && !telefono.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("cedula", cedula);
            registro.put("nombre", nombre);
            registro.put("telefono", telefono);
            BD.insert("usuario", null, registro);
            BD.close();
            etC.setText("");
            etN.setText("");
            etT.setText("");
            Toast.makeText(this, "Registro Almacenado Exitosamente", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Ingrese correctamente todos los datos", Toast.LENGTH_LONG).show();
        }
    }

    public void consultar (View view){
        AdminBD admin = new AdminBD(this,"BD", null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase();
        String cedula1 = etC.getText().toString();
        if(!cedula1.isEmpty()){
            Cursor fila = BD.rawQuery("select nombre, telefono from usuario where cedula=" + cedula1,null);
            if(fila.moveToFirst()){
                etN.setText(fila.getString(0));
                etT.setText(fila.getString(1));
                BD.close();
            }
            else {
                Toast.makeText(this, "No se encontro el usuario", Toast.LENGTH_LONG).show();
            }
        }
    }
}