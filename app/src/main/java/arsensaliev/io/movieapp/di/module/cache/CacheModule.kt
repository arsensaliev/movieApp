package arsensaliev.io.movieapp.di.module.cache

import androidx.room.Room
import arsensaliev.io.movieapp.mvp.model.cache.IMoviesCache
import arsensaliev.io.movieapp.mvp.model.cache.room.RoomMoviesCache
import arsensaliev.io.movieapp.mvp.model.entity.room.db.Database
import arsensaliev.io.movieapp.ui.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun database(app: App): Database =
        Room.databaseBuilder(app, Database::class.java, Database.DB_NAME).build()

    @Singleton
    @Provides
    fun moviesCache(db: Database): IMoviesCache = RoomMoviesCache(db)
}