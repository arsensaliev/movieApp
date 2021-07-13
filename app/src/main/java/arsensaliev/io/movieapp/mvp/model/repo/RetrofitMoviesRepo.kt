package arsensaliev.io.movieapp.mvp.model.repo

import arsensaliev.io.movieapp.mvp.model.api.IDataSource
import arsensaliev.io.movieapp.mvp.model.cache.IMoviesCache
import arsensaliev.io.movieapp.mvp.model.network.INetworkStatus
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitMoviesRepo(
    val api: IDataSource,
    val networkStatus: INetworkStatus,
    val cache: IMoviesCache
) : IMoviesRepo {
    override fun getMovies() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.getMovies("f5eec4a8eba4e9ee6ae7c75783c0632a").flatMap { movies ->
                cache.putMovies(movies.results).toSingleDefault(movies.results)
            }
        } else {
            cache.getMovies()
        }
    }.subscribeOn(Schedulers.io())
}