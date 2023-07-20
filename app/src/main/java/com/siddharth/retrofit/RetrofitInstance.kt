package com.siddharth.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    // lazy in Kotlin initializes a property in a lazy manner.
    // It creates a reference but only goes for the initialization when the property is used or called for the first time.
    // GSON converter factory converts Json objects to java objects

    val api: TodoApi by lazy {
            Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TodoApi::class.java)
    }
}


