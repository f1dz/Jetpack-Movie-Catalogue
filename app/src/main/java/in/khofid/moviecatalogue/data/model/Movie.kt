package `in`.khofid.moviecatalogue.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val title: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("poster_path")
    val poster: String,
    @SerializedName("backdrop_path")
    val backdrop: String,
    @SerializedName("vote_average")
    val vote: Float,
    @SerializedName("release_date")
    val releaseDate: String
): Parcelable