package e.jazmi.pimo.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import e.jazmi.pimo.Atributos.Atributos_Nota;
import e.jazmi.pimo.R;

public class ExampleNotas extends ArrayAdapter<Atributos_Nota> {
    private Context context;
    private List<Atributos_Nota> notes;

    public ExampleNotas(Context context, List<Atributos_Nota> notes)
    {
        super(context, R.layout.fragment_fragment__notas, notes);
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.fragment_fragment__notas, parent,false); //cambiar a item_notas

        Atributos_Nota note = notes.get(position);
        TextView textViewTitle = (TextView) convertView.findViewById(R.id.txf_title_nota_item_id);
        textViewTitle.setText(note.getTitulo());
        TextView textViewNote = (TextView) convertView.findViewById(R.id.txf_nota_item_id);
        textViewNote.setText(note.getDescripcion());
        return convertView;
    }
}
