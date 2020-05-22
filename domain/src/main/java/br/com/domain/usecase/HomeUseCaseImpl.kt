package br.com.domain.usecase

import br.com.domain.repository.HomeRepository
import br.com.infrastructure.net.ApiResultError
import br.com.infrastructure.net.ApiResultSuccess

class HomeUseCaseImpl(
    private val homeRepository: HomeRepository
) : HomeUseCase {

    override suspend fun getHomeLocalData(): List<Any> {
        return homeRepository.getHomeLocalData()
    }

    override suspend fun refreshLocalData(): Boolean {
        return when(val data = homeRepository.getHomeData()){
            is ApiResultSuccess -> {
                homeRepository.saveHomeData(data.body)
                true
            }
            is ApiResultError -> {
                false
            }
            else -> {
                false
            }
        }

    }


}