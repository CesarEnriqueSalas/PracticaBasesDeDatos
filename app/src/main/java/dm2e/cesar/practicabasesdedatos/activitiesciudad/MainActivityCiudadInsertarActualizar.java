package dm2e.cesar.practicabasesdedatos.activitiesciudad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import dm2e.cesar.practicabasesdedatos.MainActivity_Tablas;
import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.dataservice.SQLiteHelper;

public class MainActivityCiudadInsertarActualizar extends AppCompatActivity {

    private TextView texto, texto2;
    private EditText idCiudad, nombreCiudad, idPais;
    private Button regresarButton, accionButton;
    private TableLayout layout;
    int numeroRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ciudad_insertar_actualizar);

        numeroRecibido = getIntent().getIntExtra("numeroParametro", -1);

        texto = findViewById(R.id.texto);
        texto2 = findViewById(R.id.texto2);
        idCiudad = findViewById(R.id.idCiudad);
        nombreCiudad = findViewById(R.id.nombrePais);
        idPais = findViewById(R.id.idPais);
        regresarButton = findViewById(R.id.Regresar);
        accionButton = findViewById(R.id.accion);
        layout = findViewById(R.id.layout);

        if (numeroRecibido != -1){

            switch (numeroRecibido){
                case 0:
                    texto.setText(R.string.textoInsertCiudad);
                    accionButton.setText(R.string.insertar);
                    break;
                case 1:
                    texto.setText(R.string.textoActuCiudad);
                    accionButton.setText(R.string.actualizar);
                    break;
            }
        }

        accionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numeroRecibido == 0) {
                    insertarCiudad();
                } else {
                    actualizarCiudad();
                }
            }
        });

    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);
        i.putExtra("numeroParametro", numeroRecibido);
        startActivity(i);
    }

    public void insertarCiudad(){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this, "PruebaBasesDatos", null,1);
        try(SQLiteDatabase baseDeDatos = sqLiteHelper.getWritableDatabase()){

            String ciudadId = idCiudad.getText().toString();

            int id = 0;
            try {
                id = Integer.parseInt(ciudadId);
            } catch (NumberFormatException e){
                Toast.makeText(this, "ID de la Ciudad no valido", Toast.LENGTH_LONG).show();
            }

            String ciudadNombre = nombreCiudad.getText().toString();

            String paisId = idPais.getText().toString();

            int idPaiss = 0;

            try {
                idPaiss = Integer.parseInt(paisId);
            }  catch (NumberFormatException e){
                Toast.makeText(this, "ID del Pais no valido", Toast.LENGTH_LONG).show();
            }

            if (!ciudadNombre.isEmpty() && !paisId.isEmpty() && !ciudadId.isEmpty()){

                ContentValues registro = new ContentValues();

                registro.put("ciudadId", id);
                registro.put("nombre", ciudadNombre);
                registro.put("paisId", idPaiss);

                baseDeDatos.insert("Ciudad", null, registro);

                idCiudad.setText("");
                nombreCiudad.setText("");
                idPais.setText("");

                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
            }

        }catch (Exception e) {
            Toast.makeText(this, "Error al abrir la base de datos", Toast.LENGTH_LONG).show();
        }

    }

    public void actualizarCiudad(){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this, "PruebaBasesDatos", null,1);
        try(SQLiteDatabase baseDeDatos = sqLiteHelper.getWritableDatabase()){

            String ciudadId = idCiudad.getText().toString();

            int id = 0;
            try {
                id = Integer.parseInt(ciudadId);
            } catch (NumberFormatException e){
                Toast.makeText(this, "ID de la Ciudad no valido", Toast.LENGTH_LONG).show();
            }

            String ciudadNombre = nombreCiudad.getText().toString();

            String paisId = idPais.getText().toString();

            int idPaiss = 0;

            try {
                idPaiss = Integer.parseInt(paisId);
            }  catch (NumberFormatException e){
                Toast.makeText(this, "ID del Pais no valido", Toast.LENGTH_LONG).show();
            }

            if (!ciudadNombre.isEmpty() && !paisId.isEmpty() && !ciudadId.isEmpty()){

                ContentValues registro = new ContentValues();

                registro.put("ciudadId", id);
                registro.put("nombre", ciudadNombre);
                registro.put("paisId", idPaiss);

                int cantidad = baseDeDatos.update("Ciudad", registro, "ciudadId=" + id, null);

                idCiudad.setText("");
                nombreCiudad.setText("");
                idPais.setText("");

                if (cantidad == 1){
                    Toast.makeText(this, "Ciudad Actualizado", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Debes llenar todos  los campos", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
            }

        }catch (Exception e) {
            Toast.makeText(this, "Error al abrir la base de datos", Toast.LENGTH_LONG).show();
        }

    }

}