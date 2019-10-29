package `in`.khofid.moviecatalogue.ui.detail

import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.data.source.CatalogueRepository
import `in`.khofid.moviecatalogue.utils.DataDummy
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class DetailTvShowViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: DetailTvShowViewModel
    private var repository = mock(CatalogueRepository::class.java)
    private var dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private var tvShowId = dummyTvShow.id


    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(repository)
        viewModel.tvShowId = tvShowId
    }

    @Test
    fun getTvShow() {
        val tvShow: MutableLiveData<TvShow> = MutableLiveData()
        tvShow.postValue(dummyTvShow)

        `when`(repository.getTvShow(tvShowId)).thenReturn(tvShow)

        val observer = mock(Observer::class.java) as Observer<TvShow>

        viewModel.getTvShow().observeForever(observer)

        verify(observer).onChanged(dummyTvShow)
    }
}