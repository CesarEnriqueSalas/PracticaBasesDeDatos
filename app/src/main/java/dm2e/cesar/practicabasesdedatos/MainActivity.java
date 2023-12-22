package dm2e.cesar.practicabasesdedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onPulsameInsertar(View view){
        Intent i = new Intent(this, MainActivity_Tablas.class);
        int numero = 0;
        i.putExtra("numeroParametro", numero);

        startActivity(i);
    }

    public void onPulsameActualizar(View view){
        Intent i = new Intent(this, MainActivity_Tablas.class);

        int numero = 1;
        i.putExtra("numeroParametro", numero);

        startActivity(i);
    }

    public void onPulsameBorrar(View view){
        Intent i = new Intent(this, MainActivity_Tablas.class);

        int numero = 2;
        i.putExtra("numeroParametro", numero);

        startActivity(i);
    }

    public void onPulsameListar(View view){
        Intent i = new Intent(this, MainActivity_Tablas.class);

        int numero = 3;
        i.putExtra("numeroParametro", numero);

        startActivity(i);
    }
}