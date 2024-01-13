package dm2e.cesar.practicabasesdedatos.activitiespais;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.models.Pais;

public class PaisAdaptador extends RecyclerView.Adapter<PaisAdaptador.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView idP, nombreP;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idP = (TextView) itemView.findViewById(R.id.idPaises);
            nombreP = (TextView) itemView.findViewById(R.id.nombrePaises);

        }
    }

    private List<Pais> paisList;
    public PaisAdaptador(List<Pais> paisList){
        this.paisList = paisList;
    }

    @Override
    public PaisAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_recycler_pais, parent, false);
        PaisAdaptador.ViewHolder viewHolder = new PaisAdaptador.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PaisAdaptador.ViewHolder holder, int position) {
        holder.idP.setText(String.valueOf(paisList.get(position).getPaisId()));
        holder.nombreP.setText(paisList.get(position).getPais());
    }

    @Override
    public int getItemCount() {
        return paisList.size();
    }
}
