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

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView idCI, nombreCI, idPCI;

        public ViewHolder(@NonNull View itenView) {
            super(itenView);

            idCI = (TextView) itenView.findViewById(R.id.idCodeIsoPaises);
            nombreCI = (TextView) itenView.findViewById(R.id.nombreCodeIso);
            idPCI = (TextView) itenView.findViewById(R.id.idPaises);

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
        CodeIsoAdaptador.ViewHolder viewHolder = new CodeIsoAdaptador.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.idCI.setText(String.valueOf(codeIsoPaisList.get(position).getCodeId()));
        holder.nombreCI.setText(codeIsoPaisList.get(position).getCodigoIsoPais());
        holder.idPCI.setText(String.valueOf(codeIsoPaisList.get(position).getPaisId()));
    }

    @Override
    public int getItemCount() {
        return codeIsoPaisList.size();
    }
}
