package e.jazmi.pimo.Forms;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.MonthDisplayHelper;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import e.jazmi.pimo.Atributos.Atributos_Recordatorios;
import e.jazmi.pimo.Dialogs.Dialog_Time;
import e.jazmi.pimo.R;
import e.jazmi.pimo.Services.RecordatoriosInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Frm_Add_Recordatorio extends AppCompatActivity {

    Retrofit retrofit;
    private RecordatoriosInterface recordatoriosInterface;

    EditText txf_date, txf_time,txf_titulo,txf_descripcion;
    TextView tvcreacion;
    int year_x, month_x, day_x, hour_x, minute_x;

    static final int DIALOG_ID = 0, DIALOG_TIME=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**full screen**/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /***tool bar*/
        setContentView(R.layout.activity_frm__add__recordatorio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**boton de regresar**/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        /**Mostrar el dialog de datepicker*/
        final Calendar date = Calendar.getInstance();
        year_x = date.get(Calendar.YEAR);
        month_x = date.get(Calendar.MONTH);
        day_x = date.get(Calendar.DAY_OF_MONTH);
        show_Calendar();
        show_Time();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.137.204:2500/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        recordatoriosInterface = retrofit.create(RecordatoriosInterface.class);

        /**Boton guardar*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordatoriosInterface = retrofit.create(RecordatoriosInterface.class);
                createRecordatorio();
                Snackbar.make(view, "Wolf! π-mo ha guardado tu recordatorio.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /*crear recordatorio*/
    public void createRecordatorio()
    {
        txf_titulo = (EditText) findViewById(R.id.txf_title_add_recordatorio_id);
        txf_date = (EditText) findViewById(R.id.txf_date_add_recordatorio_id);
        txf_time = (EditText) findViewById(R.id.txf_time_add_recordatorio_id);
        txf_descripcion = (EditText) findViewById(R.id.txf_coment_add_recordatorio_id);
        //tvcreacion = (TextView)findViewById(R.id.txf_fecha_fue_creado_recordatorio);

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();

        String titulo, descripcion, fecha, hora;
        titulo = String.valueOf(txf_titulo.getText());
        descripcion = String.valueOf(txf_descripcion.getText());
        fecha = String.valueOf(txf_date.getText());
        hora = String.valueOf(txf_time.getText());

        Atributos_Recordatorios create = new Atributos_Recordatorios(titulo,dateFormat.format(date),hora,fecha,descripcion);
        Call<Atributos_Recordatorios> recordatoriosInterfaceCall = recordatoriosInterface.createdRecordatorio(create);
        recordatoriosInterfaceCall.enqueue(new Callback<Atributos_Recordatorios>() {
            @Override
            public void onResponse(Call<Atributos_Recordatorios> call, Response<Atributos_Recordatorios> response) {
                if(!response.isSuccessful())
                {
                    Log.i("SUCCERS", String.valueOf(response.body()));
                }
            }

            @Override
            public void onFailure(Call<Atributos_Recordatorios> call, Throwable t) {
                Log.i("FAIL",t.getMessage());
            }
        });
    }
    /*crear recordatorio*/

    /*******************
     * Dialog datepicker
     * ****************/
    public void show_Calendar(){
        txf_date = (EditText) findViewById(R.id.txf_date_add_recordatorio_id);

        txf_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID);
            }
        });
    }

    private DatePickerDialog.OnDateSetListener date_pickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            year_x  = year;
            month_x = month + 1;
            day_x   = day;

//            Toast.makeText(Frm_Add_Recordatorio.this, year_x + "/" + month_x + "/" + day_x, Toast.LENGTH_LONG).show();
            Toast.makeText(Frm_Add_Recordatorio.this,  day_x + "/" + month_x + "/" + year_x, Toast.LENGTH_LONG).show();
            txf_date.setText(day_x + "/" + month_x + "/" + year_x);
        }
    };



    /**************
     * Dialog Time
     * ***********/
    public void show_Time(){
        txf_time = (EditText) findViewById(R.id.txf_time_add_recordatorio_id);

        txf_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DialogFragment timePicker = new DialogFragment();
//                timePicker.show(getFragmentManager(), "time picker");
                showDialog(DIALOG_TIME);
            }
        });
    }

    protected TimePickerDialog.OnTimeSetListener time_datepickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            hour_x   = hour;
            minute_x = minute;
            txf_time.setText(hour + ":" + minute);
            Toast.makeText(Frm_Add_Recordatorio.this, hour + ":" + minute, Toast.LENGTH_LONG).show();
        }
    };

    /************************
    *  Muestra los Dialogos *
    *     Date and Time     *
    * **********************/
    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID){
            show_Calendar();
            return new DatePickerDialog(this, date_pickerListener, year_x, month_x, day_x);
        }else if(id == DIALOG_TIME){
            show_Time();
            return new TimePickerDialog(Frm_Add_Recordatorio.this, time_datepickerListener, hour_x, minute_x, false);
        }
        return null;
    }



    /*******************************
     * Metodo para regresar al home
     * o a una vista atras xd
     * ***************************/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){ this.finish(); }
        return super.onOptionsItemSelected(item);
    }

}
