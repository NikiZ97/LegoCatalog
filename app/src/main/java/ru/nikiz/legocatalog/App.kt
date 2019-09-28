package ru.nikiz.legocatalog

import android.app.Application
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.nikiz.legocatalog.di.*

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(
                localDataSourceModule,
                network,
                remoteDataSource,
                repositoryModule,
                interactorModule,
                viewModelModule))
        }

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }
}