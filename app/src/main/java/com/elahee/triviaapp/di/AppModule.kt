package com.elahee.triviaapp.di

import com.elahee.triviaapp.network.RetrofitApi
import com.elahee.triviaapp.repository.QuestionRepository
import com.elahee.triviaapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesQuestionRepository(api: RetrofitApi) = QuestionRepository(api)

    @Singleton
    @Provides
    fun providesRetrofitApi(): RetrofitApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)
    }

}