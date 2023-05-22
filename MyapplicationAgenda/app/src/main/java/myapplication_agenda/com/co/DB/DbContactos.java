package myapplication_agenda.com.co.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import myapplication_agenda.com.co.entidades.Contactos;

public class DbContactos extends DbHelper {

    Context context;


    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long InsertarContacto(String nombre, String telefono, String email) {

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("email", email);

            id = db.insert(TABLE_CONTACTOS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;

    }

    public ArrayList<Contactos> mostrarContactos(){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Contactos>listaContactos = new ArrayList<>();
        Contactos contacto = null;
        Cursor cursorContactos = null;


        cursorContactos = db.rawQuery("SELECT * FROM "+ TABLE_CONTACTOS, null);

        if (cursorContactos.moveToFirst()){
            do{
                contacto = new Contactos();
                contacto.setId(cursorContactos.getInt(0));
                contacto.setNombre(cursorContactos.getString(1));
                contacto.setTelefono(cursorContactos.getString(2));
                contacto.setEmail(cursorContactos.getString(3));
                listaContactos.add(contacto);
            }while (cursorContactos.moveToNext());
        }

        cursorContactos.close();

        return listaContactos;

    }

}
