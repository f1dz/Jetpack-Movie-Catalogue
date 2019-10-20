package `in`.khofid.moviecatalogue.utils

import `in`.khofid.moviecatalogue.data.MovieResponse
import `in`.khofid.moviecatalogue.data.TvResponse
import android.util.Log
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream


object DataDummy {

    var gson = Gson()

    fun generateDummyMovies() =
        gson.fromJson(loadJSON("assets/movies.json"), MovieResponse::class.java).results

    fun generateDummyTvShow() =
        gson.fromJson(loadJSON("assets/tv.json"), TvResponse::class.java).results

    fun loadJSON(fileSource: String): String? {
        var json: String? = null
        try {
            var input: InputStream = this.javaClass.classLoader!!.getResourceAsStream(fileSource) //context.assets.open(fileSource)
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            json = String(buffer, charset("UTF-8"))

        } catch (ex: IOException) {
            Log.e("Dummy", ex.localizedMessage)
        }

        return json
    }
}