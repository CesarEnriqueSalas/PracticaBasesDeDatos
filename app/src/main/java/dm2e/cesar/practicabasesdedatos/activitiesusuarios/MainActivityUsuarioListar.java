package dm2e.cesar.practicabasesdedatos.activitiesusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.dataservice.SQLiteHelper;

public class MainActivityUsuarioListar extends AppCompatActivity {

    TextView listaUsuario;
    SQLiteHelper sqLiteHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_usuario_listar);

        listaUsuario = findViewById(R.id.listaUsuario);
        sqLiteHelper = new SQLiteHelper(this, 1);

        Cursor cursor = sqLiteHelper.listarTodosUsuarios();

        if (cursor != null && cursor.moveToFirst()) {
            int nombreIndex = cursor.getColumnIndex("nombre");
            int apellidoIndex = cursor.getColumnIndex("apellido");

            if (nombreIndex != -1 && apellidoIndex != -1) {
                StringBuilder stringBuilder = new StringBuilder(); // Agrega esta línea
                do {
                    String nombre = cursor.getString(nombreIndex);
                    String apellido = cursor.getString(apellidoIndex);
                    stringBuilder.append(nombre).append(" ").append(apellido).append("\n");
                } while (cursor.moveToNext());
                listaUsuario.setText(stringBuilder.toString());
                cursor.close();
            } else {
                listaUsuario.setText("No hay usuarios para mostrar.");
            }
        }
    }
}
