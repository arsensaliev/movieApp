package arsensaliev.io.movieapp.di.module.repo

import arsensaliev.io.movieapp.mvp.model.api.IDataSource
import arsensaliev.io.movieapp.mvp.model.cache.IMoviesCache
import arsensaliev.io.movieapp.mvp.model.network.INetworkStatus
import arsensaliev.io.movieapp.mvp.model.repo.IMoviesRepo
import arsensaliev.io.movieapp.mvp.model.repo.RetrofitMoviesRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun usersRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IMoviesCache
    ): IMoviesRepo = RetrofitMoviesRepo(api, networkStatus, cache)
}