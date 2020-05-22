package br.com.data.model

data class ShowResponse (
    val id : Long = -1L,
    val description : String = "",
    val banner : String = "",
    val genderId : Int = -1,
    val title : String = "",
    val highlight : Int = 0,
    val thumbnailUrl : String = "",
    val establishment : String = "",
    val localization : String = ""
)