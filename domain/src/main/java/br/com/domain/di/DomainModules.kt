package br.com.domain.di

import br.com.domain.usecase.HomeUseCase
import br.com.domain.usecase.HomeUseCaseImpl
import br.com.domain.usecase.NewsUseCase
import br.com.domain.usecase.NewsUseCaseImpl
import org.koin.dsl.module

object DomainModules {

    val useCaseModules = module {
        single<NewsUseCase> {
            NewsUseCaseImpl(get())
        }
        single<HomeUseCase> {
            HomeUseCaseImpl(get())
        }
    }

}