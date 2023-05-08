package programmingmyapplication.co;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView dato1;
    TextView dato2;
    TextView dato3;
    Button AbrirGoogle, Llamada, wifi, Camara, Contacto;
    String phoneNumber = "3102545281";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dato1 = findViewById(R.id.datouno);
        dato2 = findViewById(R.id.datodos);
        dato3 = findViewById(R.id.datotres);
        AbrirGoogle = findViewById(R.id.openGoogle);
        AbrirGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoGoogle(view);
            }
        });
        Llamada = findViewById(R.id.llamar);
        Llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamada(view);
            }
        });
        wifi = findViewById(R.id.Wifi);
        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openWifiSettings(); }
        });
        Camara = findViewById(R.id.Camara);
        Camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { gotoCamara(); }
        });
        Contacto = findViewById(R.id.Contacto);
        Contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { gotoContactos(); }
        });

        //Obtengo el de lo recibido el dato(un String que se envio)
        String DatoUno = getIntent().getStringExtra("datoUno");
        String DatoDos = getIntent().getStringExtra("datoDos");
        String DatoTres = getIntent().getStringExtra("datoTres");
        publicarDatos(DatoUno, DatoDos, DatoTres);
    }

    public void publicarDatos(String DatoUno, String DatoDos, String DatoTres){
        dato1.setText(DatoUno);
        dato2.setText(DatoDos);
        dato3.setText(DatoTres);
    }

    public void gotoGoogle(View view){
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

    public void openWifiSettings(){
        Intent verConfiguracion = new Intent(Settings.ACTION_WIFI_SETTINGS);
        if(verConfiguracion.resolveActivity(getPackageManager())!=null){
            startActivity(verConfiguracion);
        }
    }

    public void gotoCamara(){
        Intent verCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(verCamara.resolveActivity(getPackageManager())!=null){
            startActivityForResult(verCamara, 1);
        }
    }

    public void gotoContactos(){
        Intent verContactos = new Intent(Intent.ACTION_PICK);
        verContactos.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(verContactos, 1);
    }
}
