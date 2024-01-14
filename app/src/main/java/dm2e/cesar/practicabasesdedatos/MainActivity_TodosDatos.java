package dm2e.cesar.practicabasesdedatos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import dm2e.cesar.practicabasesdedatos.activitiesciudad.CiudadAdaptador;
import dm2e.cesar.practicabasesdedatos.activitiespais.PaisAdaptador;
import dm2e.cesar.practicabasesdedatos.activitiesusuarios.UsuarioAdaptador;
import dm2e.cesar.practicabasesdedatos.dataservice.SQLiteHelper;

public class MainActivity_TodosDatos extends AppCompatActivity {

    private RecyclerView recyclerViewUsuario, recyclerViewPais, recyclerViewCiudad;
    private UsuarioAdaptador usuarioAdaptador;
    private PaisAdaptador paisAdaptador;
    private CiudadAdaptador ciudadAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_todos_datos);

        SQLiteHelper sqLiteHelper = new SQLiteHelper(getApplicationContext(), "PruebaBasesDatos", null,1);

        recyclerViewUsuario = (RecyclerView) findViewById(R.id.recyclerViewUsuario);
        recyclerViewUsuario.setLayoutManager(new LinearLayoutManager(this));

        usuarioAdaptador = new UsuarioAdaptador(sqLiteHelper.obtenerDatosUsuario());
        recyclerViewUsuario.setAdapter(usuarioAdaptador);

        recyclerViewPais = (RecyclerView) findViewById(R.id.recyclerViewPais);
        recyclerViewPais.setLayoutManager(new LinearLayoutManager(this));

        paisAdaptador = new PaisAdaptador(sqLiteHelper.obtenerDatosPais());
        recyclerViewPais.setAdapter(paisAdaptador);

        recyclerViewCiudad = (RecyclerView) findViewById(R.id.recyclerViewCiudad);
        recyclerViewCiudad.setLayoutManager(new LinearLayoutManager(this));

        ciudadAdaptador = new CiudadAdaptador(sqLiteHelper.obtenerDatosCiudad());
        recyclerViewCiudad.setAdapter(ciudadAdaptador);
    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);

        startActivity(i);
    }
}