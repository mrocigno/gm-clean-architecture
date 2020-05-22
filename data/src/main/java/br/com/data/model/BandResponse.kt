package br.com.data.model

data class BandResponse(
    val name : String = "",
    val id : Int = -1,
    val banner : String = "",
    val views : Long = -1L,
    val genderId : Int = -1,
    val shows : Int = -1,
    val logo : String = ""
)
