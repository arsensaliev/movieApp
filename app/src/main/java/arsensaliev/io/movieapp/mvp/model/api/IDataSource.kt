package arsensaliev.io.movieapp.mvp.model.api

import arsensaliev.io.movieapp.mvp.model.entity.Result
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IDataSource {
    @GET("movie/top_rated")
    fun getMovies(@Query("api_key") apiKey: String): Single<Result>
}