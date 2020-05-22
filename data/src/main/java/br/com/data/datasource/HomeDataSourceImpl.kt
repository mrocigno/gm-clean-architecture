package br.com.data.datasource

import br.com.data.db.dao.*
import br.com.data.mapper.ApiBaseHomeResponseToHome
import br.com.data.services.HomeService
import br.com.domain.entity.*
import br.com.infrastructure.base.AbstractDataSource
import br.com.infrastructure.net.*
import retrofit2.Response

class HomeDataSourceImpl(
    private val newsDao : NewsDao,
    private val bandDao : BandDao,
    private val showDao : ShowDao,
    private val genderDao : GenderDao,
    private val releaseDao : ReleaseDao,
    private val homeService: HomeService,
    private val apiBaseHomeResponseToHome: ApiBaseHomeResponseToHome
) : AbstractDataSource(), HomeDataSource.Local, HomeDataSource.Remote {


    //region Local Implements
    override suspend fun getNews(): List<News> {
        return newsDao.listFive()
    }

    override suspend fun getBands(): List<Band> {
        return bandDao.listFive()
    }

    override suspend fun getGenders(): List<Gender> {
        return genderDao.listAll()
    }

    override suspend fun getShows(): List<Show> {
        return showDao.listAll()
    }

    override suspend fun getReleases(): List<Release> {
        return releaseDao.listAll()
    }

    override suspend fun saveHome(home: Home) {
        newsDao.insertMany(home.notice)
        bandDao.insertMany(home.band)
        showDao.insertMany(home.show)
        genderDao.insertMany(home.listGender)
        releaseDao.insertMany(home.release)
    }
    //endregion

    //region Remote Implements
    override suspend fun getHome(): ApiResult<Home> {
        return getResult(apiBaseHomeResponseToHome){
            homeService.getHomeData()
        }
    }
    //endregion

}