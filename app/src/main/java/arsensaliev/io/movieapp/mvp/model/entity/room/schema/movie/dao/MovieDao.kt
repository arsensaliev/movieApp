package arsensaliev.io.movieapp.mvp.model.entity.room.schema.movie.dao

import androidx.room.*
import arsensaliev.io.movieapp.mvp.model.entity.room.schema.movie.RoomMovie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: RoomMovie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg movies: RoomMovie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movies: List<RoomMovie>)

    @Update
    fun update(movie: RoomMovie)

    @Update
    fun update(vararg movies: RoomMovie)

    @Update
    fun update(movies: List<RoomMovie>)

    @Delete
    fun delete(movie: RoomMovie)

    @Delete
    fun delete(vararg movies: RoomMovie)

    @Delete
    fun delete(movies: List<RoomMovie>)

    @Query("SELECT * FROM RoomMovie")
    fun getAll(): List<RoomMovie>

    @Query("SELECT * FROM RoomMovie WHERE id = :id LIMIT 1")
    fun findById(id: String): RoomMovie?
}