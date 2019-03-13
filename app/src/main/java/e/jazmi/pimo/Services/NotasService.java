package e.jazmi.pimo.Services;

import java.util.ArrayList;
import java.util.List;

import e.jazmi.pimo.Atributos.Atributos_Nota;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.POST;

public interface NotasService {

    @POST("notas/list")
    Call<List<Atributos_Nota>> findAll();

}
