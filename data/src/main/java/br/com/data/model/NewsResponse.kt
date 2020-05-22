package br.com.data.model

data class NewsResponse(
    val id : Long = -1L,
    val views : Long = -1L,
    val title : String = "",
    val thumbnail : String = "",
    val author : String = "",
    val description : String
)