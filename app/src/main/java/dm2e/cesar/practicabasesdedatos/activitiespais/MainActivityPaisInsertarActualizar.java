package dm2e.cesar.practicabasesdedatos.activitiespais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import dm2e.cesar.practicabasesdedatos.MainActivity_Tablas;
import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.dataservice.SQLiteHelper;

public class MainActivityPaisInsertarActualizar extends AppCompatActivity {

    private TextView texto, texto2;
    private EditText paisId, paisNombre;
    private Button regresarButton, accionButton;
    private TableLayout layout;
    int numeroRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pais_insertar_actualizar);

        numeroRecibido = getIntent().getIntExtra("numeroParametro", -1);

        texto = findViewById(R.id.texto);
        texto2 = findViewById(R.id.texto2);
        paisId = findViewById(R.id.paisId);
        paisNombre = findViewById(R.id.paisNombre);
        regresarButton = findViewById(R.id.Regresar);
        accionButton = findViewById(R.id.accion);
        layout = findViewById(R.id.layout);

        if (numeroRecibido != -1){

            switch (numeroRecibido){
                case 0:
                    texto.setText(R.string.textoInserPais);
                    accionButton.setText(R.string.insertar);
                    break;
                case 1:
                    texto.setText(R.string.textoActuPais);
                    accionButton.setText(R.string.actualizar);
                    break;
            }
        }

        accionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numeroRecibido == 0) {
                    insertarPais();
                } else {
                    actualizarPais();
                }
            }
        });
    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);
        i.putExtra("numeroParametro", numeroRecibido);
        startActivity(i);
    }

    public void insertarPais (){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this, "PruebaBasesDatos", null,1);
        try(SQLiteDatabase baseDeDatos = sqLiteHelper.getWritableDatabase()){
            String idPais = paisId.getText().toString();
            int id = 0;

            try {
                id = Integer.parseInt(idPais);
            } catch (NumberFormatException e){
                Toast.makeText(this, "ID del Pais no valido", Toast.LENGTH_LONG).show();
            }

            String nombrePais = paisNombre.getText().toString();

            if (!idPais.isEmpty() && !nombrePais.isEmpty()){

                ContentValues registro = new ContentValues();

                registro.put("paisId", id);
                registro.put("nombre", nombrePais);

                baseDeDatos.insert("Pais", null, registro);

                paisId.setText("");
                paisNombre.setText("");

                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error al abrir la base de datos", Toast.LENGTH_LONG).show();
        }
    }

    public void actualizarPais(){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this, "PruebaBasesDatos", null,1);
        try(SQLiteDatabase baseDeDatos = sqLiteHelper.getWritableDatabase()){
            String idPais = paisId.getText().toString();
            int id = 0;

            try {
                id = Integer.parseInt(idPais);
            } catch (NumberFormatException e){
                Toast.makeText(this, "ID del Pais no valido", Toast.LENGTH_LONG).show();
            }

            String nombrePais = paisNombre.getText().toString();

            if (!idPais.isEmpty() && !nombrePais.isEmpty()){

                ContentValues registro = new ContentValues();

                registro.put("paisId", id);
                registro.put("nombre", nombrePais);

                int cantidad = baseDeDatos.update("Pais", registro, "paisId=" + id, null);

                paisId.setText("");
                paisNombre.setText("");

                if (cantidad == 1){
                    Toast.makeText(this, "Pais Actualizado", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Debes llenar todos  los campos", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error al abrir la base de datos", Toast.LENGTH_LONG).show();
        }
    }
}