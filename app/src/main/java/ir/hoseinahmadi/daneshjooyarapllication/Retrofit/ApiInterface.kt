package ir.hoseinahmadi.daneshjooyarapllication.Retrofit

import ir.hoseinahmadi.daneshjooyarapllication.Retrofit.data.Email
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
    @POST("email/login")
    suspend fun senCode(
        @Field("email") email: String
    ): Response<Email>

    @FormUrlEncoded
    @POST("email/login/verify")
    suspend fun verify(
        @Header("app-device-uid") anid: String,
        @Field("code") code: String,
        @Field("email") email: String
    ): Response<Email>

}