package `in`.khofid.moviecatalogue.ui.tv

import `in`.khofid.moviecatalogue.utils.DataDummy
import androidx.lifecycle.ViewModel

class TvShowViewModel: ViewModel() {
    fun getTvShow() = DataDummy.generateDummyTvShow()
}