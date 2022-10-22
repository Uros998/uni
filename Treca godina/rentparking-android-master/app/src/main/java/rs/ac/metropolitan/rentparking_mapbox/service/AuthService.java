package rs.ac.metropolitan.rentparking_mapbox.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rs.ac.metropolitan.rentparking_mapbox.entity.Login;

public interface AuthService {
    @POST("login")
    Call<Object> login(@Body Login login);
}
