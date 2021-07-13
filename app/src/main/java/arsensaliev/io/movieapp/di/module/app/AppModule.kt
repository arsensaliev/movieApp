package arsensaliev.io.movieapp.di.module.app

import arsensaliev.io.movieapp.ui.App
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Named

@Module
class AppModule(val app: App) {
    @Provides
    fun app(): App = app

    @Named("ui")
    @Provides
    fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()
}