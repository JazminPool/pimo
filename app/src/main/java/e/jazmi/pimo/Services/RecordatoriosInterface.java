package e.jazmi.pimo.Services;

import e.jazmi.pimo.Response.RecordatoriosResponse;
import retrofit2.Call;
import retrofit2.http.POST;

public interface RecordatoriosInterface {
    @POST("recordatorios/list")
    Call<RecordatoriosResponse> getAll();

}
