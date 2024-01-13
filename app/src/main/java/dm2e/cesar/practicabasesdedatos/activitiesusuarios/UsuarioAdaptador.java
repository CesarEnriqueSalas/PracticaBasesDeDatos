package dm2e.cesar.practicabasesdedatos.activitiesusuarios;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.models.Usuario;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView id, nombre, apellido, user, email, codeIso;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.idUsuarios);
            nombre = (TextView) itemView.findViewById(R.id.nombreUsuario);
            apellido = (TextView) itemView.findViewById(R.id.apellidoUsuario);
            user = (TextView) itemView.findViewById(R.id.userUsuario);
            email = (TextView) itemView.findViewById(R.id.emailUsuario);
            codeIso = (TextView) itemView.findViewById(R.id.codeisoUsuario);
        }
    }

    public List<Usuario> usuarioList;

    public UsuarioAdaptador(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_recycler, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(String.valueOf(usuarioList.get(position).getUsuarioId()));
        holder.nombre.setText(usuarioList.get(position).getNombre());
        holder.apellido.setText(usuarioList.get(position).getApellido());
        holder.user.setText(usuarioList.get(position).getNombreUsuario());
        holder.email.setText(usuarioList.get(position).getEmail());
        holder.codeIso.setText(usuarioList.get(position).getCodigoIsoPais());
    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }
}

