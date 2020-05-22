package br.com.data.repository

import br.com.data.datasource.NewsDataSource
import br.com.domain.entity.News
import br.com.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val newsDataSourceRemote: NewsDataSource.Remote
) : NewsRepository {

    override suspend fun getNews(): List<News> {
        return newsDataSourceRemote.getRemoteNews()
    }

}