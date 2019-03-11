package e.jazmi.pimo.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import e.jazmi.pimo.R;

public class Dialog_Add_Profesor extends AppCompatDialogFragment {
    EditText materia, profe, email, phone;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_profesor,null);

        builder.setView(view).setTitle("Agregar nuevo profesor")
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("agregar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Profesor agregado", Toast.LENGTH_LONG).show();
                    }
        });

        materia = view.findViewById(R.id.txf_add_materia);
        profe = view.findViewById(R.id.txf_add_nombre_profe);
        email = view.findViewById(R.id.txf_add_email_profe);
        phone = view.findViewById(R.id.txf_add_phone_profe);

        return builder.create();
    }
}
