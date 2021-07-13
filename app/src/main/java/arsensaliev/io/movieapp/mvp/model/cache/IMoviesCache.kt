package arsensaliev.io.movieapp.mvp.model.cache

import arsensaliev.io.movieapp.mvp.model.entity.Movie
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IMoviesCache {
    fun getMovies(): Single<List<Movie>>
    fun putMovies(movies: List<Movie>): Completable
}