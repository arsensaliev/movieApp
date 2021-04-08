package arsensaliev.io.movieapp.mvp.model.entity.room.schema.movie

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomRating(
    @PrimaryKey(autoGenerate = true) val id: String,
    val source: String? = null,
    val value: String? = null,
    val movieId: String
)