package com.example.githubsearch.Repository

import com.example.githubsearch.data.GHResponse
import com.example.githubsearch.Uties.jsonInstance
import com.example.githubsearch.data.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject
import kotlin.coroutines.resume

class MainRepository @Inject constructor(private val httpClient: OkHttpClient){

    fun getData(): List<String> {
        return listOf("1", "2", "3")
    }

      suspend fun getItems(query: String, page:Int, perPage: Int = 10): List<Data> {

          return withContext(Dispatchers.IO) {
           suspendCancellableCoroutine { continuation ->

              val request = Request.Builder()
                  .url("https://api.github.com/search/users?q=$query&page=$page&per_page=$perPage")
                  .get()
                  .build()

              val response = httpClient.newCall(request).execute()

              val responseBody = response.body?.string()!!

              val rawResponse: GHResponse = jsonInstance.decodeFromString(responseBody.toString())

              println(rawResponse)

              continuation.resume(rawResponse.items)
          }
    }
      }
}