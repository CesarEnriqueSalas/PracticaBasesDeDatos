package dm2e.cesar.practicabasesdedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onPulsameInsertar(View view){
        Intent i = new Intent(this, MainActivity_Insertar.class);
        startActivity(i);
    }

    public void onPulsameActualizar(View view){
        Intent i = new Intent(this, MainActivity_Actualizar.class);
        startActivity(i);
    }

    public void onPulsameBorrar(View view){
        Intent i = new Intent(this, MainActivity_Borrar.class);
        startActivity(i);
    }

    public void onPulsameListar(View view){
        Intent i = new Intent(this, MainActivity_Listar.class);
        startActivity(i);
    }
}