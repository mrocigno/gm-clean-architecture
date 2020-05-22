package br.com.domain.entity

data class Home(
    val listGender : List<Gender> = listOf(),
    val publicity : List<Any> = listOf(),
    val notice : List<News> = listOf(),
    val show : List<Show> = listOf(),
    val release : List<Release> = listOf(),
    val band : List<Band> = listOf()
)