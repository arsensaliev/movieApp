package arsensaliev.io.movieapp.mvp.model.cache.room

import arsensaliev.io.movieapp.mvp.model.cache.IMoviesCache
import arsensaliev.io.movieapp.mvp.model.entity.Movie
import arsensaliev.io.movieapp.mvp.model.entity.room.db.Database
import arsensaliev.io.movieapp.mvp.model.entity.room.schema.movie.RoomMovie
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RoomMoviesCache(val db: Database) : IMoviesCache {

    override fun getMovies() = Single.fromCallable {
        db.movieDao.getAll().map { roomMovie ->
            Movie(roomMovie)
        }
    }

    override fun putMovies(movies: List<Movie>) = Completable.fromAction {
        val roomMovies = movies.map { movie ->
            RoomMovie(movie)
        }

        db.movieDao.insert(roomMovies)
    }.subscribeOn(Schedulers.io())

}