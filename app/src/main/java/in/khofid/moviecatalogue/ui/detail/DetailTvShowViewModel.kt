package `in`.khofid.moviecatalogue.ui.detail

import `in`.khofid.moviecatalogue.data.TvShow
import `in`.khofid.moviecatalogue.utils.DataDummy
import androidx.lifecycle.ViewModel

class DetailTvShowViewModel: ViewModel() {

    var tvShowId: Int = 0
        get() = field
        set(value) {
            field = value
        }

    fun getTvShow(): TvShow {
        val tvShows = DataDummy.generateDummyTvShow()
        return tvShows.filter { it.id == tvShowId }.get(0)
    }
}