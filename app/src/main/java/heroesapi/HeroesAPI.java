package heroesapi;

import java.util.List;
import java.util.Map;

import model.Heroes;
import model.ImageResponse;
import model.LoginSignupResponse;
import model.Users;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface HeroesAPI {
    @POST("user")
    Call<Void> insertUser(@Body Users user);

    @POST("item")
    Call<Void> addItem(@Body Heroes heroes);


    @POST("user/login")
    Call<LoginSignupResponse> loginUser(@Body Users user);


    @Multipart
    @POST("item/upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @GET("item")
    Call<List<Heroes>> getAllItems();

}
