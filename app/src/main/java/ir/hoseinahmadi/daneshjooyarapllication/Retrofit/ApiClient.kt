package ir.hoseinahmadi.daneshjooyarapllication.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {

    private const val BUSE_URL ="http://learn.alirezaahmadi.info/api/v1/auth/"

    val api:ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BUSE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}