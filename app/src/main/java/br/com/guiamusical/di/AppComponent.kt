package br.com.guiamusical.di

import br.com.data.di.DataModules
import br.com.domain.di.DomainModules
import org.koin.core.module.Module

object AppComponent {

    fun getAllModules() : List<Module> {
        return listOf(
            AppModules.viewModels,
            AppModules.database,

            DataModules.dataSourceModules,
            DataModules.repositoryModules,
            DataModules.serviceModules,
            DataModules.mapperModules,

            DomainModules.useCaseModules
        )
    }

}