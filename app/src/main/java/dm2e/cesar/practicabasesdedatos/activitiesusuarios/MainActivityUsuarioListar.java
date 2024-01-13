package dm2e.cesar.practicabasesdedatos.activitiesusuarios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dm2e.cesar.practicabasesdedatos.MainActivity_Tablas;
import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.dataservice.SQLiteHelper;
import dm2e.cesar.practicabasesdedatos.models.Usuario;

public class MainActivityUsuarioListar extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UsuarioAdaptador usuarioAdaptador;
    private int numeroRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_usuario_listar);

        numeroRecibido = getIntent().getIntExtra("numeroParametro", -1);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SQLiteHelper sqLiteHelper = new SQLiteHelper(getApplicationContext(), "PruebaBasesDatos", null,1);
        usuarioAdaptador = new UsuarioAdaptador(sqLiteHelper.obtenerDatosUsuario());
        recyclerView.setAdapter(usuarioAdaptador);

    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);

        i.putExtra("numeroParametro", numeroRecibido);

        startActivity(i);
    }


}
