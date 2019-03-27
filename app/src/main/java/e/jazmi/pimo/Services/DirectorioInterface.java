package e.jazmi.pimo.Services;

import e.jazmi.pimo.Response.DirectorioResponse;
import retrofit2.Call;
import retrofit2.http.POST;

public interface DirectorioInterface {

    @POST("profesor/list")
    Call<DirectorioResponse>getAll();
}
