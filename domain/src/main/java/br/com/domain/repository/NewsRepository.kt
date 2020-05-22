package br.com.domain.repository

import br.com.domain.entity.News

interface NewsRepository {

    suspend fun getNews() : List<News>

}