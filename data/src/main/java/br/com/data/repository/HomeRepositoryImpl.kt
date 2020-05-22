package br.com.data.repository

import br.com.data.datasource.HomeDataSource
import br.com.domain.entity.Home
import br.com.domain.repository.HomeRepository
import br.com.infrastructure.net.ApiResult

class HomeRepositoryImpl(
    private val homeDataSourceLocal: HomeDataSource.Local,
    private val homeDataSourceRemote: HomeDataSource.Remote
) : HomeRepository {

    override suspend fun getHomeData(): ApiResult<Home> {
        return homeDataSourceRemote.getHome()
    }

    override suspend fun getHomeLocalData(): List<Any> {
        val news = arrayListOf<Any>("Noticia")
        news.addAll(homeDataSourceLocal.getNews())

        val bands = arrayListOf<Any>("Bandas")
        bands.addAll(homeDataSourceLocal.getBands())

        val genders = arrayListOf("Generos", homeDataSourceLocal.getGenders())

        val releases = arrayListOf<Any>("Lançamentos")
        releases.addAll(homeDataSourceLocal.getReleases())

        val shows = arrayListOf<Any>("Shows")
        shows.addAll(homeDataSourceLocal.getShows())

        val result = arrayListOf<Any>()
        result.addAll(genders)
        result.addAll(news)
        result.addAll(bands)
//        result.addAll(releases)
//        result.addAll(shows)

        return result
    }

    override suspend fun saveHomeData(home: Home) {
        homeDataSourceLocal.saveHome(home)
    }
}