package dm2e.cesar.practicabasesdedatos.activitiesusuarios;

import androidx.appcompat.app.AppCompatActivity;

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

    private int numeroRecibido;

    private TextView listaUsuario;

    private EditText usuarioBuscar;

    private Button mostar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_usuario_listar);

        numeroRecibido = getIntent().getIntExtra("numeroParametro", -1);

        listaUsuario = findViewById(R.id.listaUsuario);
        usuarioBuscar = findViewById(R.id.usuarioBuscar);
        mostar = findViewById(R.id.accion);

        mostar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostarUsuario();
            }
        });
    }

    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);

        i.putExtra("numeroParametro", numeroRecibido);

        startActivity(i);
    }

    public void mostarUsuario() {
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this, "PruebaBaseDatos", null, 1);
        try(SQLiteDatabase baseDeDatos = sqLiteHelper.getWritableDatabase()) {

            String codigo = usuarioBuscar.getText().toString();
            int id = 0;

            if (!codigo.isEmpty()) {
                try {
                    id = Integer.parseInt(codigo);
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Error, el Id del Usuario es invalido", Toast.LENGTH_LONG).show();
                }

                Cursor fila = baseDeDatos.rawQuery("select usuarioId, nombre, apellido, usuario, email, codigoIsoPais "
                        + "from Usuario where usuarioId =" + id, null);

                if (fila.moveToFirst()) {

                    int idUser = fila.getInt(0);
                    String nomUser = fila.getString(1);
                    String apellUser = fila.getString(2);
                    String user = fila.getString(3);
                    String email = fila.getString(4);
                    String codeIso = fila.getString(5);

                    usuarioBuscar.setText("");

                    Usuario usuario = new Usuario(idUser, nomUser, apellUser, user, email, codeIso);

                    listaUsuario.setText(usuario.toString());
                }
            } else {
                Toast.makeText(this, "Llena los campos", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e){
            Toast.makeText(this, "Error al acceder en la base de datos", Toast.LENGTH_LONG).show();
        }

    }


}
