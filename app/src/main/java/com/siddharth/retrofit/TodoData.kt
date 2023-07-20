package com.siddharth.retrofit

data class TodoData(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)