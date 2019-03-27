package e.jazmi.pimo.Services;

import java.util.ArrayList;
import java.util.List;

import e.jazmi.pimo.Atributos.Atributos_Nota;
import e.jazmi.pimo.Response.NotasResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NotasService {

    @POST("notas/list")
    Call<NotasResponse> findAll();

    @POST("notas/create")
    Call<Atributos_Nota> createdNota(@Body Atributos_Nota post);

  /* @FormUrlEncoded
   @POST
   Call<Atributos_Nota> createdNota(
            @Field("titulo") String titulo,
            @Field("descripcion") String descripcion,
            @Field("hora") String hora
   );*/
}
