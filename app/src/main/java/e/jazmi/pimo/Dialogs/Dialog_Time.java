package e.jazmi.pimo.Dialogs;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

public class Dialog_Time extends DialogFragment {
    Calendar time = Calendar.getInstance();
    int hour_x   = time.get(Calendar.HOUR_OF_DAY),
        minute_x = time.get(Calendar.MINUTE);

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener) getActivity(), hour_x, minute_x, android.text.format.DateFormat.is24HourFormat(getActivity()));
    }
}
