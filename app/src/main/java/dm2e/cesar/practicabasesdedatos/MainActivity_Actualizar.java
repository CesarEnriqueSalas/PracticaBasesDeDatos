package dm2e.cesar.practicabasesdedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity_Actualizar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actualizar);
    }

    public void onPulsameRegresar(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}