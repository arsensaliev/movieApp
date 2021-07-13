package arsensaliev.io.movieapp.di

import arsensaliev.io.movieapp.di.module.api.ApiModule
import arsensaliev.io.movieapp.di.module.app.AppModule
import arsensaliev.io.movieapp.di.module.cache.CacheModule
import arsensaliev.io.movieapp.di.module.cicerone.CiceroneModule
import arsensaliev.io.movieapp.di.module.image.ImageModule
import arsensaliev.io.movieapp.di.module.repo.RepoModule
import arsensaliev.io.movieapp.mvp.presenter.main.MainPresenter
import arsensaliev.io.movieapp.mvp.presenter.movies.MoviesPresenter
import arsensaliev.io.movieapp.ui.activity.MainActivity
import arsensaliev.io.movieapp.ui.adapter.MoviesRVAdapter
import arsensaliev.io.movieapp.ui.fragment.movies.MoviesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        CiceroneModule::class,
        ImageModule::class,
        CacheModule::class,
        RepoModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)

    fun inject(moviesFragment: MoviesFragment)
    fun inject(moviesPresenter: MoviesPresenter)
    fun inject(moviesRVAdapter: MoviesRVAdapter)
}