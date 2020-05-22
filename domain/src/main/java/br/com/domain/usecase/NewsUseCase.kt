package br.com.domain.usecase

import br.com.domain.entity.News

interface NewsUseCase {

    suspend fun showNews() : List<News>

}