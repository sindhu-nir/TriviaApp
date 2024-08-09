package com.elahee.triviaapp.network

import com.elahee.triviaapp.model.Question
import retrofit2.http.GET

interface RetrofitApi {

    @GET("world.json")
    suspend fun getAllQuestions():Question
}