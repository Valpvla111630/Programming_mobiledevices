package myapplication_agenda.com.co.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbContactos extends DbHelper {

    Context context;


    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long InsertarContacto(String Nombre, String Telefono, String Email) {

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("Nombre", Nombre);
            values.put("Telefono", Telefono);
            values.put("Email", Email);

            id = db.insert(TABLE_CONTACTOS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }


        return id;

    }

}
