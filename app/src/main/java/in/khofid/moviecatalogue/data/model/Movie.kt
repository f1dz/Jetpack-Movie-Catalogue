package `in`.khofid.moviecatalogue.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName =  "Movie")
data class Movie (
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,

    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    val title: String,

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    val description: String,

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    val poster: String,

    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    val backdrop: String,

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    val vote: Float,

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    val releaseDate: String
): Parcelable