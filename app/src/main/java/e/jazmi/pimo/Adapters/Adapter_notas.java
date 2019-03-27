package e.jazmi.pimo.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import e.jazmi.pimo.Atributos.Atributos_Nota;
import e.jazmi.pimo.R;
//aqui iba
public class Adapter_notas extends RecyclerView.Adapter<Adapter_notas.ViewHolder_Notas>{

    //hago instancia a la lista que viene de la clase Atributos_Not
    private ArrayList<Atributos_Nota> list_notas;


    //Genera constructor de la lista de arriba
    //aqui iba solo un parametro
    public Adapter_notas() {
        list_notas = new ArrayList<>();
    }


    //genera la vista del adaptador, este es el enlace del xml item y mi clase
    @Override
    public ViewHolder_Notas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notas_content, parent, false);
        return new ViewHolder_Notas(view);
    }

    //Asigna el contenido de la nota al TextView
    @Override
    public void onBindViewHolder(ViewHolder_Notas holder, int position) {
        Atributos_Nota atN = list_notas.get(position);
        holder.txf_title_nota_item_id.setText(atN.getTitulo());
        holder.txf_nota_item_id.setText(atN.getDescripcion());
        holder.txf_hora_item.setText(atN.getHora());
    }

    //toma el tamaño del arreglo o de los elementos
    @Override
    public int getItemCount() {
        if (list_notas!= null)
            return list_notas.size();
        return 0;
    }

    public void addNotas(ArrayList<Atributos_Nota> notas) {
        list_notas.addAll(notas);
        notifyDataSetChanged();
    }


    //clase que saca el elemento del xml, no se bien como funciona xd
    public class ViewHolder_Notas extends RecyclerView.ViewHolder {

        TextView txf_title_nota_item_id,txf_nota_item_id,txf_hora_item;
        public ViewHolder_Notas(View itemView) {
            super(itemView);
            txf_title_nota_item_id =(TextView)itemView.findViewById(R.id.txf_title_nota_item_id);
            txf_nota_item_id =(TextView)itemView.findViewById(R.id.txf_nota_item_id);
            txf_hora_item = (TextView)itemView.findViewById(R.id.txf_nota_created_date_id);
        }

    }
}
