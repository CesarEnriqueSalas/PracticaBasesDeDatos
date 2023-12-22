package dm2e.cesar.practicabasesdedatos.activitiescodeisopais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import dm2e.cesar.practicabasesdedatos.MainActivity_Tablas;
import dm2e.cesar.practicabasesdedatos.R;

public class MainActivityCodeIsoPaisInsertarActualizar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_code_iso_pais_insertar_actualizar);
    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);
        startActivity(i);
    }
}