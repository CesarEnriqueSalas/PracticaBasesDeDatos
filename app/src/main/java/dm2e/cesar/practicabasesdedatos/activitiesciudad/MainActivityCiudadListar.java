package dm2e.cesar.practicabasesdedatos.activitiesciudad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import dm2e.cesar.practicabasesdedatos.MainActivity_Tablas;
import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.dataservice.SQLiteHelper;

public class MainActivityCiudadListar extends AppCompatActivity {

    private RecyclerView recyclerView;

    private CiudadAdaptador ciudadAdaptador;

    int numeroRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ciudad_listar);

        numeroRecibido = getIntent().getIntExtra("numeroParametro", -1);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SQLiteHelper sqLiteHelper = new SQLiteHelper(getApplicationContext(), "PruebaBasesDatos", null,1);
        ciudadAdaptador = new CiudadAdaptador(sqLiteHelper.obtenerDatosCiudad());
        recyclerView.setAdapter(ciudadAdaptador);

    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);

        i.putExtra("numeroParametro", numeroRecibido);

        startActivity(i);
    }
}
