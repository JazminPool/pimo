package e.jazmi.pimo.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import e.jazmi.pimo.Atributos.Atributos_Directorio;
import e.jazmi.pimo.R;


public class Adapter_directorio extends RecyclerView.Adapter<Adapter_directorio.ViewHolder_Directorio> {

    //instancia a la lista que viene de atributos directorio
    ArrayList<Atributos_Directorio> list_directorio;

    public Adapter_directorio(ArrayList<Atributos_Directorio> list_directorio){ this.list_directorio = list_directorio; }

    @Override
    public ViewHolder_Directorio onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_directorio_content, null, false);
        return new ViewHolder_Directorio(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder_Directorio holder, int position) {
        holder.nombre_profesor.setText(list_directorio.get(position).getNombre_profesor());
        holder.materia_profesor.setText(list_directorio.get(position).getMateria_profesor());
//        holder.correo_profesor.setText(list_directorio.get(position).getCorreo_profesor());
//        holder.telefono_profesor.setText(list_directorio.get(position).getTelefono_profesor());
    }

    @Override
    public int getItemCount() {
        return list_directorio.size();
    }


    public class ViewHolder_Directorio extends RecyclerView.ViewHolder {
        TextView nombre_profesor, materia_profesor, correo_profesor, telefono_profesor;

        public ViewHolder_Directorio(View itemView) {
            super(itemView);
            nombre_profesor = itemView.findViewById(R.id.txf_profe_directorio_item_id);
            materia_profesor = itemView.findViewById(R.id.txf_materia_directorio_item_id);
//            correo_profesor = itemView.findViewById(R.id.);
//            nombre_profesor = itemView.findViewById(R.id.txf_profe_directorio_item_id);
        }
    }
}
