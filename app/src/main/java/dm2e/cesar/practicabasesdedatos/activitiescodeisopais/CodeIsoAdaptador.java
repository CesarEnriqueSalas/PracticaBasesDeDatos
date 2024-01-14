package dm2e.cesar.practicabasesdedatos.activitiescodeisopais;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dm2e.cesar.practicabasesdedatos.R;
import dm2e.cesar.practicabasesdedatos.models.CodeIsoPais;

public class CodeIsoAdaptador extends RecyclerView.Adapter<CodeIsoAdaptador.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView idCI, nombreCI, idPC;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            idCI = (TextView) itemView.findViewById(R.id.idCodeIsoPaises);
            nombreCI = (TextView) itemView.findViewById(R.id.nombreCodeIso);
            idPC = (TextView) itemView.findViewById(R.id.idPaisesC);
        }
    }

    private List<CodeIsoPais> codeIsoPaisList;

    public CodeIsoAdaptador(List<CodeIsoPais> codeIsoPaisList){
        this.codeIsoPaisList = codeIsoPaisList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_recycler_codeiso, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CodeIsoAdaptador.ViewHolder holder, int position) {
        holder.idCI.setText(String.valueOf(codeIsoPaisList.get(position).getPaisId()));
        holder.nombreCI.setText(codeIsoPaisList.get(position).getCodeIsoPais());
        holder.idPC.setText(String.valueOf(codeIsoPaisList.get(position).getCodeID()));
    }

    @Override
    public int getItemCount() {
        return codeIsoPaisList.size();
    }

}
