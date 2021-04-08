package arsensaliev.io.movieapp.mvp.model.cache

import arsensaliev.io.movieapp.mvp.model.entity.Movie
import arsensaliev.io.movieapp.mvp.model.entity.Rating
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IRatingCache {
    fun getMovies(): Single<List<Movie>>
    fun putMovies(ratings: List<Rating>): Completable
}