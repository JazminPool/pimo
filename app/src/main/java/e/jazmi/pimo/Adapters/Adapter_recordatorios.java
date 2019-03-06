package e.jazmi.pimo.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import e.jazmi.pimo.Atributos.Atributos_Recordatorios;
import e.jazmi.pimo.R;

public class Adapter_recordatorios extends RecyclerView.Adapter<Adapter_recordatorios.ViewHolder_Recordatorios> {
    //hago instancia a la lista que viene de la clase Atributos_Nota
    ArrayList<Atributos_Recordatorios> list_recordatorios;

    public Adapter_recordatorios(ArrayList<Atributos_Recordatorios> list_recordatorios){
        this.list_recordatorios = list_recordatorios;
    }


    @Override
    public ViewHolder_Recordatorios onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recordatorios_content, null, false);
        return new ViewHolder_Recordatorios(view);
    }


    //Asigna el contenido de la nota al textView
    @Override
    public void onBindViewHolder(ViewHolder_Recordatorios holder, int position) {
        holder.title_recordatorio.setText(list_recordatorios.get(position).getTitulo_recordatorio());
        holder.hora_recordatorio.setText(list_recordatorios.get(position).getHora_recordatorio());
        holder.fecha_recordatorio.setText(list_recordatorios.get(position).getFecha_recordatorio());
        holder.comentario_recordatorio.setText(list_recordatorios.get(position).getComentario_recordatorio());
    }

    //devuelve el numero de elementos en la lista
    @Override
    public int getItemCount() { return list_recordatorios.size(); }

    public class ViewHolder_Recordatorios extends RecyclerView.ViewHolder {
        TextView title_recordatorio, hora_recordatorio, fecha_recordatorio, comentario_recordatorio;
        public ViewHolder_Recordatorios(View itemView) {
            super(itemView);
            title_recordatorio = itemView.findViewById(R.id.txf_title_recordatorio_item_id);
            hora_recordatorio = itemView.findViewById(R.id.txf_hora_recordatorio_item_id);
            fecha_recordatorio = itemView.findViewById(R.id.txf_fecha_recordatorio_item_id);
            comentario_recordatorio = itemView.findViewById(R.id.txf_comentario_recordatorio_item_id);
        }
    }
}
