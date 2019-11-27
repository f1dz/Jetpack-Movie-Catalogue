package `in`.khofid.moviecatalogue.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TvShow")
data class TvShow(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,

    @ColumnInfo(name = "original_name")
    @SerializedName("original_name")
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
    val rating: Float,

    @ColumnInfo(name = "first_air_date")
    @SerializedName("first_air_date")
    val firstAirDate: String
)