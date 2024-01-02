package dm2e.cesar.practicabasesdedatos.activitiescodeisopais;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.dataservice.SQLiteHelper;

public class MainActivityCodeIsoPaisListar extends AppCompatActivity {

    TextView listaCodeIsoPais;
    SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_code_iso_pais_listar);

        listaCodeIsoPais = findViewById(R.id.listaCodeIsoPais);
        sqLiteHelper = new SQLiteHelper(this, 1);

        Cursor cursor = sqLiteHelper.obtenerTodosLosCodeIsoPais();

        if (cursor != null && cursor.moveToFirst()) {
            int codigoIsoPaisIndex = cursor.getColumnIndex("codigoIsoPais");
            if (codigoIsoPaisIndex != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                do {
                    String codigoIsoPais = cursor.getString(codigoIsoPaisIndex);
                    stringBuilder.append(codigoIsoPais).append("\n");
                } while (cursor.moveToNext());
                listaCodeIsoPais.setText(stringBuilder.toString());
                cursor.close();
            } else {
                listaCodeIsoPais.setText("No hay CodeIsoPais para mostrar.");
            }
        }
    }
}
