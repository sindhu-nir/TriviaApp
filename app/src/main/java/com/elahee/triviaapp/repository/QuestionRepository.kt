package com.elahee.triviaapp.repository

import android.util.Log
import com.elahee.triviaapp.data.DataOrException
import com.elahee.triviaapp.model.Question
import com.elahee.triviaapp.model.QuestionItem
import com.elahee.triviaapp.network.RetrofitApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val retrofitApi: RetrofitApi) {

    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = retrofitApi.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty())
                dataOrException.loading = false
        } catch (e: Exception) {
            dataOrException.e=e
            Log.d("QuesRepo", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }
}