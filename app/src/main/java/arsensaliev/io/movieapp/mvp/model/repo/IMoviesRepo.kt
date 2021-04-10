package arsensaliev.io.movieapp.mvp.model.repo

import arsensaliev.io.movieapp.mvp.model.entity.Movie
import io.reactivex.rxjava3.core.Single

interface IMoviesRepo {
    fun getMovies(): Single<List<Movie>>
}