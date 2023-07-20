package com.siddharth.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {
    @GET("/todos")
    suspend fun getTodos(): Response<List<TodoData>>
    // suspend function is used to execute request on a coroutine
}