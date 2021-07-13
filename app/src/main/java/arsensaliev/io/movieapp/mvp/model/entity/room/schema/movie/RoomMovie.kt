package arsensaliev.io.movieapp.mvp.model.entity.room.schema.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import arsensaliev.io.movieapp.mvp.model.entity.Movie

@Entity
data class RoomMovie(
    val adult: Boolean? = null,
    val backdropPath: String? = null,
    @PrimaryKey val id: Int,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val posterPath: String? = null,
    val releaseDate: String? = null,
    val title: String,
    val video: Boolean? = null,
    val voteAverage: Double? = null,
    val voteCount: Int? = null,
) {
    constructor(movie: Movie) : this(
        adult = movie.adult,
        backdropPath = movie.backdropPath,
        id = movie.id,
        originalLanguage = movie.originalLanguage,
        originalTitle = movie.originalTitle,
        overview = movie.overview,
        popularity = movie.popularity,
        posterPath = movie.posterPath,
        releaseDate = movie.releaseDate,
        title = movie.title,
        video = movie.video,
        voteAverage = movie.voteAverage,
        voteCount = movie.voteCount
    )
}