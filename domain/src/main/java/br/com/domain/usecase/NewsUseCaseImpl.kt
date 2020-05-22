package br.com.domain.usecase

import br.com.domain.entity.News
import br.com.domain.repository.NewsRepository

class NewsUseCaseImpl(
    private val newsRepository: NewsRepository
) : NewsUseCase {

    override suspend fun showNews(): List<News> {
        return newsRepository.getNews()
    }

}