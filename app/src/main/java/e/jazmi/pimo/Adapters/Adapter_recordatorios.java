package e.jazmi.pimo.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import e.jazmi.pimo.Atributos.Atributos_Nota;
import e.jazmi.pimo.Atributos.Atributos_Recordatorios;
import e.jazmi.pimo.R;

public class Adapter_recordatorios extends RecyclerView.Adapter<Adapter_recordatorios.ViewHolder_Recordatorios> {

    //hago instancia a la lista que viene de la clase Atributos_Nota
    private ArrayList<Atributos_Recordatorios> list_recordatorios;

    public Adapter_recordatorios(ArrayList<Atributos_Recordatorios> list_recordatorios){
        this.list_recordatorios = new ArrayList<>();
    }


    @Override
    public ViewHolder_Recordatorios onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recordatorios_content, parent, false);
        return new ViewHolder_Recordatorios(view);
    }


    //Asigna el contenido de la nota al textView
    @Override
    public void onBindViewHolder(ViewHolder_Recordatorios holder, int position) {
        Atributos_Recordatorios atD = list_recordatorios.get(position);

        holder.tvnombre.setText(atD.getNombre());
        holder.tvcreacion.setText(atD.getCreacion());
        holder.tvhora.setText(atD.getHora());
        holder.tvdescripcion.setText(atD.getDescripcion());
    }

    //devuelve el numero de elementos en la lista
    @Override
    public int getItemCount() {if (list_recordatorios!= null)
        return list_recordatorios.size();
        return 0;
    }

    public void addRecordatorios(ArrayList<Atributos_Recordatorios> recordatorios)
    {
        list_recordatorios.addAll(recordatorios);
        notifyDataSetChanged();
    }

    public class ViewHolder_Recordatorios extends RecyclerView.ViewHolder {
        TextView tvnombre, tvcreacion, tvhora, tvdescripcion;
        public ViewHolder_Recordatorios(View itemView) {
            super(itemView);
            tvnombre = itemView.findViewById(R.id.txf_title_recordatorio_item_id);
            tvcreacion = itemView.findViewById(R.id.txf_hora_recordatorio_item_id);
            tvhora = itemView.findViewById(R.id.txf_fecha_recordatorio_item_id);
            tvdescripcion = itemView.findViewById(R.id.txf_comentario_recordatorio_item_id);
        }
    }
}
