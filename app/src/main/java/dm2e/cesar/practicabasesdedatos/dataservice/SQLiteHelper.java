package dm2e.cesar.practicabasesdedatos.dataservice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class SQLiteHelper extends SQLiteOpenHelper {

    String sqlCreateUserTable = "CREATE TABLE Usuario (usuarioId INTEGER PRIMARY KEY, nombre TEXT, apellido TEXT, nombreUsuario TEXT ,email TEXT, " +
            "codigoIsoPais TEXT)";
    String sqlCreateCodeIsoPaisTable = "CREATE TABLE CodeIsoPais (codigoIsoPais TEXT PRIMARY KEY, paisId NUMERIC)";
    String sqlCreatePaisTable = "CREATE TABLE Pais (paisId INTEGER PRIMARY KEY, nombre TEXT)";
    String sqlCreateCiudadTable = "CREATE TABLE Ciudad (ciudadId NUMERIC PRIMARY KEY, nombre TEXT, paisId NUMERIC)";


    public SQLiteHelper(Context context, int version) {
        super(context, "BaseDeDatosMoviles", null, version);
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

    public long insertarUsuario(String nombre, String apellido, String nombreUsuario, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("apellido", apellido);
        values.put("nombreUsuario", nombreUsuario);
        values.put("email", email);
        return db.insert("Usuario", null, values);
    }

    public int actualizarUsuario(int usuarioId, String nombre, String apellido, String nombreUsuario, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("apellido", apellido);
        values.put("nombreUsuario", nombreUsuario);
        values.put("email", email);
        return db.update("Usuario", values, "usuarioId=?", new String[]{String.valueOf(usuarioId)});
    }

    public int borrarUsuario(int usuarioId) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Usuario", "usuarioId=?", new String[]{String.valueOf(usuarioId)});
    }

    public Cursor listarTodosUsuarios() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query("Usuario", null, null, null, null, null, null);
    }

    public long insertarCodeIsoPais(String codigoIsoPais, int paisId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("codigoIsoPais", codigoIsoPais);
        values.put("paisId", paisId);
        return db.insert("CodeIsoPais", null, values);
    }

    public int actualizarCodeIsoPais(String codigoIsoPais, int nuevoPaisId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("paisId", nuevoPaisId);
        return db.update("CodeIsoPais", values, "codigoIsoPais=?", new String[]{codigoIsoPais});
    }

    public int borrarCodeIsoPais(String codigoIsoPais) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("CodeIsoPais", "codigoIsoPais=?", new String[]{codigoIsoPais});
    }

    public Cursor obtenerTodosLosCodeIsoPais() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query("CodeIsoPais", null, null, null, null, null, null);
    }

    // Métodos para la tabla Pais
    public long insertarPais(int paisId, String nombre) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("paisId", paisId);
        values.put("nombre", nombre);
        return db.insert("Pais", null, values);
    }

    public int actualizarPais(int paisId, String nuevoNombre) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nuevoNombre);
        return db.update("Pais", values, "paisId=?", new String[]{String.valueOf(paisId)});
    }

    public int borrarPais(int paisId) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Pais", "paisId=?", new String[]{String.valueOf(paisId)});
    }

    public Cursor obtenerTodosLosPaises() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query("Pais", null, null, null, null, null, null);
    }

    // Métodos para la tabla Ciudad
    public long insertarCiudad(int ciudadId, String nombre, int paisId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ciudadId", ciudadId);
        values.put("nombre", nombre);
        values.put("paisId", paisId);
        return db.insert("Ciudad", null, values);
    }

    public int actualizarCiudad(int ciudadId, String nuevoNombre, int nuevoPaisId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nuevoNombre);
        values.put("paisId", nuevoPaisId);
        return db.update("Ciudad", values, "ciudadId=?", new String[]{String.valueOf(ciudadId)});
    }

    public int borrarCiudad(int ciudadId) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Ciudad", "ciudadId=?", new String[]{String.valueOf(ciudadId)});
    }

    public Cursor obtenerTodasLasCiudades() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query("Ciudad", null, null, null, null, null, null);
    }
}
