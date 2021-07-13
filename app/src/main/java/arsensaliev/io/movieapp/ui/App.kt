package arsensaliev.io.movieapp.ui

import android.app.Application
import arsensaliev.io.movieapp.di.AppComponent
import arsensaliev.io.movieapp.di.DaggerAppComponent
import arsensaliev.io.movieapp.di.module.app.AppModule
import arsensaliev.io.movieapp.mvp.model.entity.room.db.Database

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        Database.create(this)

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}