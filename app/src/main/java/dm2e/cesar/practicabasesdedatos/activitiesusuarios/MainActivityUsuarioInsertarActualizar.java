package dm2e.cesar.practicabasesdedatos.activitiesusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import dm2e.cesar.practicabasesdedatos.MainActivity_Tablas;
import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.dataservice.SQLiteHelper;

public class MainActivityUsuarioInsertarActualizar extends AppCompatActivity {

    private TextView texto;
    private EditText usuarioId, usuarioNombre, usuarioApellido, usuario, email, codigoIsoUsuario;
    private Button regresarButton, accionButton;
    private TableLayout layout;

    int numeroRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_usuario_insertar_actualizar);

        numeroRecibido = getIntent().getIntExtra("numeroParametro", -1);

        texto = findViewById(R.id.texto);
        usuarioId = findViewById(R.id.usuarioId);
        usuarioNombre = findViewById(R.id.usuarioNombre);
        usuarioApellido = findViewById(R.id.usuarioApellido);
        usuario = findViewById(R.id.usuario);
        email = findViewById(R.id.email);
        codigoIsoUsuario = findViewById(R.id.codigoIsoUsuario);
        regresarButton = findViewById(R.id.Regresar);
        accionButton = findViewById(R.id.accion);
        layout = findViewById(R.id.layout);

        if (numeroRecibido != -1) {

            switch (numeroRecibido) {
                case 0:
                    texto.setText(R.string.textoInserUsuario);
                    accionButton.setText(R.string.insertar);
                    break;
                case 1:
                    texto.setText(R.string.textoActuUsuario);
                    usuarioId.setHint(R.string.idUsuarioActu);
                    accionButton.setText(R.string.actualizar);
                    break;
            }
        }

        accionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numeroRecibido == 0) {
                    insertarUsuario();
                } else {
                    actualizarUsuario();
                }
            }
        });
    }


    public void onPulsameRegresar(View view) {
        Intent i = new Intent(this, MainActivity_Tablas.class);

        i.putExtra("numeroParametro", numeroRecibido);

        startActivity(i);
    }

    public void insertarUsuario() {
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this, "PruebaBasesDatos", null,1);

        try (SQLiteDatabase baseDeDatos = sqLiteHelper.getWritableDatabase()) {
            String idUsuario = usuarioId.getText().toString();
            int id = 0;

            try {
                id = Integer.parseInt(idUsuario);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "ID de usuario no válido", Toast.LENGTH_LONG).show();
            }

            String nombreUsuario = usuarioNombre.getText().toString();
            String apellidoUsuario = usuarioApellido.getText().toString();
            String user = usuario.getText().toString();
            String usuarioEmail = email.getText().toString();
            String codigo = codigoIsoUsuario.getText().toString();

            if (!idUsuario.isEmpty() && !nombreUsuario.isEmpty() && !apellidoUsuario.isEmpty() && !user.isEmpty() &&
                    !usuarioEmail.isEmpty() && !codigo.isEmpty()) {

                ContentValues registro = new ContentValues();

                registro.put("usuarioId", id);
                registro.put("nombre", nombreUsuario);
                registro.put("apellido", apellidoUsuario);
                registro.put("usuario", user);
                registro.put("email", usuarioEmail);
                registro.put("codigoIsoPais", codigo);

                baseDeDatos.insert("Usuario", null, registro);

                usuarioId.setText("");
                usuarioNombre.setText("");
                usuarioApellido.setText("");
                usuario.setText("");
                email.setText("");
                codigoIsoUsuario.setText("");

                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error al abrir la base de datos", Toast.LENGTH_LONG).show();
        }
    }

    public void actualizarUsuario() {
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this, "PruebaBasesDatos", null,1);
        try (SQLiteDatabase baseDeDatos = sqLiteHelper.getWritableDatabase()){
            String idUsuario = usuarioId.getText().toString();
            int id = 0;

            try {
                id = Integer.parseInt(idUsuario);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "ID de usuario no válido", Toast.LENGTH_LONG).show();
            }

            String nombreUsuario = usuarioNombre.getText().toString();
            String apellidoUsuario = usuarioApellido.getText().toString();
            String user = usuario.getText().toString();
            String usuarioEmail = email.getText().toString();
            String codigo = codigoIsoUsuario.getText().toString();

            if (!idUsuario.isEmpty() && !nombreUsuario.isEmpty() && !apellidoUsuario.isEmpty() && !user.isEmpty() &&
                    !usuarioEmail.isEmpty() && !codigo.isEmpty()) {

                ContentValues registro = new ContentValues();

                registro.put("usuarioId", id);
                registro.put("nombre", nombreUsuario);
                registro.put("apellido", apellidoUsuario);
                registro.put("usuario", user);
                registro.put("email", usuarioEmail);
                registro.put("codigoIsoPais", codigo);

                int cantidad = baseDeDatos.update("Usuario", registro, "usuarioId=" + id, null);

                if (cantidad == 1){
                    Toast.makeText(this, "Usuario Actualizado", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Debes llenar todos  los campos", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Toast.makeText(this, "Error al abrir la base de datos", Toast.LENGTH_LONG).show();
        }
    }
}
