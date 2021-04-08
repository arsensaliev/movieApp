package arsensaliev.io.movieapp.mvp.model.entity.room.schema.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import arsensaliev.io.movieapp.mvp.model.entity.Movie
import arsensaliev.io.movieapp.mvp.model.entity.Rating

@Entity
data class RoomMovie(
    val title: String? = null,
    val year: String? = null,
    val rated: String? = null,
    val released: String? = null,
    val runtime: String? = null,
    val genre: String? = null,
    val director: String? = null,
    val writer: String? = null,
    val actors: String? = null,
    val plot: String? = null,
    val language: String? = null,
    val country: String? = null,
    val awards: String? = null,
    val poster: String? = null,
    val metascore: String? = null,
    val imdbRating: String? = null,
    val imdbVotes: String? = null,
    @PrimaryKey val imdbID: String,
    val type: String? = null,
    val dvd: String? = null,
    val boxOffice: String? = null,
    val production: String? = null,
    val website: String? = null
) {
    constructor(movie: Movie) : this(
        title = movie.title,
        year = movie.year,
        rated = movie.rated,
        released = movie.released,
        runtime = movie.runtime,
        genre = movie.genre,
        director = movie.director,
        writer = movie.writer,
        actors = movie.actors,
        plot = movie.plot,
        language = movie.language,
        country = movie.country,
        awards = movie.awards,
        poster = movie.poster,
        metascore = movie.metascore,
        imdbRating = movie.imdbRating,
        imdbVotes = movie.imdbVotes,
        imdbID = movie.imdbID,
        type = movie.type,
        dvd = movie.dvd,
        boxOffice = movie.boxOffice,
        production = movie.production,
        website = movie.website
    )
}