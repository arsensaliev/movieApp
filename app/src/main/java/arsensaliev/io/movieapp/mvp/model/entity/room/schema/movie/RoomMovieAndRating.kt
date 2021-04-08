package arsensaliev.io.movieapp.mvp.model.entity.room.schema.movie

import androidx.room.Embedded
import androidx.room.Relation

data class RoomMovieAndRating(
    @Embedded val movie: RoomMovie,
    @Relation(
        parentColumn = "imdbID",
        entityColumn = "movieId"
    )
    val rating: RoomRating
)