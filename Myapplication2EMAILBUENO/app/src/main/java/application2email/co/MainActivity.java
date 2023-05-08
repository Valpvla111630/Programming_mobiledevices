package application2email.co;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import application2email.co.Adapter.Usuarioadapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerEmails;
    Usuarioadapter usuarioadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarElementos();
    }

    private void inicializarElementos(){
        recyclerEmails = findViewById(R.id.recycler);
        recyclerEmails.setLayoutManager(new LinearLayoutManager(this));

        List<Emails> emailsList = new ArrayList<>();

        for (int i = 0; i <20 ; i++){
            emailsList.add(new Emails(i, "name","subject","remitente","date","f"+i));
        }
        usuarioadapter = new Usuarioadapter(emailsList,this);
    }

}