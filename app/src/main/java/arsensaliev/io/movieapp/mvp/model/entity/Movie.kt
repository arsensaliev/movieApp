package arsensaliev.io.movieapp.mvp.model.entity

import android.os.Parcelable
import arsensaliev.io.movieapp.mvp.model.entity.room.schema.movie.RoomMovie
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    @SerializedName("adult")
    @Expose
    val adult: Boolean? = null,

    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String? = null,

    @SerializedName("genre_ids")
    @Expose
    val genreIds: List<Int>? = null,

    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("original_language")
    @Expose
    val originalLanguage: String? = null,

    @SerializedName("original_title")
    @Expose
    val originalTitle: String? = null,

    @SerializedName("overview")
    @Expose
    val overview: String? = null,

    @SerializedName("popularity")
    @Expose
    val popularity: Double? = null,

    @SerializedName("poster_path")
    @Expose
    val posterPath: String? = null,

    @SerializedName("release_date")
    @Expose
    val releaseDate: String? = null,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("video")
    @Expose
    val video: Boolean? = null,

    @SerializedName("vote_average")
    @Expose
    val voteAverage: Double? = null,

    @SerializedName("vote_count")
    @Expose
    val voteCount: Int? = null,
) : Parcelable {
    constructor(roomMovie: RoomMovie) : this(
        adult = roomMovie.adult,
        backdropPath = roomMovie.backdropPath,
        id = roomMovie.id,
        originalLanguage = roomMovie.originalLanguage,
        originalTitle = roomMovie.originalTitle,
        overview = roomMovie.overview,
        popularity = roomMovie.popularity,
        posterPath = roomMovie.posterPath,
        releaseDate = roomMovie.releaseDate,
        title = roomMovie.title,
        video = roomMovie.video,
        voteAverage = roomMovie.voteAverage,
        voteCount = roomMovie.voteCount
    )

    val posterUrl: String
        get() = posterPath?.let { "https://image.tmdb.org/t/p/w500$it" }
            ?: "https://i.pinimg.com/originals/8a/eb/d8/8aebd875fbddd22bf3971c3a7159bdc7.png"
}