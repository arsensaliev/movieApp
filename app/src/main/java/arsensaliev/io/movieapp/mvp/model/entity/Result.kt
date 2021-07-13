package arsensaliev.io.movieapp.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    @SerializedName("results")
    @Expose
    val results: List<Movie> = ArrayList()
) : Parcelable