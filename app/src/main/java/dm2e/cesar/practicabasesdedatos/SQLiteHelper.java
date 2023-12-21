package dm2e.cesar.practicabasesdedatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class SQLiteHelper extends SQLiteOpenHelper {

    String sqlCreateUserTable = "CREATE TABLE Usuario (usuarioId NUMERIC, nombre TEXT, apellido TEXT, nombreUsuario TEXT ,email TEXT, " +
            "codigoIsoPais TEXT)";
    String sqlCreateCodeIsoPaisTable = "CREATE TABLE CodeIsoPais (codigoIsoPais TEXT , paisId Numeric)";
    String sqlCreatePaisTable = "CREATE TABLE Pais (paisId NUMERIC, nombre TEXT)";
    String sqlCreateCiudadTable = "CREATE TABLE Ciudad (ciudadId NUMERIC, nombre TEXT, paisId NUMERIC)";

    public SQLiteHelper(Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
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

    public Cursor obtenerTodosLosUsuarios() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query("Usuario", null, null, null, null, null, null);
    }

    public Cursor consultarDatosVariasTablas() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM Usuario", null);
    }
}
