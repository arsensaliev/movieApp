package arsensaliev.io.movieapp.mvp.model.entity.room.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import arsensaliev.io.movieapp.mvp.model.entity.room.schema.movie.RoomMovie
import arsensaliev.io.movieapp.mvp.model.entity.room.schema.movie.dao.MovieDao

@androidx.room.Database(
    entities = [
        RoomMovie::class
    ],
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract val movieDao: MovieDao

    companion object {
        const val DB_NAME = "moviedatabase.db"
        private var instance: Database? = null

        fun getInstance() =
            instance ?: throw  IllegalStateException("Database has not been created")

        fun create(context: Context) {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    Database::class.java,
                    DB_NAME
                ).build()
            }
        }
    }
}