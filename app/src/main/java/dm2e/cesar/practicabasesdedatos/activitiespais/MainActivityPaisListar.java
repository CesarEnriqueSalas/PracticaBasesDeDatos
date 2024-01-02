package dm2e.cesar.practicabasesdedatos.activitiespais;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.dataservice.SQLiteHelper;

public class MainActivityPaisListar extends AppCompatActivity {

    TextView listaPaises;
    SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pais_listar);

        listaPaises = findViewById(R.id.listaPais);
        sqLiteHelper = new SQLiteHelper(this, 1);

        Cursor cursor = sqLiteHelper.obtenerTodosLosPaises();

        if (cursor != null && cursor.moveToFirst()) {
            int nombreIndex = cursor.getColumnIndex("nombre");

            if (nombreIndex != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                do {
                    String nombrePais = cursor.getString(nombreIndex);
                    stringBuilder.append(nombrePais).append("\n");
                } while (cursor.moveToNext());

                // Muestra la información en el TextView
                listaPaises.setText(stringBuilder.toString());

                // Cierra el cursor después de usarlo
                cursor.close();
            } else {
                // Manejo si no hay países
                listaPaises.setText("No hay países para mostrar.");
            }
        }
    }
}
