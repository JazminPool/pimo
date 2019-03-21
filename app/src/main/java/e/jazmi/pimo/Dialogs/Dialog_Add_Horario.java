package e.jazmi.pimo.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import e.jazmi.pimo.R;

public class Dialog_Add_Horario extends AppCompatDialogFragment {
    Spinner dia;
    EditText materia, desde, hasta;

    int hora, minuto;
    static final int DIALOG_ID=0;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_horario, null);

        builder.setView(view).setTitle("Agregar materia al día")
            .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            })
            .setPositiveButton("agregar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getContext(), "Materia agregada", Toast.LENGTH_LONG).show();
                }
        });

        dia = view.findViewById(R.id.select_dia);
        materia = view.findViewById(R.id.txf_materia_horario);
        desde = view.findViewById(R.id.txf_desde_materia);
        hasta = view.findViewById(R.id.txf_hasta_materia);

        return builder.create();
    }


    /**************
     * Dialog Time
     * ***********/
    public void show_Time_desde(){

        desde = (EditText) getActivity().findViewById(R.id.txf_desde_materia);

        desde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DialogFragment timePicker = new DialogFragment();
//                timePicker.show(getFragmentManager(), "time picker");
                getActivity().showDialog(DIALOG_ID);
            }
        });
    }

    protected TimePickerDialog.OnTimeSetListener time_datepickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            hora   = hour;
            minute = minute;
            desde.setText(hour + ":" + minute);
            Toast.makeText(getContext(), hour + ":" + minute, Toast.LENGTH_LONG).show();
        }
    };

    /************************
     *  Muestra los Dialogos *
     *     Date and Time     *
     * **********************/
    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID){
            show_Time_desde();
            return new TimePickerDialog(getContext(), time_datepickerListener, hora, minuto, false);
        }
        return null;
    }


}
