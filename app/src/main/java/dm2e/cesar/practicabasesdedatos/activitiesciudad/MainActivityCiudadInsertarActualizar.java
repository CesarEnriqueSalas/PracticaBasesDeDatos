package dm2e.cesar.practicabasesdedatos.activitiesciudad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import dm2e.cesar.practicabasesdedatos.MainActivity_Tablas;
import dm2e.cesar.practicabasesdedatos.R;

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

    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);
        i.putExtra("numeroParametro", numeroRecibido);
        startActivity(i);
    }

}