package br.com.data.datasource

import br.com.data.model.HomeResponse
import br.com.domain.entity.*
import br.com.infrastructure.net.ApiResult

interface HomeDataSource {

    interface Local{

        suspend fun getNews() : List<News>
        suspend fun getBands() : List<Band>
        suspend fun getGenders() : List<Gender>
        suspend fun getShows() : List<Show>
        suspend fun getReleases() : List<Release>
        suspend fun saveHome(home : Home)

    }

    interface Remote {

        suspend fun getHome() : ApiResult<Home>

    }

}