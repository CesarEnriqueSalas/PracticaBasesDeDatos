package dm2e.cesar.practicabasesdedatos.activitiescodeisopais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import dm2e.cesar.practicabasesdedatos.MainActivity_Tablas;
import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.dataservice.SQLiteHelper;

public class MainActivityCodeIsoPaisBorrar extends AppCompatActivity {

    int numeroRecibido;

    EditText idCodeIsoPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_code_iso_pais_borrar);

        numeroRecibido = getIntent().getIntExtra("numeroParametro", -1);

        idCodeIsoPais = findViewById(R.id.idCodeIsoPais);
    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);

        i.putExtra("numeroParametro", numeroRecibido);

        startActivity(i);
    }

    public void eliminarCodeIsoPais(View view){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this, "PruebaBasesDatos", null,1);
        try(SQLiteDatabase baseDeDatos = sqLiteHelper.getWritableDatabase()) {

            String codigo = idCodeIsoPais.getText().toString();
            int id = 0;

            if (!codigo.isEmpty()) {
                try {
                    id = Integer.parseInt(codigo);
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "El id del codeIsoPais no es valido", Toast.LENGTH_LONG).show();
                }

                int cantidad = baseDeDatos.delete("CodeIsoPais", "codeID=" + id, null);

                idCodeIsoPais.setText("");

                if (cantidad == 1){
                    Toast.makeText(this, "El codeIsoPais ha sido borrado", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "El codeIsoPais no existe", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(this, "El id del codeIsoPais esta vacio", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error al abrir la base de datos", Toast.LENGTH_LONG).show();
        }
    }
}