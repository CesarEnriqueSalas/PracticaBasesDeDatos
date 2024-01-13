package dm2e.cesar.practicabasesdedatos.dataservice;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import dm2e.cesar.practicabasesdedatos.models.Ciudad;
import dm2e.cesar.practicabasesdedatos.models.CodeIsoPais;
import dm2e.cesar.practicabasesdedatos.models.Pais;
import dm2e.cesar.practicabasesdedatos.models.Usuario;

public class SQLiteHelper extends SQLiteOpenHelper {

    String sqlCreateUserTable = "CREATE TABLE Usuario (usuarioId INTEGER PRIMARY KEY, nombre TEXT, apellido TEXT, usuario TEXT ,email TEXT, " +
            "codigoIsoPais TEXT)";
    String sqlCreateCodeIsoPaisTable = "CREATE TABLE CodeIsoPais (codeID INTEGER PRIMARY KEY, codigoIsoPais TEXT, paisId INTEGER)";
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
    }

    public List<Usuario> obtenerDatosUsuario(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USUARIO", null);
        List<Usuario> usuarios = new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                usuarios.add(new Usuario(cursor.getInt(0),cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4), cursor.getString(5)));
            }while (cursor.moveToNext());
        }
        return usuarios;
    }

    public List<Pais> obtenerDatosPais(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM PAIS", null);
        List<Pais> paises = new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                paises.add(new Pais(cursor.getInt(0), cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        return paises;
    }

    public List<Ciudad> obtenerDatosCiudad(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM CIUDAD", null);
        List<Ciudad> ciudades = new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                ciudades.add(new Ciudad(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
            }while (cursor.moveToNext());
        }
        return ciudades;
    }

    public List<CodeIsoPais> obtenerDatosCodeIsoPais(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM CodeIsoPais", null);
        List<CodeIsoPais> codeIsoPaisList = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                codeIsoPaisList.add(new CodeIsoPais(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
            }while (cursor.moveToNext());
        }
        return codeIsoPaisList;
    }

}
