package dm2e.cesar.practicabasesdedatos.activitiescodeisopais;

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

public class MainActivityCodeIsoPaisInsertarActualizar extends AppCompatActivity {

    private TextView texto, texto2;
    private EditText codeIsoPaisId, codeIsoPaisNombre, paisId;
    private Button regresarButton, accionButton;
    private TableLayout layout;
    int numeroRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_code_iso_pais_insertar_actualizar);

        numeroRecibido = getIntent().getIntExtra("numeroParametro", -1);

        texto = findViewById(R.id.texto);
        texto2 = findViewById(R.id.texto2);
        paisId = findViewById(R.id.idPais);
        codeIsoPaisId = findViewById(R.id.idCodeIsoPais);
        codeIsoPaisNombre = findViewById(R.id.codeIsoPaisNombre);
        regresarButton = findViewById(R.id.Regresar);
        accionButton = findViewById(R.id.accion);
        layout = findViewById(R.id.layout);

        if (numeroRecibido != -1){

            switch (numeroRecibido){
                case 0:
                    texto.setText(R.string.textoInsertCodeIsoPais);
                    accionButton.setText(R.string.insertar);
                    break;
                case 1:
                    texto.setText(R.string.textoActuCodeIsoPais);
                    accionButton.setText(R.string.actualizar);
                    break;
            }
        }

        accionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numeroRecibido == 0) {
                    insertarCodeIsoPais();
                } else {
                    actualizarCodeIsoPais();
                }
            }
        });

    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);
        i.putExtra("numeroParametro", numeroRecibido);
        startActivity(i);
    }

    public void insertarCodeIsoPais() {
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this, "PruebaBasesDatos", null, 1);
        try (SQLiteDatabase baseDeDatos = sqLiteHelper.getWritableDatabase()) {

            String codeIssoPaisId = codeIsoPaisId.getText().toString();
            String codeIssoPaisNombre = codeIsoPaisNombre.getText().toString();
            String paissId = paisId.getText().toString();

            int id = 0;
            int paisIdInt = 0;

            try {
                id = Integer.parseInt(codeIssoPaisId);
                paisIdInt = Integer.parseInt(paissId);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "ID de CodeIsoPais o del País no válido", Toast.LENGTH_LONG).show();
            }

            if (!codeIssoPaisNombre.isEmpty() && !paissId.isEmpty() && !codeIssoPaisId.isEmpty()) {
                ContentValues registro = new ContentValues();

                registro.put("codeID", id);
                registro.put("codigoIsoPais", codeIssoPaisNombre);
                registro.put("paisId", paisIdInt);

                baseDeDatos.insert("CodeIsoPais", null, registro);

                codeIsoPaisId.setText("");
                codeIsoPaisNombre.setText("");
                paisId.setText("");

                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Toast.makeText(this, "Error al abrir la base de datos", Toast.LENGTH_LONG).show();
        }
    }


    public void actualizarCodeIsoPais() {
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this, "PruebaBasesDatos", null, 1);
        try (SQLiteDatabase baseDeDatos = sqLiteHelper.getWritableDatabase()) {

            String codeIssoPaisId = codeIsoPaisId.getText().toString();
            String codeIssoPaisNombre = codeIsoPaisNombre.getText().toString();
            String paissId = paisId.getText().toString();

            int id = 0;
            int paisIdInt = 0;

            try {
                id = Integer.parseInt(codeIssoPaisId);
                paisIdInt = Integer.parseInt(paissId);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "ID de CodeIsoPais o del País no válido", Toast.LENGTH_LONG).show();
            }

            if (!codeIssoPaisNombre.isEmpty() && !paissId.isEmpty() && !codeIssoPaisId.isEmpty()) {
                ContentValues registro = new ContentValues();

                registro.put("codeID", id);
                registro.put("codigoIsoPais", codeIssoPaisNombre);
                registro.put("paisId", paisIdInt);

                int cantidad = baseDeDatos.update("CodeIsoPais", registro, "codeID=" + id, null);

                codeIsoPaisId.setText("");
                codeIsoPaisNombre.setText("");
                paisId.setText("");

                if (cantidad == 1) {
                    Toast.makeText(this, "CodeIsoPais Actualizado", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "No se encontró el CodeIsoPais para actualizar", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Toast.makeText(this, "Error al abrir la base de datos", Toast.LENGTH_LONG).show();
        }
    }

}