package dm2e.cesar.practicabasesdedatos.activitiespais;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import dm2e.cesar.practicabasesdedatos.MainActivity_Tablas;
import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.dataservice.SQLiteHelper;

public class MainActivityPaisListar extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PaisAdaptador paisAdaptador;
    int numeroRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pais_listar);

        numeroRecibido = getIntent().getIntExtra("numeroParametro", -1);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SQLiteHelper sqLiteHelper = new SQLiteHelper(getApplicationContext(), "PruebaBasesDatos", null,1);
        paisAdaptador = new PaisAdaptador(sqLiteHelper.obtenerDatosPais());
        recyclerView.setAdapter(paisAdaptador);

    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);

        i.putExtra("numeroParametro", numeroRecibido);

        startActivity(i);
    }


}
