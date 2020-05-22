package br.com.data.datasource

import br.com.data.services.NewsService
import br.com.domain.entity.News

class NewsDataSourceImpl(
    private val newsService: NewsService
) : NewsDataSource.Local, NewsDataSource.Remote {

    override suspend fun getRemoteNews(): List<News> {
        return newsService.getRepositories(1).body()!!.items
    }
}