package e.jazmi.pimo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import e.jazmi.pimo.Atributos.Atributos_Directorio;
import e.jazmi.pimo.Fragment_Contact;
import e.jazmi.pimo.R;


public class Adapter_directorio extends RecyclerView.Adapter<Adapter_directorio.ViewHolder_Directorio> {

    //instancia a la lista que viene de atributos directorio
    ArrayList<Atributos_Directorio> list_directorio;
    private Context contexto_directorio;

    public Adapter_directorio(){list_directorio = new ArrayList<>();}


    @Override
    public ViewHolder_Directorio onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_directorio_content, parent, false);
        return new ViewHolder_Directorio(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder_Directorio holder, final int position) {
        Atributos_Directorio atR = list_directorio.get(position);
        holder.nombre_profesor.setText(atR.getNombre());
        holder.materia_profesor.setText(atR.getMateria());
        holder.correo_profesor.setText(atR.getCorreo());
        holder.telefono_profesorr.setText(atR.getCelular());

        holder.option_menu_directorioo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(contexto_directorio, holder.option_menu_directorioo);
                popupMenu.inflate(R.menu.option_menu_directorio);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.menu_item_edit:
                                Toast.makeText(contexto_directorio, "Editar al profesor", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.menu_item_delete:
                                list_directorio.remove(position);
                                notifyDataSetChanged();
                                Toast.makeText(contexto_directorio, "Eliminar al profesor", Toast.LENGTH_LONG).show();
                                break;
                            default: break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });


    }
    @Override
    public int getItemCount() {
        if (list_directorio!= null)
            return list_directorio.size();
        return 0;
    }

    public void addDirectorio(ArrayList<Atributos_Directorio> directorios) {
    list_directorio.addAll(directorios);
    notifyDataSetChanged();
    }

    public class ViewHolder_Directorio extends RecyclerView.ViewHolder {
        TextView nombre_profesor, materia_profesor, correo_profesor, telefono_profesorr, option_menu_directorioo;

        public ViewHolder_Directorio(View itemView) {
            super(itemView);
            nombre_profesor = itemView.findViewById(R.id.txf_profe_directorio_item_id);
            materia_profesor = itemView.findViewById(R.id.txf_materia_directorio_item_id);
            correo_profesor = itemView.findViewById(R.id.txf_email_item_id);
            telefono_profesorr = itemView.findViewById(R.id.txf_phone_item_id);
            option_menu_directorioo = itemView.findViewById(R.id.option_menu_directorio);
        }
    }
}
