package dm2e.cesar.practicabasesdedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import dm2e.cesar.practicabasesdedatos.activitiesciudad.MainActivityCiudadInsertarActualizar;
import dm2e.cesar.practicabasesdedatos.activitiescodeisopais.MainActivityCodeIsoPaisInsertarActualizar;
import dm2e.cesar.practicabasesdedatos.activitiespais.MainActivityPaisInsertarActualizar;
import dm2e.cesar.practicabasesdedatos.activitiesusuarios.MainActivityUsuarioBorrar;
import dm2e.cesar.practicabasesdedatos.activitiesusuarios.MainActivityUsuarioInsertarActualizar;
import dm2e.cesar.practicabasesdedatos.activitiesusuarios.MainActivityUsuarioListar;

public class MainActivity_Tablas extends AppCompatActivity {

    private TextView textView;
    private RadioGroup opcionesRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tablas);

        int numeroRecibido = getIntent().getIntExtra("numeroParametro", -1);

        if (numeroRecibido != -1) {
            String texto;
            textView = findViewById(R.id.textoPregunta);

            switch (numeroRecibido) {
                case 0:
                    texto = getString(R.string.textoInsertar);
                    textView.setText(texto);
                    break;
                case 1:
                    texto = getString(R.string.textoActualizar);
                    textView.setText(texto);
                    break;
                case 2:
                    texto = getString(R.string.textoBorrar);
                    textView.setText(texto);
                    break;
                case 3:
                    texto = getString(R.string.textoListar);
                    textView.setText(texto);
                    break;
                default:
                    break;
            }
        }

        opcionesRadioGroup = findViewById(R.id.opciones);
        opcionesRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Intent i = null;

                if (radioButton.getId() == R.id.tablaUsuario) {

                    if (numeroRecibido == 2){
                        i = new Intent(MainActivity_Tablas.this, MainActivityUsuarioBorrar.class);
                    } else if (numeroRecibido == 3) {
                        i = new Intent(MainActivity_Tablas.this, MainActivityUsuarioListar.class);
                    } else {
                        i = new Intent(MainActivity_Tablas.this, MainActivityUsuarioInsertarActualizar.class);
                    }

                    i.putExtra("numeroParametro", numeroRecibido);

                    startActivity(i);
                }

                if (radioButton.getId() == R.id.tablaPais) {
                     i = new Intent(MainActivity_Tablas.this, MainActivityPaisInsertarActualizar.class);

                    i.putExtra("numeroParametro", numeroRecibido);

                    startActivity(i);
                }

                if (radioButton.getId() == R.id.tablaCiudad) {
                    i = new Intent(MainActivity_Tablas.this, MainActivityCiudadInsertarActualizar.class);

                    i.putExtra("numeroParametro", numeroRecibido);

                    startActivity(i);
                }

                if (radioButton.getId() == R.id.tablaCodeIsoPais) {
                    i = new Intent(MainActivity_Tablas.this, MainActivityCodeIsoPaisInsertarActualizar.class);

                    i.putExtra("numeroParametro", numeroRecibido);

                    startActivity(i);
                }
            }
        });

    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
