package dm2e.cesar.practicabasesdedatos.activitiesciudad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import dm2e.cesar.practicabasesdedatos.MainActivity_Tablas;
import dm2e.cesar.practicabasesdedatos.R;

public class MainActivityCiudadInsertarActualizar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ciudad_insertar_actualizar);
    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);
        startActivity(i);
    }
}