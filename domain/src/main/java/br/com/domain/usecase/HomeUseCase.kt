package br.com.domain.usecase

import br.com.domain.entity.Home
import br.com.infrastructure.net.ApiResult

interface HomeUseCase {

    suspend fun getHomeLocalData() : List<Any>

    suspend fun refreshLocalData() : Boolean

}