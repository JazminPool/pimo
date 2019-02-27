package e.jazmi.pimo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Adapter_notas extends RecyclerView.Adapter<Adapter_notas.ViewHolder_Notas> {

    //hago instancia a la lista que viene de la clase Atributos_Nota
    ArrayList<Atributos_Nota> list_notas;

    //Genera constructor de la lista de arriba
    public Adapter_notas(ArrayList<Atributos_Nota> list_notas) {
        this.list_notas = list_notas;
    }


    //genera la vista del adaptador, este es el enlace del xml item y mi clase
    @Override
    public ViewHolder_Notas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notas_content, null, false);
        return new ViewHolder_Notas(view);
    }

    //Asigna el contenido de la nota al TextView
    @Override
    public void onBindViewHolder(ViewHolder_Notas holder, int position) {
        holder.title_nota.setText(list_notas.get(position).getTitulo_nota());
        holder.nota.setText(list_notas.get(position).getNota());
    }

    //toma el tamaño del arreglo o de los elementos
    @Override
    public int getItemCount() {
        return list_notas.size();
    }

    //clase que saca el elemento del xml, no se bien como funciona xd
    public class ViewHolder_Notas extends RecyclerView.ViewHolder {
        TextView title_nota, nota;
        public ViewHolder_Notas(View itemView) {
            super(itemView);
            title_nota = itemView.findViewById(R.id.txf_title_nota_item_id);
            nota = itemView.findViewById(R.id.txf_nota_item_id);
        }

    }
}
