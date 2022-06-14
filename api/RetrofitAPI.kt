package com.example.assignment2.api

import com.example.assignment2.Model.Post
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitAPI {

    abstract class RetrofitAPI {
        @GET("posts/{postID}")
        abstract fun getpostswithComments(@Path("postId") id: String): Call<List<Post>>


        companion object {
            var BASE_URL = "https://jsonplaceholder.typicode.com/"

            fun crate(): RetrofitAPI {
                val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                return retrofit.create(RetrofitAPI::class.java)
            }
        }
    }
}