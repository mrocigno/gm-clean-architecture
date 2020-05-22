package br.com.data.mapper

import br.com.data.model.ApiBase
import br.com.data.model.HomeResponse
import br.com.domain.entity.*
import br.com.infrastructure.net.Mapper

class ApiBaseHomeResponseToHome(
    private val bandMapper: BandResponseToBand,
    private val genderMapper: GenderResponseToGender,
    private val releaseMapper: ReleaseResponseToRelease,
    private val showMapper: ShowResponseToShow,
    private val newsMapper: NewsResponseToNews
) : Mapper<ApiBase<HomeResponse>, Home>() {

    override fun transform(item: ApiBase<HomeResponse>?): Home {
        val bands = ArrayList<Band>()
        val news = ArrayList<News>()
        val publicity = ArrayList<Any>()
        val genders = ArrayList<Gender>()
        val releases = ArrayList<Release>()
        val shows = ArrayList<Show>()

        item?.let { data ->
            data.data?.let {
                it.band.forEach {bandResponse ->
                    bands.add(bandMapper.transform(bandResponse))
                }

                it.listGender.forEach {genderResponse ->
                    genders.add(genderMapper.transform(genderResponse))
                }

                it.release.forEach {releaseResponse ->
                    releases.add(releaseMapper.transform(releaseResponse))
                }

                it.show.forEach {showResponse ->
                    shows.add(showMapper.transform(showResponse))
                }

                it.notice.forEach {newsResponse ->
                    news.add(newsMapper.transform(newsResponse))
                }
            }
        }

        return Home(
            listGender = genders,
            band = bands,
            notice = news,
            publicity = publicity,
            release = releases,
            show = shows
        )
    }
}