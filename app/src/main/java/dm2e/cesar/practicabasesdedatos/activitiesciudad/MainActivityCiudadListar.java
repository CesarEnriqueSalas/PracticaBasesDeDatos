package dm2e.cesar.practicabasesdedatos.activitiesciudad;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.dataservice.SQLiteHelper;

public class MainActivityCiudadListar extends AppCompatActivity {

    TextView listaCiudades;
    SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ciudad_listar);

        listaCiudades = findViewById(R.id.listaCiudades);
        sqLiteHelper = new SQLiteHelper(this, 1);

        Cursor cursor = sqLiteHelper.obtenerTodasLasCiudades();

        if (cursor != null && cursor.moveToFirst()) {
            int nombreIndex = cursor.getColumnIndex("nombre");
            if (nombreIndex != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                do {
                    String nombreCiudad = cursor.getString(nombreIndex);
                    stringBuilder.append(nombreCiudad).append("\n");
                } while (cursor.moveToNext());
                listaCiudades.setText(stringBuilder.toString());
                cursor.close();
            } else {
                listaCiudades.setText("No hay ciudades para mostrar.");
            }
        }
    }
}
