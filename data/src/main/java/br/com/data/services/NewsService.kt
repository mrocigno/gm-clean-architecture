package br.com.data.services

import br.com.domain.entity.TitleHome
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("search/repositories?q=language:kotlin&sort=stars&per_page=10")
    suspend fun getRepositories(@Query("page") page : Int) : Response<TitleHome>

}