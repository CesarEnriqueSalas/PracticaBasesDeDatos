package dm2e.cesar.practicabasesdedatos.dataservice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    String sqlCreateUserTable = "CREATE TABLE Usuario (usuarioId INTEGER PRIMARY KEY, nombre TEXT, apellido TEXT, usuario TEXT ,email TEXT, " +
            "codigoIsoPais TEXT)";
    String sqlCreateCodeIsoPaisTable = "CREATE TABLE CodeIsoPais (codeID INTEGER PRIMARY KEY, codigoIsoPais TEXT, paisId NUMERIC)";
    String sqlCreatePaisTable = "CREATE TABLE Pais (paisId INTEGER PRIMARY KEY, nombre TEXT)";
    String sqlCreateCiudadTable = "CREATE TABLE Ciudad (ciudadId NUMERIC PRIMARY KEY, nombre TEXT, paisId NUMERIC)";

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreateUserTable);
        sqLiteDatabase.execSQL(sqlCreatePaisTable);
        sqLiteDatabase.execSQL(sqlCreateCodeIsoPaisTable);
        sqLiteDatabase.execSQL(sqlCreateCiudadTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Puedes implementar la lógica de actualización según tus necesidades
    }
}
