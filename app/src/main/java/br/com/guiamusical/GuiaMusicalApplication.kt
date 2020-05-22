package br.com.guiamusical

import android.app.Application
import br.com.guiamusical.di.AppComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GuiaMusicalApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@GuiaMusicalApplication)
            androidLogger()
            modules(AppComponent.getAllModules())
        }
    }

}