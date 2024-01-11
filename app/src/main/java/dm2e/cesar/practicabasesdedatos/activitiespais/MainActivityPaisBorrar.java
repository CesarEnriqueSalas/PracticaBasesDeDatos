package dm2e.cesar.practicabasesdedatos.activitiespais;

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

public class MainActivityPaisBorrar extends AppCompatActivity {

    int numeroRecibido;

    EditText idPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pais_borrar);

        numeroRecibido = getIntent().getIntExtra("numeroParametro", -1);

        idPais = findViewById(R.id.idPaisBorrar);
    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);

        i.putExtra("numeroParametro", numeroRecibido);

        startActivity(i);
    }

    public void eliminarPais(View view){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this, "PruebaBasesDatos", null,1);
        try(SQLiteDatabase baseDeDatos = sqLiteHelper.getWritableDatabase()) {

            String codigo = idPais.getText().toString();
            int id = 0;

            if (!codigo.isEmpty()) {
                try {
                    id = Integer.parseInt(codigo);
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "El id del Pais no es valido", Toast.LENGTH_LONG).show();
                }

                int cantidad = baseDeDatos.delete("Pais", "paisId=" + id, null);

                idPais.setText("");

                if (cantidad == 1){
                    Toast.makeText(this, "El pais ha sido borrado", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "El pais no existe", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(this, "El id del usuario esta vacio", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error al abrir la base de datos", Toast.LENGTH_LONG).show();
        }
    }
}