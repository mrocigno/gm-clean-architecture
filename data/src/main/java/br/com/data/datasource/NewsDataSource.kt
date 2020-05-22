package br.com.data.datasource

import br.com.domain.entity.News

interface NewsDataSource {

    interface Local {

    }

    interface Remote {

        suspend fun getRemoteNews() : List<News>

    }

}