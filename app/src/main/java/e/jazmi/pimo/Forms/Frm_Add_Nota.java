package e.jazmi.pimo.Forms;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import e.jazmi.pimo.Atributos.Atributos_Nota;
import e.jazmi.pimo.R;
import e.jazmi.pimo.Response.NotasResponse;
import e.jazmi.pimo.Services.NotasService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Frm_Add_Nota extends AppCompatActivity {

    Retrofit retrofit;
    private  NotasService service;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**full screen**/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_frm__add__nota);
        /**barra tool bar**/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /**boton de regresar**/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /**floating de guardar**/

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.137.204:2500/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(NotasService.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_save_id);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service = retrofit.create(NotasService.class);
                createNota();
                Snackbar.make(view, "Wolf! π-mo ha guardado tu nota.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
    public void createNota()
    {
        final EditText tvTitulo = (EditText) findViewById(R.id.txf_title_add_nota_id);
        final EditText tvDescripcion = (EditText) findViewById(R.id.txf_nota_add_content_id);

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();

        String titulo, descripcion;

        titulo = String.valueOf(tvTitulo.getText());
        descripcion = String.valueOf(tvDescripcion.getText());

        Atributos_Nota create = new Atributos_Nota(titulo,descripcion,dateFormat.format(date));

        Call<Atributos_Nota> notasResponseCall = service.createdNota(create);
        notasResponseCall.enqueue(new Callback<Atributos_Nota>() {
            @Override
            public void onResponse(Call<Atributos_Nota> call, Response<Atributos_Nota> response) {
                if(!response.isSuccessful())
                {
                    tvTitulo.setText("titulo: "+response.code());
                    return;
                }
                Atributos_Nota nota = response.body();
                String content = "";

                content +="code: "+ response.code() +"\n";
                content +="titulo: "+ nota.getTitulo() +"\n";
                content +="descripcion: "+ nota.getDescripcion() +"\n";

                tvDescripcion.setText(content);
            }

            @Override
            public void onFailure(Call<Atributos_Nota> call, Throwable t) {
                tvTitulo.setText(t.getMessage());
            }
        });
    }
}
