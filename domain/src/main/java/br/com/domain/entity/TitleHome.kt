package br.com.domain.entity

data class TitleHome(
    val title : Int = -1,
    val incomplete_results: Boolean = false,
    val items: List<News>
)