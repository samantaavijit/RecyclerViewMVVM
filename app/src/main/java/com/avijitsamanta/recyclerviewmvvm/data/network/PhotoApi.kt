package com.avijitsamanta.recyclerviewmvvm.data.network

import com.avijitsamanta.recyclerviewmvvm.data.models.Photo
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val CLIENT_ID = "FuMcPrMvBGAbqtnCThSeExXf0E4dNepB19IXg44-wl4"

interface PhotoApi {

    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 30
    ): Response<List<Photo>>


    companion object {
        operator fun invoke(): PhotoApi {
            return Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PhotoApi::class.java)
        }
    }
}