package br.com.data.services

import br.com.data.model.ApiBase
import br.com.data.model.HomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeService {

    @GET("home")
    suspend fun getHomeData() : Response<ApiBase<HomeResponse>>

}