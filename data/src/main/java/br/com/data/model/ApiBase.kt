package br.com.data.model

data class ApiBase<T>(
    val code : Int = -1,
    val message : String = "",
    val data : T?
)