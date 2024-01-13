package dm2e.cesar.practicabasesdedatos.activitiesciudad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.models.Ciudad;

public class CiudadAdaptador extends RecyclerView.Adapter<CiudadAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView idC, nombreC, idP;

        public ViewHolder(@NonNull View itenView){
            super(itenView);

            idC = (TextView) itenView.findViewById(R.id.idCiudades);
            nombreC = (TextView) itenView.findViewById(R.id.nombreCiudades);
            idP = (TextView) itenView.findViewById(R.id.idPaises);
        }
    }

    private List<Ciudad> ciudadList;

    public CiudadAdaptador(List<Ciudad> ciudadList){
        this.ciudadList = ciudadList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_recycler_ciudad, parent, false);
        CiudadAdaptador.ViewHolder viewHolder = new CiudadAdaptador.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.idC.setText(String.valueOf(ciudadList.get(position).getCiudadId()));
        holder.nombreC.setText(ciudadList.get(position).getCiudad());
        holder.idP.setText(String.valueOf(ciudadList.get(position).getPaisId()));
    }

    @Override
    public int getItemCount() {
        return ciudadList.size();
    }
}
