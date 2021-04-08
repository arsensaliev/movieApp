package arsensaliev.io.movieapp.mvp.model.entity

import android.os.Parcelable
import arsensaliev.io.movieapp.mvp.model.entity.room.schema.movie.RoomMovie
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    @SerializedName("Title")
    @Expose
    val title: String? = null,

    @SerializedName("Year")
    @Expose
    val year: String? = null,

    @SerializedName("Rated")
    @Expose
    val rated: String? = null,

    @SerializedName("Released")
    @Expose
    val released: String? = null,

    @SerializedName("Runtime")
    @Expose
    val runtime: String? = null,

    @SerializedName("Genre")
    @Expose
    val genre: String? = null,

    @SerializedName("Director")
    @Expose
    val director: String? = null,

    @SerializedName("Writer")
    @Expose
    val writer: String? = null,

    @SerializedName("Actors")
    @Expose
    val actors: String? = null,

    @SerializedName("Plot")
    @Expose
    val plot: String? = null,

    @SerializedName("Language")
    @Expose
    val language: String? = null,

    @SerializedName("Country")
    @Expose
    val country: String? = null,

    @SerializedName("Awards")
    @Expose
    val awards: String? = null,

    @SerializedName("Poster")
    @Expose
    val poster: String? = null,

    @SerializedName("Ratings")
    @Expose
    val ratings: List<Rating>? = ArrayList(),

    @SerializedName("Metascore")
    @Expose
    val metascore: String? = null,

    @SerializedName("imdbRating")
    @Expose
    val imdbRating: String? = null,

    @SerializedName("imdbVotes")
    @Expose
    val imdbVotes: String? = null,

    @SerializedName("imdbID")
    @Expose
    val imdbID: String,

    @SerializedName("Type")
    @Expose
    val type: String? = null,

    @SerializedName("DVD")
    @Expose
    val dvd: String? = null,

    @SerializedName("BoxOffice")
    @Expose
    val boxOffice: String? = null,

    @SerializedName("Production")
    @Expose
    val production: String? = null,

    @SerializedName("Website")
    @Expose
    val website: String? = null
) : Parcelable {
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
        ratings = movie.ratings,
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

    constructor(movie: RoomMovie) : this(
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
