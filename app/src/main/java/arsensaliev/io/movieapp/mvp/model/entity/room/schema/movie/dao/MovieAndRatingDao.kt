package arsensaliev.io.movieapp.mvp.model.entity.room.schema.movie.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import arsensaliev.io.movieapp.mvp.model.entity.room.schema.movie.RoomMovieAndRating

@Dao
interface MovieAndRatingDao {
    @Transaction
    @Query("SELECT * FROM RoomMovie")
    fun getUsersAndLibraries(): List<RoomMovieAndRating>
}