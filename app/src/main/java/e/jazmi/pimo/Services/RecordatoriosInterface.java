package e.jazmi.pimo.Services;

import e.jazmi.pimo.Atributos.Atributos_Recordatorios;
import e.jazmi.pimo.Response.RecordatoriosResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RecordatoriosInterface {
    @POST("recordatorios/list")
    Call<RecordatoriosResponse> getAll();

    @POST("recordatorios/create")
    Call<Atributos_Recordatorios> createdRecordatorio(@Body Atributos_Recordatorios post);


}
