package br.com.guiamusical.di

import android.content.Context
import androidx.room.Room
import br.com.data.db.AppDatabase
import br.com.data.db.dao.NewsDao
import br.com.guiamusical.ui.main.MainViewModel
import br.com.guiamusical.ui.main.home.HomeViewModel
import br.com.guiamusical.ui.main.menu.MenuViewModel
import br.com.guiamusical.ui.main.news.NewsViewModel
import br.com.guiamusical.ui.main.shows.ShowsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModules {

    val viewModels = module {
        viewModel { MainViewModel() }
        viewModel { HomeViewModel(get()) }
        viewModel { MenuViewModel() }
        viewModel { NewsViewModel() }
        viewModel { ShowsViewModel() }
    }

    val database = module {
        single {
            Room.databaseBuilder(
                get(),
                AppDatabase::class.java,
                "gm-db"
            ).build()
        }

        single { (get() as AppDatabase).newsDao() }
        single { (get() as AppDatabase).bandDao() }
        single { (get() as AppDatabase).genderDao() }
        single { (get() as AppDatabase).releaseDao() }
        single { (get() as AppDatabase).showDao() }
    }

}