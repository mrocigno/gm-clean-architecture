package br.com.domain.repository

import br.com.domain.entity.Home
import br.com.infrastructure.net.ApiResult

interface HomeRepository {

    suspend fun getHomeData() : ApiResult<Home>

    suspend fun getHomeLocalData() : List<Any>

    suspend fun saveHomeData(home : Home)

}