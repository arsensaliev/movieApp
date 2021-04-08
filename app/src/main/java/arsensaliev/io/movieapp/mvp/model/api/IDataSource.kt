package arsensaliev.io.movieapp.mvp.model.api

import arsensaliev.io.movieapp.mvp.model.entity.Movie
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IDataSource {
    @GET("/")
    fun getMovies(@Query("apikey") key: String = "Your Key"): Single<List<Movie>>
}