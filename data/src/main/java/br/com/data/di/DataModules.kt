package br.com.data.di

import br.com.data.datasource.HomeDataSource
import br.com.data.datasource.HomeDataSourceImpl
import br.com.data.datasource.NewsDataSource
import br.com.data.datasource.NewsDataSourceImpl
import br.com.data.mapper.*
import br.com.data.model.*
import br.com.data.model.ApiBase
import br.com.data.repository.HomeRepositoryImpl
import br.com.data.repository.NewsRepositoryImpl
import br.com.data.services.HomeService
import br.com.data.services.NewsService
import br.com.domain.entity.*
import br.com.domain.repository.HomeRepository
import br.com.domain.repository.NewsRepository
import br.com.infrastructure.net.Mapper
import br.com.infrastructure.net.NetworkClient.makeService
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DataModules {

    private const val NEWS_SERVICE = "NewsService"
    private const val HOME_SERVICE = "HomeService"

    private const val NEWS_DS = "NewsDataSourceImpl"
    private const val HOME_DS = "HomeDataSourceImpl"

    private const val MAPPER_API_TO_HOME = "ApiBaseHomeResponseToHome"
    private const val MAPPER_BAND_RESPONSE_TO_BAND = "BandResponseToBand"
    private const val MAPPER_GENDER_RESPONSE_TO_GENDER = "GenderResponseToGender"
    private const val MAPPER_RELEASE_RESPONSE_TO_RELEASE = "ReleaseResponseToRelease"
    private const val MAPPER_SHOW_RESPONSE_TO_SHOW = "ShowResponseToShow"
    private const val MAPPER_NEWS_RESPONSE_TO_NEWS = "NewsResponseToNews"

    val repositoryModules = module {
        single<NewsRepository> { NewsRepositoryImpl(get()) }
        single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
    }

    val dataSourceModules = module {
        single(named(NEWS_DS)) { NewsDataSourceImpl(get(named(NEWS_SERVICE))) }
        single<NewsDataSource.Local> { get(named(NEWS_DS)) }
        single<NewsDataSource.Remote> { get(named(NEWS_DS)) }

        single(named(HOME_DS)) { HomeDataSourceImpl(
            newsDao = get(),
            bandDao = get(),
            showDao = get(),
            genderDao = get(),
            releaseDao = get(),
            homeService = get(named(HOME_SERVICE)),
            apiBaseHomeResponseToHome = get(named(MAPPER_API_TO_HOME))
        ) }
        single<HomeDataSource.Local> { get(named(HOME_DS)) }
        single<HomeDataSource.Remote> { get(named(HOME_DS)) }
    }

    val serviceModules = module {
        single(named(NEWS_SERVICE)) { makeService<NewsService>(get()) }
        single(named(HOME_SERVICE)) { makeService<HomeService>(get()) }
    }

    val mapperModules = module {
        single(named(MAPPER_BAND_RESPONSE_TO_BAND)) { BandResponseToBand() }
        single(named(MAPPER_GENDER_RESPONSE_TO_GENDER)) { GenderResponseToGender() }
        single(named(MAPPER_RELEASE_RESPONSE_TO_RELEASE)) { ReleaseResponseToRelease() }
        single(named(MAPPER_SHOW_RESPONSE_TO_SHOW)) { ShowResponseToShow() }
        single(named(MAPPER_NEWS_RESPONSE_TO_NEWS)) { NewsResponseToNews() }

        single(named(MAPPER_API_TO_HOME)) {
            ApiBaseHomeResponseToHome(
                get(named(MAPPER_BAND_RESPONSE_TO_BAND)),
                get(named(MAPPER_GENDER_RESPONSE_TO_GENDER)),
                get(named(MAPPER_RELEASE_RESPONSE_TO_RELEASE)),
                get(named(MAPPER_SHOW_RESPONSE_TO_SHOW)),
                get(named(MAPPER_NEWS_RESPONSE_TO_NEWS))

            )
        }
    }

}
