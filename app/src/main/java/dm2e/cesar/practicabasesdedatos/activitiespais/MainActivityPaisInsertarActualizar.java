package dm2e.cesar.practicabasesdedatos.activitiespais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import dm2e.cesar.practicabasesdedatos.MainActivity_Tablas;
import dm2e.cesar.practicabasesdedatos.R;

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
    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);

        i.putExtra("numeroParametro", numeroRecibido);

        startActivity(i);
    }
}