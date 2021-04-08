package arsensaliev.io.movieapp.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rating(
    @SerializedName("Source")
    @Expose
    val source: String? = null,

    @SerializedName("Value")
    @Expose
    val value: String? = null
) : Parcelable