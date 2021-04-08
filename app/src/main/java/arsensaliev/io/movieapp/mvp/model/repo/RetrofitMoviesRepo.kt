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
            api.getMovies().flatMap { movies ->
                cache.putMovies(movies).toSingleDefault(movies)
            }
        } else {
            cache.getMovies()
        }
    }.subscribeOn(Schedulers.io())
}