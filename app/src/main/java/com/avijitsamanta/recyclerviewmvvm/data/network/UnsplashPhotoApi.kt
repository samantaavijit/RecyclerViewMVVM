package com.avijitsamanta.recyclerviewmvvm.data.network

import com.avijitsamanta.recyclerviewmvvm.data.models.UnsplashPhoto
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val CLIENT_ID = "FuMcPrMvBGAbqtnCThSeExXf0E4dNepB19IXg44-wl4"

interface UnsplashPhotoApi {

    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<UnsplashPhoto>


    companion object {
        operator fun invoke(): UnsplashPhotoApi {
            return Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UnsplashPhotoApi::class.java)
        }
    }
}