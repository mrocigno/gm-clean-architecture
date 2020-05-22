package br.com.data.mapper

import br.com.data.model.NewsResponse
import br.com.domain.entity.News
import br.com.infrastructure.net.Mapper

class NewsResponseToNews : Mapper<NewsResponse, News>() {

    override fun transform(item: NewsResponse?): News {
        return News(
            id = item?.id ?: -1L,
            author = item?.author ?: "",
            description = item?.description ?: "",
            thumbnail = item?.thumbnail ?: "",
            title = item?.title ?: "",
            views = item?.views ?: -1L
        )
    }

}